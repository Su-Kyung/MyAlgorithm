package boj.Bronze;
// solved
// 별찍기
import java.util.Scanner;

public class BOJ_2438 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

}