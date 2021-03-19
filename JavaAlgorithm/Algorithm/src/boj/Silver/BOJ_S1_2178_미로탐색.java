package boj.Silver;
//S1 미로 탐색 (너비우선탐색,그래프이론,그래프탐색)
//solved
// bfs 및 방문체크를 하며 시작점으로부터의 거리를 카운트하는 연습하기 좋은 예제인 듯!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_2178_미로탐색 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
//		1. 행렬 입력 받기
		boolean[][] input = new boolean[N][M];
		String str;
		for(int i=0; i<N; i++) {
			str = br.readLine().trim();
			for(int j=0; j<M; j++) {
				input[i][j] = str.charAt(j)=='1'?true:false;	//지나갈 수 있는 곳을 true로 저장
			}
		}
		
//		2. bfs 수행하며 (0,0)부터의 거리 갱신
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0, 0, 1));
		input[0][0]=false;	//이미 방문한 곳은 다시 방문할 수 없으므로 false 설정
		
		Point cur;
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};	//상하좌우
		int nr, nc;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			if(cur.r==N-1 && cur.c==M-1) {	//도착 시 정답 출력
				System.out.println(cur.dist);
				break;
			}
			
			for(int i=0; i<4; i++) {
				nr = cur.r+dir[i][0];
				nc = cur.c+dir[i][1];
				if(nr<0 || nr>=N || nc<0 || nc>=M || !input[nr][nc]) continue;
				input[nr][nc] = false;
				queue.offer(new Point(nr, nc, cur.dist+1));
			}
		}
	}

	static class Point {
		int r, c, dist;
		
		public Point(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
}
