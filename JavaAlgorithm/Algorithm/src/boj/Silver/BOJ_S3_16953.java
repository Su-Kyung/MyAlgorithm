package boj.Silver;
// S5 배열 돌리기 3
// solved

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_16953 {
	static int[][] data;
	static int N, M, R;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		1. 입력받기: 배열의 크기, 수행해야 하는 연산 수, 배열, 수행해야 하는 연산
		N = Integer.parseInt(st.nextToken().trim());
		M = Integer.parseInt(st.nextToken().trim());
		R = Integer.parseInt(st.nextToken().trim());	// 수행해야하는 연산 수
		data = new int[N][M];
		for(int i=0; i<N; i++) {	//배열 데이터 저장
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		String[] todo = br.readLine().split(" ");	// 수행할 연산
		
//		3. 연산 수행
		for (int i=0; i<todo.length; i++) {
			data = operator(Integer.parseInt(todo[i]), data);
		}
		
//		4. 결과 출력
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
	}

//	2. 연산 정의
	public static int[][] operator(int op, int[][] arr) {
		int[][] temp; int t;
		switch(op) {
		case 1:
			temp = new int[N][M];
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					temp[i][j] = arr[N-1-i][j];
				}
			}
			return temp;
		case 2:
			temp = new int[N][M];
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					temp[i][M-1-j] = arr[i][j];
				}
			}
			return temp;
		case 3:
			t = M;
			M = N; N = t;
			temp = new int[N][M];
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					temp[i][j] = arr[M-1-j][i];
				}
			}
			return temp;
		case 4:
			t = M;
			M = N; N = t;
			temp = new int[N][M];
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					temp[i][j] = arr[j][N-1-i];
				}
			}
			return temp;
		case 5:
			temp = new int[N][M];
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if(i<N/2 && j<M/2) temp[i][j+M/2] = arr[i][j];
					else if(i<N/2 && j>=M/2) temp[i+N/2][j] = arr[i][j];
					else if(i>=N/2 && j>=M/2) temp[i][j-M/2] = arr[i][j];
					else temp[i-N/2][j] = arr[i][j];
				}
			}
			return temp;
		case 6:
			temp = new int[N][M];
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if(i<N/2 && j<M/2) temp[i][j] = arr[i][j+M/2];
					else if(i<N/2 && j>=M/2) temp[i][j] = arr[i+N/2][j];
					else if(i>=N/2 && j>=M/2) temp[i][j] = arr[i][j-M/2];
					else temp[i][j] = arr[i-N/2][j];
				}
			}
			return temp;
		}
		return arr;
	}
}
