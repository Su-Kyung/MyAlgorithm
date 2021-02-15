package swea;
// D3 수의 새로운 연산
// solved

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1493 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] pointP = new int[2];	// 주어진 정수들의좌표
		int[] pointQ = new int[2];
		int[] pointN = new int[2];	// 새로운 좌표
		int result;	//답
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
//			주어진 정수들의 좌표 구하기
			int num = 0; int plus = 1;	// 첫번째 정수
			while(num < p) {	// 같은 대각선 을 지나는 (*,1) 구하기
				num += plus++;
			}
			pointP[0] = plus-1 - (num-p);	// 차이만큼 대각선을 타고 올라간다.
			pointP[1] = 1 + num-p;
			
			num = 0; plus = 1;	// 두번째 정수
			while(num < q) {
				num += plus++;
			}
			pointQ[0] = plus-1 - (num-q);
			pointQ[1] = 1 + num-q;
			
//			새로운 좌표 구하기
			pointN[0] = pointP[0]+pointQ[0];
			pointN[1] = pointP[1]+pointQ[1];
			
//			새롭게 구한 좌표에 해당하는 정수 구하기
			result = pointN[0]*(pointN[0]+1)/2;
			for (int i = 0; i < pointN[1]-1; i++) {
				result += pointN[0]+i;
			}
			
//			결과 출력
			System.out.printf("#%d %d\n", tc+1, result);
		}
	}

}
