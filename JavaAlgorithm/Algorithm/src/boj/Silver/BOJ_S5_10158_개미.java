package boj.Silver;
//S5 개미(수학,사칙연산,애드 혹)
//solved
/* x좌표 y좌표를 각각 나누어 초에 따른 계산이 아니라 관계식을 통해 바로 결과값을 도출한다.
 * 내가 사용한 관계식: (시작좌표+초)%(변의길이*2)>변의길이
 * 위 결과값이 true면 변의길이*2에서 결과값을 빼준다.
 * 즉, 왔다갔다 하는 것을 펴서 일자로 생각하고 풀었음
 */

/*
6 4
4 1
8
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S5_10158_개미 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		격자 공간의 크기
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
//		개미의 위치
		st = new StringTokenizer(br.readLine()," ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
//		횟수(시간)
		int T = Integer.parseInt(br.readLine().trim());
		
//		T초 후 개미 위치 방법 2 - 관계식 이용
		x = (x+T)%(w*2);
		y = (y+T)%(h*2);
//		출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write((x>w?2*w-x:x)+" "+(y>h?2*h-y:y));
		bw.flush();

////		T초 후 개미 위치 방법 1 - 시간초과
//		int dr=1, dc=1;	//행,열 방향
//		for(int t=0; t<T; t++) {
//			x += dr;
//			y += dc;
//			if(x<0 || x>w) {
//				dr *= -1;
//				x += dr*2;
//			}
//			if(y<0 || y>h) {
//				dc *= -1;
//				y += dc*2;
//			}
////			System.out.printf("%d %d\n", x, y);
//		}
////		출력
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		bw.write(x+" "+y);
//		bw.flush();
////		System.out.printf("%d %d", x, y);
	}

}
