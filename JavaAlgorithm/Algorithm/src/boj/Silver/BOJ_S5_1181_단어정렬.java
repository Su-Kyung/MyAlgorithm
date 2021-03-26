package boj.Silver;
// S5 단어 정렬 (정렬,문자열)
// solved
/* - 문자열 길이로 정렬, 문자열 사전순 정렬
 * - Comparator, compare
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_S5_1181_단어정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine().trim());
		for(int i=0; i<N; i++) list.add(br.readLine().trim());
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else return Integer.compare(o1.length(), o2.length());
			}
		});
		
		for(int i=0; i<N; i++) {
			if(i>0 && list.get(i).equals(list.get(i-1))) continue;
			System.out.println(list.get(i));
		}
	}
}
