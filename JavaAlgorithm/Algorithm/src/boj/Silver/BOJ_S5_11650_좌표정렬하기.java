package boj.Silver;
// S5 좌표 정렬하기 (정렬)
// solved
// 우선순위 큐 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_S5_11650_좌표정렬하기 {
	static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x == o.x)
				return this.y - o.y;
			else
				return this.x - o.x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine().trim());

		PriorityQueue<Point> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pq.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Point point = pq.poll();
			sb.append(point.x).append(" ").append(point.y).append("\n");
		}
		System.out.println(sb.toString().trim());
	}

}
