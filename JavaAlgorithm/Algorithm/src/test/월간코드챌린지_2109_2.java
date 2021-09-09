package test;
// solved (01:54:30)
// bfs

import java.util.*;

public class 월간코드챌린지_2109_2 {

	public static void main(String[] args) {
		String[] grid = { "R", "R" };
		System.out.println(Arrays.toString(solution(grid)));
	}

	static int[][] dir = { { -1, 0, 1, 0 }, { 0, 1, 0, -1 } }; // 상우하좌

	static class Point {
		int r, c, d, w; // 행, 열, 방향, 사이클 길이

		public Point(int r, int c, int d, int w) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.w = w;
		}
	}

	static int[] solution(String[] grid) {
		ArrayList<Integer> answer = new ArrayList<>();

		int[][][] visited = new int[grid.length][grid[0].length()][4];	// 방문체크

		for (int r = 0; r < grid.length; r++) { // grid 행
			for (int c = 0; c < grid[0].length(); c++) { // grid 열
				for (int d = 0; d < 4; d++) { // 방향
					if (visited[r][c][d] != 0)
						continue;

					// 사이클 체크하기
					Queue<Point> queue = new LinkedList<>();
					queue.add(new Point(r, c, d, 1));
					while (!queue.isEmpty()) {
						Point point = queue.poll();

						// 새로운 방향
						int newdir = 0;
						switch (grid[point.r].charAt(point.c)) {
						case 'R':
							newdir = (point.d + 1) % 4;
							break;
						case 'L':
							newdir = (point.d + 3) % 4;
							break;
						default:
							newdir = point.d;
							break;
						}
						// 새로운 행, 열
						int newR = (point.r + dir[0][newdir] + grid.length) % grid.length;
						int newC = (point.c + dir[1][newdir] + grid[0].length()) % grid[0].length();

						// 만약 방문한 곳이라면 사이클 생성
						if (visited[newR][newC][newdir] != 0)
							answer.add(point.w + 1 - visited[newR][newC][newdir]);
						else { // 아니라면 계속하기
							visited[newR][newC][newdir] = point.w + 1;
							queue.offer(new Point(newR, newC, newdir, point.w + 1));
						}

					}
				}
			}
		}

		// 오름차순 정렬
		Collections.sort(answer);
		int[] ans = new int[answer.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = answer.get(i);
		}
		return ans;
	}
}
