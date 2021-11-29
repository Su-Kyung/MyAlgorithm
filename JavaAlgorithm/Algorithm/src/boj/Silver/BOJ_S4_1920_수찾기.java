package boj.Silver;
//S4 수 찾기 (이분탐색)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_S4_1920_수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
		HashSet<String> set = new HashSet<>();
		String str[] = br.readLine().split(" ");
		
		for(String s : str) {
			if(!set.contains(s))
				set.add(s);
		}

		StringBuilder sb = new StringBuilder();
		br.readLine();
		str = br.readLine().split(" ");
		
		for(String s : str) {
			if(set.contains(s))
				sb.append("1\n");
			else
				sb.append("0\n");
		}

		System.out.println(sb.toString());
	}

}
