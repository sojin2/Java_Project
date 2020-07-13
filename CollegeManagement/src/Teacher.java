package CollegeManagement;

public class Teacher extends Member {
	private String subject = ""; // ����

	public Teacher() {

	}

	public Teacher(String sname, int iage, String subject, String id, String pw, int type) {
		super(sname, iage, id, pw, type);
		this.subject = subject;
	}

	public Teacher(String sname, int iage, String subject) {
		super(sname, iage);
		this.subject = subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return this.subject;
	}

	public void PrintTeacherInfo() {
		String str = "�̸� :" + super.getName() + "\t������� : " + super.getAge() + "\t��� ���� : " + this.subject + "\tID : "
				+ super.getId() + "\tPW : " + super.getpw();
		System.out.println(str);
	}
}
