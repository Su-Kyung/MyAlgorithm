package boj.Bronze;

// B1 비밀 이메일(구현)
// solved 24m(5m,19m)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B1_2999_비밀이메일 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = br.readLine().trim();
		int N = msg.length();
		int R=0, C=N;
//		R, C 구하기
		while(++R<=C) if(N%R==0) C=N/R;
		R--;
//		행렬 만들고 문자 입력받기
		char[][] map = new char[R][C];
		for(int r=0, idx=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				map[r][c] = msg.charAt(idx++);
			}
		}
//		문자열 해독하기(열읽기)
		StringBuilder sb = new StringBuilder();
		for(int c=0; c<C; c++) {
			for(int r=0; r<R; r++) {
				sb.append(map[r][c]);
			}
		}
//		출력
		System.out.print(sb.toString());
	}

}
