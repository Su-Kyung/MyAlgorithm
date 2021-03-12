package boj.Bronze;
//S2 상수(구현)
//solved 각 자릿수가 같은 경우를 생각 안해서 한번 틀렸다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_2908_상수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] num1 = st.nextToken().trim().toCharArray();
		char[] num2 = st.nextToken().trim().toCharArray();
		
		int idx=2;
		do {
			if(num1[idx]==num2[idx]){
				continue;
			} else if(num1[idx]<num2[idx]) {
				for(int i=2; i>-1; i--) System.out.print(num2[i]);
				break;
			} else {
				for(int i=2; i>-1; i--) System.out.print(num1[i]);
				break;
			}
		} while(--idx>-1);
	}
}
