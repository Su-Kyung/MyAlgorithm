package swea;
// D4 장훈이의 높은 선반 (부분집합)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_1486_장훈이의높은선반 {
	static boolean visited[];
	static int[] height;
	static int N, B, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		1. 입력 받기: 테케 수
		int T = Integer.parseInt(br.readLine().trim());
		
//		2. 테스트케이스 수만큼 반복 (1부터 N+1 미만까지)
		for(int t=1, endT=T+1; t<endT; t++) {
//			3. 입력 받기: N, B, 점원들의 키(배열)
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			height = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
//			4. 점원들 키 sort(오름차순)
			Arrays.sort(height);
			
//			5. 부분집합 구하기
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			makeSubset(0);
			
//			6. 정답 출력(StringBuilder.append)
			System.out.printf("#%d %d\n", t, min-B);
		}
		
	}

	private static void makeSubset(int cnt) {
//		5-1. 부분집합 다 구해졌으면(기저조건) 키의 합 구하기
//			키의 합이 B이상이면 min값(정답) 비교하여 갱신
//			-> 이 때 부분집합 구하는 행위 자체를 중지해도 될까? (이후의 합들이 이 값보다 크다는게 보장 가능?)
	      if (cnt == N) {
	    	  int cur=0;
	         for (int i = 0; i < height.length; i++) {
	            if (visited[i]) {
	            	cur += height[i];
//	               System.out.print(height[i]+" ");
	            }
	         }
	         if(cur>=B) min = Math.min(min, cur);
	         return;
	      }

	      // 숫자를 사용한다는 
	      visited[cnt] = true;
	      makeSubset(cnt + 1);
	      //숫자를 사용하지는 않음
	      visited[cnt] = false;
	      makeSubset(cnt + 1);
	}
}
