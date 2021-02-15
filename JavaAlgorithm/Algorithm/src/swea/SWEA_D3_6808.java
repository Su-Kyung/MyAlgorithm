package swea;
// D3 6808 규영이와 인영이의 카드게임(순열)
// solved

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_6808 {

	static int[] c1, c2;	// 카드 정보
	static boolean[] flag;		// 사용된 숫자 확인용 배열
	static int win, lose;	// 이기고 지는 횟수
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc<=T; tc++) {
			win = 0; lose = 0; c1 = new int[9]; c2 = new int[9]; flag = new boolean[19];	// 초기화
			st = new StringTokenizer(br.readLine(), " ");
//			카드 정보 입력받기
			for(int i = 0; i < 9; i++) {
				c1[i] = Integer.parseInt(st.nextToken());
				flag[c1[i]] = true;
			}
//			상대 카드 배열 생성하기
			for(int i = 1, j=0; i <= 18; i++) {
				if(!flag[i]) c2[j++] = i;
			}
			
			permutation(0, 0);
			
//			결과 출력
			System.out.printf("#%d %d %d\n", tc, win, lose);
		}
	}

	static int[] numbers = new int[9];	//생성한 순열 저장할 배열
	private static void permutation(int idx, int flag) {

		if (idx == 9) {	// 순열의 요소를 다 생성 
//			System.out.println(Arrays.toString(numbers));
			int a = 0; int b = 0;
			for (int i = 0; i < 9; i++) {
				if (c1[i] > numbers[i]) a += c1[i]+numbers[i];
				else if(c1[i] < numbers[i]) b+= c1[i]+numbers[i];
			}
			if (a>b) win++;
			else if (a<b) lose++;
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if ((flag & 1 << i) != 0) continue;
			numbers[idx] = c2[i-1];
			permutation(idx+1, flag | 1 << i);
		}
	}

}
