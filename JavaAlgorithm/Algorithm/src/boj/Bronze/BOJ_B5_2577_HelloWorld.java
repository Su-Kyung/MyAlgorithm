package boj.Bronze;
//1차원 배열
import java.util.Scanner;

public class BOJ_B5_2577_HelloWorld {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
		int result = a*b*c;
		int array[] = new int[10];
		
		do {
			int temp = result % 10;
			array[temp]++;
			result /= 10;
		} while ((result / 10) != 0);
		array[result]++;
		
		for(int i=0;i<10;i++) {
			System.out.println(array[i]);
		}
	}

}
