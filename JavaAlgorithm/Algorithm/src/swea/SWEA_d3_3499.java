package swea;
// D3 퍼펙트 셔플(Queue)
// solved

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_d3_3499 {
	
	static int N;
	static String cards[];
	static Queue<String> queue1 = new LinkedList<String>();
	static Queue<String> queue2 = new LinkedList<String>();
	static String result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.next());
		
		for (int tc = 0; tc < testcase; tc++) {
			// 1. 입력 받기
			N = Integer.parseInt(sc.next());
			
			// 2. 입력받은 카드를 2개의 Queue에 배치
			for (int i = 0; i < N/2 + (N&1); i++) {	// 카드 개수가 홀수인 경우 하나 더 들어간다
				queue1.offer(sc.next());
//				System.out.println(queue1);
			}
			for (int i = 0; i < N/2; i++) {
				queue2.offer(sc.next());
//				System.out.println(queue2);
			}
			
			// 3. queue1부터 하나씩 꺼내오기
			System.out.print("#"+(tc+1));
			for (int i = 0; i < N/2 + (N&1); i++) {
				System.out.print(" " + queue1.poll());
				if (queue2.isEmpty()) continue;
				System.out.print(" " + queue2.poll());
			}
			System.out.println();
		}
		sc.close();
	}
}