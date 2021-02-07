package swea;
// d3 원재의 메모리 복구하기
// solved (bs: 7m, input: 8m, algo: 3m, test: 1m, dbg: 0m)

import java.util.Scanner;

public class swea_d3_1289 {
	// 홀짝 이용
	static int flag;	// 홀짝 구분위한 플래그
	static int result;	// 바꿔야할 횟수
	static String str;	// 각 케이스별 입력값(원래상태)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			flag = 0;
			result = 0;
			str = sc.next();
			for (int i = 0; i < str.length(); i++) {
				if ((str.charAt(i)-'0'+flag & 1) == 1) {
					flag++;
					result++;
				}
			}
			System.out.printf("#%d %d\n", t+1, result);
		}
		sc.close();
	}
	
	// 다른 풀이
//	static String[] number;
//    static int result;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int test_case = sc.nextInt();
// 
//        for (int t = 0; t < test_case; t++) {
//            number = sc.next().split("");
//            result = 0;
//            for (int i = 0; i < number.length-1; i++) {
//                if (i==0 && number[i].equals("1")) result++;
//                if (!number[i].equals(number[i+1])) {
//                    result++;
//                }
//            }
//            System.out.println("#"+(t+1)+" "+result);
//            result = 0;
//        }
//        sc.close();
//    }

}
