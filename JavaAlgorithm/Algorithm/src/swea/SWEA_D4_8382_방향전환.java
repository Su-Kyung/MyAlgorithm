package swea;
//D4 방향 전환
//solved 규칙이 쉬워서 규칙을 찾아서 풀었다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_8382_방향전환 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		int x1, x2, y1, y2;
		int width, height;
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=1, tEnd=T+1; t<tEnd; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			width=Math.abs(x1-x2);
			height=Math.abs(y1-y2);
			
			sb.append(2*(width>height?width:height) - ((width-height)%2==0?0:1)).append("\n");	//이 방법이 3ms 더 빠름
//			sb.append(2*Math.max(width, height) - Math.abs((width-height)%2)).append("\n");
			
//			if(width>height) {
//				if((width-height)%2==0) sb.append(width*2).append("\n");
//				else sb.append(width*2-1).append("\n");
//			} else {
//				if((width-height)%2==0) sb.append(height*2).append("\n");
//				else sb.append(height*2-1).append("\n");
//			}
		}
		System.out.println(sb.toString());
	}
}
