package boj.Gold;
//G5 마법사 상어와 비바라기 (구현,시뮬레이션)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_21610_마법사상어와비바라기 {
	static int dir[][] = { { 0, -1, -1, -1, 0, 1, 1, 1 }, { -1, -1, 0, 1, 1, 1, 0, -1 } }; // 8방

	static class Cloud {
		int r, c;

		public Cloud(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
//		1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				A[i][j] = Integer.parseInt(st.nextToken()); // 물의 양
		}

//		2. 비바라기 시전하기
		Queue<Cloud> queue = new LinkedList<Cloud>();
		// 비구름 생성
		queue.offer(new Cloud(N - 1, 0));
		queue.offer(new Cloud(N - 1, 1));
		queue.offer(new Cloud(N - 2, 0));
		queue.offer(new Cloud(N - 2, 1));

		int sum = 0; // 바구니에 들어있는 물의 양의 합
		for (int i = 0; i < M; i++) {
//			d 방향으로 s칸 이동하기
			st = new StringTokenizer(br.readLine(), " ");
			int face = Integer.parseInt(st.nextToken()) - 1; // 방향
			int dist = Integer.parseInt(st.nextToken()); // 거리

//			3. 모든 구름에 대해 이동
			for (int s = 0, end = queue.size(); s < end; s++) {
				Cloud cloud = queue.poll();
				int nr = cloud.r + dir[0][face] * dist;
				int nc = cloud.c + dir[1][face] * dist;
				while (nr < 0)
					nr += N;
				nr %= N;
				while (nc < 0)
					nc += N;
				nc %= N;
				queue.offer(new Cloud(nr, nc));
//				4. 각 구름에서 비 내리기
				A[nr][nc]++;
			}

			boolean[][] check = new boolean[N][N];
			while (!queue.isEmpty()) {
//				5. 구름 사라진다
				Cloud cur = queue.poll();
				check[cur.r][cur.c] = true;
//				6. 물이 증가한 칸에 물복사버그 마법 시전 (<- 5번과 별개의 작업 하므로 하나의 반복문에 합쳐도 좋다!)
				for (int k = 1; k < 8; k += 2) {
					int nr = cur.r + dir[0][k];
					int nc = cur.c + dir[1][k];
					if (nr == -1 || nr == N || nc == -1 || nc == N || A[nr][nc] == 0)
						continue;
					A[cur.r][cur.c]++;
				}
			}

//			7. 구름 생성 및 바구니에 들어있는 물의 양의 합 구하기
			sum = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					sum += A[r][c];
					if (A[r][c] < 2 || check[r][c])
						continue;
					queue.offer(new Cloud(r, c));
					A[r][c] -= 2;
					sum -= 2;
				}
			}
		}

		System.out.println(sum);
	}

}
