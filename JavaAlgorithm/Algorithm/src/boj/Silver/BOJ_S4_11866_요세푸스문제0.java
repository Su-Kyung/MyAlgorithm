package boj.Silver;
// S4 요세푸스 문제 0 (구현, 자료 구조, 큐)
// solved

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_S4_11866_요세푸스문제0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++)
			queue.offer(i);
		
		while(!queue.isEmpty()) {
			for(int i = 1; i < K; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}
		
		System.out.printf("%s%s", sb.subSequence(0, sb.lastIndexOf(",")), ">");
	}

}
