package boj.Silver;
//S3 2xn 타일링 (다이나믹 프로그래밍)
//solved

import java.util.Scanner;

public class BOJ_S3_11726_2xn타일링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		long[] dp = new long[1001];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=N; i++) dp[i] = (dp[i-2] + dp[i-1])%10007;
		
		System.out.println(dp[N]);
	}
}
