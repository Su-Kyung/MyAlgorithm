package boj.Gold;
//G5 파이프 옮기기 1 (다이나믹 프로그래밍,그래프 이론,그래프 탐색)
//solved
/* 방문체크 안하는 bfs. 처음에 벽 부분만 체크했다
 * dfs도 가능하겠지만 백트래킹을 엄청잘 해주어야 한다.
 * 원래 dp로 푸는 문제!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_17070_파이프옮기기1 {

	static class Pipe {
		int r, c, d;	//좌표, 모양 상태(0:가로, 1:세로, 2:대각선)
		public Pipe(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine().trim());
		boolean[][] wall = new boolean[N][N];
		
//		1. 집의 상태 입력 받기(벽이면 true)
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++)
				if(Integer.parseInt(st.nextToken())==1) wall[i][j] = true;
		}
		
//		2. queue 생성
		Queue<Pipe> queue = new LinkedList<Pipe>();
		queue.offer(new Pipe(0, 1, 0));
		int ans = 0;
		
//		3. bfs 수행
		int r, c, d;
		while(!queue.isEmpty()) {
			r = queue.peek().r;
			c = queue.peek().c;
			d = queue.peek().d;
			queue.remove();
			
//			4. [N-1][N-1]에 도착했다면 ans에 1 추가
			if(r==N-1 && c==N-1) ans++;	//continue 해도 속도 개선이 많이 안되었음
			
//			5. 도착 안했다면 3방탐색
			//대각선 이동
			if(r<N-1 && c<N-1 && !wall[r][c+1] && !wall[r+1][c] && !wall[r+1][c+1]) 
				queue.offer(new Pipe(r+1, c+1, 2));
			//가로 이동
			if(c<N-1 && d!=1 && !wall[r][c+1]) queue.offer(new Pipe(r, c+1, 0));
			//세로 이동
			if(r<N-1 && d!=0 && !wall[r+1][c]) queue.offer(new Pipe(r+1, c, 1));
		}
		
		System.out.println(ans);
	}
}
