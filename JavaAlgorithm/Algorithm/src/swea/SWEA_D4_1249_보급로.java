package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SWEA_D4_1249_보급로 {
	static int minTime, N;	//최소시간, 지도의 크기
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim())+1;
		
		for(int tc=1; tc<T; tc++) {
//			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			minTime = Integer.MAX_VALUE;
//			1. 지도 정보 받기
			String str;
			for(int i=0; i<N; i++) {
				str = br.readLine().trim();
				for(int j=0; j<N; j++) map[i][j] = str.charAt(j)-'0';
			}
			
//			2. bfs
			boolean[][] visited = new boolean[N][N];
			PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<Integer[]>() {
				@Override
				public int compare(Integer[] o1, Integer[] o2) {
					return o1[2]-o2[2];
				}
			});
			pq.offer(new Integer[] {0, 0, 0});
			int[][] dir = {{-1,1,0,0},{0,0,-1,1}};
			Integer[] cur;
			int nr, nc;
			while(!pq.isEmpty()) {
				cur = pq.poll();
				if(cur[0]==N-1 && cur[1]==N-1) {
					minTime = Math.min(minTime, cur[2]);
					break;
				}
				
				for(int i=0; i<4; i++) {
					nr = cur[0]+dir[0][i];
					nc = cur[1]+dir[1][i];
					if(nr==-1 || nr==N || nc==-1 || nc==N || visited[nr][nc]) continue;
					visited[nr][nc]=true;
					pq.offer(new Integer[] {nr, nc, cur[2]+map[nr][nc]});
				}
			}
			
////		2. dfs: 시간초과
//			boolean[][] visited = new boolean[N][N];
//			visited[0][0] = true;
//			dfs(0, 0, visited, 0);	//현재 좌표, 방문상태, 소요 시간
		
//			3. 정답
			sb.append(minTime).append("\n");
//			System.out.println(sb);
		}
		
		System.out.println(sb);
	}

	//dfs
//	static int[][] dir = {{-1,1,0,0},{0,0,-1,1}};
//	static void dfs(int r, int c, boolean[][] visited, int curTime) {
//		if(r==N-1 && c==N-1) {
//			minTime = Math.min(minTime, curTime);
//			return;
//		}
//		
//		if(curTime<minTime) {
//			int nr, nc;
//			for(int i=0; i<4; i++) {
//				nr = r+dir[0][i];
//				nc = c+dir[1][i];
//				if(nr==-1 || nr==N || nc==-1 || nc==N || visited[nr][nc]) continue;
//				visited[nr][nc]=true;
//				dfs(nr, nc, visited, curTime+map[nr][nc]);
//				visited[nr][nc]=false;
//			}
//		}
//	}
}

/*
1
4
01234
79999
09999
00000

1
4
01234
76999
09999
00000
 */
