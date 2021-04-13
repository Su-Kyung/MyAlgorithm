package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_SWT_4014_활주로건설 {
	static int N, X;
	static int[][] map, rmap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim())+1;
		StringTokenizer st; StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			rmap = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) rmap[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int ans=0;
			for(int i=0; i<N; i++) {
				if(checkRoad(map[i])) ans++;
				if(checkRoad(rmap[i])) ans++;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static boolean checkRoad(int[] arr) {
		int idx=1, before=arr[0], cnt=1;
		boolean[] build = new boolean[N];
		
		while (idx<N) {
			if(arr[idx]==before) { cnt++; idx++; }
			else if(arr[idx]==before+1) {	//한칸 높아진 경우
				if(cnt<X) return false;
				for(int x=X; x>0; x--) if(build[idx-x]) return false;
				before++; cnt=1; idx++;
			} else if(arr[idx]==before-1) {	//한칸 낮아진 경우
				if(idx+X>N) return false;
				before--;
				for(int x=0; x<X; x++) if(arr[idx+x]!=before) return false;
				for(int x=0; x<X; x++) build[idx+x] = true;
				cnt=1; idx+=X;
			} else return false;
		}
		return true;
	}
}
