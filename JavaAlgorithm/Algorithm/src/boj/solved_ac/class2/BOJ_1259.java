package boj.solved_ac.class2;
// solved
import java.util.Scanner;

public class BOJ_1259 {
	static int num;
	static String snum;
	static boolean isPalin;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		while (num!=0) {
			snum = Integer.toString(num);
			isPalin = true;
			for (int i = 0; i < snum.length()/2; i++) {
				if (snum.charAt(i) != snum.charAt(snum.length()-1-i)) {
					isPalin = false;
					break;
				}
			}
			
			if (isPalin) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			num = sc.nextInt();
		}
		
		sc.close();
	}

}
