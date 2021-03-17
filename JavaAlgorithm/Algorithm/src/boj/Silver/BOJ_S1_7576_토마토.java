package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_7576_토마토 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		int ans=0;
		
//		1. 토마토 정보 받기
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) queue.add(new Integer[] {i, j, ans});
			}
		}
		
//		2. 익은 토마토를 시작점으로 bfs
		Integer[] cur;	//현재 토마토
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		int nr, nc;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			map[cur[0]][cur[1]] = 1;
			for(int i=0; i<4; i++) {
				nr = cur[0]+dir[i][0];
				nc = cur[1]+dir[i][1];
				if(nr==-1 || nr==M || nc==-1 || nc==N || map[nr][nc]!=0) continue;
				queue.offer(new Integer[] {nr, nc, cur[2]+1});
				ans = cur[2]+1;
			}
		}
		
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
