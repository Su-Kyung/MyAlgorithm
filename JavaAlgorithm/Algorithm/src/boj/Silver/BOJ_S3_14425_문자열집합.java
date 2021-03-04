package boj.Silver;
// S3 문자열 집합(자료구조,트리를 사용한 집합과 맵,문자열,트리,트라이)
// solved
/* 다른 풀이를 보니 hashset을 이용한 경우는 자바임에도 불구하고 속도가 빨랐다.
 * https://www.acmicpc.net/source/26602464
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_14425_문자열집합 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] str = new String[N];
		for(int i=0; i<N; i++) {
			str[i]=br.readLine().trim();
		}
		String input;
		int cnt=0;
		for(int i=0; i<M; i++) {
			input = br.readLine().trim();
			for(String s : str) {
				if(s.equals(input)) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
