package swea;
// D3 의석이의 세로로 말해요
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_5356 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());	//테스트케이스
		String[] words;
		StringBuilder sb;
		
		for(int t=0; t<T; t++) {
//			1. 단어들 입력받아 저장
			words = new String[5];
			for(int i=0; i<5; i++) {
				words[i] = br.readLine().trim();
			}
			
//			2. 세로로 읽기
			sb = new StringBuilder();
			sb.append("#").append(t+1).append(" ");
			int col=0; boolean flag;
			do {
				flag=false;
				for(int i=0; i<5; i++) {
					if(words[i].length()>col) {
						flag=true;
						sb.append(words[i].charAt(col));
					}
				}
				col++;
			} while(flag);	//col이 나타내는 열에 해당하는 값이 있는 동안 반복
			
//			3. 결과 출력
			System.out.println(sb.toString());
		}
	}

}
