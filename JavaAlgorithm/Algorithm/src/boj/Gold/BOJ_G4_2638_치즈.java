package boj.Gold;
// G4 치즈 (너비 우선 탐색,깊이 우선 탐색,그래프 이론,그래프 탐색,구현,시뮬레이션)
// solved
// 2638 치즈와 비슷한 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_2638_치즈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
//		1. map 입력받기
		int cnt=0;	//치즈 수
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cnt++;
			}
		}
		
//		2. 치즈 녹이는 시간 세어주기
		int ans = 0;	//걸리는 시간
		Queue<Integer[]> point = new LinkedList<Integer[]>();
		Integer[] cur;
		boolean[][] visited;
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		
		while(cnt>0) {
			ans++;
			
//			3. 공기와 인접한 개수 세기
			int nr, nc;
			visited = new boolean[N][M];
			point.offer(new Integer[] {0, 0});
			visited[0][0]=true;
			while(!point.isEmpty()) {
				cur = point.poll();
				for(int i=0; i<4; i++) {
					nr = cur[0] + dir[i][0];
					nc = cur[1] + dir[i][1];
					if(nr==-1 || nr==N || nc==-1 || nc==M || visited[nr][nc]) continue;
					if(map[nr][nc]==1 || map[nr][nc]==2) map[nr][nc]++;
					else if(map[nr][nc]==0){
						visited[nr][nc]=true;
						point.offer(new Integer[] {nr, nc});
					}
				}
			}
			
//			4. 녹일 치즈 처리
			for(int i=1, endI=N-1; i<endI; i++) {
				for(int j=1, endJ=M-1; j<endJ; j++) {
					if(map[i][j]==2) map[i][j]=1;
					else if(map[i][j]>2) {
						cnt--;
						map[i][j]=0;
					}
				}
			}
		}
//		정답 출력
		System.out.println(ans);
	}
}
