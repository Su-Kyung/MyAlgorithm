import java.util.*;		// Scanner Ŭ���� ����

// �ڹ� �⺻ ���� �ٽ� ��� (�˰��� X)
public class hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello!");
		System.out.println("�ڹ� ��� �����");
		
		// �����ڵ� �԰� Ȯ���ϱ� (UTF-16)
		char ch1 = '��';
		char ch2 = '\uac00';
		System.out.println(ch1 + "�� �����ϰ� ���: " + ch2);
		
		// Scanner Ŭ���� ����Ͽ� �Է¹ޱ�
		Scanner input = new Scanner(System.in);
		System.out.println("�Է� : ");
		String line = input.nextLine();		// �� ���� �д´�.
		System.out.println(line);
	}

}
