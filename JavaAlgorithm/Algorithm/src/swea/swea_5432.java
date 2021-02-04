package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// D4 쇠막대기 자르기
/**
 * <swea5432 d4 쇠막대기 자르기 아이디어>
 * 1. 필요한 변수: 유효막대수, 조각 수
 * 2. 문제 해석: 괄호를 차례대로 검사하며 아래 로직 수행
 * 	- (일 때
 * 		- 다음 차례도 (인 경우: 유효막대수++
 * 		- 다음 차례가 )인 경우: 조각수 += 유효막대수
 * 	- )일 때
 * 		- 앞 차례가 (인 경우: continue (아무 작업 수행 X)
 * 		- 앞 차례가  )인 경우: 유효막대수--, 조각수++
 * 3. 출력: 조각수
 * @author 송수경
 *
 */
public class swea_5432 {
	static String inputs;
	static int stick;	// 유효막대 수
	static int result;	// 조각 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < testcase; tc++) {
			inputs = br.readLine();
			stick = 0; result = 0;
			
			for (int i = 0; i < inputs.length(); i++) {
				if (inputs.charAt(i)=='(') {
					if (inputs.charAt(i+1)=='(') stick++;
					else result += stick;
				}
				else {
					if (inputs.charAt(i-1)==')') {
						stick--;
						result++;
					}
				}
			}
			System.out.printf("#%d %d\n", tc+1, result);
		}
		
	}

}
