package boj.Gold;
//G5 동물원 (?)
//solved

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_12907_동물원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] check = new int[42]; //인접한 인덱스 두 값을 비교하므로 +1, 0~40 사용하니까+1
		for(int i=0; i<N; i++) check[Integer.parseInt(st.nextToken())]++;
		
		int num1=-1, num2=-1, idx=-1;
		while(++idx<41) {
			if(check[idx]>2 || check[idx]<check[idx+1]) {
				num1=num2=-1;
				break;
			}
			
			if(num1!=-1 && num2!=-1) continue;
			if(check[idx]==2 && check[idx+1]==0) num1=num2=idx;
			else if(check[idx]>check[idx+1]) {
				if(num1==-1) num1=idx+1;
				else num2=idx+1;
			}
		}
		
		long ans;
		if(num1==-1 && num2==-1) ans=0;
//		else if(num1==num2) ans=2; ->이부분때문에 계속틀림..
		else ans= (long) Math.pow(2, Math.min(num1, num2!=-1?num2:0))*2;
//		System.out.println(num1+" "+num2);
		System.out.println(ans);
	}
}

/*
40
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39

4
0 1 0 1
*/