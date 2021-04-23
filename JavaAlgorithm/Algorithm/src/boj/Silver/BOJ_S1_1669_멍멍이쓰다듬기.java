package boj.Silver;
//S1 멍멍이 쓰다듬기 (수학)
//solved 제곱수를 활용하는 방법도 있다

import java.util.Scanner;

public class BOJ_S1_1669_멍멍이쓰다듬기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gap = sc.nextInt() * (-1) + sc.nextInt();

		int day=0;
		long sum=0;
		while(gap>sum) {
			sum += day/2 + 1;
			day++;
		}
		System.out.println(day);
		
		sc.close();
	}
}













//if(gap==0) System.out.println(0);
//else {
//	long sum=0;
//	while(gap>sum) {
//		sum += day/2 + 1;
//		day++;
//	}
//	System.out.println(day);
//}