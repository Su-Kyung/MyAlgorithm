package boj.Bronze;
// B1 이항 계수 1 (수학, 구현, 조합론)
// solved
// 이항계수 (N K) = nCk
// factorial로 재귀 돌리는게 더 빠르다!

import java.util.Scanner;

public class BOJ_B1_11050_이항계수1 {
	static int N, K, ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.close();

		combination(0, 0);
		System.out.println(ans);
	}

	static void combination(int start, int idx) {
		if (idx == K) {
			ans++;
			return;
		}

		for (int i = start; i < N; i++) {
			combination(i + 1, idx + 1);
		}
	}
}
