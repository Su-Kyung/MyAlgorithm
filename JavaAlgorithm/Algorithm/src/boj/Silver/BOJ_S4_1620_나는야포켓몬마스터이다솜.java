package boj.Silver;
// S4 나는야 포켓몬 마스터 이다솜 (해시를 사용한 집합과 맵)
// Character.isDigit(char c) : c가 숫자면 true, 문자면 false 리턴 (boolean)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_S4_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<Integer, String> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			map1.put(i, br.readLine().trim());
			map2.put(map1.get(i), i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String key = br.readLine().trim();
			if (map2.containsKey(key))
				sb.append(map2.get(key)).append("\n");
			else
				sb.append(map1.get(Integer.parseInt(key))).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
