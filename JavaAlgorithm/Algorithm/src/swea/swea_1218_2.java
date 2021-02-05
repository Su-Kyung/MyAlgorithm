package swea;

// D4 괄호 짝짓기(스택)
// 조건 다시 잘 따져보기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea_1218_2 {
	static int length;
	static String line;
	static Stack<String> open = new Stack<>();
	static String temp;
	static int result;
	
	static int checkPair(char c, String t) {
		switch(t) {
		case "[":
			if (c!=']') result = 0;
			break;
		case "{":
			if (c!='}') result = 0;
			break;
		case "(":
			if (c!=')') result = 0;
			break;
		case "<":
			if (c!='>') result = 0;
			break;
		default: break;
		}
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 10; tc++) {
			length = Integer.parseInt(br.readLine());
			line = br.readLine();
			result = 1;
			
			// line 길이가 홀수면 이미 안됨!
			if (result%2==1) continue;
			
			for(int i = 0; i < length; i++) {
				// 왼쪽 괄호면 stack에 삽입, 오른쪽 괄호면 top 괄호 꺼내서 비교
				if (line.charAt(i)=='[' || line.charAt(i)=='{' || line.charAt(i)=='(' || line.charAt(i)=='<') {
					open.push(""+line.charAt(i));
				} else {
					if (open.isEmpty()) {
						result = 0; break;	// 스택이 비어있는 경우
					} else {
						temp = open.pop();
						// 짝 검사
						result = checkPair(line.charAt(i), temp);
					}
				}
				
				// result==0이면 이미 유효하지 않으므로 반복 중지
				if (result==0) {
					break;
				}
				
			}
			// 마지막까지 수행했는데 스택이 안비었다면 유효하지 않음
			if (!open.isEmpty()) result = 0;
			
			System.out.printf("#%d %d\n",tc+1,result);
		}
		br.close();
	}

}
