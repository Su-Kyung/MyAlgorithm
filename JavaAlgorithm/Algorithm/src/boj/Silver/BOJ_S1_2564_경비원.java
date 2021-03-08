package boj.Silver;
//S1 경비원(Case work,구현)
//solved
/*
 * - 북쪽을 시작 기준점으로 하여 일렬로 펼친다.(북동남서 순서)
 * - 일렬로 펼친 수를 기준으로 차이를 구하되, 그 차이가 가로,세로의 길이 합을 넘는 경우에는 최단거리가 아니므로 결괴를 뒤집어(?)준다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_2564_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine().trim());	//상점 개수
		int[] points = new int[N+1];	
		for(int n=0, end=N+1; n<end; n++) {	//상점 위치, 동근이 위치
			st = new StringTokenizer(br.readLine()," ");
			switch(st.nextToken()) {
			case "1":
				points[n] = Integer.parseInt(st.nextToken());
				break;
			case "4":
				points[n] = Integer.parseInt(st.nextToken())+width;
				break;
			case "2":
				points[n] = width+width-Integer.parseInt(st.nextToken())+height;
				break;
			case "3":
				points[n] = 2*(width+height)-Integer.parseInt(st.nextToken());
				break;
			}
		}
		
		int sum=0;
		for(int n=0; n<N; n++) {	//상점 개수만큼 반복
			sum+=Math.abs(points[N]-points[n])>width+height?
					2*(width+height)-Math.abs(points[N]-points[n]):Math.abs(points[N]-points[n]);
		}
		System.out.println(sum);
	}
}
