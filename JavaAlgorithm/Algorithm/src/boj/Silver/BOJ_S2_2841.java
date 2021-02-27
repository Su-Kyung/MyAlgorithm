package boj.Silver;
// S2 외계인의 기타 연주(자료구조, 스택)
// solved(40m)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S2_2841 {

	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tc = br.readLine().split(" ");
		int N = Integer.parseInt(tc[0]);	//멜로디 수
		
		//줄마다 스택 생성
		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		Stack<Integer> st3 = new Stack<>();
		Stack<Integer> st4 = new Stack<>();
		Stack<Integer> st5 = new Stack<>();
		Stack<Integer> st6 = new Stack<>();
		
		// 연주
		StringTokenizer str;
		int line, num;
		count = 0;
		for(int n = 0; n < N; n++) {
			str = new StringTokenizer(br.readLine(), " ");
			line = Integer.parseInt(str.nextToken());
			num = Integer.parseInt(str.nextToken());
			switch(line) {
			case 1:
				play(st1, num);
				break;
			case 2:
				play(st2, num);
				break;
			case 3:
				play(st3, num);
				break;
			case 4:
				play(st4, num);
				break;
			case 5:
				play(st5, num);
				break;
			case 6:
				play(st6, num);
				break;
			}
		}
		
		// 결과 출력
		System.out.println(count);
	}

	private static void play(Stack<Integer> stack, int number) {
		while(true) {
			if(stack.isEmpty() || stack.peek() < number) {
				count++;
				stack.push(number);
				break;
			} else if(stack.peek()==number) {
				break;
			} else if(stack.peek() > number) {
				count++;
				stack.pop();
			}
		}
	}
}
