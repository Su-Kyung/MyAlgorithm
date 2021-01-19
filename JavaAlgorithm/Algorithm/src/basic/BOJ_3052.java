package basic;
// 1차원 배열
import java.util.Scanner;

public class BOJ_3052 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int result = 0;
		boolean array[] = new boolean[42];
				
		for(int i = 0; i < 10; i++) {
			result = scan.nextInt() % 42;
			array[result] = true;
		}
		
		int count = 0;
		for(boolean i : array) {
			if(i) {
				count++;
			}
		}
		System.out.println(count);
	}

}
