package CollegeManagement;

public class Join {
	static String sid, spw, sname;
	static int age;

	public Join() { // ȸ������
		// TODO Auto-generated method stub
	}

	public void JoinType(int iType) { // Ÿ�Ժ��� �߰� �Ǿ�� �� �׸��� �ٸ�. List�� �߰��ϴ� �� ����
		String jType = "";
		BasicJoin();
		switch (iType) {
		case 1: // �л�
			System.out.print(" >> �й��� �Է����ּ��� : ");
			jType = Management.scanner.next();
			Management.student.add(new Student(sname, age, jType, sid, spw, iType));
			break;
		case 2: // ����
			System.out.print(" >> ������ �Է����ּ��� : ");
			jType = Management.scanner.next();
			Management.teacher.add(new Teacher(sname, age, jType, sid, spw, iType));
			break;
		case 3: // ����
			System.out.print(" >> �μ��� �Է����ּ��� : ");
			jType = Management.scanner.next();
			Management.employee.add(new Employee(sname, age, jType, sid, spw, iType));
			break;
		default:
			System.out.print("�߸� �Է� �ϼ̽��ϴ�.");
			break;
		}
		System.out.println(sname + "��, " + sid + "���̵�� ���ԵǾ����ϴ�.");
	}

	private static void BasicJoin() { // ȸ������ �⺻����
		// TODO Auto-generated method stub
		do {
			System.out.print(" >> id�� �Է��ϼ��� : ");
			sid = Management.scanner.next();
			Overlap(sid);
		} while (!Overlap(sid));
		System.out.print(" >> pw�� �Է��ϼ��� : ");
		spw = Management.scanner.next();
		System.out.print(" >> �̸��� �Է��ϼ��� : ");
		sname = Management.scanner.next();
		System.out.print(" >> �ֹε�Ϲ�ȣ �� 6�ڸ��� �Է��ϼ��� : ");
		age = Management.scanner.nextInt();
	}

	private static boolean Overlap(String sid) { // id �ߺ� ���� üũ
		for (int i = 0; i < Management.student.size(); i++) {
			if (Management.student.get(i).getId().equals(sid)) {
				return false;
			}
		}
		for (int i = 0; i < Management.student.size(); i++) {
			if (Management.teacher.get(i).getId().equals(sid)) {
				return false;
			}
		}
		for (int i = 0; i < Management.student.size(); i++) {
			if (Management.employee.get(i).getId().equals(sid)) {
				return false;
			}
		}
		return true;
	}
}
