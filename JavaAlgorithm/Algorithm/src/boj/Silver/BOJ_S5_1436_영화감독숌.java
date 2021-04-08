package boj.Silver;
//S5 영화감독 숌 (브루트포스 알고리즘)
//solved
//dp나 수식으로 규칙을 찾아서 풀어야 할 것 같았는데, 그냥 있는 그대로 풀면 되는 문제였다.

import java.util.Scanner;

public class BOJ_S5_1436_영화감독숌 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		int ans = 0;
		for(int i=0, checkNum=666; i<N;) {
			if(String.valueOf(checkNum).contains("666") && i++==N-1)  ans=checkNum;
			checkNum++;
		}
		
		System.out.println(ans);
	}

}
