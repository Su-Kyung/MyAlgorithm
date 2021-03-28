package boj.Gold;
//G4 불! (너비 우선 탐색,그래프 이론,그래프 탐색)
//solved
//5427불과 똑같은 문제. 다른 풀이방법으로 풀었다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_4179_불 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		
		Queue<Integer[]> qPerson = new LinkedList<Integer[]>();
		Queue<Integer[]> qFire = new LinkedList<Integer[]>();
//		맵 입력 받기
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().trim().toCharArray();
			for(int j=0; j<C; j++) {
				switch(map[i][j]) {
				case '#':
					visited[i][j] = true;
					break;
				case 'J':
					visited[i][j] = true;
					qPerson.offer(new Integer[] {i, j, 0});
					break;
				case 'F':
					visited[i][j] = true;
					qFire.offer(new Integer[] {i, j});
					break;
				default: break;
				}
			}
		}
		
//		bfs
		Integer[] cur;
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		while(!qPerson.isEmpty()) {
			
//			불 번지기
			for(int i=0, end=qFire.size(); i<end; i++) {
				cur = qFire.poll();
				
				int nr, nc;
				for(int d=0; d<4; d++) {
					nr = cur[0] + dir[d][0];
					nc = cur[1] + dir[d][1];
					if(nr==-1 || nr==R || nc==-1 || nc==C || map[nr][nc]=='#' || map[nr][nc]=='F') continue;
					visited[nr][nc] = true;
					map[nr][nc] = 'F';
					qFire.offer(new Integer[] {nr, nc});
				}
			}
			
//			지훈이 이동하기
			for(int i=0, end=qPerson.size(); i<end; i++) {
				cur = qPerson.poll();
				
				int nr,nc;
				for(int d=0; d<4; d++) {
					nr = cur[0] + dir[d][0];
					nc = cur[1] + dir[d][1];
					if(nr==-1 || nr==R || nc==-1 || nc==C) {	//탈출한 경우
						System.out.println(cur[2]+1);
						return;
					}
					if(map[nr][nc]=='.' && !visited[nr][nc]) {
						visited[nr][nc] = true;
						qPerson.offer(new Integer[] {nr, nc, cur[2]+1});
					}
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}
}
