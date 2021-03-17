package boj.Silver;
//S3 스타트와 링크 (백트래킹,브루트포스 알고리즘)
//solved
//S3같지가 않았다.. 구현이 오래걸렸음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_14889_스타트와링크 {
	static int N, sum, ans;
	static int[][] map;
	static int[] team1, team2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		
//		1. 능력치 입력받기
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				if(j<i) {
					map[j][i] = map[i][j] = map[j][i]+Integer.parseInt(st.nextToken());
					sum+=map[j][i];
				}
				else map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//출력확인
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
//		2. 조합
		ans = Integer.MAX_VALUE;
		team1 = new int[N/2];
		team2 = new int[N/2];
		comb(0, 0);
		
//		4. 출력
		System.out.println(ans);
	}

//	2. 조합
	private static void comb(int idx, int start) {
		if(idx == N/2) {
			int score1 = checkAbility(team1);
			for(int n=0, i=0, j=0; n<N; n++) {
				if(i<N/2 && team1[i]==n) i++;
				else {
					team2[j++] = n;
				}
			}
			int score2 = checkAbility(team2);
//			System.out.println(Arrays.toString(team1));
//			System.out.println(Arrays.toString(team2));
//			System.out.println(score1+" "+score2);
			ans = Math.min(ans, Math.abs(score1-score2));
			return;
		}
		
		if(idx==0 && start>N/2) return;	//중복됨
		
		for(int i=start; i<N; i++) {
			team1[idx] = i;
			comb(idx+1, i+1);
		}
	}
	
//	3. 능력치 체크 
	private static int checkAbility(int[] arr) {
		int score=0;
		for(int i=0, j=1, end=arr.length-1; i<end; i++) {
			while(j != arr.length) {
				score += map[arr[i]][arr[j++]];
			}
			j=i+1;
		}
		
		return score;
	}
}
