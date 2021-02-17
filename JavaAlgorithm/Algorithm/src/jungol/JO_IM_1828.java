package jungol;
// IM 냉장고(그리디)
// solved

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JO_IM_1828 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
//		온도 받아오기
		int[][] chem = new int[N][2];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			chem[i][0] = Integer.parseInt(st.nextToken());
			chem[i][1] = Integer.parseInt(st.nextToken());
		}
		
//		끝 온도를 기준으로 정렬(끝 온도 같으면 시작 온도 기준)
		Arrays.sort(chem, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				} else return o1[1]-o2[1];
			}
		});
		
//		끝온도 vs 다음 시작온도
		int cnt = 1;	//냉장고 수
		for(int i=1, j=0; i<N; i++) {
			if(chem[j][1] < chem[i][0]) {
				j=i;
				cnt++;
			}
		}

//		출력
		System.out.print(cnt);
	}

}
