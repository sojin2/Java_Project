package CollegeManagement;

public class LoginManager {
	public LoginManager() {

	}

	public void StudentOutput(Member memberClass) // 학생일 때 목록 노출
	{
		int isel = 0;
		boolean bflag = false;

		while (!bflag) {
			Management.Line();
			System.out.println(" 1.수강신청 | 2.수강목록 확인 | 3.학점 확인 | 4.로그아웃 | 기타.종료");
			Management.Line();
			System.out.print(" >> 진행하고자 하는 번호를 입력해주세요 : ");
			isel = Management.scanner.nextInt();
			if (isel == 4) { // 로그아웃
				System.out.print("로그아웃 되었습니다.");
				bflag = false;
				return;
			}
			SelectNum_Student(isel, memberClass);
		}
	}

	private void SelectNum_Student(int isel, Member memberClass) {
		// TODO Auto-generated method stub
		Student studentInfo = FindMyClassList(memberClass); // 로그인 한 해당 학생관련 정보출력
		StudentClassInfo studentclassInfo = new StudentClassInfo();

		switch (isel) {
		case 1:// 수강신청 관련
			studentclassInfo.EnrollClass(studentInfo);
			break;
		case 2:
			studentclassInfo.OutputMyClassList(studentInfo);// 수강목록 리스트
			break;
		case 3:
			studentclassInfo.OutputMyClassGradeList(studentInfo);// 수강목록 리스트
			break;
		default:
			System.out.println("프로그램이 종료되었습니다.\n감사합니다.");
			System.exit(0);
			break;
		}
	}

	private Student FindMyClassList(Member memberClass) { // 로그인 한 해당 학생의 리스트 출력
		if (memberClass != null) {
			for (int i = 0; i < Management.student.size(); i++)
				if (Management.student.get(i).getId().equals(memberClass.getId()))
					return Management.student.get(i);
		}
		return null;
	}

	public void EmployeeOutput() { // 직원 일 때 목록 노출
		// TODO Auto-generated method stub

		int isel = 0;
		boolean bflag = false;

		while (!bflag) {
			Management.Line();
			System.out.println(" 1.학생목록 | 2.교사목록 | 3.로그아웃 | 기타.종료");
			Management.Line();
			System.out.print(" >> 진행하고자 하는 번호를 입력해주세요 : ");
			isel = Management.scanner.nextInt();
			if (isel == 3) { // 로그아웃
				System.out.print("로그아웃 되었습니다.");
				bflag = false;
				return;
			}
			SelectNum_Employee(isel);
		}
	}

	private void SelectNum_Employee(int isel) { // 직원
		// TODO Auto-generated method stub
		switch (isel) {
		case 1:
			OutputStudentList(3); // 학생 리스트 출력
			break;
		case 2:
			OutputTeacherList();// 교사 리스트 출력
			break;
		default:
			System.out.println("프로그램이 종료되었습니다.\n감사합니다.");
			System.exit(0);
			break;
		}
	}

	public void TeacherOutput() { // 교사일 때 목록 노출
		int isel = 0;
		boolean bflag = false;

		while (!bflag) {
			System.out.println(" 1.학생목록 | 2. 학점 관리 | 3.로그아웃 | 기타.종료");
			Management.Line();
			System.out.print(" >> 진행하고자 하는 번호를 입력해주세요 : ");
			isel = Management.scanner.nextInt();
			if (isel == 3) { // 로그아웃
				System.out.print("로그아웃 되었습니다.");
				bflag = false;
				return;
			}
			SelectNum_Teacher(isel);
		}
	}

	private void SelectNum_Teacher(int isel) { // 교사
		// TODO Auto-generated method stub
		switch (isel) {
		case 1:
			OutputStudentList(2); // 학생 리스트 출력 Id와 Pw노출 X
			break;
		case 2:
			GradeManage();// 학점 관리
			break;
		default:
			System.out.println("프로그램이 종료되었습니다.\n감사합니다.");
			System.exit(0);
			break;
		}
	}

	private void GradeManage() {
		// TODO Auto-generated method stub

	}

	private void OutputTeacherList() { // 교사 목록 리스트
		// TODO Auto-generated method stub
		Management.Line();

		for (int i = 0; i < Management.teacher.size(); i++) {
			Management.teacher.get(i).PrintTeacherInfo();
		}
	}

	private void OutputStudentList(int iType) { // 학생 목록 리스트 iType이 3일 경우, 직원 || iType이 2일 경우, 교사
		// 교사일 경우, 학생의 ID와 Pw는 볼 수 없음.
		Management.Line();
		for (int i = 0; i < Management.student.size(); i++) {
			if (iType == 3)
				Management.student.get(i).PrintStudentInfo_Employee();
			else
				Management.student.get(i).PrintStudentInfo_Teacher();
		}
	}
}
