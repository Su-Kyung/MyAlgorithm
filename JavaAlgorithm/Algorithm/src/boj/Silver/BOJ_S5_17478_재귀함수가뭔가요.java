package boj.Silver;
// S5 재귀함수가 뭔가요? (구현, 재귀)
// solved

import java.io.IOException;
import java.util.Scanner;

public class BOJ_S5_17478_재귀함수가뭔가요 {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();

		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		chatBot(sb, 0, "");
		System.out.println(sb.toString());
	}

	private static void chatBot(StringBuilder sb, int n, String flagStr) {
		if (n > N)
			return;

		sb.append(flagStr).append("\"재귀함수가 뭔가요?\"\n");

		if (n == N) {
			sb.append(flagStr).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		} else {
			sb.append(flagStr).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
			.append(flagStr).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
			.append(flagStr).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		}

		chatBot(sb, n + 1, flagStr + "____");

		sb.append(flagStr).append("라고 답변하였지.\n");
	}

}