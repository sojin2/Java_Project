package CollegeManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Management {
	public static ArrayList<Student> student = new ArrayList<Student>();
	public static ArrayList<Teacher> teacher = new ArrayList<Teacher>();
	public static ArrayList<Employee> employee = new ArrayList<Employee>();
	public static ArrayList<Subject> subject = new ArrayList<Subject>(); // ���� ����Ʈ ������ ��

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CollegeInfo.Input();
		Output();
	}

	public static void Output() {
		int isel = 0;
		boolean bFlag = false;

		while (!bFlag) {
			System.out.println("---------------- ��õ���б� Ȩ�������Դϴ�.--------------");
			Line();
			System.out.println(" 1.ȸ������ | 2.�α��� | 3.IDã�� | 4.PWã�� | ��Ÿ.���� ");
			Line();
			System.out.print(" >> �����ϰ��� �ϴ� ��ȣ�� �Է����ּ��� : ");
			isel = scanner.nextInt();
			Line();
			SelectNum(isel);
		}
	}

	private static void SelectNum(int isel) {
		// TODO Auto-generated method stub
		FindID findID = new FindID();
		switch (isel) {
		case 1:
			MemberType();
			break;
		case 2:
			LogIn login = new LogIn();
			login.LogInInput();
			break;
		case 3:
			findID.IdInfoInput();
			break;
		case 4:
			findID.PwInfoInput();
			break;
		default:
			System.exit(0);
			break;
		}
	}

	public static void MemberType() { // ȸ�� Ÿ�� ����
		int iType = 0;
		Join join = new Join();
		// �о� ���� 0���� �޴���, 1.�л� 2.���� 3.����
		Management.Line();
		System.out.println("�޴��� ���ư���� 0���� �����ּ���.");
		System.out.println("1. �л� | 2. ���� | 3. ����");
		System.out.print(" >> ȸ�� Ÿ���� �������ּ��� : ");
		iType = scanner.nextInt();
		if (iType == 1 || iType == 2 || iType == 3)
			join.JoinType(iType);
		else if (iType == 0) {
			Output();
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			MemberType();
		}
	}

	public static void Line() {
		System.out.println("==============================================================================");
	}
}
