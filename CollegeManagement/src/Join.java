package CollegeManagement;

public class Join {
	static String sid, spw, sname;
	static int age;

	public Join() { // 회원가입
		// TODO Auto-generated method stub
	}

	public void JoinType(int iType) { // 타입별로 추가 되어야 할 항목이 다름. List에 추가하는 것 까지
		String jType = "";
		BasicJoin();
		switch (iType) {
		case 1: // 학생
			System.out.print(" >> 학번을 입력해주세요 : ");
			jType = Management.scanner.next();
			Management.student.add(new Student(sname, age, jType, sid, spw, iType));
			break;
		case 2: // 교사
			System.out.print(" >> 과목을 입력해주세요 : ");
			jType = Management.scanner.next();
			Management.teacher.add(new Teacher(sname, age, jType, sid, spw, iType));
			break;
		case 3: // 직원
			System.out.print(" >> 부서를 입력해주세요 : ");
			jType = Management.scanner.next();
			Management.employee.add(new Employee(sname, age, jType, sid, spw, iType));
			break;
		default:
			System.out.print("잘못 입력 하셨습니다.");
			break;
		}
		System.out.println(sname + "님, " + sid + "아이디로 가입되었습니다.");
	}

	private static void BasicJoin() { // 회원가입 기본정보
		// TODO Auto-generated method stub
		do {
			System.out.print(" >> id를 입력하세요 : ");
			sid = Management.scanner.next();
			Overlap(sid);
		} while (!Overlap(sid));
		System.out.print(" >> pw를 입력하세요 : ");
		spw = Management.scanner.next();
		System.out.print(" >> 이름을 입력하세요 : ");
		sname = Management.scanner.next();
		System.out.print(" >> 주민등록번호 앞 6자리를 입력하세요 : ");
		age = Management.scanner.nextInt();
	}

	private static boolean Overlap(String sid) { // id 중복 가입 체크
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
