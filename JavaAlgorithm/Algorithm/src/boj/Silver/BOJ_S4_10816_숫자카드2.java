package boj.Silver;
// S4 숫자 카드 2 (자료 구조, 정렬, 이분 탐색, 해시를 사용한 집합과 맵)
// solved (배열로 풀었음)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_10816_숫자카드2 {
	static final int INF = 10000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[] cards = new int[INF + INF + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cards[Integer.parseInt(st.nextToken()) + INF]++;
		}
		
		int M = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			sb.append(cards[Integer.parseInt(st.nextToken()) + INF]).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}

}
