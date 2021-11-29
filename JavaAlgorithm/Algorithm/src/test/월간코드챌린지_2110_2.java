package test;

import java.util.*;

public class 월간코드챌린지_2110_2 {

	public static void main(String[] args) {
		int n = 3;
		long left = 2;
		long right = 5;
		System.out.println(Arrays.toString(solution(n, left, right)));
	}

	public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        
        for(long i = left; i <= right; i++) {
            answer[(int) (i - left)] = (int) (Math.max(i/n, i%n) + 1);
        }
        return answer;
    }
}
