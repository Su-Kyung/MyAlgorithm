package boj.Bronze;
// 1차원 배열
import java.util.Scanner;

public class BOJ_B3_10818_최소최대 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int array[] = new int[num];
		
		array[0] = scan.nextInt();
		int max = array[0], min = array[0];
		for (int i = 1; i < array.length; i++) {
			array[i] = scan.nextInt();
			if (array[i] < min) {
				min = array[i];
			} else if (array[i] > max) {
				max = array[i];
			}
		}
		
		System.out.println(min + " " + max);
	}

}
