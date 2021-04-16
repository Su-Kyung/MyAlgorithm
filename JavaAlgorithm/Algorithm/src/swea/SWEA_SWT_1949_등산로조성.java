package swea;
//[모의 SW 역량테스트] 등산로 조성 (맵에 변화 있는 dfs)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_SWT_1949_등산로조성 {
	static int ans, N, K, map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim())+1;
		int max;	//최대 높이
		
		for(int t=1; t<T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans=0; max=0;
			
//			1. 높이 입력 받기
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
//			2. 최대 높이인 곳에서 dfs 수행
			boolean visited[][];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					if(map[i][j]==max) {
						visited = new boolean[N][N];
						visited[i][j] = true;
						dfs(i, j, map[i][j], 1, true, visited);	//행,열,높이,공사가능여부,방문배열
					}
			}
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static int[][] dir = {{-1,1,0,0},{0,0,-1,1}};
	static void dfs(int r, int c, int top, int dist, boolean canBreak, boolean[][] visited) {
		
		int nr, nc, nt; boolean nb;
		for(int i=0; i<4; i++) {
			nr = r + dir[0][i];
			nc = c + dir[1][i];
			if(nr==-1 || nr==N || nc==-1 || nc==N || visited[nr][nc]) continue;
			
			nt = map[nr][nc];
			if(nt<top) nb=canBreak;
			else if(!canBreak || nt-top+1>K) continue;
			else {
				nb = false;
				nt = top-1;
			}
			
			visited[nr][nc] = true;
			dfs(nr, nc, nt, dist+1, nb, visited);
			ans = Math.max(ans, dist+1);
			visited[nr][nc] = false;
		}
	}
}
