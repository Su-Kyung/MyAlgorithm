package swea;
// d3 농작물 수확하기
// solved (bs: 13m, input: 9m, algo: 6m, test&dbg: 12m)

import java.util.Scanner;

public class SWEA_d3_2805 {
	
	static int N;		// 농장의 크기
	static int farm[][];	// 농작물의 가치
	static String line;		// 농작물 가치 위해 받아올 한 줄
	static int sum;	// 가치 총합
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=0; t<tc; t++) {
			sum=0;
			N = sc.nextInt();
			farm = new int[N][N];
//			1. 2x2 배열에 농작물 가치정보 받아오기
			for (int i=0; i<N; i++) {
				line = sc.next();
				for (int j = 0; j<N; j++) {
					farm[i][j]=line.charAt(j)-'0';
				}
			}
			
//			2. 마름모에 해당하는 부분 더하기: 가로행 기준 왼->오 / 다음행 왼->오...(단, 대칭 상하 대칭부분도 함께 탐색!)
			for(int i=0; i<=N/2; i++) {	//열
				for(int j=i*(-1); j<=i; j++) {	//행
					sum+=farm[i][N/2+j];
//					System.out.println(i+" "+(N/2+j));
					if (i==N/2) continue;
					sum+=farm[N-i-1][N/2+j];
//					System.out.println(N-1-i+" "+(N/2+j));
				}
			}
//			3. 결과 출력
			System.out.printf("#%d %d\n", t+1, sum);
		}
		sc.close();
	}
	
	// 다른 풀이
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int testcase = sc.nextInt();
//		int N, sum;
//		int[][] farm;
//		
//		for (int tc = 0; tc < testcase; tc++) {
//			// 입력받기
//			N = sc.nextInt();
//			farm = new int[N][N];
//			sum = 0;
//			String farmLine;
//			for (int i = 0; i < N; i++) {
//				farmLine = sc.next();
//				for (int j = 0; j < N; j++) {
//					farm[i][j] = farmLine.charAt(j) - '0';
//				}
//			}
//			
//			int half = N/2;	// 절반
//			
//			// 가치 구하기 - 중심으로부터의 거리 비교
////			int r, c;		// 행, 열 차이
////			for (int i = 0; i < N; i++) {
////				for (int j = 0; j < N; j++) {
////					r = Math.abs(i-half);
////					c = Math.abs(j-half);
////					
////					if (r+c >= half*(-1) && r+c <= half) { // 마름모 내부라면
////						sum += farm[i][j];
////						
////					}
////				}
////			}
//			
//			// 가치 구하기 - 대칭 이용
//			for (int i = 0; i <= half; i++) {
//				for (int j = half-i; j <= half+i; j++) {
//					sum += farm[i][j];
//					if (i == half) continue;
//					sum += farm[N-i-1][j];
//				}
//			}
//			
//			// 결과 출력
//			System.out.printf("#%d %d\n",tc+1,sum);
//		}
//		sc.close();
//	}
}
