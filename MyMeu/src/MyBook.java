import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MyBook {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Book b = new Book();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("**** DB 로딩 오류 !!! ****");
			System.exit(0);
		}
		System.out.print("*** DB 로딩 통과 *** ");
		;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb?serverTimezone=UTC",
					"root", "root");

			Statement stmt = conn.createStatement();
			while (true) {

				System.out.println("***도서관리 메뉴***");

				System.out.println("1. 도서등록");
				System.out.println("2. 도서목록 출력");
				System.out.println("3. 도서 검색");
				System.out.println("4. 도서정보 변경");
				System.out.println("5. 도서 삭제");
				System.out.println("0. 종료");
				System.out.print("선택 : ");
				int t = s.nextInt();
				if (t == 0)
					break; // 시스템 종료
				switch (t) {
				case 1:
					System.out.print("도서 번호 : ");
					b.id = s.nextInt();
					System.out.print("도서 명 : ");
					b.name = s.next();
					System.out.print("도서 출판사 : ");
					b.publisher = s.next();
					System.out.print("도서 저자 : ");
					b.author = s.next();
					System.out.print("장르(1,2,3) : ");
					b.genre = s.next();
					
					String SQL = "insert into book values(?,?,?,?,?)";
					PreparedStatement psmt = conn.prepareStatement(SQL);
					psmt.setInt(1, b.id); 
					psmt.setString(2, b.name);
					psmt.setString(3, b.author);
					psmt.setString(4, b.publisher);
					psmt.setString(5, b.genre);
					
					psmt.executeUpdate();

					break;

				case 2:
					System.out.println("*** 도서 목록 출력***");
					ResultSet rs = stmt.executeQuery("select * from book");
					while (rs.next()) {
						b.id = rs.getInt("id"); // 1
						b.name = rs.getString("name");
						b.author = rs.getString("author");
						b.publisher = rs.getString("publisher");
						b.genre = rs.getString("genre");
						b.print();
					}
					break;
				case 3:
					System.out.print("검색 도서번호 : ");
					b.id = s.nextInt();
					SQL = "select * from book where id = ?";
					psmt = conn.prepareStatement(SQL);
					psmt.setInt(1, b.id);
					rs = psmt.executeQuery();
					
					if (rs.next()) {
						b.name = rs.getString("name");
						b.author = rs.getString("author");
						b.publisher = rs.getString("publisher");
						b.genre = rs.getString("genre");
						b.print();
					}
					break;

				case 4:
					System.out.print("검색 도서번호 : ");
					b.id = s.nextInt();
					System.out.println("*** 도서 변경 입력 ***");
					System.out.print("도서명 :");
					b.name = s.next();
					System.out.print("저자 :");
					b.author = s.next();
					System.out.print("출판사 :");
					b.publisher = s.next();
					System.out.print("장르(1: IT, 2: 어학, 3: 기타) :");
					b.genre = s.next();

					SQL = "update book set name=?, author=?, publisher=?, genre=? where id=?";
					psmt = conn.prepareStatement(SQL);
					psmt.setString(1, b.name);
					psmt.setString(2, b.author);
					psmt.setString(3, b.publisher);
					psmt.setString(4, b.genre);
					psmt.setInt(5, b.id);
					int r = psmt.executeUpdate();

					SQL = "select * from book where id = ?";
					psmt = conn.prepareStatement(SQL);
					psmt.setInt(1, b.id);
					rs = psmt.executeQuery(); // 도서변경 중 변경 후 확인 로직

					if (rs.next()) {
						b.name = rs.getString("name");
						b.author = rs.getString("author");
						b.publisher = rs.getString("publisher");
						b.genre = rs.getString("genre");
						b.print();
					}
					break;

				case 5:
					System.out.println("삭제할 도서번호 : ");
					b.id = s.nextInt();
					SQL = "delete from book where id = ?";
					psmt = conn.prepareStatement(SQL);
					psmt.setInt(1, b.id);
					r = psmt.executeUpdate();
					break;
				}
			}
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}

class Book {
	int id;
	String name;
	String author;
	String publisher;
	String genre; // 장르

	void print() {
		System.out.println("도서번호 - " + id + ", 도서명 = " + name + ", 저자 = " + author + "" + " , 출판사 = " + publisher
				+ ", 장르 = " + genre);
	}
}