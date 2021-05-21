package boj.Gold;
//G4 오큰수 (자료 구조,스택)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_G4_17298_오큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] num = new int[N];
		int[] ans = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		stack.push(num[N-1]);
		
		for(int i=N-2; i>-1; i--) {
			while(stack.size()>1) {
				if(stack.peek() > num[i]) break;
				stack.pop();
			}
			if(stack.peek() > num[i]) ans[i] = stack.peek();
			else ans[i] = -1;
			stack.push(num[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N-1; i++) sb.append(ans[i]).append(" ");
		sb.append(-1);
		System.out.println(sb);
	}

}
