package swea;
// d3 한빈이와 Spot Mart (조합)
// SWEA 5215-햄버거 다이어트와 비슷하지만 이 문제는 뽑는 개수 정해져있으므로 조합!
// solved

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_d3_9229 {

	static int N;
	static int M;
	static int[] combW;
	static int[] weight;	// 과자봉지 무게 배열
	static int max;	// 무게 합 최대
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	//과자 봉지의 개수
			M = Integer.parseInt(st.nextToken());	//무게 합 제한
			
			weight = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {	// 과제 무게 배열에 저장
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			max=0; combW=new int[2];
			combination(0, 0);
			if (max==0) max=-1;
			System.out.println("#"+(t+1)+" "+max);
		}
	}

	private static void combination(int idx, int start) {
		if(idx == 2) {	// 한 개의 조합을 모두 만든 경우
			if (combW[0]+combW[1] <= M) max = Math.max(max, combW[0]+combW[1]);
			return;
		}
		// 조합
		for (int i = start; i < N; i++) {
			combW[idx] = weight[i];
			combination(idx+1, i+1);
		}
	}
}
