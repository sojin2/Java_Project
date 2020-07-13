package CollegeManagement;

import java.util.ArrayList;

public class Student extends Member {
	private String studentid = ""; // �й�
	private ArrayList<Subject> subject = new ArrayList<>(); // ��� �ִ� ���� Ŭ����

	public Student() {
	}

	public Student(String sname, int iage, String studentid, String id, String pw, int type) { // �̸�, ����, �й�,
																								// ���̵�,��й�ȣ,�л� Ÿ��
		super(sname, iage, id, pw, type);
		this.studentid = studentid;
	}

	public Student(String sname, int iage, String studentid) { // �̸�, ����, �й�
		super(sname, iage);
		this.studentid = studentid;
	}

//	public void setSubjectInfo(String subject, String subjectTeacher) { // ����, ������
//		this.subject.add(new Subject(subject, subjectTeacher));
//	}

//	public void setSubjectInfo_Grade(String subject, String subjectTeacher, String subjectGrade) { // ����, ������, ����
//		this.subject.add(new Subject(subject, subjectTeacher, subjectGrade));
//	}

	public void setSubject(Subject subject) {
		this.subject.add(subject);
	}

	public ArrayList<Subject> getSubject() {
		return subject;
	}
	// public Subject getSubjectGrade(int index) {
	// return subject.get(index).PrintClassInfo_Grade();
	// }

	public void setstudentId(String studentid) {
		this.studentid = studentid;
	}

	public String getstudentId() {
		return this.studentid;
	}

	public void PrintStudentInfo_Employee() {
		String str = "�̸� :" + super.getName() + "\t������� : " + super.getAge() + "\t�й� : " + this.studentid + "\tID : "
				+ super.getId() + "\tPW : " + super.getpw();
		System.out.println(str);
	}

	public void PrintStudentInfo_Teacher() {
		String str = "�̸� :" + super.getName() + "\t������� : " + super.getAge() + "\t�й� : " + this.studentid;
		System.out.println(str);
	}

}
