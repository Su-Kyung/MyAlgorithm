package boj.solved_ac.class1;
// A+B(분류: 수학, 구현, 사칙연산)
// solved

import java.util.Scanner;

public class BOJ_10951 {
	static int a, b;
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a+b);
		}
	}

}
