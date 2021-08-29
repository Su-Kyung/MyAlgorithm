package boj.Silver;
// S5 나이순 정렬 (정렬)
// solved
// 처음에는 문제를 대충 읽어서 이름 순으로 정렬했다.. 문자열 정렬 하는 방법을 익혔음 (부등호를 사용하는 방법도 있다.)
// 다음으로는 우선순위 큐로 stable한 정렬을 보장할 수가 없었다! 보통 merge sort를 이용하는 것 같은데, 나는 order 속성을 추가해 해결했다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_S5_10814_나이순정렬 {

	static class Info implements Comparable<Info> {
		int order, age; // 순서, 나이
		String name; // 이름

		public Info(int order, int age, String name) {
			this.order = order;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Info o) {
//			if(this.age == o.age) return this.name.compareTo(o.name);	// 문제 잘못 읽어서 추가했던 조건.. (String 정렬)
			if (this.age == o.age)
				return this.order - o.order;
			return this.age - o.age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		StringTokenizer st = null;
		PriorityQueue<Info> pq = new PriorityQueue<>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			pq.add(new Info(n, Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Info info = pq.poll();
			sb.append(info.age).append(" ").append(info.name).append("\n");
		}

		System.out.print(sb.toString().trim());
	}

}
