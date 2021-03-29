package boj.Silver;
//S3 파도반 수열 (다이나믹 프로그래밍,수학)
//solved
//배열 선언할 때 값의 범위 잘 확인하자! (ex. int vs long)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_9461_파도반수열 {
	static long[] memo = new long[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		memo[1]=1;
		memo[2]=1;
		memo[3]=1;
		for(int t=0, T=Integer.parseInt(br.readLine().trim()); t<T; t++)
			sb.append(dp(Integer.parseInt(br.readLine().trim()))).append("\n");
		System.out.print(sb.toString());
	}
	static long dp(int n) {
		for(int i=4; i<=n; i++) memo[i] = memo[i-2] + memo[i-3];
		return memo[n];
	}
}
