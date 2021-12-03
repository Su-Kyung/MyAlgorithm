package boj.Platinum;
// P5 시계 사진들 (문자열, kmp)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_P5_10266_시계사진들 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int MAXA = 360000;
		int N = Integer.parseInt(br.readLine().trim());

		// 방법1) 360000만큼의 배열 만들기
		int[] angle1 = new int[MAXA];
		int[] angle2 = new int[MAXA * 2];
		int[] table = new int[MAXA];

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			angle1[Integer.parseInt(st1.nextToken())] = 1;
			int idx = Integer.parseInt(st2.nextToken());
			angle2[idx] = angle2[idx + MAXA] = 1;
		}

		// angle1 기준으로 table 만들기
		for (int i = 1, j = 0; i < MAXA; i++) {
			while (j > 0 && angle1[i] != angle1[j]) {
				j = table[j - 1];
			}
			if (angle1[i] == angle1[j]) {
				table[i] = ++j;
			}
		}

		// kmp
		boolean flag = false;
		for (int i = 0, j = 0; j < 2 * MAXA - 1; j++) {
			while (i > 0 && angle1[i] != angle2[j]) {
				i = table[i - 1];
			}
			if (angle1[i] == angle2[j]) {
				if (i == MAXA - 1) {
					flag = true;
					break;
				} else
					i++;
			}
		}

		// 정답 출력
		System.out.println(flag ? "possible" : "impossible");

		// 방법2) 각도 차이 만들어 배열 만들어 kmp: 방법1보다 시간 약 2배
//		int[] diff1 = new int[N];
//		int[] diff2 = new int[N * 2]; // 0 ~ N*2-2 사용
//		int[] table = new int[N];
//
//		// 각도 입력받기
//		StringTokenizer st1 = new StringTokenizer(br.readLine());
//		StringTokenizer st2 = new StringTokenizer(br.readLine());
//		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
//		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
//		for (int i = 0; i < N; i++) {
//			pq1.offer(Integer.parseInt(st1.nextToken()));
//			pq2.offer(Integer.parseInt(st2.nextToken()));
//		}
//
//		// 각도 차이 배열 만들기
//		int first1 = pq1.poll();
//		int first2 = pq2.poll();
//		int pre1 = first1;
//		int pre2 = first2;
//		for (int i = 0; i < N - 1; i++) {
//			diff1[i] = pq1.peek() - pre1;
//			diff2[i] = diff2[i + N] = pq2.peek() - pre2;
//			pre1 = pq1.poll();
//			pre2 = pq2.poll();
//		}
//		diff1[N - 1] = first1 - pre1 + MAXA;
//		diff2[N - 1] = diff2[N * 2 - 1] = first2 - pre2 + MAXA;
//
//		// 첫번째 각도 테이블 만들기
//		for (int i = 1, j = 0; i < N; i++) {
//			while (j > 0 && diff1[i] != diff1[j]) {
//				j = table[j - 1];
//			}
//			if (diff1[i] == diff1[j]) {
//				table[i] = ++j;
//			}
//		}
//
//		// kmp
//		boolean flag = false;
//		for (int i = 0, j = 0; i < N * 2 - 1; i++) {
//			while (j > 0 && diff1[j] != diff2[i]) {
//				j = table[j - 1];
//			}
//			if (diff1[j] == diff2[i]) {
//				if (j == N - 1) {
//					flag = true;
//					break;
//				} else
//					j++;
//			}
//		}
		
		// 결과 출력
		System.out.println(flag ? "possible" : "impossible");
	}

}

/*
9
1 3 5 120000 120001 120002 240001 240003 240005
0 1 2 120001 120003 120005 240000 240001 240002
 */