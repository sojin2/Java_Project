package CollegeManagement;

public class StudentClassInfo {
	public StudentClassInfo() {

	}

	public void OutputMyClassList(Student student) { // 수강목록 리스트 노출
		int index = Management.student.indexOf(student);
		for (int i = 0; i < Management.student.get(index).getSubject().size(); i++) {
			System.out.println("과목 : " + Management.student.get(index).getSubject().get(i).getSubjectName()
					+ "\t\t교사명 : " + Management.student.get(index).getSubject().get(i).getSubjectTeacher());
		}
	}

	public void OutputMyClassGradeList(Student student) { // 수강목록 및 학점 리스트 노출
		int index = Management.student.indexOf(student);
		for (int i = 0; i < Management.student.get(index).getSubject().size(); i++) {
			System.out.print("과목 : " + Management.student.get(index).getSubject().get(i).getSubjectName() + "\t\t교사명 : "
					+ Management.student.get(index).getSubject().get(i).getSubjectTeacher() + "\t\t학점 : ");
			if (Management.student.get(index).getSubject().get(i).getSubjectGrade() != null
					&& Management.student.get(index).getSubject().get(i).getSubjectGrade() != "")
				System.out.println(Management.student.get(index).getSubject().get(i).getSubjectGrade());
			else
				System.out.println("대기중");
		}
	}

	public void EnrollClass(Student student) { // 수강신청
		int isel = 0;
		String str = "";
		boolean bflag = false;
		while (!bflag) {
			EnrollClassList();
			Management.Line();
			System.out.print("메뉴로 돌아가려면 0번을 눌러주세요.\n >> 신청하고자 하는 과목의 번호를 눌러주세요.");
			isel = Management.scanner.nextInt();
			if (isel == 0) {
				bflag = true;
				return;
			}
			if (isel > Management.subject.size()) {
				System.out.println("잘못 누르셨습니다. 다시 선택해주세요.");
			} else {
				isel -= 1;
				int index = Management.student.indexOf(student);
				if (!OverlapChk(Management.subject.get(isel), index)) {
					str = "선택하신 과목은 " + Management.subject.get(isel).getSubjectName() + "입니다. \n해당 교과목의 담당 교사는 "
							+ Management.subject.get(isel).getSubjectTeacher() + "입니다.";
					Management.Line();
					System.out.println(str);
					Management.Line();
					Management.student.get(index).setSubject(Management.subject.get(isel)); // 선택한 과목을 내 과목 리스트에 추가하기
				} else {
					Management.Line();
					System.out.println("이미 추가된 과목입니다.");
					Management.Line();
				}
			}
		}
	}

	private boolean OverlapChk(Subject subject, int index) {
		// 중복된 수업 등록 시 , return true;
		// TODO Auto-generated method stub
		if (Management.student.get(index).getSubject().contains(subject))
			return true;
		else
			return false;
	}

	private void EnrollClassList() { // 수강신청 리스트 현재 등록되어 있는 List 호출
		for (int i = 0; i < Management.subject.size(); i++) {
			System.out.print((i + 1) + "번 > ");
			Management.subject.get(i).PrintClassInfo();
		}
	}
}
