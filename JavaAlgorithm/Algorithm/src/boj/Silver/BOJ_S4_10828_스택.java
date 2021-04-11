package boj.Silver;
//S4 스택 (자료 구조,스택)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S4_10828_스택 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine().trim());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			switch(st.nextToken()) {
			case "push": stack.push(Integer.parseInt(st.nextToken())); break;
			case "pop": sb.append(stack.isEmpty()?-1:stack.pop()).append("\n"); break;
			case "size": sb.append(stack.size()).append("\n"); break;
			case "empty": sb.append(stack.isEmpty()?1:0).append("\n"); break;
			default: sb.append(stack.isEmpty()?-1:stack.peek()).append("\n"); break;
			}
		}
		System.out.println(sb);
	}

}
