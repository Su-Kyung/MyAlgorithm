package boj.Bronze;
//B3 직사각형을 만드는 방법(구현,수학)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B3_8320_직사각형을만드는방법 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int square, cnt=0;
		for(int i=1, j=1, end=(int)Math.sqrt(N)+1; i<end; i++) {
			j=i;
			while (true) {
				square = i*j++;
				if(square > N) break;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
