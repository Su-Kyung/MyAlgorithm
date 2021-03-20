package boj.Silver;
//S2 나이트의 이동 (너비우선탐색,그래프이론,그래프탐색)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_7562_나이트의이동 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		int size, sr, sc, er, ec;	//크기, 시작점, 끝점
		boolean[][] visited;
		StringTokenizer st;
		int[][] dir = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}};
		
		for(int t=0; t<T; t++) {
			size = Integer.parseInt(br.readLine().trim());
			visited = new boolean[size][size];
			//시작점, 끝점 입력받기
			st = new StringTokenizer(br.readLine()," ");
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			//bfs
			Queue<Point> queue = new LinkedList<Point>();
			queue.offer(new Point(sr, sc, 0));
			visited[sr][sc] = true;
			Point cur;
			
			while(!queue.isEmpty()) {
				cur = queue.poll();
				
				//도착한 경우 종료
				if(cur.r==er && cur.c==ec) {
					System.out.println(cur.dist);
					break;
				}
				
				int nr, nc;
				for(int i=0; i<8; i++) {
					nr = cur.r + dir[i][0];
					nc = cur.c + dir[i][1];
					if(nr<0 || nr>=size || nc<0 || nc>=size || visited[nr][nc]) continue;
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc, cur.dist+1));
				}
			}
		}
	}

	static class Point {
		int r, c, dist;
		
		public Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
}
