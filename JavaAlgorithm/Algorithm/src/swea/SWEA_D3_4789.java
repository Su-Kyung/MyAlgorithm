package swea;
//D3 성공적인 공연 기획
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_4789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		String str;
		int[] people;
		int clap, need;	//박수치고있는 사람, 필요한 사람 수
		
		for (int t=0; t<T; t++) {
//			입력 받기
			str = br.readLine().trim();
			people = new int[str.length()];
			for(int i=0, end=str.length(); i<end; i++) {
				people[i] = str.charAt(i)-'0';
			}
			
//			필요한 인원 세기
			clap=0;
			need=0;
			for(int i=0, end=people.length; i<end; i++) {
				if(people[i]==0) continue;
				if(clap < i) {
					need+= i-clap;
					clap+= i-clap;
				}
				clap += people[i];
			}
			
//			정답 출력
			System.out.printf("#%d %d\n", t+1, need);
		}
	}

}
