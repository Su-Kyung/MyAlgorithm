package swea;
//D4 수지의 수지 맞는 여행
//solved 백준 알파벳과 같은 문제. dfs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_7699_수지의수지맞는여행 {

	static char map[][] = new char[21][21];	//인덱스 1~20 사용
	static int R, C, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim()) + 1;
		for(int t=1; t<T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine()," ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			for(int i=1; i<=R; i++) {
				String str = br.readLine();
				for(int j=1, idx=0; j<=C; j++)
					map[i][j] = str.charAt(idx++);
			}
			
			boolean[] visited = new boolean[26];
			visited[map[1][1]-'A'] = true;
			max = 1;
			dfs(1, 1, visited, 1);
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	static int[][] dir = {{-1,1,0,0},{0,0,-1,1}};
	static void dfs(int r, int c, boolean[] visited, int cnt) {	//현재위치, 방문배열, 명물 개수
		
		for(int i=0, nr=r, nc=c; i<4; i++) {
			nr = r + dir[0][i];
			nc = c + dir[1][i];
			if(nr<1 || nr>R || nc<1 || nc>C) continue;
			
			int piece = map[nr][nc]-'A';
			if(visited[piece]) max = Math.max(max, cnt); 
			else {
				visited[piece] = true;
				dfs(nr, nc, visited, cnt+1);
				visited[piece] = false;
			}
		}
	}

}
