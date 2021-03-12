package boj.Bronze;
// 두 수 비교하기(분류:수학, 구현, 사칙연산)
// solved

import java.util.Scanner;

public class BOJ_1330 {
	static int a, b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		
//		삼항연산자
//		System.out.println((A>B)?">":(A<B)?"<":"==");
		
		if (a > b) System.out.println(">");
		else if (a < b) System.out.println("<");
		else System.out.println("==");
		sc.close();
	}
}
