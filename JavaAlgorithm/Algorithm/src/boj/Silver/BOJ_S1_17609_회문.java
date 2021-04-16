package boj.Silver;
//S1 회문 (그리디 알고리즘,구현,문자열,두 포인터)
//solved
//팰린드롬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_17609_회문 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		test:
		for(int i=0; i<T ; i++) {
			String str = br.readLine().trim();
			
			for(int front = 0, back = str.length()-1; front<back; front++, back--) {
				if(str.charAt(front)==str.charAt(back)) continue;
				if(check(str, front+1, back) || check(str, front, back-1)) { sb.append(1).append("\n"); continue test; }
				else { sb.append(2).append("\n"); continue test; }
			}
			sb.append(0).append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean check(String str, int front, int back) {
		for(int f=front, b=back; f<b; f++, b--) {
			if(str.charAt(f)==str.charAt(b)) continue;
			else return false;
		}
		return true;
	}
}

/*
8
a
aba
baa
asdf
abdab
aaaaaaaaaaaaaaaaaaabaaaaaaa
abababc
summsu

6
abcddcdba
baaba
abcccbccb
bcccbccb
ccbcbccb
cbcbccc
 */
