package boj.Silver;
// S4 카드2 (자료 구조, 큐)
// solved
// 수학으로 푸는 방법 혹은 큐 아닌 자료구조를 사용하는 방법도 있을 것 같음

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_S4_2164_카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int n = 1; n <= N; n++) {
			queue.add(n);
		}
		
		while(queue.size() != 1) {
			queue.poll();
			queue.add(queue.poll());
		}
		
		System.out.println(queue.poll());
	}

}
