package boj.Silver;
// S4 큐 (자료 구조, 큐)
// solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S4_10845_큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine().trim());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				queue.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(queue.size() == 0)
					sb.append("-1\n");
				else sb.append(queue.poll()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				sb.append(queue.isEmpty() ? "1\n" : "0\n");
				break;
			case "front":
				if(queue.size() == 0)
					sb.append("-1\n");
				else sb.append(queue.peek()).append("\n");
				break;
			case "back":
				if(queue.size() == 0)
					sb.append("-1\n");
				else {
					ArrayList<Integer> list = new ArrayList<>();
					while(!queue.isEmpty()) {
						list.add(queue.poll());
					}
					for(int n : list) {
						queue.add(n);
					}
					sb.append(list.get(list.size() - 1)).append("\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}

}
