package boj.Gold;
// G4 가르침 (백트래킹,비트마스킹,브루트포스 알고리즘,문자열)
// solved
/* 아는 범위 내에서 풀려고하니 아이디어를 생각해내는게 쉽지 않았다(조합 이용했음)
 * 넥퍼, 비스마스킹으로 풀어봐야하는 문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1062_가르침 {
	
	static int N;	//단어의 수
	static int K;	//가르칠 글자 수
	static String[] input;	//입력받은 문자열들
	static char[] learn;	//배우는 문자들
	static int max;	//최대로 가르칠 수 있는 단어 수
	static int numA='a'-97, numC='c'-97, numI='i'-97, numN='n'-97, numT='t'-97;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(K>4) {	//최소 a,c,i,n,t는 가르쳐야 함
//			1. 단어 입력 받기
			input = new String[N];
			for (int i = 0; i < N; i++) input[i] = br.readLine().trim();
			
//			2. 배울 알파벳 고르기(필수 5개 빼고 K-5개)
			learn = new char[K-5];
			combination(0, 1);
		}
		System.out.println(max);
	}

	//알파벳 고르기
	private static void combination(int idx, int start) {
//		4. 조합이 완성되었을 경우 각 단어 검사하면서 배울 수 있는 단어 세고, max값 갱신하기
		if(idx == K-5) {
			int cnt = 0;	//배운 단어의 개수
			boolean canMake;//현재 검사중인 단어를 만들 수 있는지 체크

//			4-1. 배울 단어를 하나의 String으로 모으는 작업
			StringBuilder sb = new StringBuilder();
			sb.append("acint");
			for(char c : learn) sb.append(c);
			String strCheck = sb.toString();
			
//			4-2. 단어 개수만큼 반복하면서 검사
			for(int i=0; i<N; i++) {	
				canMake = true;
				for(int j=4, end=input[i].length()-4; j<end; j++) {	//앞,뒤 고정적인 부분 빼고 검사
					char c = input[i].charAt(j);
					if(strCheck.contains(String.valueOf(c))) continue;
					canMake = false;	//배운 문자에 포함되지 않는 것이 발견되면 못만든다고 표시하고 반복 종료
					break;
				}
				if(canMake) cnt++;	//만들 수 있는 단어인 경우에만 +1
			}
//			4-3. 최대 개수 갱신
			max = Math.max(max, cnt);
			return;
		}
		
//		3. 배울 단어 char배열로 조합구하기 (꼭 배워야하는 단어 제외)
		for (int i = start; i < 26; i++) {
			if(i==numA || i==numC || i==numI || i==numN || i==numT) continue;
			learn[idx] = (char)(i+97);
			combination(idx+1, i+1);
		}
	}
}
