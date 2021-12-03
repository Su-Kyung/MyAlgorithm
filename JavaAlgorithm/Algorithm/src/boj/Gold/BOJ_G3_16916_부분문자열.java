package boj.Gold;
// G3 부분 문자열 (문자열, kmp)
// solved

import java.util.Scanner;

public class BOJ_G3_16916_부분문자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str = sc.next().toCharArray();
		char[] pattern = sc.next().toCharArray();
		sc.close();

		int[] table = new int[pattern.length];
		for (int i = 1, j = 0; i < pattern.length; i++) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = table[j - 1];
			}
			if (pattern[i] == pattern[j]) {
				table[i] = ++j;
			}
		}

		int ans = 0;
		for (int i = 0, j = 0; i < str.length; i++) {
			while (j > 0 && str[i] != pattern[j]) {
				j = table[j - 1];
			}
			if (str[i] == pattern[j]) {
				if (j == pattern.length - 1) {
					ans = 1;
					break;
				} else
					j++;
			}
		}
		
		System.out.println(ans);
	}

}
