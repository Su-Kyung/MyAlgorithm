package boj.Silver;
//S1 A→B (너비 우선 탐색,그래프 이론,그래프 탐색,그리디 알고리즘)
//solved
//재귀로 풀었음. 10^9 < Integer.MAX_VALUE 인데 왜 long?

import java.util.Scanner;

public class BOJ_S1_16953_AtoB {
	static long B, min=-1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		B = sc.nextInt();
		dfs(A, 0);
		System.out.println(min);
		sc.close();
	}

	static void dfs(long n, long cnt) {
		if(n==B) {
			if(min==-1) min = cnt+1;
			else min = Math.min(min, cnt+1);
			return;
		}
		if(n>B) return;
		
		dfs(n*2, cnt+1);
		dfs(n*10+1, cnt+1);
	}
}
