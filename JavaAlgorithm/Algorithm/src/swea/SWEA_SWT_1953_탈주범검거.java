package swea;
//[모의 SW 역량테스트] 탈주범 검거
//solved (bfs)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_SWT_1953_탈주범검거 {
	static class Point {
		int r, c, d, t;	//좌표, 방향, 시간
		public Point(int r, int c, int d, int t) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim())+1;
		int N, M, R, C, L, map[][];
		boolean visited[][];
		Queue<Point> queue;
		int dir[][] = {{-1,1,0,0},{0,0,-1,1}};	//상하좌우
		boolean link[][] = {{false,true,true,false,true,false,false,true},	//상
							{false,true,true,false,false,true,true,false},	//하
							{false,true,false,true,false,false,true,true},	//좌
							{false,true,false,true,true,true,false,false}};	//우
		
		for(int tc=1; tc<T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<M; j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			queue = new LinkedList<Point>();
			queue.offer(new Point(R, C, map[R][C], 1));
			visited[R][C] = true;
			int cnt=1, nr, nc;
			Point cur;
			
			while(!queue.isEmpty()) {
				cur = queue.poll();
				if(cur.t==L) break;
//				System.out.println(cur.r+" "+cur.c+" "+cur.d);
				for(int i=0; i<4; i++) {
					if(link[i][cur.d]) {
						nr = cur.r + dir[0][i];
						nc = cur.c + dir[1][i];
						if(nr==-1 || nr==N || nc==-1 || nc==M || visited[nr][nc] || !link[i+(i%2==0?1:-1)][map[nr][nc]]) continue;
						visited[nr][nc] = true;
						queue.offer(new Point(nr, nc, map[nr][nc], cur.t+1));
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}
