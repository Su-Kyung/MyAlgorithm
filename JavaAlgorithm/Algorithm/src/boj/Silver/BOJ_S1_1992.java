package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//S1 쿼드트리(분할정복, 재귀)
//solved

public class BOJ_S1_1992 {

	static int[][] video;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		video = new int[N][N];
//		1. 영상을 입력받아 2차원 배열에 저장		
		String str;
		for(int i=0; i<N; i++) {
			str = br.readLine();
			for(int j=0; j<N; j++) {
				video[i][j] = str.charAt(j)-'0';
			}
		}
		
//		2. 영상 압축(재귀)
		sb = new StringBuilder();
		compress(0, 0, N, sb);
		
//		3. 출력
		System.out.print(sb);
	}

	private static void compress(int startR, int startC, int size, StringBuilder s) {
		if(check(video, startR, startC, size, 0)) {
			s.append(0);
			return;
		} else if(check(video, startR, startC, size, 1)) {
			s.append(1);
			return;
		}
		s.append("(");
		compress(startR, startC, size/2, s);
		compress(startR, startC+size/2, size/2, s);
		compress(startR+size/2, startC, size/2, s);
		compress(startR+size/2, startC+size/2, size/2, s);
		s.append(")");
	}

	private static boolean check(int[][] arr, int r, int c, int s, int n) {
		for(int i=r, end=r+s; i<end; i++) {
			for(int j=c, end2=c+s; j<end2; j++) {
				if(arr[i][j] != n) return false;
			}
		}
		return true;
	}
}
