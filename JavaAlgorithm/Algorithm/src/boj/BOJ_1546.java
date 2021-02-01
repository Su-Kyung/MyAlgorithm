package boj;
// 1차원 배열
import java.util.Scanner;

public class BOJ_1546 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int subject = scan.nextInt();
		
		int score[] = new int[subject];
		score[0] = scan.nextInt();
		int max = score[0];
		double scoreSum = score[0];
		
		for (int i = 1; i < subject; i++) {
			score[i] = scan.nextInt();
			if (score[i] > max) {
				max = score[i];
			}
			scoreSum += score[i];
		}
		
		double average = (scoreSum * 100.0)/ (double)(max * subject);
		System.out.printf("%f", average);
	}

}
