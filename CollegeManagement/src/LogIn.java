package CollegeManagement;

import java.util.Iterator;

public class LogIn {

	public void LogInInput() { // �α��� �� �ʿ��� ���̵�� ��й�ȣ �Է� �ޱ�
		String strId = "";
		String strPw = "";

		System.out.println("�޴��� ���ư����� 0�� �����ּ���.");
		System.out.print(" >> ���̵� �Է����ּ��� : ");
		strId = Management.scanner.next();
		if (!ReturnMenu(strId.trim())) // trim �� �� ���� ����, ID�� ��й�ȣ ��� ������ �ʿ� �����Ƿ�
			return;
		else {
			System.out.print(" >> ��й�ȣ�� �Է����ּ��� : ");
			strPw = Management.scanner.next();
			if (!ReturnMenu(strId.trim()))// trim �� �� ���� ����, ID�� ��й�ȣ ��� ������ �ʿ� �����Ƿ�
				return;
		}
		LogInChk(IdPwChk(strId, strPw)); // ���̵�� ��й�ȣ�� ���������� �Է�������, ������ �ִ� ���̵� ���� Ȯ���ϴ� ���μ��� �ۼ�
	}

	private void LogInChk(Member memberClass) { //
		// TODO Auto-generated method stub
		if (memberClass == null) {
			Management.Line();
			System.out.println("��ġ�ϴ� ������ �����ϴ�.\n���̵�� ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
			LogInInput();
		} else {
			int iType = memberClass.getType();
			Management.Line();
			System.out.println(memberClass.getName() + "�� ȯ���մϴ�.");
			LoginManager loginmanager = new LoginManager();

			switch (iType) {
			case 1:
				loginmanager.StudentOutput(memberClass);
				break;
			case 2:
				loginmanager.TeacherOutput();
				break;
			case 3:
				loginmanager.EmployeeOutput();
				break;
			}
		}
	}

	public Member IdPwChk(String strId, String strPw) { // ���̵�� ��й�ȣ �´� Ŭ������ ���� ���, �ش� Ŭ���� ����
		// TODO Auto-generated method stub
		Iterator<Student> iter_s = Management.student.iterator();
		Student stud;
		while (iter_s.hasNext()) {
			stud = iter_s.next();
			if ((stud.getId().equals(strId)) && (stud.getpw().equals(strPw))) {
				return stud;
			}
		}
		Iterator<Teacher> iter_t = Management.teacher.iterator();
		Teacher teach;
		while (iter_t.hasNext()) {
			teach = iter_t.next();
			if ((teach.getId().equals(strId)) && (teach.getpw().equals(strPw))) {
				return teach;
			}
		}
		Iterator<Employee> iter_e = Management.employee.iterator();
		Employee emp;
		while (iter_e.hasNext()) {
			emp = iter_e.next();
			if ((emp.getId().equals(strId)) && (emp.getpw().equals(strPw))) {
				return emp;
			}
		}
		return null;
	}

	private boolean ReturnMenu(String str) { // 0���� �������, �޴��� ���ư���
		// TODO Auto-generated method stub
		if (str.equals("0"))
			return false;
		else
			return true;
	}
}
