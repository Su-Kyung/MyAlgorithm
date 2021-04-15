package boj.Gold;
//G5 마법사 상어와 파이어볼 (구현,시뮬레이션)
//solved
//배열 인덱스에 대한 문제 이해가 까다로웠다 + 실수좀 제발..!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_G5_20056_마법사상어와파이어볼 {
	static int dir[][] = {{-1,-1,0,1,1,1,0,-1},{0,1,1,1,0,-1,-1,-1}}, move[][];
	static ArrayList<FireBall> list = new ArrayList<>();
	
	static class FireBall implements Comparable<FireBall>{
		int r, c, m, s, d;	//행,열,질량,속력,방향
		public FireBall(int r, int c, int m, int s, int d) {
			this.r = r; this.c = c;
			this.m = m; this.s = s; this.d = d;
		}
		
		@Override
		public int compareTo(FireBall o) {
			if(this.r==o.r) return this.c-o.c;
			return this.r-o.r;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());	//격자 크기
		int M = Integer.parseInt(st.nextToken());	//파이어볼 개수
		int K = Integer.parseInt(st.nextToken());	//이동 명령 횟수
		
//		1. 파이어볼 입력받기: 리스트에 저장
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine()," ");
			list.add(new FireBall(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1,
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
//		2. K번 이동 명령 수행
		FireBall cur;
		while (K-->0 && !list.isEmpty()) {	//리스트가 비었는지에 대한 조건은 예외처리용도
//			2-1. 모든 파이어볼이 자신의 방향, 속력만큼 이동
			int nr, nc;	//새로운 좌표
			move = new int[N][N];
			for(int i=0, end=list.size(); i<end; i++) {
				cur = list.remove(0);
//				System.out.println(cur.r+" "+cur.c+" 방향:"+cur.d+" 속력:"+cur.s);
				
				nr = cur.r + dir[0][cur.d]*cur.s;
				nc = cur.c + dir[1][cur.d]*cur.s;
//				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
//				System.out.print(nr+" "+nc);
				if(nr<0) while(nr<0) nr+=N; else if(nr>=N) nr%=N;
				if(nc<0) while(nc<0) nc+=N; else if(nc>=N) nc%=N;
				
//				System.out.println("-> 새 좌표:"+nr+" "+nc);
				list.add(new FireBall(nr, nc, cur.m, cur.s, cur.d));
				move[nr][nc]++;
			}
			//정렬
			Collections.sort(list);
//			for(int i=0; i<N; i++) System.out.println(Arrays.toString(move[i]));
//			//출력 확인
//			for(int i=0; i<list.size(); i++) System.out.println(list.get(i).r+" "+list.get(i).c+" "+list.get(i).m);
//			System.out.println();
//			2-2. 2개 이상의 파이어볼이 있는 경우 다음 과정 실행
			for(int i=0, idx=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(move[i][j]>1) mixFireBall(idx, move[i][j], i, j);
					else idx+=move[i][j];
				}
			}
//			//출력 확인
//			for(int i=0; i<list.size(); i++) System.out.println(list.get(i).r+" "+list.get(i).c+" "+list.get(i).m);
//			System.out.println("===========================");
		}
		
//		5. 남아있는 파이어볼 질량의 합 구하기
		int ans=0;
		for(FireBall fb : list) ans += fb.m;
		System.out.println(ans);
	}

//	3. 파이어볼 합치고, 나누기
	static void mixFireBall(int idx, int num, int r, int c) {
//		System.out.println("2이상!"+num+" "+idx+" "+r+" "+c);
		int nm=0, ns=0, nd=0;
		FireBall cur;
//		3-1. 파이어볼 합치기
		for(int n=0; n<num; n++) {
			cur = list.remove(idx);
			nm += cur.m; ns += cur.s; nd += cur.d%2;
		}

		if(nm/5==0) return;	//4. 질량이 0인 파이어볼은 소멸되어 없어짐
		nm /= 5; ns /= num;
		if(nd==0 || nd==num) nd=0; else nd=1;	//방향 설정
//		3-2. 파이어볼 나누기
		for(int i=nd; i<8; i+=2) list.add(new FireBall(r, c, nm, ns, i));
	}
}

/*
4 9 5
3 2 8 5 2
3 3 19 3 4
3 1 7 1 1
4 4 6 4 0
2 1 6 2 5
4 3 9 4 3
2 2 16 1 2
4 2 17 5 3
3 4 3 5 7
->33
 */
