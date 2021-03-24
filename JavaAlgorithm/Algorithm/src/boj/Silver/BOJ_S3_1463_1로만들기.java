package boj.Silver;
//S3 1로 만들기(다이나믹 프로그래밍)
//solved
//아이디어를 명확하게 계획하고, 식으로 표현하기

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S3_1463_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[1]=0;
		for(int i=2; i<=N; i++) {
			if(i%3==0) dp[i]=Math.min(dp[i/3]+1, dp[i]);
			if(i%2==0) dp[i]=Math.min(dp[i/2]+1, dp[i]);
			dp[i]=Math.min(dp[i-1]+1, dp[i]);
		}
		System.out.println(dp[N]);
		sc.close();
	}
}
