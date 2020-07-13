package CollegeManagement;

public class LoginManager {
	public LoginManager() {

	}

	public void StudentOutput(Member memberClass) // �л��� �� ��� ����
	{
		int isel = 0;
		boolean bflag = false;

		while (!bflag) {
			Management.Line();
			System.out.println(" 1.������û | 2.������� Ȯ�� | 3.���� Ȯ�� | 4.�α׾ƿ� | ��Ÿ.����");
			Management.Line();
			System.out.print(" >> �����ϰ��� �ϴ� ��ȣ�� �Է����ּ��� : ");
			isel = Management.scanner.nextInt();
			if (isel == 4) { // �α׾ƿ�
				System.out.print("�α׾ƿ� �Ǿ����ϴ�.");
				bflag = false;
				return;
			}
			SelectNum_Student(isel, memberClass);
		}
	}

	private void SelectNum_Student(int isel, Member memberClass) {
		// TODO Auto-generated method stub
		Student studentInfo = FindMyClassList(memberClass); // �α��� �� �ش� �л����� �������
		StudentClassInfo studentclassInfo = new StudentClassInfo();

		switch (isel) {
		case 1:// ������û ����
			studentclassInfo.EnrollClass(studentInfo);
			break;
		case 2:
			studentclassInfo.OutputMyClassList(studentInfo);// ������� ����Ʈ
			break;
		case 3:
			studentclassInfo.OutputMyClassGradeList(studentInfo);// ������� ����Ʈ
			break;
		default:
			System.out.println("���α׷��� ����Ǿ����ϴ�.\n�����մϴ�.");
			System.exit(0);
			break;
		}
	}

	private Student FindMyClassList(Member memberClass) { // �α��� �� �ش� �л��� ����Ʈ ���
		if (memberClass != null) {
			for (int i = 0; i < Management.student.size(); i++)
				if (Management.student.get(i).getId().equals(memberClass.getId()))
					return Management.student.get(i);
		}
		return null;
	}

	public void EmployeeOutput() { // ���� �� �� ��� ����
		// TODO Auto-generated method stub

		int isel = 0;
		boolean bflag = false;

		while (!bflag) {
			Management.Line();
			System.out.println(" 1.�л���� | 2.������ | 3.�α׾ƿ� | ��Ÿ.����");
			Management.Line();
			System.out.print(" >> �����ϰ��� �ϴ� ��ȣ�� �Է����ּ��� : ");
			isel = Management.scanner.nextInt();
			if (isel == 3) { // �α׾ƿ�
				System.out.print("�α׾ƿ� �Ǿ����ϴ�.");
				bflag = false;
				return;
			}
			SelectNum_Employee(isel);
		}
	}

	private void SelectNum_Employee(int isel) { // ����
		// TODO Auto-generated method stub
		switch (isel) {
		case 1:
			OutputStudentList(3); // �л� ����Ʈ ���
			break;
		case 2:
			OutputTeacherList();// ���� ����Ʈ ���
			break;
		default:
			System.out.println("���α׷��� ����Ǿ����ϴ�.\n�����մϴ�.");
			System.exit(0);
			break;
		}
	}

	public void TeacherOutput() { // ������ �� ��� ����
		int isel = 0;
		boolean bflag = false;

		while (!bflag) {
			System.out.println(" 1.�л���� | 2. ���� ���� | 3.�α׾ƿ� | ��Ÿ.����");
			Management.Line();
			System.out.print(" >> �����ϰ��� �ϴ� ��ȣ�� �Է����ּ��� : ");
			isel = Management.scanner.nextInt();
			if (isel == 3) { // �α׾ƿ�
				System.out.print("�α׾ƿ� �Ǿ����ϴ�.");
				bflag = false;
				return;
			}
			SelectNum_Teacher(isel);
		}
	}

	private void SelectNum_Teacher(int isel) { // ����
		// TODO Auto-generated method stub
		switch (isel) {
		case 1:
			OutputStudentList(2); // �л� ����Ʈ ��� Id�� Pw���� X
			break;
		case 2:
			GradeManage();// ���� ����
			break;
		default:
			System.out.println("���α׷��� ����Ǿ����ϴ�.\n�����մϴ�.");
			System.exit(0);
			break;
		}
	}

	private void GradeManage() {
		// TODO Auto-generated method stub

	}

	private void OutputTeacherList() { // ���� ��� ����Ʈ
		// TODO Auto-generated method stub
		Management.Line();

		for (int i = 0; i < Management.teacher.size(); i++) {
			Management.teacher.get(i).PrintTeacherInfo();
		}
	}

	private void OutputStudentList(int iType) { // �л� ��� ����Ʈ iType�� 3�� ���, ���� || iType�� 2�� ���, ����
		// ������ ���, �л��� ID�� Pw�� �� �� ����.
		Management.Line();
		for (int i = 0; i < Management.student.size(); i++) {
			if (iType == 3)
				Management.student.get(i).PrintStudentInfo_Employee();
			else
				Management.student.get(i).PrintStudentInfo_Teacher();
		}
	}
}
