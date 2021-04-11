package boj.Silver;
//S3 마인크래프트 (브루트포스 알고리즘,구현)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_18111_마인크래프트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
//		1. 땅 상태 입력 받기
		int[][] map = new int[N][M];
		int max=0, min=256;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min=Math.min(min, map[i][j]);
				max=Math.max(max, map[i][j]);
			}
		}
		
//		2. 땅 고르기
		int flag = max;
		int time = Integer.MAX_VALUE;
		int low, high;	//낮은 지대, 높은 지대
		for(int i=flag; i>-1; i--) {
			low=0; high=0;
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(map[n][m]<i) low+=i-map[n][m];
					else if(map[n][m]>i) high+=map[n][m]-i;
				}
			}
			if(low>B+high) continue;
			if(time>high*2+low) {
				time = high*2 + low;
				flag=i;
			}
		}
		
//		3. 출력
		System.out.printf("%d %d\n",time, flag);
	}

}
