package boj.Silver;
// S3 프린터 큐 (구현, 자료 구조, 시뮬레이션, 큐)
// solved
// 처음에는 우선순위 큐를 사용하려고 했다가 틀렸다. 일반적인 큐를 사용하는 방식으로 풀었다. 더 효율적인 방법이 있을것 같다..!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S3_1966_프린터큐 {

	static class Docs {
		boolean find; // 궁금한 문서인지
		int input, impt; // 쌓인 순서, 중요도

		public Docs(boolean find, int input, int impt) {
			this.find = find;
			this.input = input;
			this.impt = impt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스의 수
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) { // 테스트 케이스 수만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 궁금한 문서가 놓여진 순서

			st = new StringTokenizer(br.readLine(), " ");
			Queue<Docs> queue = new LinkedList<Docs>();
			for (int n = 0; n < N; n++) {
				queue.add(new Docs(n == M, n, Integer.parseInt(st.nextToken())));
			}

			int out = 0; // out번째로 출력
			while (!queue.isEmpty()) {
				Docs dcur = null;
				Docs dout = null;
				out++;

				// 출력할 문서 찾기
				for (int i = 0, end = queue.size(), max = 0; i < end; i++) {
					dcur = queue.poll();
					if (dcur.impt > max) {
						max = dcur.impt;
						dout = dcur;
					}
					queue.add(dcur);
				}

				// 출력하기
				// 1) 궁금한 문서면 반복 멈추기
				if (dout.find) {
					sb.append(out).append("\n");
					break;
				}
				// 2) 아직 궁금한 문서의 차례가 아니라면 큐 갱신
				while (!queue.isEmpty()) {
					if (!queue.peek().equals(dout)) {
						queue.add(queue.poll());
					} else { // 프린트할 문서 제거
						queue.poll();
						break;
					}
				}
			}
		}

		System.out.print(sb.toString().trim());
	}

}
