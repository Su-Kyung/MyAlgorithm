package kakao.BlindRecruitment2021;
// solved 40분 (문자열)
/* 다른 사람의 풀이 (java)
 * https://programmers.co.kr/learn/courses/30/lessons/72410/solution_groups?language=java
 */
// StringBuilder를 이용했는데, replaceAll() 메서드 및 정규표현식을 사용하면 String으로 간단하게 풀어낼 수 있다.

import java.util.Scanner;

public class Solution_신규_아이디_추천 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String new_id = sc.next().trim();
		sc.close();

		StringBuilder sb = new StringBuilder();
		// 1단계
		sb.append(new_id.toLowerCase());
		// 2단계
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c >= 'a' && c <= 'z')
				continue;
			else if (c == '-' || c == '_' || c == '.')
				continue;
			else if (c >= '0' && c <= '9')
				continue;
			else
				sb.deleteCharAt(i--);
		}
		// 3단계
		for (int i = 1; i < sb.length(); i++) {
			char pre = sb.charAt(i - 1);
			char cur = sb.charAt(i);

			if (pre == '.' && cur == '.')
				sb.deleteCharAt(i--);
		}
		// 4단계
		if (sb.length() > 0 && sb.charAt(0) == '.')
			sb.deleteCharAt(0);
		if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.')
			sb.deleteCharAt(sb.length() - 1);
		// 5단계
		if (sb.length() == 0)
			sb.append('a');
		// 6단계
		if (sb.length() >= 16) {
			sb.setLength(15);
			if (sb.charAt(sb.length() - 1) == '.')	// 4단계 조건 다시 검사
				sb.deleteCharAt(sb.length() - 1);
		}
		// 7단계
		while (sb.length() <= 2) {
			sb.append(sb.charAt(sb.length() - 1));
		}
		System.out.println(sb.toString());
	}

}
