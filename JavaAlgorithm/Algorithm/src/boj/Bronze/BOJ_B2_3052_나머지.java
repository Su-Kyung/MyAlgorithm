package boj.Bronze;
//B2 나머지(사칙연산,수학)
//solved 6m(2m,4m)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B2_3052_나머지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		boolean[] flag = new boolean[42];
		for(int i=0; i<10; i++) {
			N = Integer.parseInt(br.readLine().trim());
			flag[N%42]=true;
		}
		int cnt=0;
		for(int i=0; i<42; i++) {
			if(flag[i]) cnt++;
		}
		System.out.print(cnt);
	}

}
