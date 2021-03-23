package boj.Silver;
//S1 RGB거리(다이나믹프로그래밍)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_1149_RGB거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] color = new int[N][3];
		
		//비용 입력 받기
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<3; j++) color[i][j]=Integer.parseInt(st.nextToken());
//			System.out.println(Arrays.toString(color[i]));
		}
		
		//dp
		int[][] sum = new int[N][3];
		sum[0][0] = color[0][0];
		sum[0][1] = color[0][1];
		sum[0][2] = color[0][2];
		
		for(int i=1; i<N; i++) {
			sum[i][0] = Math.min(sum[i-1][1], sum[i-1][2]) + color[i][0];
			sum[i][1] = Math.min(sum[i-1][2], sum[i-1][0]) + color[i][1];
			sum[i][2] = Math.min(sum[i-1][0], sum[i-1][1]) + color[i][2];
		}
		
		//답 출력
		System.out.println(Math.min(Math.min(sum[N-1][0], sum[N-1][1]), sum[N-1][2]));
	}
}
