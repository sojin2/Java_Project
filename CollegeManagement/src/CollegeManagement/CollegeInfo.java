package CollegeManagement;

import java.util.Scanner;

public class CollegeInfo {
	public static Scanner scanner = new Scanner(System.in);

	public static void Input() {
		Management.student.add(new Student("홍길동", 930607, "200201020", "hong", "hong20", 1));
		Management.student.add(new Student("윤소정", 941004, "201317370", "yun", "yun25", 1));
		Management.student.add(new Student("추윤지", 930607, "201233560", "choo0607", "choo26", 1));

		Management.teacher.add(new Teacher("박진주", 860602, "화학과", "park", "park30", 2));
		Management.teacher.add(new Teacher("정재호", 700207, "통계학과", "jeong", "jeong56", 2));
		Management.teacher.add(new Teacher("조성민", 720508, "컴퓨터공학", "joseong", "jo40", 2));

		Management.employee.add(new Employee("라용문", 560541, "학생처", "ra", "ra56", 3));
		Management.employee.add(new Employee("이길여", 800824, "이사장", "lee", "lee80", 3));
		Management.employee.add(new Employee("김신영", 501010, "교무과", "kim", "kim50", 3));

		Management.subject.add(new Subject("C언어", "조성민"));
		Management.subject.add(new Subject("JAVA ", "조성민"));
		Management.subject.add(new Subject("C++ ", "조성민"));

		Management.subject.add(new Subject("미적분학", "정재호"));
		Management.subject.add(new Subject("통계학", "정재호"));
		Management.subject.add(new Subject("기하학", "정재호"));
	}
}
