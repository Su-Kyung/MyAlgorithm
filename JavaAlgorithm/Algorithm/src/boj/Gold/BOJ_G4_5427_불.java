package boj.Gold;
//G4 불 (너비 우선 탐색,그래프 이론,그래프 탐색)
//solved
/* 문제에 힌트가 대놓고 있는데 제대로 안읽어서 로직 생각해내는데 엄청오래걸렸다.
 * 최적화:
 * 	불 먼저 bfs 수행 -> 큐에 이미 상근이 위치표시되어 있으므로 상근이와 관계없이 그냥 불 번지면 된다!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_5427_불 {

	static class Point {
		int r, c, t;	//좌표, 시간
		public Point(int r, int c, int t) {	//상근이
			this.r = r;
			this.c = c;
			this.t = t;
		}
		public Point(int r, int c) {	//불
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		int T = Integer.parseInt(br.readLine().trim());
		
//		1. 테스트케이스 수만큼 반복
		testcase:
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
//			2. map 입력 받기
			char[][] map = new char[H][W];
			boolean[][] visited = new boolean[H][W];
			
			Queue<Point> qPerson = new LinkedList<Point>();	//상근이
			Queue<Point> qFire = new LinkedList<Point>();	//불
			
			String str;
			for(int i=0; i<H; i++) {
				str = br.readLine().trim();
				for(int j=0; j<W; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='*') qFire.offer(new Point(i, j));			//불 혹은 상근이 위치일 때 queue에 추가
					else if(map[i][j]=='@') qPerson.offer(new Point(i, j, 1));	//t가 0이면 fire
					
					if(map[i][j]!='.') visited[i][j] = true;					//빈 공간(갈 수 있는 곳) 빼고 모두 방문처리
				}
			}
			
//			3. bfs 수행
			Point cur, fire;
			int nr, nc;
			while(!qPerson.isEmpty()) {
				
				// 4. 상근이 이동
				for(int i=0, end=qPerson.size(); i<end; i++) {
					cur = qPerson.poll();
					if(map[cur.r][cur.c]!='@') continue;	//불에 먹한 상근이,,라면 pass
					for(int j=0; j<4; j++) {
						nr = cur.r + dir[j][0];
						nc = cur.c + dir[j][1];
						//빌딩 탈출한 경우
						if(nr==-1 || nr==H || nc==-1 || nc==W) {	
							sb.append(cur.t).append("\n");
							continue testcase;
						}
						//이동
						if(!visited[nr][nc]) {
							visited[nr][nc]=true;
							map[nr][nc]='@';
							qPerson.offer(new Point(nr, nc, cur.t+1));
						}
					}
					map[cur.r][cur.c]='.';
				}
				
				// 5. 불 번지기
				for(int i=0, end=qFire.size(); i<end; i++) {
					fire = qFire.poll();
					for(int j=0; j<4; j++) {
						nr = fire.r + dir[j][0];
						nc = fire.c + dir[j][1];
						if(nr==-1 || nr==H || nc==-1 || nc==W || map[nr][nc]=='#') continue;
						
						if(map[nr][nc]=='@' || !visited[nr][nc]) {
							visited[nr][nc]=true;
							map[nr][nc]='*';
							qFire.offer(new Point(nr, nc));
						}
					}
				}
			}
			//탈출하지 못했다면
			sb.append("IMPOSSIBLE\n");
		}
		System.out.println(sb.toString());
	}
}


/*
2
2 2
@*
..
4 4
####
@..#
*#..
*###
==>
1
1

1
7 7
#.#####
#.....#
#####.#
#....*#
####.##
#@....#
#####.#
==>IMPOSSIBLE

5
4 3
####
#*@.
####
7 6
###.###
#*#.#*#
#.....#
#.....#
#..@..#
#######
7 4
###.###
#....*#
#@....#
.######
5 5
.....
.***.
.*@*.
.***.
.....
3 3
###
#@#
###
==>
2
5
IMPOSSIBLE
IMPOSSIBLE
IMPOSSIBLE
*/