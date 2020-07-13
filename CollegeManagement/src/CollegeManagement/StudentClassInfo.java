package CollegeManagement;

public class StudentClassInfo {
	public StudentClassInfo() {

	}

	public void OutputMyClassList(Student student) { // ������� ����Ʈ ����
		int index = Management.student.indexOf(student);
		for (int i = 0; i < Management.student.get(index).getSubject().size(); i++) {
			System.out.println("���� : " + Management.student.get(index).getSubject().get(i).getSubjectName()
					+ "\t\t����� : " + Management.student.get(index).getSubject().get(i).getSubjectTeacher());
		}
	}

	public void OutputMyClassGradeList(Student student) { // ������� �� ���� ����Ʈ ����
		int index = Management.student.indexOf(student);
		for (int i = 0; i < Management.student.get(index).getSubject().size(); i++) {
			System.out.print("���� : " + Management.student.get(index).getSubject().get(i).getSubjectName() + "\t\t����� : "
					+ Management.student.get(index).getSubject().get(i).getSubjectTeacher() + "\t\t���� : ");
			if (Management.student.get(index).getSubject().get(i).getSubjectGrade() != null
					&& Management.student.get(index).getSubject().get(i).getSubjectGrade() != "")
				System.out.println(Management.student.get(index).getSubject().get(i).getSubjectGrade());
			else
				System.out.println("�����");
		}
	}

	public void EnrollClass(Student student) { // ������û
		int isel = 0;
		String str = "";
		boolean bflag = false;
		while (!bflag) {
			EnrollClassList();
			Management.Line();
			System.out.print("�޴��� ���ư����� 0���� �����ּ���.\n >> ��û�ϰ��� �ϴ� ������ ��ȣ�� �����ּ���.");
			isel = Management.scanner.nextInt();
			if (isel == 0) {
				bflag = true;
				return;
			}
			if (isel > Management.subject.size()) {
				System.out.println("�߸� �����̽��ϴ�. �ٽ� �������ּ���.");
			} else {
				isel -= 1;
				int index = Management.student.indexOf(student);
				if (!OverlapChk(Management.subject.get(isel), index)) {
					str = "�����Ͻ� ������ " + Management.subject.get(isel).getSubjectName() + "�Դϴ�. \n�ش� �������� ��� ����� "
							+ Management.subject.get(isel).getSubjectTeacher() + "�Դϴ�.";
					Management.Line();
					System.out.println(str);
					Management.Line();
					Management.student.get(index).setSubject(Management.subject.get(isel)); // ������ ������ �� ���� ����Ʈ�� �߰��ϱ�
				} else {
					Management.Line();
					System.out.println("�̹� �߰��� �����Դϴ�.");
					Management.Line();
				}
			}
		}
	}

	private boolean OverlapChk(Subject subject, int index) {
		// �ߺ��� ���� ��� �� , return true;
		// TODO Auto-generated method stub
		if (Management.student.get(index).getSubject().contains(subject))
			return true;
		else
			return false;
	}

	private void EnrollClassList() { // ������û ����Ʈ ���� ��ϵǾ� �ִ� List ȣ��
		for (int i = 0; i < Management.subject.size(); i++) {
			System.out.print((i + 1) + "�� > ");
			Management.subject.get(i).PrintClassInfo();
		}
	}
}
