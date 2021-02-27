package boj.Bronze;
//B2 방배정(수학,구현)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_13300 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	//학생 수
		int K = Integer.parseInt(st.nextToken());	//한 방 최대 인원 수
		
		int[][] student = new int[2][6];	//성별, 학년
		for(int i=0; i<N; i++) {	//학생 입력받기
			st = new StringTokenizer(br.readLine(), " ");
			student[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())-1]++;
		}
		
		int room = 0;	//필요한 방의 수
		for(int i=0; i<2; i++) {	//성별
			for(int j=0; j<6; j++) {//학년
				if(student[i][j]==0) continue;
				// 주의!!
				if(student[i][j]%K==0) room += student[i][j]/K;
				else room += student[i][j]/K+1;
			}
		}
		System.out.println(room);
	}

}
