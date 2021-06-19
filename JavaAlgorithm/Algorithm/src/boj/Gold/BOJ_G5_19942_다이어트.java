package boj.Gold;
//G5 다이어트 (문자열,브루트포스 알고리즘,백트래킹)
//solved
// 부분집합으로 하면 사전순으로 안만들어지고 조합으로 하면 사전순으로 만들어진다. 부분집합으로 하면 사전순인지 점검하는 과정이 필요하다!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G5_19942_다이어트 {
	static int N, mp, mf, ms, mv, mcost=Integer.MAX_VALUE, info[][];
	static List<String> list = new ArrayList<String>();
	static boolean[] choose;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
//		1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		
		info = new int[N][5];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<5; j++) info[i][j] = Integer.parseInt(st.nextToken());
		}
		
//		2. 부분집합 구하기
		choose = new boolean[N];
		makeSubset(0);
		
		Collections.sort(list);
		System.out.println(list.size()==0?-1:mcost+"\n"+list.get(0));
	}
	
	private static void makeSubset(int idx) {
		if (idx == N) {
			int p=0, f=0, s=0, v=0, cost=0;
	    	for (int i = 0; i < N; i++) {
	    		if (choose[i]) {
	               p+=info[i][0];
	               f+=info[i][1];
	               s+=info[i][2];
	               v+=info[i][3];
	               cost+=info[i][4];
//	               System.out.printf(i+" ");
	    		}
	    	}
//	    	System.out.println();
	    	if(p>=mp && f>=mf && s>=ms && v>=mv && cost<=mcost) {
	    		if(cost < mcost) {
	    			mcost = cost;
	    			list = new ArrayList<>();
	    		}
	    		sb.setLength(0);
//	    		sb.append(cost).append("\n");
	    		for (int i = 0; i < N; i++) {
		    		if (choose[i]) {
		               sb.append(i+1).append(" ");
		    		}
		    	}
	    		list.add(sb.toString());
	    	}
	    	return;
		}
		
		choose[idx] = true;
		makeSubset(idx + 1);
		choose[idx] = false;
		makeSubset(idx + 1);
	}

}

/*
3
0 0 0 1
0 0 0 1 1
0 0 0 0 0
0 0 0 0 0
=>
1
1


3
0 0 0 1
0 0 0 0 0
0 0 0 0 0
0 0 0 1 0
=>
0
1 2 3 


3
0 0 0 1
0 0 0 1 0
0 0 0 0 0
0 0 0 0 0
=>
0
1


 */
