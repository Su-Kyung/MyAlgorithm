package boj.Bronze;
// B2 컵홀더(그리디 알고리즘,구현,문자열)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_B2_2810_컵홀더 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		char[] input = br.readLine().toCharArray();
		ArrayList<Character> seat = new ArrayList<>();
		seat.add('*');
		boolean couple=false;
		for(int i=0; i<N; i++) {
			if(input[i]=='S') {
				seat.add('S');
				seat.add('*');
			} else {
				if(couple) {
					seat.add('L');
					seat.add('*');
					couple = false;
				} else {
					seat.add('L');
					couple = true;
				}
			}
		}
//		System.out.println(Arrays.toString(seat.toArray()));
		int cnt=0;
		for(int i=1, end=seat.size()-1; i<end; i++) {
			switch(seat.get(i)) {
			case 'L':
			case 'S':
				if(seat.get(i-1)=='*') {
					seat.set(i-1, '.');
					cnt++;
				} else if(seat.get(i+1)=='*') {
					seat.set(i+1, '.');
					cnt++;
				}
			default:
				continue;
			}
		}
		System.out.println(cnt);
	}
}
