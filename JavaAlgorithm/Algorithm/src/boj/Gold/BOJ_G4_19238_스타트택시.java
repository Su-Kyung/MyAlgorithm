package boj.Gold;
//G4 스타트 택시 (너비 우선 탐색,그래프 이론,그래프 탐색,구현,시뮬레이션)
//solved
/* <실수한 부분>
 * - 타는곳, 목적지가 동일한 경우
 * - 모든 승객의 타는곳과 목적지가 다르다는 보장이 없다 
 * 따라서, map자체에 값을 지정하면 안된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_19238_스타트택시 {
	static int map[][], N, goalList[][], taxi_r, taxi_c, goal;
	static class Pos implements Comparable<Pos>{
		int r, c, d;	//위치, 거리
		public Pos(int r, int c, int d) {
			this.r = r; this.c = c; this.d = d;
		}
		
		@Override
		public int compareTo(Pos o) {
			if(this.d==o.d) {
				if(this.r==o.r) return this.c - o.c;	//3순위 열: 오름차순
				else 			return this.r - o.r;	//2순위 행: 오름차순
			} else return this.d - o.d;		//1순위 거리: 오름차순
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
//		1. 입력받기
		N = Integer.parseInt(st.nextToken());	//격자 크기
		int M = Integer.parseInt(st.nextToken());	//손님 수
		int charge = Integer.parseInt(st.nextToken());	//초기 연료
		
//		1-2. 맵 입력받기
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) 
				map[i][j] = Integer.parseInt(st.nextToken())*(-1);	//벽-> -1로
		}
		
//		1-3. 백준의 운전시작 지점, 승객의 출발~도착지 행열번호 입력받기
		st = new StringTokenizer(br.readLine()," ");
		taxi_r = Integer.parseInt(st.nextToken()) - 1;	//백준의 지점
		taxi_c = Integer.parseInt(st.nextToken()) - 1;
		
		goalList = new int[M+1][2];
		for(int i=1; i<=M; i++) {	
			st = new StringTokenizer(br.readLine()," ");
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i;		//승객 출발 지점
			for(int j=0; j<2; j++)	//승객 도착 지점
				goalList[i][j] = Integer.parseInt(st.nextToken())-1;
		}
		
		//예외 발생: 좌표 겹칠 경우!!
//		for(int i=2, end=M+2; i<end; i++) {	//2번부터 양의정수는 손님위치, 음의정수는 그 손님의 도착위치
//			st = new StringTokenizer(br.readLine()," ");
//			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i;		//승객 출발 지점
//			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i*(-1);	//승객 도착 지점
//		}
		
//		2. 승객 수만큼 반복
		for(int i=0, dist=0; i<M; i++) {
//			3. 가장 가까운 승객 찾기 (taxi_r, taxi_c부터 bfs 시작하여 1보다 큰 정수 만나는 지점을 반환한다. -> int으로 거리 리턴받는다
			dist = foundGuestBFS();
//			3-1. 리턴받은 거리가 charge보다 크거나 같다면 charge = -1, break
			if(dist>charge || dist==-1) { charge = -1; break; }
//			3-2. 아니면 charge-거리
			else charge-=dist;
			
//			4. 찾은 승객을 기준으로 그 승객의 값*(-1)한 지점 bfs
			dist = foundGoalBFS();
//			4-1. 리턴받은 거리가 charge보다 크다면 charge = -1, break
			if(dist>charge || dist==-1) { charge = -1; break; }
//			4-2. 아니면 charge + 거리
			else charge+=dist;
		}
		
//		5. 정답 출력
		System.out.println(charge);
	}

	static int[][] dir = {{-1,1,0,0},{0,0,-1,1}};	//상하좌우
	
	static int foundGoalBFS() {	//도착지점 찾기
		if(taxi_r==goalList[goal][0] && taxi_c==goalList[goal][1]) return 0;
		Pos cur;
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(taxi_r, taxi_c, 0));
		boolean[][] visited = new boolean[N][N];
		visited[taxi_r][taxi_c] = true;
		
		while(!queue.isEmpty()) {
			cur = queue.poll();
			
			for(int i=0, nr=0, nc=0; i<4; i++) {
				nr = cur.r + dir[0][i];
				nc = cur.c + dir[1][i];
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || map[nr][nc]==-1) continue;
				if(nr==goalList[goal][0] && nc==goalList[goal][1]) {
					taxi_r = nr;
					taxi_c = nc;
					return cur.d+1;	//도착했다면
				}
				visited[nr][nc] = true;
				queue.offer(new Pos(nr, nc, cur.d+1));
			}
		}
		return -1;	//못찾은 경우
	}
	
	static int foundGuestBFS() {	//승객찾기
		Pos cur;
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(taxi_r, taxi_c, 0));
		boolean[][] visited = new boolean[N][N];
		visited[taxi_r][taxi_c] = true;
		
		while(!pq.isEmpty()) {
			cur = pq.poll();
			
			int n = map[cur.r][cur.c];
			if(n>0) {	//태울 승객을 찾았다면
				goal = n;
				taxi_r = cur.r; taxi_c = cur.c;
				map[taxi_r][taxi_c] = 0;
				return cur.d;
			}
			
			for(int i=0, nr=0, nc=0; i<4; i++) {
				nr = cur.r + dir[0][i];
				nc = cur.c + dir[1][i];
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || map[nr][nc]==-1) continue;
				visited[nr][nc] = true;
				pq.offer(new Pos(nr, nc, cur.d+1));
			}
		}
		return -1;	//못찾은 경우
	}
}
