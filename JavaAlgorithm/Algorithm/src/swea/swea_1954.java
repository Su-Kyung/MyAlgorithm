package swea;
// D2 달팽이 숫자
// solved 50m

import java.util.Scanner;

public class swea_1954 {
	static int next[][] = {{0,1},{1,0},{0,-1},{-1,0}};	//우하좌상
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int snail;
		int [][] nums;
		for (int t = 0; t < tc; t++) {
			snail = sc.nextInt();
			nums = new int[snail][snail];
			int r = 0, c = 0;
			
			for (int s = 0, direc = 0; s < snail*snail; s++) {
				// 현 좌표에 숫자 적는다.
				nums[r][c] = s+1;
				// 주어진 방향대로 한 칸 이동한다.
				r += next[direc][0];
				c += next[direc][1];
				// 만약, 이동한 좌표 위치가 범위를 벗어나거나 내용이 채워져있으면 방향 바꾼다.
				if (r < 0 || r > snail-1 || c < 0 || c > snail-1 || nums[r][c] != 0) {
					// 되돌리고
					r -= next[direc][0];
					c -= next[direc][1];
					// 방향 변경하고
					direc = (direc+1)%4;
					// 다시 이동한다
					r += next[direc][0];
					c += next[direc][1];
				}
			}
			// 출력
			System.out.println("#"+(t+1));
			for (int i = 0; i < snail; i++) {
				for (int j = 0; j < snail; j++) {
					System.out.print(nums[i][j]+" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
