package kakao.BlindRecruitment2021;
// solved (해쉬맵, 문자열)
/*  해쉬맵 관련 메서드 참고 링크
 *  https://hianna.tistory.com/573
 */
// 우선순위 큐를 사용하면 더 간단하게도 풀 수 있다. 메뉴별 조합 세어서 해보기
// 각 상황마다 어떤 자료구조를 써야할지에 대한 고민을 꽤 길게 했다. 풀었던 방법으로도 다시 풀어보고 정리해보기

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution_메뉴_리뉴얼 {

	public static void main(String[] args) {
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };
		System.out.println(Arrays.toString(solution(orders, course)));
	}

	static int[] choose = {};
	static HashMap<String, Integer> map = new HashMap<>();
	static int[] max = new int[11];

	static String[] solution(String[] orders, int[] course) {

		// 코스메뉴 등장 횟수 세기
		for (String s : orders) {
			for (int len : course) {
				choose = new int[len];
				combination(s, len, 0, 0);
			}
		}

		// 코스요리 유효한 메뉴 리스트에 담기
		ArrayList<String> list = new ArrayList<>();

		map.forEach((key, value) -> {
			if (value > 1 && max[key.length()] == value) {
				list.add(key);
			}
		});

		String[] answer = new String[list.size()];
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

	static void combination(String s, int len, int start, int idx) {
		if (idx == len) {
			char[] combiArr = new char[len];
			for (int i = 0; i < len; i++)
				combiArr[i] = s.charAt(choose[i]);
			Arrays.sort(combiArr); // 정렬을 위해 char[] 활용

			String str_key = "";
			for (char c : combiArr)
				str_key += c;

			if (map.containsKey(str_key))
				map.put(str_key, map.get(str_key) + 1);
			else
				map.put(str_key, 1);

			if (max[len] < map.get(str_key))
				max[len] = map.get(str_key);
			return;
		}

		for (int i = start; i < s.length(); i++) {
			choose[idx] = i;
			combination(s, len, i + 1, idx + 1);
		}
	}
}
