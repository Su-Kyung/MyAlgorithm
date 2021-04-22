package boj.Gold;
//G1 달이 차오른다, 가자. (비트마스킹,너비 우선 탐색,그래프 이론,그래프 탐색)
//solved 비트마스킹 연습!! key값에 대한 처리에 신경써야 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G1_1194_달이차오른다가자 {

	static class Point {
		int r, c, h, m;
		public Point(int r, int c, int h, int m) {
			this.r = r;	//행
			this.c = c;	//열
			this.h = h;	//visited배열의 인덱스(찾은 열쇠)
			this.m = m;	//움직인 횟수
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println(1<<('f'-'a'+1));
//		System.out.println('a'-'A');
//		System.out.println('A'-'A');
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][M];
		boolean visited[][][] = new boolean[N][M][1<<('F'-'A'+1)];
		Queue<Point> q = new LinkedList<Point>();
		int[][] dir = {{-1,1,0,0},{0,0,-1,1}};	//상하좌우
		
		for(int i=0; i<N; i++) {	//미로 입력받기
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(map[i][j]=='0') {	//시작점 확인
					q.offer(new Point(i, j, 0, 0));
					visited[i][j][0] = true;
				}
			}
		}
		
		//bfs
		Point cur;
		char curMap;
		int min=-1, nr, nc, nh;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(map[cur.r][cur.c]=='1') { 	//1이라면 미로 탈출
				min = min==-1?cur.m:Math.min(min, cur.m);
				break;
			}
			
			for(int i=0; i<4; i++) {
				nr = cur.r + dir[0][i];
				nc = cur.c + dir[1][i];
				nh = cur.h;
				if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc][nh] || map[nr][nc]=='#') continue;
				
				visited[nr][nc][nh] = true;
				curMap = map[nr][nc];
				
				if(curMap!='.' && curMap!='0' && curMap!='1') {
					//소문자라면: or연산해서 키 가졌다고 표시
					if(curMap-'A'>31) nh = cur.h | (1<<(curMap-'A'-32));	//소문자인 경우이므로 'a'를 빼주는 것이 더 효율적
					//대문자라면: 해당 키가 존재하지 않으면 continue
					else if( ((1<<(curMap-'A')) & nh) == 0 ) continue;
//					System.out.println(nh);
				}
				
				//다음으로 이동
//				System.out.println(nr+" "+nc+" "+nh);
				q.offer(new Point(nr, nc, nh, cur.m+1));
			}
		}
		
		System.out.println(min);
	}

}
