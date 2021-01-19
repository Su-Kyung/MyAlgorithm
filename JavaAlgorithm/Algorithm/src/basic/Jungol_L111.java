package basic;
// 연산자
import java.util.Scanner;

public class Jungol_L111 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		int num4 = scan.nextInt();
		
		int sum = num1 + num2 + num3 + num4;
		int avg = sum / 4;
		
		System.out.printf("sum %d\navg %d", sum, avg);
	}

}
