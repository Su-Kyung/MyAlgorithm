package test;
// solved (02:09)

public class 월간코드챌린지_2109_1 {

	public static void main(String[] args) {
		int[] numbers = { 1,2,3,4,6,7,8,0 };
		System.out.println(solution(numbers));
	}

	static int solution(int[] numbers) {
		int answer = 45;
		for(int n : numbers)
			answer -= n;
		return answer;
	}
}
