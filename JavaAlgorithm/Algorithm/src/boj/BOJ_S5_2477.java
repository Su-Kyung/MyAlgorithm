package boj;
//S5 참외밭(구현,기하학)
//solved 32m(5m, 16m, 10m)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_2477 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine().trim());	//참외 개수
		int[][] length = new int[2][6];	//방향,변의 길이 저장 배열
		int flag=0;	//전체 넓이에서 빼야할 부분의 인덱스 flag
		
//		참외밭 정보 입력받기
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			length[0][i] = Integer.parseInt(st.nextToken());
			length[1][i] = Integer.parseInt(st.nextToken());
		}
		
//		빼야할 포인트 찾기
		for(int i=0; i<6; i++) {
			if(length[0][i]==length[0][(i+4)%6] && length[0][(i+1)%6]==length[0][(i+5)%6]) {
				flag = i;
				break;
			}
		}
		
//		넓이 구하기
		int area = length[1][(flag+2)%6] * length[1][(flag+3)%6]
				- length[1][flag] * length[1][(flag+5)%6];
		System.out.println(area*num);
	}

}
