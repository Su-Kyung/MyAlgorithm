package boj.Silver;
// S4 괄호 (자료 구조, 문자열, 스택)
// solved
// 스택 문제라서 그냥 깊은 고민 없이 문제 그대로 풀었는데, 가독성이나 효율성이 좀 떨어진 것 같다.
// 예를 들어, 검사하는 메서드를 따로 분리하여 가독성을 개선하고, stack 대신 의미상 int 변수를 활용할 수도 있었을 것이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S4_9012_괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		test: for (int n = 0; n < N; n++) {
			char[] string = br.readLine().trim().toCharArray();

			Stack<Character> stack = new Stack<>();

			for (int idx = 0, end = string.length; idx < end; idx++) {
				switch (string[idx]) {
				case '(':
					stack.push('(');
					break;
				case ')':
					if (stack.isEmpty()) { // ')'가 더 많은 경우
						sb.append("NO\n");
						continue test;
					} else {
						stack.pop();
						break;
					}
				default:
					break;
				}
			}

			if (stack.isEmpty())
				sb.append("YES\n");
			else
				sb.append("NO\n"); // '('가 더 많은 경우
		}

		System.out.println(sb.toString().trim());
	}

}
