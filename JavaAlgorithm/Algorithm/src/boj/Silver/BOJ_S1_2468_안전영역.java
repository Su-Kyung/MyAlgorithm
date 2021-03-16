package boj.Silver;
//S1 안전 영역(너비 우선 탐색, 브루트포스 알고리즘, 깊이 우선 탐색, 그래프 이론, 그래프 탐색)
//solved (0부터 100이 아닌 최대 높이 정보를 저장해 그만큼 반복 돌리는 것으로 개선 가능)

/*
2
1 1
1 1

5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_2468_안전영역 {
	static int N, max;
	static int[][] temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim()); 
		
//		1. 2차배열로 높이 정보 받기
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		2. 물 높이에 따른 for문
		int cur;
		for(int h=0; h<100; h++) {
//			3. 잠기지 않은 부분 찾아 dfs
			cur=0;
			temp = new int[N][N];
//			temp = map;
//			temp = map.clone();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					temp[i][j] = map[i][j];
				}
			}
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(temp[i]));
//			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(temp[i][j]>h) {
						cur++;
						dfs(h, temp, i, j);
					}
				}
			}
//			4. 최댓값 갱신
			max = Math.max(max, cur);
		}
		
//		5. 정답 출력
		System.out.println(max);
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void dfs(int height, int[][] arr, int row, int col) {
		if(arr[row][col]<=height) return;
		
		arr[row][col] = 0;	//방문처리
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println();
		
//		4방탐색
		int nr, nc;
		for(int i=0; i<4; i++) {
			nr = row+dr[i];
			nc = col+dc[i];
			if(nr<0 || nr==N || nc<0 || nc==N) continue;
			dfs(height, arr, nr, nc);
		}
	}
}
