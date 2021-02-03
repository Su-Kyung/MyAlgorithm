package swea;
//d2 파리퇴치
// solved
import java.util.Scanner;

public class swea_2001 {

	static int N, M;
	static int[][] area;
	static int sum, max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for (int tc = 0; tc < testcase; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			area = new int[N][N];
			max = 0;

			// 배열 입력 받기(NxN)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					area[i][j] = sc.nextInt();
				}
			}
			
			// 가장 왼쪽 위를 기준으로 하여 파리채 for문 돌리기(0부터 N-M까지)
			for (int i = 0; i < N-M+1; i++) {
				for (int j = 0; j < N-M+1; j++) {
					// 파리채 범위 모든인덱스 탐색하면서 값 더하기
					sum = 0;
					for (int a = i; a < i+M; a++) {
						for (int b = j; b < j+M; b++) {
							sum += area[a][b];
						}
					}
					// Max보다 크면 갱신
					if (sum > max) max = sum;
				}
			}
			// 출력
			System.out.printf("#%d %d\n", tc+1, max);
		}
		sc.close();
	}

}
