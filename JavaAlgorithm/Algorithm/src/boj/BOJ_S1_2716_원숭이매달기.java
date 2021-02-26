package boj;
//S1 원숭이 매달기
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_2716_원숭이매달기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());	//테케 수
		String tree;
		int depth, max;
		
		for(int t=0; t<T; t++) {
			tree=br.readLine().trim();
			depth=0; max=0;
			for(int i=0, end=tree.length(); i<end; i++) {
				if(tree.charAt(i)=='[') {
					depth++;
					max = Math.max(depth, max);
				} else depth--;
			}
			
			System.out.println((int)Math.pow(2, max));
		}
	}
}
