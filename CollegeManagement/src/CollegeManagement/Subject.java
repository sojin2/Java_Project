package CollegeManagement;

public class Subject {
	private String subjectName = ""; // ���� ��
	private String subjectTeacher = ""; // ����
	private String subjectGrade = ""; // ����

	public Subject() {

	}

	public Subject(String subjectName, String subjectTeacher, String subjectGrade) { // �����, ������, ����
		this.subjectName = subjectName;
		this.subjectTeacher = subjectTeacher;
		this.subjectGrade = subjectGrade;
	}

	public Subject(String subjectName, String subjectTeacher) { // �����, ������
		this.subjectName = subjectName;
		this.subjectTeacher = subjectTeacher;
	}

	public String getSubjectName() {
		return this.subjectName;

	}
	public String getSubjectTeacher() {
		return this.subjectTeacher;

	}
	public String getSubjectGrade() {
		return this.subjectGrade;
	}

	public Subject PrintClassInfo() {
		String str = "���� : " + this.subjectName + "\t\t����� : " + this.subjectTeacher;
		System.out.println(str);
		return null;
	}

	public Subject PrintClassInfo_Grade() {
		String str = "���� : " + this.subjectName + "\t\t����� : " + this.subjectTeacher + "\t����: " + this.subjectGrade;
		System.out.println(str);
		return null;
	}
}