package boj;
// Gold5 탑(분류: 자료구조, 스택)
// solved

import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2493 {
	static int temp;
	static int idx;
	static Stack<int[]> building = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line[] = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			temp = Integer.parseInt(line[i]); 
			
			while(!building.isEmpty()) {
				if (building.peek()[1] > temp) {
					System.out.print(building.peek()[0]+1+" ");
					break;
				} else if (building.peek()[1] == temp) {
					System.out.print(building.peek()[0]+1+" ");
					building.pop();
					break;
				} else if (building.peek()[1] < temp) {
					building.pop();
				}
			}
			if (building.isEmpty()) System.out.print(0+" ");
			building.push(new int[] {i,temp});
		}
		br.close();
	}

}
