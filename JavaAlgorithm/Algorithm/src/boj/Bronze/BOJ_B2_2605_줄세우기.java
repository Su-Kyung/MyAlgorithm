package boj.Bronze;
//B2 줄 세우기(구현)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_B2_2605_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		ArrayList<Integer> students = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//첫번째 학생
		st.nextToken();
		students.add(1);
		
		//나머지 학생 배열
		for(int i=1; i<N; i++) {
			students.add(i-Integer.parseInt(st.nextToken()), i+1);
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i : students) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
