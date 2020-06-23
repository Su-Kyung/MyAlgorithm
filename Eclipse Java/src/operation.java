// 사칙연산, 기본(선택과 반복)

import java.util.Scanner;	// 사용자로부터 입력받음

public class operation {

	public static void main(String[] args) {
		// 사용자의 입력 받기 위한 장치
		Scanner input = new Scanner(System.in);
		
		// 사용자로부터 두 수를 입력받고 그 두 수의 합 출력하기
		int x; int y;
		int sum;
		
		System.out.println("첫 번째 숫자를 입력하세요 : ");
		x = input.nextInt();
		System.out.println("두 번째 숫자를 입력하세요 : ");
		y = input.nextInt();
		
		sum = x + y;
		System.out.println("두 수의 합은 " + sum);
		
		
		// 홀수, 짝수 구별하기 (if문)
		int a;
		System.out.println("구별하고자 하는 수를 입력하세요 : ");
		a = input.nextInt();
		
		if (a % 2 == 0) System.out.println("입력한 수는 짝수입니다.");
		else System.out.println("입력한 수는 홀수입니다.");
		
		
		// 영문으로 입력한 달 숫자로 바꾸기 (switch문)
		String month;	int monthNum;
		System.out.println("월의 영문 이름을 입력하세요 : ");
		month = input.next();
		
		switch(month) {
		case "January":
			monthNum=1;
			break;
		case "Fabuary":
			monthNum=2;
			break;
		case "March":
			monthNum=3;
			break;
		default:
			monthNum=0;
			break;
		}
		System.out.println(monthNum);
	}

}
