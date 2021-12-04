package boj.Silver;
// S2 배열 돌리기 1 (구현)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_16926_배열돌리기1 {
	static int[][] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		while(R-->0) {
			rotate(arr, N, M);
			arr = ans;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j : ans[i]) sb.append(j).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void rotate(int[][] arr, int N, int M) {
		ans = new int[N][M];
		
		int idx = 0, limit = Math.min(N, M);
		while(idx<limit/2) {
			
			int r=idx, c=idx;
			for(int i=idx; i<N-1-idx; i-=-1) {
				r++;
				ans[r][c] = arr[r-1][c];
			}
			for(int i=idx; i<M-1-idx; i++) {
				c++;
				ans[r][c] = arr[r][c-1];
			}
			for(int i=idx; i<N-1-idx; i++) {
				r--;
				ans[r][c] = arr[r+1][c];
			}
			for(int i=idx; i<M-1-idx; i++) {
				c--;
				ans[r][c] = arr[r][c+1];
			}
			idx++;
		}
	}

}

/*
1 1 1 1 1 1 1
1 1 1 1 1 1 1
1 1 1 1 1 1 1
1 1 1 1 1 1 1
 */
