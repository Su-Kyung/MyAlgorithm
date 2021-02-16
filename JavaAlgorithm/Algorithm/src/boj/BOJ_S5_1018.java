package boj;
// S5 체스판 다시 칠하기 (브루트포스 알고리즘)
// solved(35m)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_1018 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		1. 입력 받기
		int M = Integer.parseInt(st.nextToken());	//열
		int N = Integer.parseInt(st.nextToken());	//행
		char[][] input = new char[M][N];
		for(int i = 0; i < M; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
//		2. 체스판 만들기
		int[][] c1 = {{'W','B','W','B','W','B','W','B'},
					{'B','W','B','W','B','W','B','W'},
					{'W','B','W','B','W','B','W','B'},
					{'B','W','B','W','B','W','B','W'},
					{'W','B','W','B','W','B','W','B'},
					{'B','W','B','W','B','W','B','W'},
					{'W','B','W','B','W','B','W','B'},
					{'B','W','B','W','B','W','B','W'}};
		int[][] c2 = {{'B','W','B','W','B','W','B','W'},
					{'W','B','W','B','W','B','W','B'},
					{'B','W','B','W','B','W','B','W'},
					{'W','B','W','B','W','B','W','B'},
					{'B','W','B','W','B','W','B','W'},
					{'W','B','W','B','W','B','W','B'},
					{'B','W','B','W','B','W','B','W'},
					{'W','B','W','B','W','B','W','B'}};
		
//		3. 8x8크기로 만들 수 있는 경우로 반복
		int min = 64;
		int cnt;
		for(int i = 0, I = M-8; i <= I; i++) {
			for(int j = 0, J = N-8; j <= J; j++) {
//				3-1. c1과 비교해 바꿔야하는 개수 구하기
				cnt = 0;
				for(int m = 0; m < 8; m++) {
					for(int n = 0; n < 8; n++) {
						if(input[m+i][n+j] != c1[m][n]) cnt++;
					}
				}
				min = Math.min(min, cnt);
				
//				3-2. c2과 비교해 바꿔야하는 개수 구하기
				cnt = 0;
				for(int m = 0; m < 8; m++) {
					for(int n = 0; n < 8; n++) {
						if(input[m+i][n+j] != c2[m][n]) cnt++;
					}
				}
				min = Math.min(min, cnt);
			}
		}
		
//		4. 결과 출력
		System.out.println(min);
	}

}
