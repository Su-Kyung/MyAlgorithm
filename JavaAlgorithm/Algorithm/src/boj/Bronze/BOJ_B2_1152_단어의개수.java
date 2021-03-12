package boj.Bronze;

// B2 단어의 개수(구현, 문자열)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B2_1152_단어의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int cnt=0;
		for(int i=1, end=str.length; i<end; i++) {
			if(str[i]==' ') {
				cnt++;
			}
		}
		if(str[str.length-1]!=' ') cnt++;
		System.out.println(cnt);
	}
}
