package boj.Silver;
// S5 최대공약수와 최소공배수 (수학, 정수론, 유클리드 호제법)
// solved
// 유클리드 호제법을 활용한 재귀 or 반복문으로 풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int d = gcd(A, B);
		System.out.printf("%d\n%d", d, A * B / d);
	}

	// 재귀 방식으로 최대공약수 구하기
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b); // GCD(a, b) = GCD(b, r)이므로 (r = a % b)
	}

	// 반복문 방식으로 최대공약수 구하기
//	static int gcd(int a, int b) {
//		while (b != 0) {
//			int r = a % b;
//			// GCD(a, b) = GCD(b, r)
//			a = b;
//			b = r;
//		}
//		return a;
//	}
}
