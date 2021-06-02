package boj.Silver;
//S1 봄버맨 (너비 우선 탐색,그래프 이론,그래프 탐색,구현)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_16918_봄버맨 {
	static char[][] map;
	static int[][] dir = {{0, -1, 1, 0, 0}, {0, 0, 0, -1, 1}};	//중심,상,하,좌,우
	static Queue<Point> posBomb = new LinkedList<Point>();	// 새롭게 설치된 폭탄 위치 넣어두기
	static int R, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken())-1;		//초기 1초 동안 아무것도 하지 않으므로 1을 빼서 저장한다.
		
//		1. 가장 처음 일부 칸에 설치된 폭탄 입력 받기
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				if(map[i][j]=='O') posBomb.offer(new Point(i, j));
			}
		}
		
//		2. (N-1)초 동안 반복
		while(N-->0) {
//			3. 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j]=='.') map[i][j]='O';
				}
			}
			if(N--<=0) break;
			
//			4. 3초 전에 설치된 폭탄 모두 폭발
			bomb();
		}
		
//		5. 정답 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void bomb() {
		//폭발
		Point point;
		while(!posBomb.isEmpty()) {
			point = posBomb.poll();
			for(int i=0; i<5; i++) {
				int nr = point.r + dir[0][i];
				int nc = point.c + dir[1][i];
				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				map[nr][nc] = '.';
			}
		}
		
		//남은 폭탄으로 새로운 큐 생성
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='O') posBomb.offer(new Point(i, j));
			}
		}
	}
	
	static class Point {
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
