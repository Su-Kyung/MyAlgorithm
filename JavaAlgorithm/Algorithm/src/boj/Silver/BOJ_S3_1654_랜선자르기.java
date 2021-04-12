package boj.Silver;
//S3 랜선 자르기 (이분 탐색,매개 변수 탐색)
//solved
//이분탐색 연습하자 ..
//high, low 모두 2^31-1이라면 flag+1에서 오버플로우가 발생한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_1654_랜선자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] have = new int[K];
		int max=0;
		for(int i=0; i<K; i++)  {
			have[i] = Integer.parseInt(br.readLine().trim());
			max = Math.max(max, have[i]);
		}
		
		int piece;
		long flag, low=1, high=max;
		while(low<=high) {
			piece = 0;
			flag = (low+high)/2;
			for(int i=0; i<K; i++) piece += have[i]/flag;

			if(piece<N) high = flag-1;
			else low = flag+1;
		}
		
		System.out.println(high);
	}

}
