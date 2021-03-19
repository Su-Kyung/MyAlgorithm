package boj.Silver;
//S3 01타일(다이나믹 프로그래밍)
//solved
/* 왜 풀이와 같은 점화식이 성립하는가?
 * xxxxx = (1xxxx인 경우 + 00xxx인 경우의 합)%15746
 * 이 때 1xxxx인 경우의 수는 xxxx의 경우의 수와 같고,
 * 00xxx인 경우의 수는 xxx의 경우의 수와 같다!
 */

import java.util.Scanner;

public class BOJ_S3_1904_01타일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(solve(N));
		sc.close();
	}
	
	static int solve(int n) {
		int[] result = new int[1000001];
		result[1]=1;
		result[2]=2;
		for(int i=3, end=n+1; i<end; i++) {
			result[i] = (result[i-2]+result[i-1])%15746;
		}
		return result[n];
	}
}
