package CollegeManagement;

public class Employee extends Member {
	private String dept = "";// 부서

	public Employee() {

	}

	public Employee(String sname, int iage, String dept, String id, String pw, int type) {
		super(sname, iage, id, pw, type);
		this.dept = dept;
	}

	public Employee(String sname, int iage, String dept) {
		super(sname, iage);
		this.dept = dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getdept() {
		return this.dept;
	}

	public void PrintEmployeeInfo() {
		String str = "이름 :" + super.getName() + "\t생년월일 : " + super.getAge() + "\t부서 : " + this.dept + "\tID : "
				+ super.getId() + "\tPW : " + super.getpw();
		System.out.println(str);
	}
}
