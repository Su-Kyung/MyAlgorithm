package boj.Gold;
//G4 텀 프로젝트 (깊이 우선 탐색,그래프 이론,그래프 탐색)
//solved
//dfs를 너무 오랜만에 풀어서 힘들었다..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_9466_텀프로젝트_dfs {
	static int nextStudents[], N, num;
	static boolean checked[], visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        
        for(int t=0; t<T; t++) {
        	N = Integer.parseInt(br.readLine().trim());
        	nextStudents = new int[N+1];
        	checked = new boolean[N+1];
        	visited = new boolean[N+1];
        	
        	st = new StringTokenizer(br.readLine()," ");
        	for(int i=1, end=N+1; i<end; i++) nextStudents[i] = Integer.parseInt(st.nextToken());
        	
        	num = 0;
        	for(int i=1, end=N+1; i<end; i++) {
        		if(visited[i]) continue;	//팀 만들든 못만들든 어쨌든 방문한 적이 있으므로 다시 체크하지 않는다!
        		dfs(i);
//        		System.out.println(num);
        	}
        	
        	sb.append(N-num).append("\n");
        }
        System.out.println(sb);
    }	
    
    static void dfs(int n) {
    	visited[n] = true;
    	int next = nextStudents[n];
    	
    	if(visited[next]) {		//현재 학생이 함께 팀만들고 싶은 학생에 대해 이미 방문했다 -> 팀 만들 수 있거나, 이미 결정한 애거나
    		if(!checked[next]) {//팀 만들 수 있음
    			num += 1;	//본인부터 포함하고 시작 (i==next인 경우)
    			for(int i = nextStudents[next]; i != next; i = nextStudents[i]) {
    				num++;	//i: 현재 만들고 있는 팀에 포함되는 학생이므로 학생 수 +1
    			}
    		}	//else: next 학생은 이미 모든 결정과 처리가 끝난 상태 -> 더 이상 아무 처리도 하지 않음
    	} else {	//팀 하기를 원하는 학생을 처음 만났음 -> 연쇄적으로 물어봐야 하므로 재귀 호출
    		dfs(next);
    	}
    	
    	checked[n] = true;
    }
}

/*
1
5
2 3 4 2 2

1
5
5 3 4 5 1
 */
