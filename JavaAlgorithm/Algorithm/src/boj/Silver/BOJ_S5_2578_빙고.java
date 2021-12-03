package boj.Silver;
// S5 구현
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_2578_빙고 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		boolean[][] pan = new boolean[5][5];
		Point[] numbers = new Point[26];

		// 빙고판 입력
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				numbers[Integer.parseInt(st.nextToken())] = new Point(i, j);
			}
		}

		// 사회자가 부르는 수
		loop:
		for (int i = 0, call = 1; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++, call++) {
				Point p = numbers[Integer.parseInt(st.nextToken())];
				pan[p.x][p.y] = true;
				
				if(bingo(pan)) {
					System.out.println(call);
					break loop;
				}
			}
		}
	}

	private static boolean bingo(boolean[][] pan) {
		int cnt = 0;	//빙고 수
		
		// 가로
		for(int i = 0; i < 5; i++) {
			if(pan[i][0] && pan[i][1] && pan[i][2] && pan[i][3] && pan[i][4])
				cnt++;
		}
		if(cnt >= 3)
			return true;
		
		// 세로
		for(int i = 0; i < 5; i++) {
			if(pan[0][i] && pan[1][i] && pan[2][i] && pan[3][i] && pan[4][i])
				cnt++;
		}
		if(cnt >= 3)
			return true;
		
		// 대각선
		if(pan[0][0] && pan[1][1] && pan[2][2] && pan[3][3] && pan[4][4])
			cnt++;
		if(pan[0][4] && pan[1][3] && pan[2][2] && pan[3][1] && pan[4][0])
			cnt++;
		if(cnt >= 3)
			return true;
		
		return false;
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
