package CollegeManagement;

import java.util.ArrayList;

public class Student extends Member {
	private String studentid = ""; // 학번
	private ArrayList<Subject> subject = new ArrayList<>(); // 듣고 있는 수업 클래스

	public Student() {
	}

	public Student(String sname, int iage, String studentid, String id, String pw, int type) { // 이름, 나이, 학번,
																								// 아이디,비밀번호,학생 타입
		super(sname, iage, id, pw, type);
		this.studentid = studentid;
	}

	public Student(String sname, int iage, String studentid) { // 이름, 나이, 학번
		super(sname, iage);
		this.studentid = studentid;
	}

//	public void setSubjectInfo(String subject, String subjectTeacher) { // 과목, 교수명
//		this.subject.add(new Subject(subject, subjectTeacher));
//	}

//	public void setSubjectInfo_Grade(String subject, String subjectTeacher, String subjectGrade) { // 과목, 교수명, 성적
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
		String str = "이름 :" + super.getName() + "\t생년월일 : " + super.getAge() + "\t학번 : " + this.studentid + "\tID : "
				+ super.getId() + "\tPW : " + super.getpw();
		System.out.println(str);
	}

	public void PrintStudentInfo_Teacher() {
		String str = "이름 :" + super.getName() + "\t생년월일 : " + super.getAge() + "\t학번 : " + this.studentid;
		System.out.println(str);
	}

}
