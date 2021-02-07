package swea;
// d3 암호생성기(큐)
// solved 40m = (bs: 9m, input: 18m, algo: 10m, test&dbg: 3m)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		String tc;	// 테스트케이스 번호
		int n;	// 빼는 숫자
		
		// 문제에 제대로 명시되지 않았지만 테케 10개
		for (int t=0; t<10; t++) {
			// 초기화, 입력 받기
			q.clear();
			tc = br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i=0; i<8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			// 구현
			n=1;
			while(true) {
				// 0이하로 되는 경우 끝
				if(q.peek()-n<=0) {
					q.poll();
					q.add(0);
					break;
				}
				q.add(q.poll()-n++);
				if (n==6) n=1;
			}

//			출력 -> 입출력 너무 많음
//			System.out.print("#"+tc);
//			for (int i : q) {
//				System.out.print(" "+i);
//			}
//			System.out.println();
			sb.append("#"+tc);
			for (int i : q) {
				sb.append(" "+i);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
		br.close();
	}
}
