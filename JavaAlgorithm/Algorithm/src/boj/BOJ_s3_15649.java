package com.ssafy.ws0204;
// N과 M(1) (분류: 백트래킹)
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
		//재귀함수 작성 시 종료 조건 먼저 생각하자!! (없으면 계속 호출해서 스택오버플로우 발생)
		if (idx == M) {	// 순열의 요소를 다 생성 
			tc++;
			for(int i : numbers) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			// 중복 검사(idx뽑을거니까 idx 전까지 똑같은 애 있나 검사)
			if ((flag & 1 << i) != 0) continue;
			
			// 중복되지 않은 경우이므로
			numbers[idx] = i;
//			flag | i << i : flag에 i숫자를 사용했다고 표시
			permutation(idx+1, flag | 1 << i);	// 다음 요소 뽑으러 출동!
		}
	}
}
