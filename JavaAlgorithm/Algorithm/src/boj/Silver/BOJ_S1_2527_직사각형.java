package boj.Silver;
//S1 직사각형
//solved: 경우에 대한 조건만 잘 생각하면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_2527_직사각형 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int x1=0, y1=0, p1=0, q1=0;
		int x2=0, y2=0, p2=0, q2=0;
		
		for(int t=0; t<4; t++) {
			// 좌표 입력받기
			st = new StringTokenizer(br.readLine()," ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			p1 = Integer.parseInt(st.nextToken());
			q1 = Integer.parseInt(st.nextToken());
			
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			p2 = Integer.parseInt(st.nextToken());
			q2 = Integer.parseInt(st.nextToken());
			
			if(p1<x2 || p2<x1 || q1<y2 || q2<y1) System.out.println('d');
			else if(y1==q2 || y2==q1) {
				if(x1==p2 || x2==p1) System.out.println('c');
				else System.out.println('b');
			} else if(x1==p2 || x2==p1) {
				if(y1==q2 || y2==q1) System.out.println('c');
				else System.out.println('b');
			} else System.out.println('a');
		}
	}
}
