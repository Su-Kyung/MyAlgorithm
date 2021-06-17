package boj.Gold;
//G5 로봇 청소기 (구현,시뮬레이션)
//solved
//당연히 bfs일줄 알고 큐부터 만들었는데 청소기 하나만 가지고 수행하기 때문에 큐가 필요 없다!
//사실상 Pos class도 필요 없음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_14503_로봇청소기 {
	static int[][] dir = { { -1, 0, 1, 0 }, { 0, 1, 0, -1 } }; // 북동남서

	static class Pos {
		int r, c, d, next;	// 위치, 바라보는 방향, 다음 수행할 작업

		public Pos(int r, int c, int d, int next) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.next = next;
		}
	}

	static Queue<Pos> queue = new LinkedList<>();
	static int map[][], ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		queue.offer(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), 1));

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		todo: while (true) {
//			1. 현재 위치 청소
			Pos cur = queue.poll();
			if (cur.next == 1) {
				ans++;
				map[cur.r][cur.c] = -1;
			}

//			2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색
			int nr = cur.r + dir[0][(cur.d + 3) % 4];
			int nc = cur.c + dir[1][(cur.d + 3) % 4];
//			2-a. 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸 전진
			if (map[nr][nc] == 0) {
				queue.offer(new Pos(nr, nc, (cur.d + 3) % 4, 1));
				continue;
			}

			boolean cleaned = true;
			for (int d = 0; d < 4; d++) {
				nr = cur.r + dir[0][(cur.d + d) % 4];
				nc = cur.c + dir[1][(cur.d + d) % 4];
				if (map[nr][nc] == 0) {
					cleaned = false;
					break;
				}
			}

			nr = cur.r + dir[0][(cur.d + 3) % 4];
			nc = cur.c + dir[1][(cur.d + 3) % 4];
			if (!cleaned && map[nr][nc] != 0) {
//				2-b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
				queue.offer(new Pos(cur.r, cur.c, (cur.d + 3) % 4, 2));
				continue;
			}

			if (cleaned) {
				nr = cur.r + dir[0][(cur.d + 2) % 4];
				nc = cur.c + dir[1][(cur.d + 2) % 4];
//				2-c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
				if (map[nr][nc] != 1) {
					queue.offer(new Pos(nr, nc, cur.d, 2));
					continue;
				} else {
//					2-d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
					break todo;
				}

			}
		}

		System.out.println(ans);
	}

}
