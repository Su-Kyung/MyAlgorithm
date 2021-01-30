package boj.solved_ac.class1;
// 문자열 반복
//solved
import java.util.Scanner;

public class BOJ_2675 {
	static int test_case;
	static int r;
	static char[] s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		test_case = sc.nextInt();
		
		for (int t = 0; t < test_case; t++) {
			r = sc.nextInt();
			s = sc.next().toCharArray();
			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < r; j++) {
					System.out.print(s[i]);
				}
			}
			System.out.println();
		}
		
		sc.close();
	}

}
