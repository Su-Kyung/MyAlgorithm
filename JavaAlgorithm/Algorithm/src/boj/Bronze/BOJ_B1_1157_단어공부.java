package boj.Bronze;
//B1 단어 공부(구현,문자열)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B1_1157_단어공부 {

	public static void main(String[] args) throws IOException {
//		System.out.println((char)('A'+32));
//		System.out.println('a'-'0');
//		System.out.println('a'-0);	ASCII
//		System.out.println('A'-0);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().trim().toCharArray();
		int[] used = new int[26];
		
//		1. 단어 받아 알파벳 개수 세기
		for(int i=0, end=word.length; i<end; i++) {
			if(word[i]>96) {	//소문자라면
				used[word[i]-97]++;
			} else used[word[i]-65]++;
		}
		
//		2. 가장 많이 사용된 알파벳 구하기
		int max=0, ans=0;
		boolean flag = false;	//?출력 판별
		for(int i=0; i<26; i++) {
			if(used[i]>max) {
				max=used[i];
				ans=i;
				flag = false;
			} else if(used[i]==max) {
				flag = true;
			}
		}
		
//		3. 정답 출력
		System.out.println(flag?'?':(char)(ans+65));
	}

}
