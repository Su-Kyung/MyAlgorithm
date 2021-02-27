package boj.Silver;
// S1 별찍기-10 (분할 정복, 재귀)
// solved(1h 18m)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_S1_2447 {
	static int N;
	static boolean[][] area;
	public static void main(String[] args) throws Exception {
//		1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
//		2. 배열 생성
		area = new boolean[N][N];
		
//		3. 공백이 들어갈 자리인지 체크
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(area[i][j]) continue;
				whiteCheck(1, N, i, j);
			}
		}
		
//		4. 배열에 문자 채우기
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!area[i][j]) sb.append('*');
				else sb.append(' ');
			}
			sb.append('\n');
		}
		
//		5. 출력
		System.out.print(sb);
	}

	private static void whiteCheck(int rest, int share, int row, int col) {
		if(rest==share) {
			return;
		}
		if(row%(rest*3)==rest && col%(rest*3)==rest) {
			for(int i = 0; i < rest; i++) {
				for(int j = 0; j < rest; j++) {
					area[row+i][col+j]=true;
				}
			}
			return;
		}
		whiteCheck(rest*3, share, row, col);
	}
}
