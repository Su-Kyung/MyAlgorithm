package boj.Bronze;
// 숫자의 합(분류: 수학,문자열,사칙연산)
// solved

import java.util.Scanner;

public class BOJ_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int sum = 0;
		String[] number = sc.next().split("");
				
		for (int i = 0; i < count; i++) {
			sum+=Integer.parseInt(number[i]);
		}
		System.out.println(sum);
		sc.close();
	}

}
