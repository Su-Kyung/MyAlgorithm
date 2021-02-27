package boj.Bronze;
//B1 색종이(구현)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B1_10163 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());	//테스트케이스 수
		int[][] area = new int[101][101];
		
		int x, y;	//좌표
		int width, height;	//가로, 세로 길이
		
		// 색종이 입력값 받아와 평면에 적용하기
		for(int t=1, end=T+1; t<end; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<width; i++) {
				for(int j=0; j<height; j++) {
					area[x+i][y+j] = t;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int[] count = new int[T];
		int temp;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				temp = area[i][j]-1;
				if(temp>-1) {
					count[temp]++;
				}
			}
		}
		
		for(int i=0; i<T; i++) {
			sb.append(count[i]).append("\n");
		}
		System.out.print(sb.toString());
	}

}
