// �������� ���� ����� �������� �Ÿ� ����ϱ� (��� �ڹٴ� ó������? 72page)

public class operation_ex1 {

	public static void main(String[] args) {
		// TODO ���� ����
		final double light_speed = 30e4;	// ���� �ӵ�
		double distance = 40e12;	// ���Ͻø� ��Ÿ�츮 �������� �Ÿ�
		
		double secs;	// �ɸ��� �ð�
		
		// TODO: ���� �ӵ��� ���Ͻø� ��Ÿ�츮���� ���� ���� �ɸ��� �ð� ���ϱ�
		secs = distance / light_speed;
		
		double light_year = secs/(60.0*60.0*24.0*365.0);	// �ʸ� �������� ��ȯ
		System.out.println("�ɸ��� �ð���  " + light_year + "�����Դϴ�.");	// ���
	}

}
