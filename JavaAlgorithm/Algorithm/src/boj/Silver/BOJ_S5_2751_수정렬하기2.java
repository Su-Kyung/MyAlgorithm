package boj.Silver;
// S5 수 정렬하기 2 (정렬)
// solved
// 상대적으로 속도가 빠른 우선순위 큐 이용
// 다른 풀이 보니, boolean 배열을 생성해 입력된 수를 true로 하고, 인덱스를 기준으로 true인 인덱스만 차례대로 출력하는 방법이 훨씬 빨랐다.
// https://www.acmicpc.net/source/32848443

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_S5_2751_수정렬하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++)
			pq.offer(Integer.parseInt(br.readLine().trim()));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(pq.poll()).append("\n");
		System.out.println(sb.toString().trim());
	}

}
