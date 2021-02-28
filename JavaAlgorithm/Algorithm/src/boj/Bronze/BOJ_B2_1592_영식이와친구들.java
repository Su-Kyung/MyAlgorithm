package boj.Bronze;
//B2 영식이와 친구들(구현,수학,시뮬레이션)
//solved 33m(9m,12m,13m)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_1592_영식이와친구들 {
	static int N, M, L, cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		int[] receive = new int[N+1];
		toss(1, receive);
		System.out.println(cnt);
	}
	static void toss(int idx, int[] receive) {
		if(++receive[idx]>M-1) return;
		cnt++;
		int next = (idx+(receive[idx]%2==1?L:N-L))%N;
//		System.out.println(next);
		toss(next==0?N:next, receive);
	}
}
