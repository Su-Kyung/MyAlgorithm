package boj.Silver;
// S4 제로 (구현, 자료 구조, 스택)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S4_10773_제로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine().trim());
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < K; i++) {
			int input = Integer.parseInt(br.readLine().trim());
			if(input == 0)
				stack.pop();
			else
				stack.push(input);
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}

}
