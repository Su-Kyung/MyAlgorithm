package boj.Platinum;
// P5 찾기 (문자열, kmp)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_P5_1786_찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		int T = text.length;
		int P = pattern.length;

		int[] table = new int[P];
		for (int i = 1, j = 0; i < P; i++) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = table[j - 1];
			}
			if (pattern[i] == pattern[j]) {
				table[i] = ++j;
			}
		}

		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = 0; j < T; j++) {
			if (i > 0 && pattern[i] != text[j]) {
				i = table[i - 1];
			}
			if (pattern[i] == text[j]) {
				if (i == P - 1) {
					cnt++;
					sb.append(j - P + 2).append(" ");
					i = table[i];
				} else
					i++;
			}
		}
		
		System.out.println(cnt);
		if(sb.length() > 0) System.out.println(sb.toString());
	}

}

/*
abcababcabab
abcabab
2
1 6

AXAXXAXX
AXAXX
1
1

banana banana
ana
4
2 4 9 11

ababacabababcababab
ababacababab
1
1

abaabaabb
abaaba
1
1

abacabacabacabaca
abaca
4
1 5 9 13

ababababababababa
ababa
7
1 3 5 7 9 11 13 

https://www.acmicpc.net/board/view/52492
 */
