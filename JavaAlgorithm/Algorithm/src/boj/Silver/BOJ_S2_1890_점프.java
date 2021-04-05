package boj.Silver;
//S2 점프 (다이나믹 프로그래밍)
//solved
/* 파이프옮기기2 기초버전
 * bfs로 했다가 메모리초과가 나왔다. 파이프 옮기기는 쉽게 생각했었는데 이 문제는 그 풀이를 참고해야했다.
 * 답안에 대한 범위가 주어졌음에도 path배열을 int로 선언해서 틀렸었다!!!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_1890_점프 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][N];
		StringTokenizer st = null;
		
//		1. map 입력받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
//		2. dp
		long[][] path = new long[N][N];
		path[0][0]=1;	//처음 지점에 도달하는 경로의 수
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0) continue;
				if(j+map[i][j]<N) path[i][j+map[i][j]] += path[i][j];
				if(i+map[i][j]<N) path[i+map[i][j]][j] += path[i][j];
			}
		}
		
//		3. 경로 개수 출력
		System.out.println(path[N-1][N-1]);
	}
}
