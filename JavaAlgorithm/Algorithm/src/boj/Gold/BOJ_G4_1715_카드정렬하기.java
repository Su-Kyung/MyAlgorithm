package boj.Gold;
//G4 카드 정렬하기 (자료 구조,그리디 알고리즘,우선순위 큐)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_G4_1715_카드정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) pq.offer(Integer.parseInt(br.readLine().trim()));
		
		int ans = 0;
		while(pq.size()>1) {	//작은것들부터 합친다.
			int num1 = pq.poll();
			int num2 = pq.poll();
			pq.offer(num1+num2);
			ans += num1 + num2;
		}
		
		System.out.println(ans);
	}
}
