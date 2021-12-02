package boj.Platinum;
// P5 속타는 저녁 메뉴 (문자열, kmp)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_P5_11585_속타는저녁메뉴 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
//		1. 입력받기
		int N = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());
		char[] pattern = new char[N];
		char[] str = new char[N * 2];	//실제로는 N*2-1만큼만 사용
		for(int i = 0; i < N; i++) {
			pattern[i] = st.nextToken().charAt(0);
			str[i] = str[i + N] = pattern[i];
		}
		
//		2. kmp 위한 table 생성
		int[] table = new int[N];
		for(int i = 1, j = 0; i < N; i++) {
			if(j > 0 && pattern[i] != pattern[j]) {
				j = table[j - 1];
			}
			if(pattern[i] == pattern[j]) {
				table[i] = ++j;
			}
		}
		
//		3. kmp
		int cnt = 0;
		for(int i = 0, j = 0; i < N * 2 - 1; i++) {	//i: 실제로는 N*2-1만큼만 사용
			if(j > 0 && str[i] != pattern[j]) {
				j = table[j - 1];
			}
			if(str[i] == pattern[j]) {
				if(j == N - 1) {
					cnt++;
					j = table[j];
				} else j++;
			}
		}
		
//		4. 약분 (cnt/N)
		int gcd = gcd(cnt, N);
		System.out.printf("%d/%d", cnt / gcd, N / gcd);
	}

	// 최대공약수
	private static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}

}
