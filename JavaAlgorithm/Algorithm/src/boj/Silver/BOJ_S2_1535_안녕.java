package boj.Silver;

//S2 안녕(다이나믹 프로그래밍,브루트포스 알고리즘,배낭 문제)
//solved
/*조합을 이용하는 문제인 줄 알았으나 개수 정해져있지 않음
 * -> 그냥 선택 한다/안한다로 각각 재귀 돌린다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_S2_1535_안녕 {
	static int N, max;
	static int[] L, J;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		L = new int[N];
		J = new int[N];
		
//		1. 체력, 기쁨 배열 받아오기
		StringTokenizer st1, st2;
		st1 = new StringTokenizer(br.readLine(), " ");
		st2 = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			L[i] = Integer.parseInt(st1.nextToken());
			J[i] = Integer.parseInt(st2.nextToken());
		}

//		2. recursion
		max=0;
		recursion(100, 0, 0);
		
//		3. 정답 출력
		System.out.println(max);
	}

	static ArrayList<Integer> numbers = new ArrayList<>();
	static void recursion(int health, int happy, int idx) {
		if(idx==N || health<1) {
			max = Math.max(happy, max);
			return;
		}
		
		recursion(health, happy, idx+1);	//선택 안하고 넘기기
		if(health-L[idx]>0) recursion(health-L[idx], happy+J[idx], idx+1);	//선택하고 넘기기
	}
}
