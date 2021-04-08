package boj.Silver;
//S3 스택 수열 (자료 구조,스택)
//solved
//힌트 보기 전까지 문제 자체가 이해 안됐었다.. 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S3_1874_스택수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		int input;
		for(int i=0, num=1; i<N; i++) {
			input = Integer.parseInt(br.readLine().trim());
			
			while(num<=input) {
				stack.add(num++);
				sb.append("+\n");
			}
			
			if(input==stack.peek()) {
				stack.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
	}

}
