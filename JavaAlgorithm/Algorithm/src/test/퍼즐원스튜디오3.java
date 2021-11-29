//import java.util.*;
//
//class Solution {
//    public ArrayList<ArrayList<Integer>> info = new ArrayList<>();
//    public int[] time;
//
//    public int solution(int[] T, int[][] R, int k) {
//        for(int i=0; i<T.length; i++) {
//            info.add(new ArrayList<Integer>());
//        }
//
//        for(int i = 0; i < R.length; i++) {
//            info.get(R[i][1]-1).add(R[i][0]-1);
//        }
//
//        time = new int[T.length];
//        return dfs(k-1, T);
//    }
//
//    public int dfs(int n, int[] T) {
//        if(time[n]>0) return time[n];
//
//        int cur = 0;
//        for(int i = 0; i < info.get(n).size(); i++) {
//            cur = Math.max(cur, dfs(info.get(n).get(i), T));
//        }
//
//        return time[n] = cur + T[n];
//    }
//}