package boj.solved_ac.class1;
// 사칙연산(분류: 수학, 구현, 사칙연산)
// solved

import java.util.Scanner;

public class BOJ_10869 {
	static int a, b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
		sc.close();
	}

}
