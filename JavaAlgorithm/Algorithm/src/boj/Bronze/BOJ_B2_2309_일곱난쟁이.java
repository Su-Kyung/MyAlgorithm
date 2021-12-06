package boj.Bronze;
// B2 일곱 난쟁이 (브루트포스, 정렬)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_B2_2309_일곱난쟁이 {
	static int[] input;
	static int[] picked = new int[7];
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = new int[9];
		for(int i=0; i<9; i++) {
			input[i] = Integer.parseInt(br.readLine().trim());
		}
		Arrays.sort(input);
		combination(0, 0);
	}
	
	static void combination(int idx, int start) {
		if(flag) return;
		if(idx==7) {
//			System.out.println(Arrays.toString(picked));
			int sum=0;
			for(int num: picked) sum += num;
			if(sum==100) {
				for(int i: picked) System.out.println(i);
				flag=true;
			}
			return;
		}
		for(int i=start; i<9; i++) {
			picked[idx]=input[i];
			combination(idx+1, i+1);
		}
	}
}
