package CollegeManagement;

import java.util.Iterator;

public class FindID {
	public FindID() {

	}

	public void IdInfoInput() { // 이름이랑 주민등록 앞자리 입력 받
		StringBuffer sId = new StringBuffer();
		String sname;
		int iage;

		System.out.print("이름을 입력해주세요 : ");
		sname = Management.scanner.next();
		if (sname.equals("0"))
			Management.Output();
		System.out.print("주민등록 앞자리를 입력해주세요 : ");
		iage = Management.scanner.nextInt();
		if (sname.equals("0"))
			Management.Output();
		String str = IDChk(sname, iage);
		if (str.equals("")) {
			Management.Line();
			System.out.println("일치하는 정보가 없습니다.\n메인으로 돌아가려면 0번을 입력해주세요.");
			IdInfoInput();
		} else {
			sId.append(str);
			System.out.println("고객님의 아이디는 " + IDOutput(sId) + " 입니다.");
		}
	}

	public void PwInfoInput() { // 아이디랑 이름이랑 주민등록 앞자리 입력 받
		StringBuffer sPW = new StringBuffer();
		String sID;
		String sname;
		int iage;

		System.out.print("아이디를 입력해주세요 : ");
		sID = Management.scanner.next();
		if (sID.equals("0"))
			Management.Output();
		System.out.print("이름을 입력해주세요 : ");
		sname = Management.scanner.next();
		if (sname.equals("0"))
			Management.Output();
		System.out.print("주민등록 앞자리를 입력해주세요 : ");
		iage = Management.scanner.nextInt();
		if (sname.equals("0"))
			Management.Output();

		String str = PWChk(sID, sname, iage);
		if (str.equals("")) {
			Management.Line();
			System.out.println("일치하는 정보가 없습니다.\n메인으로 돌아가려면 0번을 입력해주세요.");
			PwInfoInput();
		} else {
			sPW.append(str);
			System.out.println("고객님의 비밀번호는 " + IDOutput(sPW) + " 입니다.");
		}
	}

	public StringBuffer IDOutput(StringBuffer sId) // ID 앞 세자리 까지만 노출해주기 나머지는 *로 노출
	{
		String str = "";
		for (int i = 0; i < (sId.length() - 3); i++) {
			str += "*";
		}
		if (sId.length() >= 3)
			return sId.replace(3, sId.length(), str);
		return sId;
	}

	private String IDChk(String sname, int iage) { // 해당 이름과 주민등록번호 있는 index의 아이디 추출
		Iterator<Student> iter_s = Management.student.iterator();
		String sId = "";
		Student stud;
		while (iter_s.hasNext()) {
			stud = iter_s.next();
			if ((stud.getName().equals(sname)) && (stud.getAge() == iage)) {
				sId = stud.getId();
				return sId;
			}
		}
		Iterator<Teacher> iter_t = Management.teacher.iterator();

		Teacher teach;
		while (iter_t.hasNext()) {
			teach = iter_t.next();
			if ((teach.getName().equals(sname)) && (teach.getAge() == iage)) {
				sId = teach.getId();
				return sId;
			}
		}
		Iterator<Employee> iter_e = Management.employee.iterator();
		Employee emp;
		while (iter_e.hasNext()) {
			emp = iter_e.next();
			if ((emp.getName().equals(sname)) && (emp.getAge() == iage)) {
				sId = emp.getId();
				return sId;
			}
		}
		return sId;
	}

	private String PWChk(String sId, String sname, int iage) { // 해당 이름과 주민등록번호, id가 있는 곳의 pw추출
		Iterator<Student> iter_s = Management.student.iterator();
		String sPW = "";
		Student stud;
		while (iter_s.hasNext()) {
			stud = iter_s.next();
			if ((stud.getId().equals(sId)) && (stud.getName().equals(sname)) && (stud.getAge() == iage)) {
				sPW = stud.getpw();
				return sPW;
			}
		}
		Iterator<Teacher> iter_t = Management.teacher.iterator();
		Teacher teach;
		while (iter_t.hasNext()) {
			teach = iter_t.next();
			if ((teach.getId().equals(sId)) && (teach.getName().equals(sname)) && (teach.getAge() == iage)) {
				sPW = teach.getpw();
				return sPW;
			}
		}
		Iterator<Employee> iter_e = Management.employee.iterator();
		Employee emp;
		while (iter_e.hasNext()) {
			emp = iter_e.next();
			if ((emp.getId().equals(sId)) && (emp.getName().equals(sname)) && (emp.getAge() == iage)) {
				sPW = emp.getpw();
				return sPW;
			}
		}
		return sPW;
	}
}
