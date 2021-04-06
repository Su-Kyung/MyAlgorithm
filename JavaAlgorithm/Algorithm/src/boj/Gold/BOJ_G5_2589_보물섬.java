package boj.Gold;
// G5 보물섬 (너비 우선 탐색,브루트포스 알고리즘,그래프 이론,그래프 탐색)
// solved
// 시간초과 날 줄 알았는데 그냥 있는 그대로 bfs하면 풀리는 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_2589_보물섬 {
	static class Land {
		int r, c, dist;	//행, 열, 기준점으로부터의 거리
		public Land(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	static int ans, M, N;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		
//		1. map 입력받기
		for(int i=0; i<M; i++) map[i] = br.readLine().trim().toCharArray();
		
//		2. 행렬 탐색하면서 육지인 경우 bfs하기
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++)
				if(map[i][j]=='L') bfs(i,j);
		}
		
//		3. 정답 출력
		System.out.println(ans);
	}

	static void bfs(int i, int j) {
		Queue<Land> queue = new LinkedList<Land>();
		queue.offer(new Land(i, j, 0));
		boolean[][] visited = new boolean[M][N];
		visited[i][j] = true;
		
		Land cur;
		int nr, nc;
		int[][] dir = {{-1,1,0,0},{0,0,-1,1}};
		while(!queue.isEmpty()) {
			cur = queue.poll();
			
			for(int k=0; k<4; k++) {
				nr = cur.r + dir[0][k];
				nc = cur.c + dir[1][k];
				if(nr==-1 || nr==M || nc==-1 || nc==N || visited[nr][nc] || map[nr][nc]=='W') continue;
				queue.offer(new Land(nr, nc, cur.dist+1));
				ans = Math.max(ans, cur.dist+1);
				visited[nr][nc]=true;
			}
		}
	}
}
