package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_8458_원점으로집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim())+1;
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int dist[] = null;
		
		for(int t=1; t<T; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine().trim());
			dist = new int[N];
			
			int max=0;
			for(int i=0; i<N; i++) {	//좌표를 입력받아 원점과의 거리를 계산하고, 가장 먼 거리를 갱신한다.(max)
				st = new StringTokenizer(br.readLine()," ");
				dist[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
				max = Math.max(dist[i], max);
			}
			
			int turn=0, sum=0;	//turn번째 움직임, 그 움직임까지의 총 이동 좌표 수
			while(true) {		//최대 거리에 있는 좌표가 원점에 도착
				if(sum>=max && (sum-max)%2==0) break;	
				sum += ++turn;
			}
			
			for(int n : dist) {		//모든 좌표에 대해 원점 도착 가능 여부 조사
				if((sum-n)%2!=0) {	//하나라도 홀수라면 원점에 도착할 수 없음
					turn=-1; break;	
				}
			}
			sb.append(turn).append("\n");
		}
		System.out.println(sb);
	}

}
