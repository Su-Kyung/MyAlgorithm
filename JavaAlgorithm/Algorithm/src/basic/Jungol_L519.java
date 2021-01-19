package basic;
// 연산자
import java.util.Scanner;

public class Jungol_L519 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		num1 += 100;
		num2 %= 10;
		
		System.out.println(num1 + " " + num2);
	}

}