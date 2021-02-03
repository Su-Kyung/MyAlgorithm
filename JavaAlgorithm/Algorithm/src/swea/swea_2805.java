package swea;
// 농작물 수확하기
// solved

import java.util.Scanner;

public class swea_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int N, sum;
		int[][] farm;
		
		for (int tc = 0; tc < testcase; tc++) {
			// 입력받기
			N = sc.nextInt();
			farm = new int[N][N];
			sum = 0;
			String farmLine;
			for (int i = 0; i < N; i++) {
				farmLine = sc.next();
				for (int j = 0; j < N; j++) {
					farm[i][j] = farmLine.charAt(j) - '0';
				}
			}
			
			int half = N/2;	// 절반
			
			// 가치 구하기 - 중심으로부터의 거리 비교
//			int r, c;		// 행, 열 차이
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					r = Math.abs(i-half);
//					c = Math.abs(j-half);
//					
//					if (r+c >= half*(-1) && r+c <= half) { // 마름모 내부라면
//						sum += farm[i][j];
//						
//					}
//				}
//			}
			
			// 가치 구하기 - 대칭 이용
			for (int i = 0; i <= half; i++) {
				for (int j = half-i; j <= half+i; j++) {
					sum += farm[i][j];
					if (i == half) continue;
					sum += farm[N-i-1][j];
				}
			}
			
			// 결과 출력
			System.out.printf("#%d %d\n",tc+1,sum);
		}
		sc.close();
	}

}
