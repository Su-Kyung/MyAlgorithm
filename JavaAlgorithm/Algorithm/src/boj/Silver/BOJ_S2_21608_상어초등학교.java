package boj.Silver;
//S2 구현
//solved
//2021 상반기 3급 대졸 신입 공채 역테 오전 1번

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_S2_21608_상어초등학교 {

	static class Point implements Comparable<Point>{
		int r, c, like, none;
		public Point(int r, int c, int like, int none) {
			this.r = r; this.c = c;
			this.like = like; this.none = none;
		}
		
		@Override
		public int compareTo(Point o) {
			if(this.like==o.like) {
				if(this.none==o.none) {
					if(this.r==o.r) return this.c - o.c;
					else 			return this.r - o.r;
				} else return o.none - this.none;
			} else return o.like - this.like;
		}
	}
	
	static int N, map[][], info[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
//		1. 학생 정보 입력받기
		N = Integer.parseInt(br.readLine().trim());
		info = new int[N*N][7];	//학생번호, 좋아하는 학생 4명 번호, 인접한 좌표
		for(int i=0, end=N*N; i<end; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<5; j++)
				info[i][j] = Integer.parseInt(st.nextToken());
		}
		
//		2. 자리 정하기
		map = new int[N][N];
		for(int i=0, end=N*N; i<end; i++) 
			chooseSeat(i);
		
//		3. 만족도의 총합 구하기
		int ans = 0;
		for(int i=0, end=N*N; i<end; i++)
			ans += checkSeat(i, info[i][5], info[i][6]);
		
		System.out.println(ans);
	}

	private static int checkSeat(int n, int r, int c) {	//학생 번호, 행, 열
		int friend = 0, nr, nc;
		
		for(int i=0; i<4; i++) {
			nr = r + dir[0][i];
			nc = c + dir[1][i];
			if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
			for(int f=1; f<5; f++)	//원하는 친구가 있는 경우
				if(map[nr][nc]==info[n][f]) friend++;
		}
		
		switch(friend) {
		case 4: return 1000;
		case 3: return 100;
		case 2: return 10;
		case 1: return 1;
		default: return 0;
		}
	}

	static int[][] dir = {{-1,1,0,0},{0,0,-1,1}};
	private static void chooseSeat(int i) {
//		2-1. 자리 검사
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				int like = 0, none = 0;
				for(int d=0, nr, nc; d<4; d++) {	//새로운 좌표 4방 탐색
					nr = r + dir[0][d];
					nc = c + dir[1][d];
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
					
					if(map[nr][nc]==0) none++;	//빈 자리인 경우
					else {
						for(int f=1; f<5; f++)	//원하는 친구가 있는 경우
							if(map[nr][nc]==info[i][f]) {
								like++; break;
							}
					}
				}
				pq.offer(new Point(r, c, like, none));	//그 좌표의 정보 저장
			}
		}
		
//		2-2. 자리 선택
		Point seat = null;
		do seat = pq.poll();
		while(map[seat.r][seat.c]!=0);	//이미 누가 선점한 자리면 다음 자리 poll
		
		map[seat.r][seat.c] = info[i][0];
		info[i][5] = seat.r;
		info[i][6] = seat.c;
	}
}
