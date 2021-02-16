package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//B1 설탕 배달(그리디, 수학, dp)

public class BOJ_B1_2839 {

	public static void main(String[] args) throws Exception {
//		1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());	//설탕 무게
		
//		2. 봉지 수 구하기
		int count=0;	//봉지 개수
		while (N>0) {
			if(N==0) break;
			if(N%10==0 || N%10==5) {
				count += N/5;
				break;
			} else {
				N -= 3;
				count++;
			}
		}
		
//		3. 결과 출력
		if(N<0) System.out.println(-1);
		else System.out.println(count);
	}

}
