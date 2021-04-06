package boj.Silver;
//S2 IOIOI (문자열)
//solved
//인덱스 주의!

import java.util.Scanner;

public class BOJ_S2_5525_IOIOI {

	public static void main(String[] args) {
//		1. 입력받기
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//O의 개수
		int M = sc.nextInt();	//S의 길이
		String S = sc.next();	//문자열 S
		sc.close();
		
//		2. S 탐색
		int idx=0;	//문자열에서 참조할 인덱스
		int ans=0;	//답
		int cnt;	//연속한 IOI개수 세는 변수
		while(idx<M-1) {	//idx=M-2까지는 IOI 있을 가능성 있다
			if(S.charAt(idx)=='I') {	//'I'라면 뒤에 연속한 OI 몇개오는지 검사
				cnt=0;
				while(idx+(cnt+1)*2<M) {	//charAt()안에 들어갈 인덱스가 유효한 범위 내에서만 검사
					if(S.charAt(idx+cnt*2+1)=='O' && S.charAt(idx+(cnt+1)*2)=='I') cnt++;	//연속한 OI의 개수
					else break;
				}
				idx+=cnt*2+1;	//연속한 OI 다음부터 검사
				ans+=Math.max(0, cnt-N+1);	//하나도 없다면 음수가 나올 수 있으므로 0과 비교	
//				System.out.println(ans);
			} else idx++;	//'O'면 필요 없으니 그냥 인덱스 하나 더해서 다음 char 검사
		}
		System.out.println(ans);
	}
}
