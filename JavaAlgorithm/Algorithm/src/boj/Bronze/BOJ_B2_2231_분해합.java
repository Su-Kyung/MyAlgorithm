package boj.Bronze;
//B2 분해합 (브루트포스 알고리즘)
//solved

import java.util.Scanner;

public class BOJ_B2_2231_분해합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = 1;

		int sum;
		boolean flag=false;
		while(min<=N) {
			sum=min;
			int temp = min;
			while(temp>0) {
				sum+=temp%10;
				temp/=10;
			}
			
			if(sum==N) {
				flag = true;
				break;
			}
			else min++;
		}
		System.out.println(flag?min:0);
		sc.close();
	}
}
