package basic;
// 연산자
import java.util.Scanner;

public class Jungol_L524 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		boolean bool1 = num1 != 0;
		boolean bool2 = num2 != 0;
		
		System.out.print(bool1 && bool2);
		System.out.print(" ");
		System.out.print(bool1 || bool2);
	}

}
