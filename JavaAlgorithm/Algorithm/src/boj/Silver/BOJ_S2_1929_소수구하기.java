package boj.Silver;
// S2 소수구하기 (수학,정수론,소수 판정,에라토스테네스의 체)
// solved
/* 에라토스테네스의 체를 사용하자 소수 판별 속도가 굉장히 빨랐다
 * 특히 하나의 수에 대해서만 소수판정하는 경우에는 제곱근까지 검사를 하는 에라토스테네스의 접근을 활용해도 되지만
 * 이 문제와 같이 여러 수에 대해 판단하고 싶을 때에는
 * 2부터 N-1까지 배수들을 체크하는 에라토스테네스의 체를 사용하는 것이 효율적이다.
 */

import java.util.Scanner;

public class BOJ_S2_1929_소수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		sc.close();
		
		//소수 아닌 부분에 true 처리
		boolean[] check = new boolean[N+1];
		check[1]=true;
		for(int i=2; i<N; i++) {
			if(!check[i]) {
				for(int j=i*2, end=N+1; j<end; j+=i) check[j]=true;
			}
		}
		
		//범위 내의 소수 찾아 출력
		StringBuilder sb = new StringBuilder();
		for(int i=M, end=N+1; i<end; i++) if(!check[i]) sb.append(i).append("\n");
		
		System.out.println(sb);
	}

}
