package boj.Silver;
// S3 구간 합 구하기 4 (누적 합)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[N+1];
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=N; i++)  dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			sb.append(dp[Integer.parseInt(st.nextToken())-1]*(-1) + dp[Integer.parseInt(st.nextToken())]).append("\n");
		}
		
		System.out.println(sb);
	}
}
