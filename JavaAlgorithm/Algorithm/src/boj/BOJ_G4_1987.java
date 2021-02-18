package boj;
//G4 알파벳(BFS, 백트래킹)
//solved

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1987 {

	static int R, C;
	static char[][] map;
	static boolean[] alphabet;
	static int max, count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		String str;
		for(int i=0; i<R; i++) {
			str = br.readLine().trim();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		alphabet = new boolean[26];
		alphabet[map[0][0]-65]=true;
		count=1; max=1;
		bfs(0, 0, alphabet);
		System.out.print(max);
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void bfs(int row, int col, boolean[] arr) {
		int nr, nc;
		for(int i=0; i<4; i++) {
			nr = row+dr[i];
			nc = col+dc[i];
			if(nr>-1 && nr<R && nc>-1 && nc<C) {
				if(!arr[map[nr][nc]-65]) {
					count++;
					arr[map[nr][nc]-65]=true;
					max = Math.max(count, max);
					bfs(nr, nc, arr);
				}
			}
		}
		count--;
		arr[map[row][col]-65]=false;
	}

	//안풀린 풀이
//	static int R, C;
//	static char[][] map;
//	static boolean[] alphabet;
//	static int max, count;
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		R = Integer.parseInt(st.nextToken());
//		C = Integer.parseInt(st.nextToken());
//		map = new char[R][C];
//		String str;
//		for(int i=0; i<R; i++) {
//			str = br.readLine().trim();
//			for(int j=0; j<C; j++) {
//				map[i][j] = str.charAt(j);
//			}
//		}
//		
//		max = 1; count=1;
//		alphabet = new boolean[26];
//		alphabet[map[0][0]-65] = true;
//		move(0, 0, true, alphabet);	//이전 방문한 좌표, 현재좌표, 기저조건판별, 이동 칸 수, 알파벳 사용 여부 확인 배열
//		
//		System.out.print(max);
//	}
//	
//	//상하좌우
//	static int[] dr = {-1,1,0,0};
//	static int[] dc = {0,0,-1,1};
//	private static void move(int row, int col, boolean flag, boolean[] ab) {
//		if(!flag) {
//			return;
//		}
//		
//		int nr, nc;
//		for(int i=0; i<4; i++) {
//			nr = row+dr[i];
//			nc = col+dc[i];	//새로운 좌표
////			cnt++;
//			if(nr>=0 && nr<R && nc>=0 && nc<R && !ab[map[nr][nc]-65]) {
////				System.out.println(cnt);
//				count++;
//				max = Math.max(max, count);
////				System.out.println(nr+" "+nc+" : "+count);
//				ab[map[nr][nc]-65] = true;
//				move(nr, nc, true, ab);
//			} else {
////				System.out.println(cnt+"false");
//				move(nr, nc, false, ab);	//false말고는 사실상 의미 없음
//			}
//		}
//		count--;
//		ab[map[row][col]-65]=false;
//	}

}
