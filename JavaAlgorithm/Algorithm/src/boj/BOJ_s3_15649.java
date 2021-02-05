package boj;
// N과 M(1) (분류: 백트래킹, solved.ac 표준)
// solved

import java.util.Scanner;

public class BOJ_s3_15649 {
	static int N,M;				// 범위, 원소 개수
	static int[] numbers;		// 순열을 저장하는 배열
	static int tc;				// 순열 개수
	static int count;			// 재귀함수 호출 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.close();
		numbers = new int[M];
		permutation(0, 0);
	}
	
	private static void permutation(int idx, int flag) {
		count++;
		if (idx == M) {	
			tc++;
			for(int i : numbers) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if ((flag & 1 << i) != 0) continue;
			
			numbers[idx] = i;
			permutation(idx+1, flag | 1 << i);
		}
	}
}
