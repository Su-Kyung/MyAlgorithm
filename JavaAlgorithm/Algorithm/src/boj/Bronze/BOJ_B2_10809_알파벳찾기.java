package boj.Bronze;
//B2 알파벳 찾기(구현,문자열)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_B2_10809_알파벳찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().trim().toCharArray();
		int[] alphabet = new int[26];
		Arrays.fill(alphabet, -1);
		
//		System.out.println('a'-97);
		for(int i=0, end=word.length; i<end; i++) {
			if(alphabet[word[i]-97]==-1) {
				alphabet[word[i]-97]=i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : alphabet) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
