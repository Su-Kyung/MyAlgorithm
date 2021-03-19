package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_2573_빙산 {
	static int[][] ice, near;
	static int R, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ice = new int[R][C];	//빙산 정보
		near = new int[R][C];	//접하는 바닷물 정보
		for(int i=0; i<R; i++) {
			Arrays.fill(near[i], 4);
		}
		
//		1. 빙산 정보 받아오기
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<C; j++) {
				ice[i][j]=Integer.parseInt(st.nextToken());
				if(ice[i][j] != 0) {	//바다면 상하좌우에 near값을 1더한다
					if(i>0) near[i-1][j]--;
					if(i<R-1) near[i+1][j]--;
					if(j>0) near[i][j-1]--;
					if(j<C-1) near[i][j+1]--;
				}
			}
		}
		//출력: 입력 확인
		for(int i=0; i<R; i++) {
			System.out.println(Arrays.toString(ice[i]));
		}
		System.out.println();
		for(int i=0; i<R; i++) {
			System.out.println(Arrays.toString(near[i]));
		}
		
//		2. 빙산이 분리될 때 까지 반복
		int year=0;
		boolean flag;
		do {
			year++;
			flag = false;
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(ice[i][j]<1) continue;
					//유효한 빙산
					ice[i][j]-=near[i][j];
					flag = true;
					if(ice[i][j]<1) {	//다 녹아버린 경우
						setSea(i,j);
//						3. 빙산 개수 하나인지 체크
						if(isOne()) {
							System.out.println(year);
							return;
						}
					}
				}
			}
		} while(flag);
		
//		4. 정답 출력
		System.out.println(year);
	}

	private static boolean isOne() {
		boolean isFirst = true;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(ice[i][j]>0) {
					if(isFirst) {
						isFirst = false;
						bfs(i, j);
					}
					else return false;
				}
			}
		}
		
		return true;
	}
	
	//bfs: 빙산 하나인지 체크
	private static void bfs(int i, int j) {
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		queue.offer(new Integer[] {i, j});
		
		while(!queue.isEmpty()) {
			
		}
	}
	
	// 주변(4방)에 대해 인접하는 바다의 면 개수를 하나씩 줄인다.
	private static void setSea(int i, int j) {
		if(i>0) near[i-1][j]++;
		if(i<R-1) near[i+1][j]++;
		if(j>0) near[i][j-1]++;
		if(j<C-1) near[i][j+1]++;
	}
}
