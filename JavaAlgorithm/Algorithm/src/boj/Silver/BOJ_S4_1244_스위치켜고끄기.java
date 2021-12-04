package boj.Silver;
//스위치 켜고 끄기(분류: 구현)
//solved

import java.util.Scanner;

public class BOJ_S4_1244_스위치켜고끄기 {
	// 여학생 대칭 처리를 위한 속성
	static int nIndex1, nIndex2;
	
	public static void main(String[] args) {
//		1. 입력 받기
		Scanner sc = new Scanner(System.in);
		int switchNum = sc.nextInt();
		sc.nextLine();
		String[] switches = sc.nextLine().split(" ");
		int studentNum = sc.nextInt();
		int gender = 0;
		int mission = 0;
		
//		2. 학생 수만큼 반복
		for (int s = 0; s < studentNum; s++) {
			gender = sc.nextInt();
			mission = sc.nextInt();
//			3. 학생 성별에 따라 처리하기
			if (gender == 1) {	// 남학생
//				3.1 남학생인 경우 - 배수인 경우 바꾸기
				for (int i = 1; i < switches.length+1; i++) {
					if (i%mission==0) {
						switches[i-1] = Integer.toString(1-Integer.parseInt(switches[i-1]));
					}
				}
			} else if (gender == 2) {	// 여학생
//				3.2 여학생인 경우 - 최대 대칭하는 만큼 바꾸기
				switches[mission-1] = Integer.toString(1-Integer.parseInt(switches[mission-1]));
				for (int i = 1; i < switches.length; i++) {
					nIndex1 = mission-1 + (-1)*i;
					nIndex2 = mission-1 + i;
					if (nIndex1 < 0 || nIndex2 > switches.length-1 || !switches[nIndex1].equals(switches[nIndex2])) break;
					else {
						switches[nIndex1] = Integer.toString(1-Integer.parseInt(switches[nIndex1]));
						switches[nIndex2] = Integer.toString(1-Integer.parseInt(switches[nIndex2]));
					}
				}
			}
		}
		sc.close();
		
//		4. 결과 출력
		for (int i = 0; i < switchNum; i++) {
			if ((i+1)%20==0) {
				System.out.println(switches[i]+" ");
			} else System.out.print(switches[i]+" ");
//			System.out.print(switches[i]);
//			if ((i+1)%20==0) {
//				System.out.println();
//			} else if (i != switchNum-1) System.out.print(" ");
		}
	}

}
