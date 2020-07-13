package CollegeManagement;

import java.util.Iterator;

public class FindID {
	public FindID() {

	}

	public void IdInfoInput() { // �̸��̶� �ֹε�� ���ڸ� �Է� ��
		StringBuffer sId = new StringBuffer();
		String sname;
		int iage;

		System.out.print("�̸��� �Է����ּ��� : ");
		sname = Management.scanner.next();
		if (sname.equals("0"))
			Management.Output();
		System.out.print("�ֹε�� ���ڸ��� �Է����ּ��� : ");
		iage = Management.scanner.nextInt();
		if (sname.equals("0"))
			Management.Output();
		String str = IDChk(sname, iage);
		if (str.equals("")) {
			Management.Line();
			System.out.println("��ġ�ϴ� ������ �����ϴ�.\n�������� ���ư����� 0���� �Է����ּ���.");
			IdInfoInput();
		} else {
			sId.append(str);
			System.out.println("������ ���̵�� " + IDOutput(sId) + " �Դϴ�.");
		}
	}

	public void PwInfoInput() { // ���̵�� �̸��̶� �ֹε�� ���ڸ� �Է� ��
		StringBuffer sPW = new StringBuffer();
		String sID;
		String sname;
		int iage;

		System.out.print("���̵� �Է����ּ��� : ");
		sID = Management.scanner.next();
		if (sID.equals("0"))
			Management.Output();
		System.out.print("�̸��� �Է����ּ��� : ");
		sname = Management.scanner.next();
		if (sname.equals("0"))
			Management.Output();
		System.out.print("�ֹε�� ���ڸ��� �Է����ּ��� : ");
		iage = Management.scanner.nextInt();
		if (sname.equals("0"))
			Management.Output();

		String str = PWChk(sID, sname, iage);
		if (str.equals("")) {
			Management.Line();
			System.out.println("��ġ�ϴ� ������ �����ϴ�.\n�������� ���ư����� 0���� �Է����ּ���.");
			PwInfoInput();
		} else {
			sPW.append(str);
			System.out.println("������ ��й�ȣ�� " + IDOutput(sPW) + " �Դϴ�.");
		}
	}

	public StringBuffer IDOutput(StringBuffer sId) // ID �� ���ڸ� ������ �������ֱ� �������� *�� ����
	{
		String str = "";
		for (int i = 0; i < (sId.length() - 3); i++) {
			str += "*";
		}
		if (sId.length() >= 3)
			return sId.replace(3, sId.length(), str);
		return sId;
	}

	private String IDChk(String sname, int iage) { // �ش� �̸��� �ֹε�Ϲ�ȣ �ִ� index�� ���̵� ����
		Iterator<Student> iter_s = Management.student.iterator();
		String sId = "";
		Student stud;
		while (iter_s.hasNext()) {
			stud = iter_s.next();
			if ((stud.getName().equals(sname)) && (stud.getAge() == iage)) {
				sId = stud.getId();
				return sId;
			}
		}
		Iterator<Teacher> iter_t = Management.teacher.iterator();

		Teacher teach;
		while (iter_t.hasNext()) {
			teach = iter_t.next();
			if ((teach.getName().equals(sname)) && (teach.getAge() == iage)) {
				sId = teach.getId();
				return sId;
			}
		}
		Iterator<Employee> iter_e = Management.employee.iterator();
		Employee emp;
		while (iter_e.hasNext()) {
			emp = iter_e.next();
			if ((emp.getName().equals(sname)) && (emp.getAge() == iage)) {
				sId = emp.getId();
				return sId;
			}
		}
		return sId;
	}

	private String PWChk(String sId, String sname, int iage) { // �ش� �̸��� �ֹε�Ϲ�ȣ, id�� �ִ� ���� pw����
		Iterator<Student> iter_s = Management.student.iterator();
		String sPW = "";
		Student stud;
		while (iter_s.hasNext()) {
			stud = iter_s.next();
			if ((stud.getId().equals(sId)) && (stud.getName().equals(sname)) && (stud.getAge() == iage)) {
				sPW = stud.getpw();
				return sPW;
			}
		}
		Iterator<Teacher> iter_t = Management.teacher.iterator();
		Teacher teach;
		while (iter_t.hasNext()) {
			teach = iter_t.next();
			if ((teach.getId().equals(sId)) && (teach.getName().equals(sname)) && (teach.getAge() == iage)) {
				sPW = teach.getpw();
				return sPW;
			}
		}
		Iterator<Employee> iter_e = Management.employee.iterator();
		Employee emp;
		while (iter_e.hasNext()) {
			emp = iter_e.next();
			if ((emp.getId().equals(sId)) && (emp.getName().equals(sname)) && (emp.getAge() == iage)) {
				sPW = emp.getpw();
				return sPW;
			}
		}
		return sPW;
	}
}
