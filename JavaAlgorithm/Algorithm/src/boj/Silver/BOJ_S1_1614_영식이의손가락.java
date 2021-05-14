package boj.Silver;
//S1 영식이의 손가락 (Case work)
//solved

import java.util.Scanner;

public class BOJ_S1_1614_영식이의손가락 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int finger = sc.nextInt();
		long chance = sc.nextLong();
		sc.close();
		long ans = 0;
		
		switch(finger) {	//몇번째 손가락이냐에 따라 경우 분류 (끝과 끝, 가운데)
		case 1: ans = 8*chance; break;
		case 5: ans = 8*chance + 4; break;
		default: //짝수or홀수에 따라 분류
			if(chance%2==0) ans = 8*chance/2 + finger-1;
			else ans = 8*(chance-1)/2 + 9-finger;
			break;
		}
		
		System.out.println(ans);
	}

}
