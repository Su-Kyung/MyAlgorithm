package boj.solved_ac.class1;
// 아스키 코드(분류: 구현)
// solved

import java.util.Scanner;

public class BOJ_11654 {
	static Scanner sc;
	static int ascii;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		ascii = sc.next().charAt(0);
		System.out.println(ascii);
	}

}
