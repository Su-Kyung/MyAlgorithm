package boj.Gold;
// G4 마법사 상어와 토네이도 (구현, 시뮬레이션)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_20057_마법사상어와토네이도 {

	static int[][] dir = { { 0, 1, 1, 1, 0, -1, -1, -1 }, { -1, -1, 0, 1, 1, 1, 0, -1 } }; // 좌하우상 8방
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int ans = 0;

//		1. 입력
		N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

//		2. 가운데 지점부터 (0, 0)까지 토네이도 이동
		// 초기 설정
		int px = N / 2, py = px, d = 0;
		boolean[][] visited = new boolean[N][N]; // 토네이도 방문 여부;
		visited[px][py] = true;
		int scatter[] = { 10, 7, 1 };

		// (0, 0)까지 토네이도 이동
		do {
			// 토네이도가 이동할 새 좌표
			int nx = px + dir[0][d];
			int ny = py + dir[1][d];
			if (visited[nx][ny]) {
				// 왼쪽으로 못꺾으면 직진.
				d = (d + 6) % 8;
				px += dir[0][d];
				py += dir[1][d];
			} else {
				px = nx;
				py = ny;
			}
			visited[px][py] = true;

			if (map[px][py] == 0) {
				d = (d + 2) % 8;
				continue;
			}

			// 모래 흩날리기
			int alpha = map[px][py], origin = alpha, move = 0;

			// 1) 5%
			move = origin * 5 / 100;
			if(move != 0) {
				nx = px + dir[0][d] * 2;
				ny = py + dir[1][d] * 2;
				if (isOut(nx, ny)) {
					ans += move;
				} else {
					map[nx][ny] += move;
				}
				alpha -= move;
			}

			// 2) 2%
			move = origin * 2 / 100;
			if(move != 0) {
				for (int i = 2; i < 7; i += 4) {
					nx = px + dir[0][(d + i) % 8] * 2;
					ny = py + dir[1][(d + i) % 8] * 2;
					if (isOut(nx, ny)) {
						ans += move;
					} else {
						map[nx][ny] += move;
					}
					alpha -= move;
				}
			}

			// 3) 10%, 7%, 1%
			for (int i = 1; i < 4; i++) {
				int temp = (d + i) % 8;
				move = origin * scatter[i - 1] / 100;
				if(move != 0) {
					nx = px + dir[0][temp];
					ny = py + dir[1][temp];
					if(isOut(nx, ny)) {
						ans += move;
					} else {
						map[nx][ny] += move;
					}
					alpha -= move;
				}
				
				temp = (temp + 4) % 8;
				move = origin * scatter[3 - i] / 100;
				if(move != 0) {
					nx = px + dir[0][temp];
					ny = py + dir[1][temp];
					if(isOut(nx, ny)) {
						ans += move;
					} else {
						map[nx][ny] += move;
					}
					alpha -= move;
				}
			}
			
			// 4) alpha
			if(alpha != 0) {
				nx = px + dir[0][d];
				ny = py + dir[1][d];
				if(isOut(nx, ny)) {
					ans += alpha;
				} else {
					map[nx][ny] += alpha;
				}
			}
			
			map[px][py] = 0;
			d = (d + 2) % 8;
			
		} while (!(px == 0 && py == 0));
		
		System.out.println(ans);
	}

	// 경계를 벗어났는가?
	private static boolean isOut(int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > N - 1)
			return true;
		return false;
	}
}
