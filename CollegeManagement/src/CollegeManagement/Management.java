package CollegeManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Management {
	public static ArrayList<Student> student = new ArrayList<Student>();
	public static ArrayList<Teacher> teacher = new ArrayList<Teacher>();
	public static ArrayList<Employee> employee = new ArrayList<Employee>();
	public static ArrayList<Subject> subject = new ArrayList<Subject>(); // 과목 리스트 보여줄 것

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CollegeInfo.Input();
		Output();
	}

	public static void Output() {
		int isel = 0;
		boolean bFlag = false;

		while (!bFlag) {
			System.out.println("---------------- 가천대학교 홈페이지입니다.--------------");
			Line();
			System.out.println(" 1.회원가입 | 2.로그인 | 3.ID찾기 | 4.PW찾기 | 기타.종료 ");
			Line();
			System.out.print(" >> 진행하고자 하는 번호를 입력해주세요 : ");
			isel = scanner.nextInt();
			Line();
			SelectNum(isel);
		}
	}

	private static void SelectNum(int isel) {
		// TODO Auto-generated method stub
		FindID findID = new FindID();
		switch (isel) {
		case 1:
			MemberType();
			break;
		case 2:
			LogIn login = new LogIn();
			login.LogInInput();
			break;
		case 3:
			findID.IdInfoInput();
			break;
		case 4:
			findID.PwInfoInput();
			break;
		default:
			System.exit(0);
			break;
		}
	}

	public static void MemberType() { // 회원 타입 설정
		int iType = 0;
		Join join = new Join();
		// 분야 선택 0번은 메뉴로, 1.학생 2.교사 3.직원
		Management.Line();
		System.out.println("메뉴로 돌아가기는 0번을 눌러주세요.");
		System.out.println("1. 학생 | 2. 교사 | 3. 직원");
		System.out.print(" >> 회원 타입을 선택해주세요 : ");
		iType = scanner.nextInt();
		if (iType == 1 || iType == 2 || iType == 3)
			join.JoinType(iType);
		else if (iType == 0) {
			Output();
		} else {
			System.out.println("잘못 입력하셨습니다.");
			MemberType();
		}
	}

	public static void Line() {
		System.out.println("==============================================================================");
	}
}
