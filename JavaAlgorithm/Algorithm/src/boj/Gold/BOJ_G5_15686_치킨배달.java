package boj.Gold;
//G5 치킨 배달 (브루트포스 알고리즘,구현)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G5_15686_치킨배달 {
	static int ans, M, dist[][], alive[]; //답, 고를 치킨집 수, 집x치킨집 치킨거리, 남는 치킨집
	static ArrayList<Point> arrH = new ArrayList<>(), arrC = new ArrayList<>();
	
	static class Point {
		int r, c;
		public Point(int r, int c) { this.r = r; this.c = c; }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		1. 입력받으며 집,치킨집 체크
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				switch(Integer.parseInt(st.nextToken())) {
				case 1: arrH.add(new Point(i, j)); break;
				case 2: arrC.add(new Point(i, j)); break;
				default: break;
				}
			}
		}
		dist = new int[arrH.size()][arrC.size()];
		
//		2. 치킨거리 구하기
		for(int i=0, endI=arrH.size(); i<endI; i++) {
			for(int j=0, endJ=arrC.size(); j<endJ; j++)
				dist[i][j] = Math.abs(arrH.get(i).r - arrC.get(j).r) + Math.abs(arrH.get(i).c - arrC.get(j).c);
		}
		
//		3. 치킨집 고르기 (조합)
		alive = new int[M];
		ans=Integer.MAX_VALUE;
		combi(0, 0);
		
		//출력
		System.out.println(ans);
	}

	static void combi(int start, int idx) {
		if(idx==M) {	//살아남을 치킨집 다 골랐으면
//			4. 최소 치킨거리 구하기
			ans = Math.min(ans, minDist(alive));
			return;
		}
		
		for(int i=start, end=arrC.size(); i<end; i++) {
			alive[idx] = i;
			combi(i+1, idx+1);
		}
	}
	
	//치킨거리 구하기
	static int minDist(int[] arr) {
		int sum=0, min;
		for(int i=0, endI=arrH.size(); i<endI; i++) {
			min = Integer.MAX_VALUE;
			for(int j=0, endJ=arr.length; j<endJ; j++) min = Math.min(min, dist[i][arr[j]]);
			sum+=min;
			if(sum>=ans) return ans;
		}
		return sum;
	}
}
