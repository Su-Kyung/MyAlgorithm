package boj.Silver;
//S1 구간 합 구하기 5 (다이나믹 프로그래밍,누적 합)
//solved (나는 행에 대해서만 누적했는데 행, 열 모두에 대해서 누적할 수 있다.)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
//		1. 표 입력받기
		int numbers[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				numbers[i][j] = Integer.parseInt(st.nextToken());
				if(j>0) numbers[i][j] += numbers[i][j-1];
			}
		}
		
//		2. 케이스별로 합 구하기
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sr = Integer.parseInt(st.nextToken())-1;
			int sc = Integer.parseInt(st.nextToken())-1;
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken())-1;
			
			int sum=0;
			for(int r=sr; r<er; r++) {
				sum += numbers[r][ec];
				if(sc!=0) sum-=numbers[r][sc-1];
			}
			
			sb.append(sum).append("\n");
		}
		
//		3. 정답 출력
		System.out.println(sb);
	}

}
