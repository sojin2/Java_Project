package CollegeManagement;

import java.util.Scanner;

public class CollegeInfo {
	public static Scanner scanner = new Scanner(System.in);

	public static void Input() {
		Management.student.add(new Student("ȫ�浿", 930607, "200201020", "hong", "hong20", 1));
		Management.student.add(new Student("������", 941004, "201317370", "yun", "yun25", 1));
		Management.student.add(new Student("������", 930607, "201233560", "choo0607", "choo26", 1));

		Management.teacher.add(new Teacher("������", 860602, "ȭ�а�", "park", "park30", 2));
		Management.teacher.add(new Teacher("����ȣ", 700207, "����а�", "jeong", "jeong56", 2));
		Management.teacher.add(new Teacher("������", 720508, "��ǻ�Ͱ���", "joseong", "jo40", 2));

		Management.employee.add(new Employee("��빮", 560541, "�л�ó", "ra", "ra56", 3));
		Management.employee.add(new Employee("�̱濩", 800824, "�̻���", "lee", "lee80", 3));
		Management.employee.add(new Employee("��ſ�", 501010, "������", "kim", "kim50", 3));

		Management.subject.add(new Subject("C���", "������"));
		Management.subject.add(new Subject("JAVA ", "������"));
		Management.subject.add(new Subject("C++ ", "������"));

		Management.subject.add(new Subject("��������", "����ȣ"));
		Management.subject.add(new Subject("�����", "����ȣ"));
		Management.subject.add(new Subject("������", "����ȣ"));
	}
}
