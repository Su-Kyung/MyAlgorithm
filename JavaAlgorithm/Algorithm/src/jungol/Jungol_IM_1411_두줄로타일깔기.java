package jungol;

// Intermediate_동적계획법: 두 줄로 타일 깔기(다이나막,DP,Fibonacci)
// solved
/* f(1)=1
 * f(2)=3
 * n>2: f(n) = f(n-2)*2 + f(n-1)
 */

import java.util.Scanner;

public class Jungol_IM_1411_두줄로타일깔기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] f = new int[N+1];
		
		f[1] = 1;
		f[2] = 3;
		for(int i=3; i<=N; i++) {
			f[i] = (f[i-2]*2 + f[i-1]) % 20100529;
		}
		System.out.println(f[N]);
		sc.close();
	}
}
