//import java.util.*;
//
//class Solution {
//    class Char implements Comparable<Char> {
//        int idx;
//        char ch;
//        public Char(int idx, char ch) {
//            this.idx = idx;
//            this.ch = ch;
//        }
//
//        @Override
//        public int compareTo(Char o) {
//            if(this.ch == o.ch) return this.idx - o.idx;
//            return o.ch - this.ch;
//        }
//    }
//
//    public String solution(String letters, int k) {
//
//        PriorityQueue<Char> pq = new PriorityQueue<>();
//        for(int i=0; i<=letters.length() - k; i++) {
//            pq.offer(new Char(i, letters.charAt(i)));
//        }
//        StringBuilder sb = new StringBuilder();
//
//        int len = 0, flag = -1;  //문자열의 길이, 기준 인덱스
//        int next = letters.length() - k + 1;
//
//        while(len < k) {
//            Char cur = pq.poll();
//
//            if(flag >= cur.idx) continue;
//            flag = cur.idx;
//            sb.append(cur.ch);
//
//            len++;
//            if(next==letters.length()) continue;
//            pq.offer(new Char(next, letters.charAt(next++)));
//        }
//
//        return sb.toString();
//    }
//}