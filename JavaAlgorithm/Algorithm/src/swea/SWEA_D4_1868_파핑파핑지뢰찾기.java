package swea;
//D4 파핑파핑 지뢰찾기
//solved
//지뢰를 참조해서 주변 처리를 먼저 해준다는 아이디어가 중요했음!, bfs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_D4_1868_파핑파핑지뢰찾기 {
	static int[][] map = new int[300][300];	//최대 크기 300
	static boolean[][] visited;
	static int N;
	static int dir[][] = {{-1,1,0,0,-1,-1,1,1},{0,0,-1,1,-1,1,-1,1}};	//상 하 좌 우 좌상 우상 좌하 우하
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine().trim()) + 1;
		for(int tc=1; tc<TC; tc++) {
			int ans = 0;
			sb.append("#").append(tc).append(" ");
			
//			1. 표 입력받기
			N = Integer.parseInt(br.readLine().trim());
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++)
					map[i][j] = str.charAt(j)=='.'?0:9;	//지뢰:9
			}
			
//			2. 행, 열을 순서대로 탐색하며 지뢰인 부분에 대해 8방에 지뢰 있다고 표시
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==9) hasMine(i, j);
				}
			}
			
//			3. 연결되는 부분, 즉 0인 곳을 찾아 bfs 수행하며 중복되어 세어지지 않도록 하기
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					if(map[i][j]==0 && !visited[i][j]) {
						ans++;
						bfs(i, j);
					}
			}
			
//			4. 다른 곳과 연결되지 않은 지점을 더해준다.
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					if(!visited[i][j] && map[i][j]<9) ans++;
			}
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static class Pos {
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(r, c));
		visited[r][c] = true;
		Pos cur;
		int nr, nc;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int i=0; i<8; i++) {
				nr = cur.r + dir[0][i];
				nc = cur.c + dir[1][i];
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				if(map[nr][nc]==0) q.offer(new Pos(nr, nc));
			}
		}
	}
	
	static void hasMine(int r, int c) {	//지뢰 주변에 지뢰 있다고 1 추가해주기
		for(int i=0, nr=r, nc=c; i<8; i++) {
			nr = r + dir[0][i];
			nc = c + dir[1][i];
			if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]==9) continue;
			map[nr][nc]++;
		}
	}
}


/*
2
3
..*
..*
**.
5
..*..
..*..
.*..*
.*...
.*...
 */
