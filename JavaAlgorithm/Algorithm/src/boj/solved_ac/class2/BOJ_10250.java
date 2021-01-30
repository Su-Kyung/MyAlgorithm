package boj.solved_ac.class2;
// ACM 호텔(분류: 수학,구현,사칙연산)
// solved

import java.util.Scanner;

public class BOJ_10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		int layer, room, guest;
		int room1;
//		String room2;	// 호수 앞,뒤 둘로 나누기
		int room2;
		
		for (int t = 0; t < test_case; t++) {
			layer = sc.nextInt();
			room = sc.nextInt();
			guest = sc.nextInt();
			
			if (guest%layer==0) {
				room1=layer*100;
			} else room1=(guest%layer)*100;
			
			if (guest%layer==0) room2=guest/layer;
			else room2=guest/layer+1;
			
			System.out.println(room1+room2);
			
//			if (guest%layer==0) {
//				room1=layer;
//				if (guest/layer+1 < 10) room2="0"+(guest/layer);
//				else room2=""+(guest/layer);
//			}
//			else {
//				room1=guest%layer;
//				if (guest/layer+1 < 10) room2="0"+(guest/layer+1);
//				else room2=""+(guest/layer+1);
//			}
//
//			System.out.println(room1+room2);
		}
		sc.close();
	}

}
