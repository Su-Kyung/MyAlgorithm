package boj.Gold;
//G2 통나무 옮기기 (너비 우선 탐색,그래프 이론,그래프 탐색)
//solved (입력받는 부분에서 같은 변수명을 사용하는 경우 갱신을 하고 연산을 하는 실수를 범해서 틀렸다)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_G2_1938_통나무옮기기 {
	static char[][] map;
	static int N, sr, sc, stype, er, ec, etype;	//크기, 시작점, 최종점, 최종점 가로(1) 혹은 세로(2) 상태
	static Queue<Tree> q = new LinkedList<Tree>();
	
	static class Tree {
		int r, c, move, type;	//위치, 움직임 횟수, 형태(가로 1, 세로 2)
		
		public Tree(int r, int c, int move, int type) {
			this.r = r;
			this.c = c;
			this.move = move;
			this.type = type;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());	//평지의 한 변의 길이
		map = new char[N][N];
		
//		1. 입력받기(최초 위치, 최종 위치)
		for(int i=0, start=0, end=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				if(map[i][j]=='B') {
					if(start==0) { sr=i; start++;}
					else if(start++==1) {
						stype = 1 + (i-sr);	//(i-sr): 가로면 열 같으므로 0, 세로면 1이다. 따라서 정의대로 방향 표시 위해 +1해준다.
						sr = i; sc = j;		//통나무 시작 위치
						q.offer(new Tree(sr, sc, 0, stype));
					}
				} else if(map[i][j]=='E') {
					if(end==0) { er=i; end++;}
					else if(end++==1) {
						etype = 1 + (i-er);	//(i-er): 가로면 열 같으므로 0, 세로면 1이다. 따라서 정의대로 방향 표시 위해 +1해준다.
						er = i; ec = j;		//통나무 최종 위치
					}
				}
			}
		}
		
//		2. bfs
		System.out.println(bfs());
	}
	
	static int bfs() {
		Tree cur;	//현재 참조하는 Tree 객체
		int[][] visitedDir = new int[N][N];		//가로형태로 방문했으면 1, 세로형태로 방문했으면 2, 둘다 이미 방문했으면 3
		visitedDir[sr][sc] = stype;	
		
		int cr, cc, ctype, nr, nc;	//현재 좌표, 현재 방향, 새 좌표
		int[][] dir = {{-1,1,0,0},{0,0,-1,1}};	//상하좌우
		
		while(!q.isEmpty()) {
			cur = q.poll();
			cr = cur.r; cc = cur.c; ctype = cur.type;
			
			if(cr==er && cc==ec && ctype==etype) {	//통나무 도착(위치가 같고, 가로세로 방향이 같다)
				return cur.move;
			}
			
			//상하좌우 이동
			for(int i=0; i<4; i++) {	
				if(!checkMove(cur, i)) continue;	//이동이 불가능하면 pass!
				nr = cr + dir[0][i];
				nc = cc + dir[1][i];
				
				if(visitedDir[nr][nc]==3 || visitedDir[nr][nc]==ctype) continue;
				visitedDir[nr][nc] += ctype;
				q.offer(new Tree(nr, nc, cur.move+1, ctype));
			}
			
			//회전
			//		이미 존재하므로 0이될 순 없음
			if(visitedDir[cr][cc]==ctype && checkMove(cur, 4)) {
				ctype = 3-ctype;	//방향 전환
				q.offer(new Tree(cr, cc, cur.move+1, ctype));	//회전
				visitedDir[cr][cc]=3;
			}
		}
		return 0;
	}
	
	//경우에 따라 이동 가능한지 체크한다. (n: 5개의 기본동작) -> dir 대신
	static boolean checkMove(Tree t, int n) {
		int r = t.r, c = t.c;
		
		switch(n) {
		case 0:	//상
			if(t.type==1) {	//가로 방향인 경우
				return r>0 && map[r-1][c-1]!='1' && map[r-1][c]!='1' && map[r-1][c+1]!='1';
			} else {	//세로 방향인 경우
				return r>1 && map[r-2][c]!='1';
			}
		case 1:	//하
			if(t.type==1) {	//가로 방향인 경우
				return r<N-1 && map[r+1][c-1]!='1' && map[r+1][c]!='1' && map[r+1][c+1]!='1';
			} else {	//세로 방향인 경우
				return r<N-2 && map[r+2][c]!='1';
			}
		case 2:	//좌
			if(t.type==1) {	//가로 방향인 경우
				return c>1 && map[r][c-2]!='1';
			} else {	//세로 방향인 경우
				return c>0 && map[r-1][c-1]!='1' && map[r][c-1]!='1' && map[r+1][c-1]!='1';
			}
		case 3:	//우
			if(t.type==1) {	//가로 방향인 경우
				return c<N-2 && map[r][c+2]!='1';
			} else {	//세로 방향인 경우
				return c<N-1 && map[r-1][c+1]!='1' && map[r][c+1]!='1' && map[r+1][c+1]!='1';
			}
		default: //회전
			if(r==0 || r==N-1 || c==0 || c==N-1) return false;
			return map[r-1][c-1]!='1' && map[r-1][c]!='1' && map[r-1][c+1]!='1'
					&& map[r][c-1]!='1' && map[r][c+1]!='1'
					&& map[r+1][c-1]!='1' && map[r+1][c]!='1' && map[r+1][c+1]!='1';
		}
	}

}

/*
7
0000000
0001000
B0010E0
B0010E0
B0010E0
0001000
0000000
correct : 13
out : 12

7
0000000
0000000
0000000
E001000
E0000B0
E0000B0
00000B0
correct : 6
out : 0

5
B0000
B0000
B0000
00000
00EEE
correct : 7
*/