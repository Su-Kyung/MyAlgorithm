//import java.util.*;
//
//class Solution {
//    public int ans = Integer.MAX_VALUE, choose[];
//    public int solution(int[] bricks, int n, int k) {
//
//        choose = new int[k-1];    //조합 결과
//        combi(1, 0, n, k-1, bricks);
//
//        return ans;
//    }
//
//    public void combi(int start, int idx, int height, int limit, int[] bricks) {
//        if(idx==limit) {    //조합 다 골랐다면
//            int cnt = 0;    //벽돌 수
//
//            for(int n : choose) {
//                cnt += height - bricks[n];
//            }
//            ans = Math.min(ans, cnt);
//            return;
//        }
//
//        for(int i = start; i < bricks.length-1; i++) {
//            choose[idx] = i;
//            combi(i + 2, idx + 1, height, limit, bricks);
//        }
//    }
//}