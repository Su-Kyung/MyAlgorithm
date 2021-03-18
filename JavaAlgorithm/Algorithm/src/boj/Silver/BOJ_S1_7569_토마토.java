package boj.Silver;
// S1 토미토 (너비우선탐색,그래프이론,그래프탐색)
// solved(3차원 bfs)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_7569_토마토 {

	static class Tomato {
		int row, col, height, day;
		public Tomato(int row, int col, int height, int day) {
			this.row = row;
			this.col = col;
			this.height = height;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] map = new int[M][N][H];
		int ans=0;
		
//		1. 토마토 정보 받기
		Queue<Tomato> queue = new LinkedList<Tomato>();
		for(int k=0; k<H; k++) {
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) queue.offer(new Tomato(i, j, k, ans));
				}
			}
		}
		
//		2. 익은 토마토를 시작점으로 bfs
		Tomato cur;	//현재 토마토
		int[][] dir = {{-1,0,0},{1,0,0},{0,-1,0},{0,1,0},{0,0,-1},{0,0,1}};
		int nr, nc, nh;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			for(int i=0; i<6; i++) {
				nr = cur.row+dir[i][0];
				nc = cur.col+dir[i][1];
				nh = cur.height+dir[i][2];
				if(nr==-1 || nr==M || nc==-1 || nc==N ||
						nh==-1 || nh==H || map[nr][nc][nh]!=0) continue;
				map[nr][nc][nh] = 1;
				queue.offer(new Tomato(nr, nc, nh, cur.day+1));
				ans = cur.day+1;
			}
		}
		
//		3. 정답 출력
		for(int k=0; k<H; k++) {
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j][k]==0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
