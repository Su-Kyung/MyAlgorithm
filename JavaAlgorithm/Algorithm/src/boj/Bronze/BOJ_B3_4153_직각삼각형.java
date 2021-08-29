package boj.Bronze;
// B3 직각삼각형 (수학, 기하학)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_B3_4153_직각삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		Integer[] numbers = new Integer[3];
		String str = br.readLine();
		while (!str.equals("0 0 0")) {
			st = new StringTokenizer(str, " ");
			for (int i = 0; i < 3; i++)
				numbers[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(numbers);
			if(numbers[0] * numbers[0] + numbers[1] * numbers[1] == numbers[2] * numbers[2])
				sb.append("right\n");
			else sb.append("wrong\n");
			
			str = br.readLine();
		}
		
		System.out.println(sb.toString().trim());
	}

}
