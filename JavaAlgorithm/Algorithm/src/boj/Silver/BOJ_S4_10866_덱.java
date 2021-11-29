package boj.Silver;
// S4 덱 (자료 구조, 덱)
// solved
// LinkedList < ArrayDeque(시간은 비슷한데, 살짝 빠름) < ConcurrentLinkedDeque < LinkedBlockingDeque

import java.io.*;
import java.util.*;

public class BOJ_S4_10866_덱 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		Deque<String> deque = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			switch(str[0]) {
			case "push_front":
				deque.addFirst(str[1]);
				break;
			case "push_back":
				deque.addLast(str[1]);
				break;
			case "pop_front":
				if(deque.isEmpty())
					sb.append("-1\n");
				else sb.append(deque.pollFirst()).append("\n");
				break;
			case "pop_back":
				if(deque.isEmpty())
					sb.append("-1\n");
				else sb.append(deque.pollLast()).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if(deque.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			case "front":
				if(deque.isEmpty())
					sb.append("-1\n");
				else sb.append(deque.peekFirst()).append("\n");
				break;
			case "back":
				if(deque.isEmpty())
					sb.append("-1\n");
				else sb.append(deque.peekLast()).append("\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}

}
