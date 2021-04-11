package boj.Bronze;
//B2 Hashing (해싱,문자열)
//solved
//간단하지만 계산 과정에서 발생하는 오버플로우, pow로 인한 시간 문제 등이 있었다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B2_15829_Hashing {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String str = br.readLine().trim();
		long ans = 0, r=1;
		for(int i=0, end=str.length(); i<end; i++) {
			ans = (ans+(str.charAt(i)-'a'+1)*r)%1234567891;
			r*=31;
			r%=1234567891;
		}
		System.out.println(ans);
	}

}

/*
50
abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx

437172291
*/