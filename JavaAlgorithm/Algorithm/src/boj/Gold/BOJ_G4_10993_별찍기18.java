package boj.Gold;
//G4 별 찍기 - 18 (구현,재귀,문자열)
//solved

import java.util.Scanner;

public class BOJ_G4_10993_별찍기18 {
	static int N, size;
	static boolean[][] checkStar;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();

		size = (int)Math.pow(2, N)-1;
		checkStar = new boolean[size][size];
		triangle(N%2==1, N%2==1?size-1:0, 0);
		
		StringBuilder sb = new StringBuilder();
		if(checkStar[0][0]) {	//역삼각형인 경우
			for(int i=0, idx=size; i<size; i++, idx--) {
				for(boolean b : checkStar[i]) if(b) sb.append('*'); else sb.append(' ');
				for(int j=size-2; j>=size-idx; j--) if(checkStar[i][j]) sb.append('*'); else sb.append(' ');
				sb.append("\n");
			}
		} else {	//정삼각형인 경우
			for(int i=0, idx=1; i<size; i++, idx++) {
				for(boolean b : checkStar[i]) if(b) sb.append('*'); else sb.append(' ');
				for(int j=size-2; j>=size-idx; j--) if(checkStar[i][j]) sb.append('*'); else sb.append(' ');
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
	
	private static void triangle(boolean up, int r, int c) {
		if(N==1) {
			checkStar[r][c]=true;
			return;
		}
		
		int h=draw(up, r, c)/2;
		
		N--;
		triangle(!up, r + h*(up?-1:1), c+h+1);
	}

	private static int draw(boolean up, int r, int c) {
		for(int i=c; i<size; i++) checkStar[r][i] = true;	//밑변
		
		int h=1;	//높이
		int gap=up?-1:1;
		while(c<size-1) {
			r+=gap;
			checkStar[r][++c] = true;
			h++;
		}
		return h;
	}

}
