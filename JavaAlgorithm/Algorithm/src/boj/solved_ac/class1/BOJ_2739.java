package boj.solved_ac.class1;
// 구구단(분류: 수학, 구현, 사칙연산)
// solved

import java.util.Scanner;

public class BOJ_2739 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			System.out.println(n + " * " + i + " = " + n*i);
		}
		sc.close();
	}

}
