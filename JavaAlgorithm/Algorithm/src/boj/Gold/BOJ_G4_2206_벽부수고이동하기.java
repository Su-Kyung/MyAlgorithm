package boj.Gold;
//G4 벽 부수고 이동하기 (너비 우선 탐색,그래프 이론,그래프 탐색)
//solved
/* 벽 부수기 여부를 boolean으로 접근했어서 계속 틀렸었다.
 * visit배열을 3차원으로 쓸 생각을 못했음.
 * 벽을 부수는 순간 새로운 판이 깔린다고 생각하자!
 * 
 * 배열에 충실하게 푼 풀이는 벽 부수고 이동하기2
 * 아래는 boolean을 살려서 수정했다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_2206_벽부수고이동하기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
//		1. map 입력받기
		char[][] map = new char[M][N];
		for(int i=0; i<M; i++) map[i] = br.readLine().toCharArray();
		
//		2. bfs에 필요한 큐 생성
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 1, true));
		boolean[][][] visited = new boolean[M][N][2];
		visited[0][0][0] = true;
		Point cur;
		int p;
		
//		3. bfs
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		while(!queue.isEmpty()) {
			cur = queue.poll();
			p = cur.pass?0:1;
			
			// 4. 도착 시 출력 후 프로그램 종료
			if(cur.r==M-1 && cur.c==N-1) {
				System.out.println(cur.dist);
				return;
			}
			
			int nr, nc;
			for(int i=0; i<4; i++) {	//4방탐색
				nr = cur.r+dir[i][0];
				nc = cur.c+dir[i][1];
				if(nr<0 || nr>=M || nc<0 || nc>=N || visited[nr][nc][p]) continue;
				if(map[nr][nc]=='0') {
					visited[nr][nc][p] = true;
					queue.offer(new Point(nr, nc, cur.dist+1, cur.pass));
				}
				else if(map[nr][nc]=='1' && cur.pass) {
					visited[nr][nc][p] = false;
					queue.offer(new Point(nr, nc, cur.dist+1, false));
				}
			}
		}
		
//		5. 반복문을 벗어났다면 -1 출력
		System.out.println(-1);
	}

	static class Point{
		int r, c, dist;	//좌표, 거리
		boolean pass;	//벽을 부술 수 있는가?
		
		public Point(int r, int c, int dist, boolean pass) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.pass = pass;
		}
	}
}

/*
5 5
00000
11101
00001
01111
00010

*/