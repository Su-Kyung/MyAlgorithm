package boj.solved_ac.class2;
// 직사각형에서 탈출(분류: 수학,기하학)
// solved

import java.util.Scanner;

public class BOJ_1085 {
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		if(x < y) min = x; else min = y;
		if(min > w-x) min = w-x;
		if(min > h-y) min = h-y;
		
		System.out.println(min);
		sc.close();
	}

}
