package CollegeManagement;

public class Subject {
	private String subjectName = ""; // 수업 명
	private String subjectTeacher = ""; // 교수
	private String subjectGrade = ""; // 학점

	public Subject() {

	}

	public Subject(String subjectName, String subjectTeacher, String subjectGrade) { // 과목명, 교수명, 학점
		this.subjectName = subjectName;
		this.subjectTeacher = subjectTeacher;
		this.subjectGrade = subjectGrade;
	}

	public Subject(String subjectName, String subjectTeacher) { // 과목명, 교수명
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
		String str = "과목 : " + this.subjectName + "\t\t교사명 : " + this.subjectTeacher;
		System.out.println(str);
		return null;
	}

	public Subject PrintClassInfo_Grade() {
		String str = "과목 : " + this.subjectName + "\t\t교사명 : " + this.subjectTeacher + "\t학점: " + this.subjectGrade;
		System.out.println(str);
		return null;
	}
}