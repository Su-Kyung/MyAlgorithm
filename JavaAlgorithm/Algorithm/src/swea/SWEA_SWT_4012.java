package swea;
//[모의 SW 역량테스트 - 쉬운 A수준] 요리사(조합)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_SWT_4012 {

	static int N;	//배열 크기
	static int[][] table;	//시너지 테이블
	static int[] food1, food2;
	static int min;	//결과
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sb;
		int T = Integer.parseInt(br.readLine().trim());	//테스트케이스 개수
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			table = new int[N][N];
			for(int i=0; i<N; i++) {	//테이블 입력받기
				sb = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					table[i][j] = Integer.parseInt(sb.nextToken());
				}
			}
			
			food1 = new int[N/2];
			food2 = new int[N/2];
			min=Integer.MAX_VALUE;
			combination(0, 0, N/2);
			
			System.out.printf("#%d %d\n", t+1, min);
		}
	}

	private static void combination(int idx, int start, int R) {
		if(idx == R) {
			for(int i=0, j=0, k=0; i<N; i++) {	//food1 결과에 따른 food2 구하기
				if(j<food1.length && food1[j] == i) {
					j++;
				} else {
					food2[k++] = i;
				}
			}

			synergy(food1, food2);	//시너지 차이 구하기
			
			return;
		}
		// 조합
		for (int i = start; i < N; i++) {
			food1[idx] = i;
			combination(idx+1, i+1, R);
		}
	}

	private static void synergy(int[] f1, int[] f2) {	//시너지 구하고 차이의 최솟값 갱신하는 함수
		int s1=0, s2=0;
		int end = f1.length;
		
		for(int i=0; i<end; i++) {
			for(int j=0; j<end; j++) {
				s1 += table[f1[i]][f1[j]];
			}
		}
		for(int i=0; i<end; i++) {
			for(int j=0; j<end; j++) {
				s2 += table[f2[i]][f2[j]];
			}
		}
		
		min = Math.min(min, Math.abs(s1-s2));
	}
}
