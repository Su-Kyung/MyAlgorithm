package boj.Silver;
//S1 숨바꼭질(너비우선탐색,그래프이론,그래프탐색)
//solved
/* - visited배열을 놓쳤었음
 * - 1차원 배열, 탐색 방식도 자주 풀던 문제와 달라서 헷갈렸다.. 원리를 완벽하게 이해하자!
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_S1_1697_숨바꼭질 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] visited = new boolean[100001];
		int[] dir = {N,-1,1};
		
		if(N==K) System.out.println(0);
		else if(N>K) System.out.println(N-K);
		else {
			Queue<Point> queue = new LinkedList<Point>();
			queue.offer(new Point(N, -1, 0));	//위치,방향,시간
			visited[N]=true;
			Point cur;
			while(!queue.isEmpty()) {
				cur = queue.poll();
//				System.out.println(cur.p);
				if(cur.p==K) {
					System.out.println(cur.c);
					break;
				}
				
				//방향 - 0:*2 / 1:-1 / 2:+2
				int np;	//새로운 포지션
				dir[0] = cur.p;
				for(int i=0; i<3; i++) {
					np = cur.p+dir[i];
					if(np<0 || np>100000 || visited[np]) continue;
					visited[np] = true;
					queue.offer(new Point(np, i, cur.c+1));
				}
			}
		}
		sc.close();
	}

	static class Point {
		int p, d, c;	//위치, 움직인 방향, 움직인 시간
		
		public Point(int p, int d, int c) {
			this.p = p;
			this.d = d;
			this.c = c;
		}
	}
}
