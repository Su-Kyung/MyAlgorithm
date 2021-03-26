package boj.Gold;
//G5 파이프 옮기기 2 (다이나믹 프로그래밍)
//solved
/* - 파이프 옮기기 1 포함 dp버전 (이 문제는 제한조건 때문에 dp안하면 안풀림)
 * - 마지막 지점(N-1열 N-1행)이 1일 때 처리가 제대로 안돼서 틀렸었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_17069_파이프옮기기2 {
	static int N;
	static boolean[][] wall;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		wall = new boolean[N][N];
		long[][][] memo = new long[N][N][3];	//0:대각선, 1:가로, 2:세로
		
//		1. 입력받으면서 벽 체크
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++)
				if(Integer.parseInt(st.nextToken())==1) wall[i][j] = true;
		}
		
		memo[0][1][1]=1;
		
//		2. 물려주기
		for(int i=0; i<N; i++) {
			for(int j=1; j<N; j++) {
				if(wall[i][j]) continue;
				//대각선
				if(i<N-1 && j<N-1) memo[i+1][j+1][0] += isEmpty(i,j)?memo[i][j][0] + memo[i][j][1] + memo[i][j][2]:0;
				//가로
				if(j<N-1) memo[i][j+1][1] += memo[i][j][0] + memo[i][j][1];
				//세로
				if(i<N-1) memo[i+1][j][2] += memo[i][j][0] + memo[i][j][2];
			}
		}
		
//		3. 출력
		System.out.println(wall[N-1][N-1]?0:memo[N-1][N-1][0] + memo[N-1][N-1][1] + memo[N-1][N-1][2]);
	}
	
	static boolean isEmpty(int r, int c) {
		if(!wall[r][c+1] && !wall[r+1][c] && !wall[r+1][c+1]) return true;
		else return false;
	}
}
