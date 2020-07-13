package CollegeManagement;

import java.util.Iterator;

public class LogIn {

	public void LogInInput() { // 로그인 시 필요한 아이디랑 비밀번호 입력 받기
		String strId = "";
		String strPw = "";

		System.out.println("메뉴로 돌아가려면 0을 눌러주세요.");
		System.out.print(" >> 아이디를 입력해주세요 : ");
		strId = Management.scanner.next();
		if (!ReturnMenu(strId.trim())) // trim 앞 뒤 공백 제거, ID와 비밀번호 모두 공백이 필요 없으므로
			return;
		else {
			System.out.print(" >> 비밀번호를 입력해주세요 : ");
			strPw = Management.scanner.next();
			if (!ReturnMenu(strId.trim()))// trim 앞 뒤 공백 제거, ID와 비밀번호 모두 공백이 필요 없으므로
				return;
		}
		LogInChk(IdPwChk(strId, strPw)); // 아이디와 비밀번호를 정상적으로 입력했으면, 기존에 있는 아이디 인지 확인하는 프로세스 작성
	}

	private void LogInChk(Member memberClass) { //
		// TODO Auto-generated method stub
		if (memberClass == null) {
			Management.Line();
			System.out.println("일치하는 정보가 없습니다.\n아이디와 비밀번호를 다시 확인해주세요.");
			LogInInput();
		} else {
			int iType = memberClass.getType();
			Management.Line();
			System.out.println(memberClass.getName() + "님 환영합니다.");
			LoginManager loginmanager = new LoginManager();

			switch (iType) {
			case 1:
				loginmanager.StudentOutput(memberClass);
				break;
			case 2:
				loginmanager.TeacherOutput();
				break;
			case 3:
				loginmanager.EmployeeOutput();
				break;
			}
		}
	}

	public Member IdPwChk(String strId, String strPw) { // 아이디와 비밀번호 맞는 클래스가 있을 경우, 해당 클래스 리턴
		// TODO Auto-generated method stub
		Iterator<Student> iter_s = Management.student.iterator();
		Student stud;
		while (iter_s.hasNext()) {
			stud = iter_s.next();
			if ((stud.getId().equals(strId)) && (stud.getpw().equals(strPw))) {
				return stud;
			}
		}
		Iterator<Teacher> iter_t = Management.teacher.iterator();
		Teacher teach;
		while (iter_t.hasNext()) {
			teach = iter_t.next();
			if ((teach.getId().equals(strId)) && (teach.getpw().equals(strPw))) {
				return teach;
			}
		}
		Iterator<Employee> iter_e = Management.employee.iterator();
		Employee emp;
		while (iter_e.hasNext()) {
			emp = iter_e.next();
			if ((emp.getId().equals(strId)) && (emp.getpw().equals(strPw))) {
				return emp;
			}
		}
		return null;
	}

	private boolean ReturnMenu(String str) { // 0번을 누를경우, 메뉴로 돌아가기
		// TODO Auto-generated method stub
		if (str.equals("0"))
			return false;
		else
			return true;
	}
}
