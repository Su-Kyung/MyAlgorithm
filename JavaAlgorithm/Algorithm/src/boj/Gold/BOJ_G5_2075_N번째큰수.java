package boj.Gold;
//G5 N번째 큰 수(자료구조, 우선순위 큐)
//solved
/*
 * 최적화 방법:
 * 어차피 우선순위 큐를 써서 N번째로 큰 수를 찾을거면 사실 다른 과정 필요 없이
 * 수를 입력받는 동시에 우선순위 큐로 저장하면 된다!!
 * 그래도 아래 방법으로 구현 연습 하였음
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G5_2075_N번째큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][N];
		
//		1. 배열 입력 받기
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
//			2. 행마다 정렬
			Arrays.sort(map[i]);
//			System.out.println(Arrays.toString(map[i]));
		}
		
//		3. 가장 마지막 위치(우하)부터 N번 탐색(bfs)
		Point cur;
		int nr, nc;
		int[][] dir = {{-1,0},{0,-1}};	//상, 좌 탐색
		
		int idx = 1;	//몇 번째 수인가?
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		queue.offer(new Point(N-1, N-1, map[N-1][N-1]));	//가장 마지막위치 넣고 시작
		boolean[][] visited = new boolean[N][N];	//방문 체크
		visited[N-1][N-1] = true;
		
		while(!queue.isEmpty()) {
			cur = queue.poll();
			if(idx++==N) {	//N번째 큰 수 찾으면 종료
				System.out.println(cur.num);
				break;
			}
			
			for(int i=0; i<2; i++) {	//상,좌 탐색
				nr = cur.r + dir[i][0];
				nc = cur.c + dir[i][1];
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				queue.offer(new Point(nr, nc, map[nr][nc]));
			}
		}
	}

	// 탐색하는 숫자의 행렬 상 위치 및 그에 해당하는 숫자 나타냄
	static class Point implements Comparable<Point>{
		int r, c, num;
		
		public Point(int r, int c, int num) {
			super();
			this.r = r; 
			this.c = c;
			this.num = num;
		}
		
		@Override
		public int compareTo(Point o) {	//숫자를 기준으로 내림차순 정렬
			if(this.num > o.num) return -1;
			else if(this.num < o.num) return 1;
			else return 0;
		}
	}
}
