package boj.Bronze;
//B1 슈퍼 마리오(구현)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B1_2851_슈퍼마리오 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int score, nscore, sum=0;
		for(int i=0; i<10; i++) {
			score = Integer.parseInt(br.readLine().trim());
			nscore = score+sum;
			if(nscore>100) {
				sum = 100-sum < nscore-100 ? sum:nscore;
				break;
			} else sum=nscore;
		}
		System.out.println(sum);
	}
}