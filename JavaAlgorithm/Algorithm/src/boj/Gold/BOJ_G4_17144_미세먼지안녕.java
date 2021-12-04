package boj.Gold;
// G4 미세먼지 안녕! (구현, 시뮬레이션)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_17144_미세먼지안녕 {
	static Queue<Dust> queue = new LinkedList<>();
	static int[][] dir = { { 0, -1, 0, 1 }, { 1, 0, -1, 0 } }; // 우상좌하(반시계)
	static int[][] ddir = { { 0, 1, 0, -1 }, { 1, 0, -1, 0 } }; // 우하좌상(시계)
	static int R, C, machine;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		machine = -1; // 공기청정기 윗부분

		int[][] map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					queue.offer(new Dust(i, j, map[i][j]));
				} else if (map[i][j] == -1 && machine == -1) {
					machine = i;
				}
			}
		}

		for (int t = 0; t < T; t++) { // t초만큼 반복
			// 1. 미세먼지 확산
			while (!queue.isEmpty()) {
				Dust dust = queue.poll();

				int share = dust.amount / 5;
				if (share == 0)
					continue;
				for (int d = 0; d < 4; d++) {
					if (isIn(dust.r + dir[0][d], dust.c + dir[1][d])) {
						map[dust.r][dust.c] -= share;
						map[dust.r + dir[0][d]][dust.c + dir[1][d]] += share;
					}
				}
			}

			// 2. 공기청정기 작동
			// 위쪽 (반시계)
			int r = machine, c = 0, d = 0, cur = 0;
			while (true) {
				int nr = r + dir[0][d];
				int nc = c + dir[1][d];
				if (nr < 0 || nr > machine || nc < 0 || nc >= C) {
					d = (d + 1) % 4;
					nr = r + dir[0][d];
					nc = c + dir[1][d];
				}

				if (nr == machine && nc == 0)
					break;

				int next = map[nr][nc];
				map[nr][nc] = cur;
				cur = next;
				r = nr;
				c = nc;
			}
			// 아래쪽 (시계)
			r = machine + 1;
			c = 0;
			d = 0;
			cur = 0;
			while (true) {
				int nr = r + ddir[0][d];
				int nc = c + ddir[1][d];
				if (nr <= machine || nr >= R || nc < 0 || nc >= C) {
					d = (d + 1) % 4;
					nr = r + ddir[0][d];
					nc = c + ddir[1][d];
				}

				if (nr == machine + 1 && nc == 0)
					break;

				int next = map[nr][nc];
				map[nr][nc] = cur;
				cur = next;
				r = nr;
				c = nc;
			}

			// queue 새로 추가
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) {
						queue.offer(new Dust(i, j, map[i][j]));
					}
				}
			}
		}

		int ans = 0;
		while (!queue.isEmpty()) {
			ans += queue.poll().amount;
		}
		System.out.println(ans);
	}

	private static boolean isIn(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C || (c == 0 && (r == machine || r == machine + 1)))
			return false;
		return true;
	}

	static class Dust {
		int r, c, amount;

		Dust(int r, int c, int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
	}
}
