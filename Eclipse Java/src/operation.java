// ��Ģ����, �⺻(���ð� �ݺ�)

import java.util.Scanner;	// ����ڷκ��� �Է¹���

public class operation {

	public static void main(String[] args) {
		// ������� �Է� �ޱ� ���� ��ġ
		Scanner input = new Scanner(System.in);
		
		// ����ڷκ��� �� ���� �Է¹ް� �� �� ���� �� ����ϱ�
		int x; int y;
		int sum;
		
		System.out.println("ù ��° ���ڸ� �Է��ϼ��� : ");
		x = input.nextInt();
		System.out.println("�� ��° ���ڸ� �Է��ϼ��� : ");
		y = input.nextInt();
		
		sum = x + y;
		System.out.println("�� ���� ���� " + sum);
		
		
		// Ȧ��, ¦�� �����ϱ� (if��)
		int a;
		System.out.println("�����ϰ��� �ϴ� ���� �Է��ϼ��� : ");
		a = input.nextInt();
		
		if (a % 2 == 0) System.out.println("�Է��� ���� ¦���Դϴ�.");
		else System.out.println("�Է��� ���� Ȧ���Դϴ�.");
		
		
		// �������� �Է��� �� ���ڷ� �ٲٱ� (switch��)
		String month;	int monthNum;
		System.out.println("���� ���� �̸��� �Է��ϼ��� : ");
		month = input.next();
		
		switch(month) {
		case "January":
			monthNum=1;
			break;
		case "Fabuary":
			monthNum=2;
			break;
		case "March":
			monthNum=3;
			break;
		default:
			monthNum=0;
			break;
		}
		System.out.println(monthNum);
	}

}
