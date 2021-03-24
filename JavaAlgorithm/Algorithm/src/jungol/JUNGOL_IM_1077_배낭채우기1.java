package jungol;
//IM 동적계획법1 배낭채우기1 (dp,배낭문제)
//solved
/* <개선 사항>
 * 앞서 푼 BOJ 평범한 배낭과의 차이점 확실히!
 * 이전 행을 참고할 필요가 없기 때문에 result를 2차원이 아닌 1차원으로 풀이할 수 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_IM_1077_배낭채우기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		int[][] results = new int[N+1][W+1];
		
//		1. 무게, 값어치 입력 받기
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
//		2. 테이블 만들기
		int cw, cv;	//현재 가방의 무게, 가치
		int preVal = 0;	//이전까지의 가치
		int diffVal=0;	
		
		for(int item=1; item<=N; item++) {
			cw = weight[item];
			cv = value[item];
			
			//한 아이템을 기준으로 1부터 K까지 가치 테이블 만들기
			for(int w = 1; w<=W; w++) {
				preVal = results[item-1][w];
				
				if(cw<=w) {	//갱신 가능
					diffVal = results[item][w-cw];	//보석의 개수가 무제한이므로 현재 보석을 또 선택 가능하다 -> item 행으로 설정
					results[item][w] = Math.max(preVal, diffVal+cv);
				} else {	//무게 초과하므로 이전 값으로 채우고 pass
					results[item][w] = preVal;
				}
			}
		}
		
//		3. 정답 출력
		System.out.println(results[N][W]);
	}
}
