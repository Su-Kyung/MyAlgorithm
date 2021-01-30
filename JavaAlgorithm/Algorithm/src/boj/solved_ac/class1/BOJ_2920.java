package boj.solved_ac.class1;
//음계 (분류: 구현)
//solved
import java.util.Scanner;

public class BOJ_2920 {
	static String input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine().toString();
		switch(input) {
		case "1 2 3 4 5 6 7 8":
			System.out.println("ascending");
			break;
		case "8 7 6 5 4 3 2 1":
			System.out.println("descending");
			break;
		default:
			System.out.println("mixed");
			break;
		}
		sc.close();
	}

}
