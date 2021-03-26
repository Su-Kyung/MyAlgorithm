package boj.Gold;
//G5 치즈 (너비 우선 탐색, 그래프 이론, 그래프 탐색, 구현, 시뮬레이션)
//solved
/* 공기 부분을 기준으로 탐색한다는 것
 * -> 내부 공기, 외부 공기 생각할 필요 없다!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_2636_치즈 {
	static class Point {
		int r, c, t;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int time = 0, cnt = 0;	//걸리는 시간, 녹기 한시간 전 치즈개수
		
//		1. map 입력 받기(치즈 개수 세면서)
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cnt++;
			}
		}
		
//		치즈 녹이기
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		Queue<Point> queue = new LinkedList<>();
		boolean visited[][];
		Point cur;
		int pre_cnt = cnt;
		
//		2. 치즈 개수가 0이 될 떄까지 (0,0)부터 bfs 탐색하면서  치즈 개수 세어준다
		while(cnt!=0) {
//			2-1. 방문배열 새롭게 갱신(생성)
			visited = new boolean[R][C];
			
//			2-2. 0행 0열 지점 처리하고 bfs 진행
			queue.offer(new Point(0, 0));
			visited[0][0] = true;
			int nr, nc;
			pre_cnt = cnt;	//치즈 개수가 0이될 경우를 대비해 저장하고 시작
			
			while(!queue.isEmpty()) {
				//바깥 공기부분 탐색
				cur = queue.poll();
				for(int i=0; i<4; i++) {
					nr = cur.r+dir[i][0];
					nc = cur.c+dir[i][1];
					if(nr==-1 || nr==R || nc==-1 || nc==C || visited[nr][nc]) continue;
					visited[nr][nc] = true;
					if(map[nr][nc]==1) {	//공기와 인접한 치즈인 경우
						cnt--;
						map[nr][nc]=0;	//offer안해주니까 바깥공기와 인접한 치즈인 경우라는 것이 보장됨
					} else queue.offer(new Point(nr,nc));
				}
			}
			time++;	//탐색 한번 끝났으므로 시간 +1
		}
		
//		4. 정답 출력
		System.out.printf("%d\n%d", time, pre_cnt);
	}
}
