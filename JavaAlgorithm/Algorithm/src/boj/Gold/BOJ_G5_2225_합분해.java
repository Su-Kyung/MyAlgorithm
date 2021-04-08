package boj.Gold;
//G5 합분해 (다이나믹 프로그래밍)
//solved
/* dp[1][j]를 K로 넣어둬서 몇 번을 틀렸다...실수 주의하자
 * 1000000000으로 나누므로 int로 선언 가능하다
 * 직접 숫자를 써보며 규칙을 찾았다. 왜 그렇게 되는지 논리로 규칙 찾는 연습을 하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_2225_합분해 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[N+1][K+1];
		for(int i=1; i<=N; i++) {		//N
			for(int j=1; j<=K; j++) {	//K
				if(i==1) dp[1][j]=j;
				else if(j==1) dp[i][1]=1;
				else dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000000;
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
