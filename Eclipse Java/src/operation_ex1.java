// 지구에서 가장 가까운 별까지의 거리 계산하기 (어서와 자바는 처음이지? 72page)

public class operation_ex1 {

	public static void main(String[] args) {
		// TODO 변수 선언
		final double light_speed = 30e4;	// 빛의 속도
		double distance = 40e12;	// 프록시마 센타우리 별까지의 거리
		
		double secs;	// 걸리는 시간
		
		// TODO: 빛의 속도로 프록시마 센타우리까지 가는 데에 걸리는 시간 구하기
		secs = distance / light_speed;
		
		double light_year = secs/(60.0*60.0*24.0*365.0);	// 초를 연단위로 변환
		System.out.println("걸리는 시간은  " + light_year + "광년입니다.");	// 출력
	}

}
