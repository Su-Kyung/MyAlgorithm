package boj.Gold;
//G4 아기 상어 (너비 우선 탐색,그래프 이론,그래프 탐색,구현,시뮬레이션)
//solved 우선순위 큐 사용하는 것이 키포인트!!! + map 처리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_16236_아기상어 {
	static int size=2, pos_r, pos_c, N, map[][];	//상어의 크기, 상어의 위치, 공간의 크기, 공간의 상태
	static int dir[][] = {{-1,0,0,1},{0,-1,1,0}};
	static PriorityQueue<Point> pq = new PriorityQueue<>();
	
	static class Point implements Comparable<Point>{
		int r, c, dist;
		
		public Point(int r, int c, int dist) {
			this.r = r;
			this.c = c; 
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Point o) {	//거리 > 행 > 열 순으로 우선순위 부여 (숫자는 모두 오름차순)
			if(this.dist == o.dist) {
				if(this.r == o.r) return this.c - o.c;
				else return this.r - o.r;
			} else return this.dist - o.dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		
//		1. 공간의 상태 입력받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {	//상어의 위치
					map[i][j] = 0;
					pos_r = i; pos_c = j;
				}
			}
		}
		
//		2. 상어 이동
		int time=0, cnt=0, nr, nc;	//총 걸리는 시간 (답), 섭취한 물고기 수, 상어가 새롭게 이동할 좌표
		Point cur;	//현재 참조하는 상어
		boolean canEat, visited[][];	//물고기 먹을 수 있는지 체크, 방문 체크
		
		do {
			canEat = false;
			visited = new boolean[N][N];
			visited[pos_r][pos_c] = true;
			pq.offer(new Point(pos_r, pos_c, 0));
			
//			2-1. bfs
			while(!pq.isEmpty()) {
				cur = pq.poll();
				
//				3. 물고기 먹을 수 있는지 검사
				if(map[cur.r][cur.c]!=0 && map[cur.r][cur.c]<size) {	//물고기를 발견한 경우
//					3-1. 물고기 먹고, 아기상어는 새로운 좌표로 이동
					canEat = true;	
					cnt++;
					map[cur.r][cur.c] = 0;
					time += cur.dist;
					pos_r = cur.r; pos_c = cur.c;
					pq.clear();
					
//					3-2. 상어의 크기 갱신
					if(size==cnt) { size++; cnt=0; }
					
					break ;
				}
				
//				4. 물고기 아니라면 계속해서 탐색
				for(int i=0; i<4; i++) {
					nr = cur.r + dir[0][i];
					nc = cur.c + dir[1][i];
					
					if(nr==-1 || nr==N || nc==-1 || nc==N || visited[nr][nc] || map[nr][nc]>size) continue;
					
					pq.offer(new Point(nr, nc, cur.dist+1));
					visited[nr][nc] = true;
				}
			}
			
		} while(canEat);	//상어가 먹을 물고가 수가 없다면 종료
		
//		3. 정답 출력
		System.out.println(time);
	}
}

/*
1 1 1 1
1 1 0 1 
1 1 0 3
3 5 1 5
 */
/*
? ? 1 ? ?
? 2 x 3 ?
4 x C x 6
? 5 x 7 ?
? ? 8 ? ?
*/