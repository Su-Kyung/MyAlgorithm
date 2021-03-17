package boj.Silver;
// S1 토마토 (너비 우선 탐색,그래프 이론,그래프 탐색)
// solved
// 계속 메모리 초과여서 애먹었는데 불필요한 큐 접근이 많아서였다...

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_7576_토마토_2 {

	static class Tomato {
		int row, col, day;
		public Tomato(int row, int col, int day) {
			this.row = row;
			this.col = col;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		int ans=0;
		
//		1. 토마토 정보 받기
		Queue<Tomato> queue = new LinkedList<Tomato>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) queue.offer(new Tomato(i, j, ans));
			}
		}
		
//		2. 익은 토마토를 시작점으로 bfs
		Tomato cur;	//현재 토마토
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		int nr, nc;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			for(int i=0; i<4; i++) {
				nr = cur.row+dir[i][0];
				nc = cur.col+dir[i][1];
				if(nr==-1 || nr==M || nc==-1 || nc==N || map[nr][nc]!=0) continue;
				map[nr][nc] = 1;
				queue.offer(new Tomato(nr, nc, cur.day+1));
				ans = cur.day+1;
			}
		}
		// 중복되는 경우가 많아 메모리초과
//		while(!queue.isEmpty()) {
//			cur = queue.poll();
//			map[cur.row][cur.col] = 1;
//			for(int i=0; i<4; i++) {
//				nr = cur.row+dir[i][0];
//				nc = cur.col+dir[i][1];
//				if(nr==-1 || nr==M || nc==-1 || nc==N || map[nr][nc]!=0) continue;
//				queue.offer(new Tomato(nr, nc, cur.day+1));
//				ans = cur.day+1;
//			}
//		}
		
//		3. 정답 출력
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(ans);
	}
}
