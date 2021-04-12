package boj.Silver;
//S4 소수 찾기 (수학,정수론,소수 판정,에라토스테네스의 체)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_1978_소수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int max=0;
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, numbers[i]);
		}
		
		boolean[] check = new boolean[max+1];
		check[1]=true;
		for(int i=2; i<max; i++) //에라토스테네스의 체
			for(int j=i*2; j<max+1; j+=i) check[j]=true;
		
		int cnt=0;
		for(int i=0; i<N; i++) if(!check[numbers[i]]) cnt++;
		
		System.out.println(cnt);
	}

}
