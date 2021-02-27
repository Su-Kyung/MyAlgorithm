package boj.Bronze;
//B2 블랙잭(브루트포스 알고리즘)
//solved 조합으로 풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_2798_블랙잭 {
	static int N, M, max;
	static int[] cards, picked;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		cards = new int[N];
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		picked=new int[3];
		max=0;
		combination(0, 0);
		System.out.println(max);
	}

	static void combination(int idx, int start) {
		if(idx==3) {
			int sum = picked[0]+picked[1]+picked[2];
			if(sum>M) return;
			max = Math.max(max, sum);
			return;
		}
		for(int i=start; i<N; i++) {
			picked[idx]=cards[i];
			combination(idx+1, i+1);
		}
	}
}
