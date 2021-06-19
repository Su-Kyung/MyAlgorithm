package boj.Gold;
//G3 ACM Craft (다이나믹 프로그래밍,그래프 이론,위상 정렬)
//sovled
//퍼즐원스튜디오 SSAFY전형 코테 3번 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_1005_ACMCraft {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int time[] = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				time[i] = Integer.parseInt(st.nextToken());

			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			for (int i = 0; i < N; i++)
				list.add(new ArrayList<>());
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int pre = Integer.parseInt(st.nextToken()) - 1;
				list.get(Integer.parseInt(st.nextToken()) - 1).add(pre);
			}

			int[] sumTime = new int[N];
			Arrays.fill(sumTime, -1);
			sb.append(dfs(Integer.parseInt(br.readLine().trim()) - 1, sumTime, list, time)).append("\n");
		}
		System.out.println(sb);
	}

	private static int dfs(int w, int[] sumTime, ArrayList<ArrayList<Integer>> list, int[] time) {
		if (sumTime[w] > -1)
			return sumTime[w];

		int curTime = 0;
		for (int i = 0; i < list.get(w).size(); i++) {
			curTime = Math.max(curTime, dfs(list.get(w).get(i), sumTime, list, time));
		}
		return sumTime[w] = time[w] + curTime;
	}

}
