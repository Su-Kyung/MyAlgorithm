package boj.Silver;
// Silver5 요세푸스 문제(큐)
// solved

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_S5_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> Q = new LinkedList<Integer>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for (int i = 0; i < N; i++) Q.add(i+1);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (!Q.isEmpty()) {
			for (int i = 0; i < K-1; i++) Q.add(Q.poll());
			sb.append(Q.poll()).append(", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(" "));
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(">");
		System.out.println(sb.toString());
		
		sc.close();
	}

}
