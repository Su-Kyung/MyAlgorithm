package boj.Silver;
//S1 정수 삼각형 (다이나믹 프로그래밍)
//solved
//맨 아래층부터 위로 올라갈 때 더 큰 값을 저장하면서 맨 위까지 올라가는 방식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_1932_정수삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		long triangle[][] = new long[N][N];
		
//		1. 삼각형 값 입력받기
		StringTokenizer st = null;
		for(int i=1, end=N+1; i<end; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<i; j++) {
				triangle[i-1][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		2. 맨 아래 행부터 탐색
		for(int i=N-2; i>-1; i--) {		//행(맨 아래-1 번째)
			for(int j=0, end=i+1; j<end; j++) {	//열
				triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
			}
		}
		
//		3. 답 출력
		System.out.println(triangle[0][0]);
	}

}
