package boj.solved_ac.class1;
// A+B(분류: 수학, 구현, 사칙연산)
// solved

import java.util.Scanner;

public class BOJ_10950 {
	static int test_case, a, b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		test_case = sc.nextInt();
		for (int i = 0; i < test_case; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a+b);
		}
	}

}
