import java.util.*;		// Scanner 클래스 포함

// 자바 기본 개념 다시 잡기 (알고리즘 X)
public class hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello!");
		System.out.println("자바 기억 더듬기");
		
		// 유니코드 규격 확인하기 (UTF-16)
		char ch1 = '가';
		char ch2 = '\uac00';
		System.out.println(ch1 + "와 동일하게 출력: " + ch2);
		
		// Scanner 클래스 사용하여 입력받기
		Scanner input = new Scanner(System.in);
		System.out.println("입력 : ");
		String line = input.nextLine();		// 한 줄을 읽는다.
		System.out.println(line);
	}

}
