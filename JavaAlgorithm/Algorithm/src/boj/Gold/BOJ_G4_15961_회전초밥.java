package boj.Gold;
//G4 회전 초밥 (슬라이딩 윈도우,두 포인터)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_15961_회전초밥 {
	static int D, C, max;	//연속접시 수, 쿠폰번호, 최대 종류 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());	//접시 수
		D = Integer.parseInt(st.nextToken());	//초밥 가짓 수
		int K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int picked[] = new int[D+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
//		1. 첫 번째 고르는 경우
		int num;
		int pre[] = new int[K-1];
		for(int i=0, end=K-1; i<end; i++) {
			num = Integer.parseInt(br.readLine());
			picked[num]++; q.offer(num);
			pre[i] = num;
		}
		num = Integer.parseInt(br.readLine());
		picked[num]++; q.offer(num);
		
//		2. 첫 번째 경우에서의 가짓수를 최댓값으로 설정
		int cnt = max = checkType(picked);
		
//		3. 한 바퀴 돌며 나머지 경우의 수에서의 가짓수를 구하고, 최댓값 갱신
		int out;
		for(int i=1, idx=0; i<N; i++) {
			num = i>N-K?pre[idx++]:Integer.parseInt(br.readLine());
			out = q.poll();
			q.offer(num);
			if(num==out) continue;	//결과 동일하므로
			picked[out]--; picked[num]++;
			if(picked[num]==1) cnt++;
			if(picked[out]==0) cnt--;
			if(picked[C]==0 && out==C) cnt++;	//쿠폰에 대해서 미리 1로 설정하면 이 부분이 필요 없다!!
			else if(picked[C]==1 && num==C) cnt--;
			max = Math.max(max, cnt);
		}
		
//		4. 결과 출력
		System.out.println(max);
	}
	
	static int checkType(int[] arr) {
		int cnt=0;
		for(int i=0, end=D+1; i<end; i++) if(arr[i]!=0) cnt++;
		if(arr[C]==0) cnt++;
		return cnt;
	}

}
