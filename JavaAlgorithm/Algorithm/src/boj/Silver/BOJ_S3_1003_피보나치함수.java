package boj.Silver;
//S3 피보나치 함수 (다이나믹 프로그래밍)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_1003_피보나치함수 {
	static int[][] memo = new int[41][3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		int N;
		for(int tc=0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			fibonacci(N);
			sb.append(memo[N][0]).append(" ").append(memo[N][1]).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void fibonacci(int n) {
		memo[0][0] = 1;
		memo[0][1] = 0;

		memo[1][0] = 0;
		memo[1][1] = 1;
		
		memo[2][0] = 1;
		memo[2][1] = 1;
		
		for(int i=3; i<=n; i++) {
			memo[i][0] = memo[i-2][0] + memo[i-1][0];
			memo[i][1] = memo[i-2][1] + memo[i-1][1];
		}
	}
}
