package boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B5_2475_검증수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int cur, result=0;
		while(st.hasMoreTokens()) {
			cur = Integer.parseInt(st.nextToken());
			result+=cur*cur;
		}
		System.out.println(result%10);
	}

}
