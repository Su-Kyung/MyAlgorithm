package boj.Gold;
//G4 알고스팟 (0-1너비우선탐색,다익스트라,그래프 이론)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_1261_알고스팟 {
	static int M, N, map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [M][N];
		
		for(int i=0; i<M; i++) {
			String str = br.readLine().trim();
			for (int j=0; j<N; j++)
				map[i][j] = str.charAt(j)-'0';
		}
		
		System.out.println(bfs());
	}

	static int[][] dir = {{-1,1,0,0},{0,0,-1,1}};	//4방탐색
	static int bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, 0));
		boolean[][] visited = new boolean[M][N];
		visited[0][0] = true;
		
		Point cur;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(cur.r==M-1 && cur.c==N-1) return cur.b;	//도착지에 다다르면 부신 벽 개수 리턴
			
			int nr, nc;
			for(int i=0; i<4; i++) {
				nr = cur.r + dir[0][i];
				nc = cur.c + dir[1][i];
				if(nr<0 || nr>=M || nc<0 || nc>=N || visited[nr][nc]) continue;
				
				pq.offer(new Point(nr, nc, cur.b + map[nr][nc]));	//벽을 부셨으면 1을 더하기
				visited[nr][nc] = true;
			}
		}
		return 0;
	}
	
	static class Point implements Comparable<Point>{
		int r, c, b;
		public Point(int r, int c, int b) {
			this.r = r;
			this.c = c;
			this.b = b;
		}
		@Override
		public int compareTo(Point o) {	//부신 벽 개수에 따라 오름차순 정렬
			return this.b - o.b;
		}
	}
}
