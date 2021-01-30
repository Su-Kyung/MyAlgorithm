package boj.solved_ac.class1;
// 최댓값(분류: 구현)
// solved
import java.util.Scanner;

public class BOJ_2562 {
	static int max, next, index;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		max = sc.nextInt();
		index = 1;
		for (int i = 2; i <= 9; i++) {
			next = sc.nextInt();
			if (max < next) {
				max = next;
				index = i;
			}
		}
		System.out.println(max);
		System.out.println(index);
		sc.close();
	}

}
