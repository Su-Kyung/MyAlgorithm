package jungol;
// 백설공주(조합)
// solved
import java.util.Scanner;

public class jungol_1810 {
	static int[] numbers;
	static int[] inputs;
	static int tc;
	static int count;
	static int sum;
	static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		numbers = new int[7];
		inputs = new int[9];
		for (int i = 0; i < 9; i++) {
			inputs[i] = sc.nextInt();
		}
		combination(0,1);
	}

	private static void combination(int idx, int start) {
		count++;
		// 기저조건
		if(idx == 7) {	// 한 개의 조합을 모두 만든 경우
			tc++;
			sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += numbers[i];
			}
			if (sum==100) {
				for(int number : numbers) {
					System.out.println(number);
				}
			}
			return;
		}
		// 조합
		for (int i = start; i <= 9; i++) {
			numbers[idx] = inputs[i-1];
			combination(idx+1, i+1);
		}
	}

}
