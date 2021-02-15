package swea;
// D4 사칙연산 유효성 검사(이진트리)
// solved

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_D4_1233 {

	static int N;	// 정점의 수
	static String tree[][];	// Line 단위로 읽어 배열에 저장
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 0; t < 10; t++) {
			N = Integer.parseInt(br.readLine());
			
//			1번 조건: 노드의 개수 판단
			if (N%2==0) {	//노드가 짝수개인 경우 break
				for (int i = 0; i < N; i++) br.readLine();
				System.out.printf("#%d %d\n", t+1, 0);
				continue;
			}
			// 유효한 트리인 경우 입력 받아 배열에 저장
			tree = new String[N][];
			for (int i = 0; i < N; i++) {
				tree[i] = br.readLine().split(" ");
//				System.out.println(Arrays.toString(tree[i])+" "+tree[i].length);
			}
			
//			2번 조건: 연산자 자리 / 피연산자 자리 판단
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				if (tree[i].length==4) {	//연산자 자리
					if (!isOperator(tree[i][1]) || isOperator(tree[i][2]) || isOperator(tree[i][3])) {
						flag = false;	// 위의 조건에 맞지 않는 경우 break
//						System.out.println(i+1+"번쨰:"+tree[i][1]+" "+tree[i][2]+" "+tree[i][3]+" ");
//						System.out.println(i+1+"번쨰:"+!isOperator(tree[i][1])+" "+isOperator(tree[i][2])+" "+isOperator(tree[i][3])+" ");
						break;
					}
				} else if (tree[i].length==2){	// 숫자 자리 (length==2인 경우)
					if (isOperator(tree[i][1])) {	// 숫자가 아니면 break
//						System.out.println(i+1+"번쨰:"+tree[i][1]);
						flag = false; break;
					}
				}
			}
			if(!flag) {
				System.out.printf("#%d %d\n", t+1, 0);
				continue;
			}

			System.out.printf("#%d %d\n", t+1, 1);
		}
	}

	static public boolean isOperator(String s) {
		if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) return true;
		return false;
	}
}
