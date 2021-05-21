package boj.Gold;
//G3 오등큰수 (자료 구조,스택)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_G3_17299_오등큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[N];
		int[] ans = new int[N];
		int[] arrF = new int[1000001];	//등장 횟수
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arrF[arr[i]]++;
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[N-1]);
		ans[N-1] = -1;
		for(int i=N-2; i>=0; i--) {
			while(stack.size()>1) {
				if(arrF[stack.peek()] > arrF[arr[i]]) break;
				stack.pop();
			}
			if(arrF[stack.peek()] <= arrF[arr[i]]) ans[i] = -1;
			else ans[i] = stack.peek();
			stack.add(arr[i]);
		}
	
		//아래 반례있음 (오큰수도 아래처럼 하면 안풀림!!)
//		for(int i=N-2, max=arr[N-1]; i>=0; i--) {
//			if(arrF[arr[i+1]]>arrF[arr[i]]) {	//오른쪽 원소와 비교
//				ans[i] = arr[i+1];
//			} else if(ans[i+1]!=-1 && arrF[ans[i+1]]>arrF[arr[i]]) {	//오른쪽 원소 기준 가장 가까운 큰 값 비교
//				ans[i] = ans[i+1];
//			} else if(arrF[max]>arrF[arr[i]]) {	//전체 기준 최대 값 비교
//				ans[i] = max;
//			} else {	//세 가지 경우를 모두 벗어난다면
//				ans[i] = -1;
//				max = i;
//			}
//		}
//		ans[N-1]=-1;
		
		StringBuilder sb = new StringBuilder();
		for(int n : ans) sb.append(n).append(" ");
		System.out.println(sb);
	}
}


/*
arrF: [0, 3, 2, 1, 1, 0, ...
arr: [1, 1, 2, 3, 4, 2, 1]
ans: [-1, -1, 1, 2, 2, 1, -1]

반례) 개수가 3 1 2 4 5
15
1 1 1 2 3 3 4 4 4 4 5 5 5 5 5
_____________________________

14
1 1 1 2 3 4 4 4 4 5 5 5 5 5
=> 4 4 4 4 4 5 5 5 5 -1 -1 -1 -1 -1

13
2 1 4 3 3 3 2 2 2 4 4 4 4
=> 4 4 -1 2 2 2 4 4 4 -1 -1 -1 -1

10
1 1 2 3 4 2 1 3 3 3
=> 3 3 3 -1 2 1 3 -1 -1 -1

11
1 1 2 1 3 4 2 1 3 3 3
=> -1 -1 1 -1 -1 2 1 -1 -1 -1 -1
*/