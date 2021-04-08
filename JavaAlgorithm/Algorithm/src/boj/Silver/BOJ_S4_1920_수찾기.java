package boj.Silver;
//S4 수 찾기 (이분탐색)
//solved
/* s4라서 통과한것같다. 속는 셈 치고 그냥 그대로 풀었더니 통과는 됐으나 시간과 메모리는 엄청났다..
 * 그런데 HashSet을 활용한 풀이를 보니 로직은 비슷한데 훨씬 빨랐다.
 * 문제 의도는 binarySearch메소드를 활용하는 것 아닌가 싶다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_1920_수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) num[i]=Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine()," ");
		int input;
		boolean flag;
		for(int i=0; i<M; i++) {
			input = Integer.parseInt(st.nextToken());
			flag = true;
			for(int j=0; j<N; j++) {
				if(num[j]==input) {
					sb.append(1).append("\n");
					flag = false;
					break;
				}
			}
			if(flag) sb.append(0).append("\n");
		}
		
		System.out.println(sb);
	}

}
