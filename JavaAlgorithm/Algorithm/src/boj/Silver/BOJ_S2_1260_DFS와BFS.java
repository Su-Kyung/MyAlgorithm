package boj.Silver;
//S2 DFS와 BFS (너비 우선 탐색,깊이 우선 탐색, 그래프 이론, 그래프 탐색)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_1260_DFS와BFS {
	static int N, V;
	static boolean[][] map;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		int r, c;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map[r][c] = map[c][r] = true;
		}
		
		sb = new StringBuilder();
		dfs(V);
		sb.append("\n");
		bfs();
		
		System.out.println(sb.toString());
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		sb.append(cur).append(" ");
		for(int i=1, end=N+1; i<end; i++) {
			if(map[cur][i] && !visited[i]) dfs(i);
		}
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited = new boolean[N+1];
		int cur=V;
		
		visited[cur] = true;
		queue.offer(cur);
		
		while(!queue.isEmpty()) {
			cur = queue.poll();
			sb.append(cur).append(" ");
			for(int i=1, end=N+1; i<end; i++) {
				if(map[cur][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
