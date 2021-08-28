package codeup;
//기초5-3. 크레이지 아케이드 (이차원배열)
//solved
//물줄기 때문에 아직 터지지 않은 다른 물풍선이 사라지지 않도록 주의

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CU_1525_크레이지아케이드 {
	static int map[][] = new int[10][10];
	static Queue<Bubble> queue = new LinkedList<Bubble>();
	static int players[][];
	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	static class Bubble { // 물풍선 객체
		int r, c, l; // 행, 열, 터지는 길이

		public Bubble(int r, int c, int l) {
			this.r = r;
			this.c = c;
			this.l = l;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

//		1. 10*10의 보드판 입력
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) // 현재 좌표가 물풍선인 경우
					queue.add(new Bubble(i, j, map[i][j]));
			}
		}

//		2. 플레이어 정보 입력
		int num = Integer.parseInt(br.readLine().trim()); // 플레이어 수
		players = new int[num][3]; // 플레이어의 위치 저장 (행, 열, 생존유무:죽었으면 1)
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			players[i][0] = Integer.parseInt(st.nextToken()) - 1;
			players[i][1] = Integer.parseInt(st.nextToken()) - 1;
		}

//		3. 물풍선 터뜨리기
		while (!queue.isEmpty()) {
			Bubble cur = queue.poll(); // 터뜨릴 물풍선

			map[cur.r][cur.c] = -2; // 물풍선 위치
			for (int d = 0; d < 4; d++) { // 상하좌우 탐색
				for (int l = 1; l <= cur.l; l++) { // 해당 수만큼 물풍선 터진다.
					int nr = cur.r + dir[0][d] * l;
					int nc = cur.c + dir[1][d] * l;
					if (nr < 0 || nr > 9 || nc < 0 || nc > 9 || map[nr][nc] == -1)
						break; // map 범위를 벗어나거나 장애물 만나면 그만터진다.
					map[nr][nc] = -2;
				}
			}
		}

//		4. 플레이어의 생존 유무 체크하기
		for (int i = 0; i < num; i++) {
			if (map[players[i][0]][players[i][1]] == -2)
				players[i][2] = 1; // 플레이어 죽음
			else
				map[players[i][0]][players[i][1]] = i + 1; // 플레이어 번호 표시
		}

//		5. 정답 출력
		StringBuilder sb = new StringBuilder();
		// 5-1. 물풍선 터진 지도
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append("\n");
		}
		// 5-2. 플레이어 정보
		sb.append("Character Information");
		for (int i = 0; i < num; i++) {
			sb.append("\nplayer ").append(i + 1).append(players[i][2] == 0 ? " survive" : " dead");
		}
		System.out.println(sb.toString());
	}

}
