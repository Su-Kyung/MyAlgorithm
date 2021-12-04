package boj.Gold;
// G5 배열 돌리기 2 (구현)
// solved
// 최적화 아이디어 : 겉 껍질부터 원을 이루는 부분끼리 생각하기. -> 각각을 일차원 배열로 펼쳐 생각해도 편할 것 같다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_16927_배열돌리기2 {

	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());	//R번 회전
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = Math.min(N, M);
		for(int i = 0; i < min / 2; i++) {
			// 회전 수 모듈러 연산
			int mod = 2 * (N + M - 4 * i - 2);	// (N - 2 * i - 1) + (M - 2 * i - 1)
			int r = R % mod;	
			for(int j = 0; j < r; j++) {
				move(i, mod);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	static int[][] dir = { { 1, 0, -1, 0 }, { 0, 1, 0, -1 } }; // 하우상좌
	
	private static void move(int x, int mod) {
		int r = x, c = x, cur = map[x][x], next;
		
		for(int i = 0, d = 0; i < mod; i++) {
			int nr = r + dir[0][d];
			int nc = c + dir[1][d];
			if(nr < x || nr >= N - x || nc < x || nc >= M - x) {
				d = (d + 1) % 4;
				nr = r + dir[0][d];
				nc = c + dir[1][d];
			}
			
			next = map[nr][nc];
			map[nr][nc] = cur;
			cur = next;
			r = nr;
			c = nc;
		}
	}

}

/*
4 4 100000000
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

8 12 16 15 
4 6 7 14 
3 10 11 13 
2 1 5 9 
 */