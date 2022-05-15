package boj.Bronze;
// B1 달팽이는 올라가고 싶다 (수학)
// solved

import java.util.Scanner;

public class BOJ_B1_2869_달팽이는올라가고싶다 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int oneDay = A-B;
		int V = sc.nextInt();
		sc.close();
		
		System.out.println(((V-A)%oneDay==0?0:1) + (V-A)/oneDay + 1);
	}

}
