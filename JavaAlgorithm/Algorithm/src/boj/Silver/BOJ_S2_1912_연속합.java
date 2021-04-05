package boj.Silver;
//S2 연속합 (다이나믹 프로그래밍)
//solved
//메모이제이션 점화식 원리 이해하는데 한참걸렸다..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_1912_연속합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int cur = Integer.parseInt(st.nextToken());
		int memo=cur, max=cur;
		for(int i=1; i<N; i++) {
			cur = Integer.parseInt(st.nextToken());
			memo = Math.max(cur, cur+memo);
			max = Math.max(memo, max);
//			System.out.println(cur+" "+memo+" "+max);
		}
		System.out.println(max);
	}
}
