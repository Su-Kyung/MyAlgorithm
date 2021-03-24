package boj.Gold;
//G5 평범한 배낭 (다이나믹 프로그래밍,배낭 문제)
//solved
//dp 배낭 문제 기본!! (외우기)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N, K;
		int[] weights, profits;
		int[][] results;
		StringTokenizer	st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		weights = new int[N+1];
		profits = new int[N+1];
		results = new int[N+1][K+1];
		
		for (int i = 1; i <=N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
		int cw=0, value=0;					//현재 선택된 아이템의 가치
		int preVal=0;						//이전  아이템까지 고려한 가치
		int diffVal=0;						//(배낭무게-현재 선택된 아이템의 무게)의 이전 가치
		for (int item = 1; item <=N; item++) {
			cw = weights[item];				//현 아이템의 무게
			value=profits[item];			//현 아이템의 가치
			
			//현 아이템을 1부터 K까지의 가치 테이블을 만들어 보기 
			for (int w = 1; w <=K; w++) {
				preVal = results[item-1][w];
				if(cw <= w) {
					diffVal= results[item-1][w-cw];
					results[item][w] = Math.max(preVal, diffVal+value);
				}else {
					results[item][w] = preVal;
				}
			}
		}
		System.out.println(results[N][K]);
	}
}
