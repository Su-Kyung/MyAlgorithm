package boj.Silver;
// S5 크로아티아 알파벳(구현,문자열)
// solved
/* 다른 풀이 방법:
 * - 배열에 검사할 key들을 저장해두고 있는지 검사하여 다른 문자로 대체한다. -> 새로운 문자열 길이 구하면 됨
 * - 큐를 이용하는 방법도 있음
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int idx=0, end = str.length()-1;
		int cnt=0;
		char next;
		while(idx<end) {
			next=str.charAt(idx+1);
			switch(str.charAt(idx)) {
			case 'd':
				if(next=='-') idx++;
				else if(idx<end-1 && next=='z'
						&& str.charAt(idx+2)=='=') idx+=2;
				break;
			case 'c':
				if(next=='-') idx++;
			case 's':
			case 'z':
				if(next=='=') idx++;
				break;
			case 'l':
			case 'n':
				if(next=='j') idx++;
				break;
			default:
				break;
			}
			cnt++;
			idx++;
		}
		System.out.println(idx==end?++cnt:cnt);	//마지막 알파벳 하나 남은경우 cnt+1 출력
	}
}
