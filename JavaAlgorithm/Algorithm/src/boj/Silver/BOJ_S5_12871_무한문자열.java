package boj.Silver;
//S5 무한 문자열 (구현,문자열)
//solved
//실버 5답게 단순하게 접근(시간,메모리 제한 넉넉하므로)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_12871_무한문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine().trim();
		String str2 = br.readLine().trim();
		int len1 = str1.length();
		int len2 = str2.length();
		
		String result1="", result2="";
		for(int i=0; i<len2; i++) result1 += str1;
		for(int i=0; i<len1; i++) result2 += str2;
		
		if(result1.equals(result2)) System.out.println(1);
		else System.out.println(0);
	}
}
