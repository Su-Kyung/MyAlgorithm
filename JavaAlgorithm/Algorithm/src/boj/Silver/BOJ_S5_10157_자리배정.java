package boj.Silver;
// S5 자리배정(구현,수학,재귀)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_10157_자리배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine().trim());	//대기번호
		
		if(K>C*R) System.out.println(0);
		else {
			//			4방 : 하우상좌
			int[] dr = {1,0,-1,0};
			int[] dc = {0,1,0,-1};
			int dir=0;	//현재 방향
			int cr=1, cc=1, nr, nc;	//현재 좌표,새로운 좌표
			boolean[][] visited = new boolean[R+1][C+1];
			visited[1][1]=true;
			
			for(int i=2, end=K+1; i<end; i++) {
				nr = cr+dr[dir];
				nc = cc+dc[dir];
				if(nr<1 || nr>R || nc<1 || nc>C || visited[nr][nc]) {	//범위를 벗어나면
					dir=(dir+1)%4;	//방향 전환
					nr = cr+dr[dir];
					nc = cc+dc[dir];
				}
				cr=nr;
				cc=nc;
				visited[cr][cc]=true;
			}
			System.out.printf("%d %d\n", cc, cr);
		}
	}
}
