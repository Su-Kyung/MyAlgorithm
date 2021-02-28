package boj.Bronze;
// OX퀴즈(분류: 구현,문자열)
// solved
import java.util.Scanner;

public class BOJ_B2_8958_OX퀴즈 {
	static int test_case;
	static char[] inputs;
	static int count;
	static int score;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		test_case = sc.nextInt();
		inputs=sc.nextLine().toCharArray();
		
		for (int t = 0; t < test_case; t++) {
			inputs = sc.nextLine().toCharArray();
			count = 0;
			score = 0;
			for (int i = 0; i < inputs.length; i++) {
				if (inputs[i]=='O') {
					count++;
				} else if (inputs[i]=='X'){
					score += count*(count+1)/2;
					count = 0;
				}
				if (i==inputs.length-1) {
					score += count*(count+1)/2;
					count = 0;
				}
			}
			System.out.println(score);
		}
		sc.close();
	}
}
	
