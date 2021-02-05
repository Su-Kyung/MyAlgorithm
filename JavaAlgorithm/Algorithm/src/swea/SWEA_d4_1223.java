package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// d4 계산기2 (Stack)
// solved

public class SWEA_d4_1223 {
	static Stack<Integer> number = new Stack<>();
	static int length;
	static char[] tcStr;
	static boolean next;
	static int nextStr;
	static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int n = 0; n < 10; n++) {
			// 할당 및 초기화
			length = Integer.parseInt(br.readLine());
			tcStr = br.readLine().toCharArray();
			sum = 0;
			number.clear();
			
			for (int i = 0; i < length; i++) {
				if (next) {
					next = false;
					continue;
				}
				if (tcStr[i] > 47 && tcStr[i] < 58) {	// 숫자인 경우
					number.push(Integer.parseInt(tcStr[i]+""));
				} else if (tcStr[i]=='*') {	// 곱셈
					nextStr = Integer.parseInt(tcStr[i+1]+"");	// 다음 숫자 받아오기
					number.push(number.pop()*nextStr);
					next = true;
				}
			}
			for (int num : number) sum += num;
			
			System.out.printf("#%d %d\n", n+1, sum);
		}
		br.close();
	}
}
