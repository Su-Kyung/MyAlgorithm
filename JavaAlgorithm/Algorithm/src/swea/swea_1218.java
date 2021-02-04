package swea;

// 괄호 짝짓기(스택)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class swea_1218 {
	static int N;
	static String[] str;
	static Stack<String> opens = new Stack<>();
	static boolean result;
//	static boolean end;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		top:
		for (int i = 0; i < 10; i++) {
			result = true;
//			end = false;
			// 입력 받기
			N = Integer.parseInt(br.readLine());
			str = br.readLine().split("");
			if (N%2 != 0) {	// 개수가 홀수이면 유효하지 않음
				System.out.printf("#%d %d\n", i+1, 0);
//				System.out.println("홀수개");
				continue;
			}
			
			// 입력받은 수만큼 반복 (본격적인 괄호 검사!)
			for (int j = 0; j < str.length; j++) {

//				if (j == str.length-1) end = true;	// 끝까지 검사했는지를 위한 장치
				if (str[j].equals("(") || str[j].equals("{") || str[j].equals("[") || str[j].equals("<")) {
					opens.push(str[j]);
				} else if (opens.isEmpty()) {	// 여는 괄호 수 > 닫는 괄호 수인 경우, 유효하지 않음
					System.out.printf("#%d %d\n", i+1, 0);
					result = false;
//					System.out.println("닫는게 나와버림");
					break;
				} else {	// 비교가능한 닫는 괄호인 경우
					switch(str[j]) {
					case ")":
						if (!opens.peek().equals("(")) {
							result = false;
							break;
						}
						break;
					case "}":
						if (!opens.peek().equals("{")) {
							result = false;
							break;
						}
						break;
					case "]":
						if (!opens.peek().equals("[")) {
							result = false;
							break;
						}
						break;
					case ">":
						if (!opens.peek().equals("<")) {
							result = false;
							break;
						}
						break;
					}
					
					if (result) opens.pop();
					else {	// 괄호 짝이 안맞으므로 유효하지 않음
						System.out.printf("#%d %d\n", i+1, 0);
//						System.out.println(j+1+"짝이 안맞음");
						result = false;
						break;	
					}
				}
			}
			
//			if (end && !opens.isEmpty()) {
//				System.out.printf("#%d %d\n", i+1, 0);
//				System.out.println("empty");
//				continue top;
//			}

			if(result) System.out.printf("#%d %d\n", i+1, 1);
		
		}
		br.close();
	}

}
