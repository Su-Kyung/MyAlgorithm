package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_S5_2563_색종이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());	//색종이 수
		String[] str;
		int x, y;
		boolean area[][] = new boolean[101][101];	// 1~100 인덱스 사용
		int colored = 0;
		
		for (int n = 0; n < N; n++) {
			// 색종이 좌표 받아오기
			str = br.readLine().split(" ");
			x = Integer.parseInt(str[0]);
			y = Integer.parseInt(str[1]);
			
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					area[i][j] = true;	// 칠해지는 곳 표시
				}
			}
		}
		
		// 칠해진 영역 구하기
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (area[i][j]) colored++;
			}
		}
		
		// 정답 출력
		System.out.println(colored);
	}

}
