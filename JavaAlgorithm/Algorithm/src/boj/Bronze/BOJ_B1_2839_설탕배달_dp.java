package boj.Bronze;
//B1 설탕 배달 (다이나믹 프로그래밍,그리디 알고리즘, 수학)
//solved

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B1_2839_설탕배달_dp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] memo = new int[N+1];
		Arrays.fill(memo, -1);
		
		memo[3]=1;
		if(N>4) {
			memo[5]=1;
			for(int i=6; i<=N; i++) {
				if(memo[i-5]==-1 && memo[i-3]==-1) memo[i]=-1;
				else if(memo[i-5]==-1) memo[i]=memo[i-3]+1;
				else if(memo[i-3]==-1) memo[i]=memo[i-5]+1;
				else memo[i] = Math.min(memo[i-3], memo[i-5])+1;
			}
		}
		System.out.println(memo[N]);
		sc.close();
	}
}
