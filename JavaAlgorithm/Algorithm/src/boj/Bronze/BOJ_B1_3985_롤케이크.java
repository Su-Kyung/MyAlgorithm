package boj.Bronze;
//B1 롤 케이크(구현)
//solved

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_B1_3985_롤케이크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine().trim());	//케이크 길이
		int N = Integer.parseInt(br.readLine().trim());	//방청객 수
		int[][] arr = new int[2][2];	//최대 예상,실제의 방청객 번호와 해당 개수 저장
		boolean[] cake = new boolean[L+1];
		int P, K;	//적어낸 수
		int cnt;
		StringTokenizer st;
		for(int i=1, end=N+1; i<end; i++) {
			st = new StringTokenizer(br.readLine()," ");
			P=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			if(arr[0][1]<K-P+1) {	//최대 예상 번호,개수 갱신
				arr[0][0]=i;
				arr[0][1]=K-P+1;
			}
			
			//케이크 배열
			cnt=0;
			for(int j=P, e=K+1; j<e; j++) {
				if(!cake[j]) {
					cake[j]=true;
					cnt++;
				}
			}
			
			if(arr[1][1]<cnt) {	//최대 실제 번호,개수 갱신
				arr[1][0]=i;
				arr[1][1]=cnt;
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(arr[0][0]+"\n"+arr[1][0]);
		bw.flush();
	}
}

/*
10
3
2 4
7 8
6 9
 */
