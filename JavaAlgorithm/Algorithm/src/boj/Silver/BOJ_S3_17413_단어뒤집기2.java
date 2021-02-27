package boj.Silver;
// S3 단어 뒤집기 2(구현,문자열)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S3_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		StringBuilder ans = new StringBuilder();
		Stack<String> stack = new Stack<>();
		int idx=0, end=str.length();
		while (idx<end) {
			switch(str.charAt(idx)) {
			case '<':
				while (!stack.isEmpty()) ans.append(stack.pop());
				do ans.append(str.charAt(idx)); while(str.charAt(++idx)!='>');
				ans.append(str.charAt(idx++));
				break;
			case ' ':
				while (!stack.isEmpty()) ans.append(stack.pop());
				ans.append(str.charAt(idx++));
				break;
			default:
				stack.push(String.valueOf(str.charAt(idx++)));
				break;
			}
			if(idx==end) while (!stack.isEmpty()) ans.append(stack.pop());
		}
		System.out.print(ans.toString());
	}
}
