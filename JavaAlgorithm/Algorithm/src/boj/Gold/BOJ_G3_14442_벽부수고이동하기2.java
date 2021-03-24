package boj.Gold;
//G3 벽 부수고 이동하기 2 (너비 우선 탐색,그래프 이론,그래프 탐색)
//solved
//1 풀 때는 끙끙댔는데 해결 팁을 알기도 했지만 오히려 k개라고 정수로 풀면된다는게 주어지니까 더 쉽게 느껴졌다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_14442_벽부수고이동하기2 {

	static class Point {
		int r, c, d, k;	//좌표, 거리, 부순 벽 개수
		
		public Point(int r, int c, int d, int k) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.k = k;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
//		1. N,M,K 입력받기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
//		2. 배열(map) 입력받기
		char[][] map = new char[N][M];
		for(int i=0; i<N; i++) map[i] = br.readLine().toCharArray();
		
//		3. bfs 위한 준비
//		3-1. Queue 생성
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0, 0, 1, 0));
//		3-2. 방문 처리 배열
		boolean[][][] visited = new boolean[N][M][K+1];
		visited[0][0][0]=true;
		
//		4. bfs
		Point cur;
		int nr, nc;
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};	//우하좌상
		while(!queue.isEmpty()) {
			cur = queue.poll();
			
//			5-1. 목적지에 도착한 경우 거리 출력
			if(cur.r==N-1 && cur.c==M-1) {
				System.out.println(cur.d);
				return;
			}
			
//			6. 아직 도착하지 못했다면 4방탐색하며 새로운 이동 지점 추가
			for(int i=0; i<4; i++) {
				nr = cur.r+dir[i][0];
				nc = cur.c+dir[i][1];
				if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc][cur.k]) continue;
				
				//부술 수 있는 벽이 남았다면
				if(map[nr][nc]=='1' && cur.k<K) {
					visited[nr][nc][cur.k+1] = true;
					queue.offer(new Point(nr, nc, cur.d+1, cur.k+1));
				}
				
				//갈 수 있는 곳이라면
				if(map[nr][nc]=='0') {
					visited[nr][nc][cur.k] = true;
					queue.offer(new Point(nr, nc, cur.d+1, cur.k));
				}
			}
		}
		
//		5-2. 반복문을 빠져나왔다면 -1 출력
		System.out.println(-1);
	}
}
