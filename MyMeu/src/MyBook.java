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
			System.out.println("**** DB �ε� ���� !!! ****");
			System.exit(0);
		}
		System.out.print("*** DB �ε� ��� *** ");
		;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb?serverTimezone=UTC",
					"root", "root");

			Statement stmt = conn.createStatement();
			while (true) {

				System.out.println("***�������� �޴�***");

				System.out.println("1. �������");
				System.out.println("2. ������� ���");
				System.out.println("3. ���� �˻�");
				System.out.println("4. �������� ����");
				System.out.println("5. ���� ����");
				System.out.println("0. ����");
				System.out.print("���� : ");
				int t = s.nextInt();
				if (t == 0)
					break; // �ý��� ����
				switch (t) {
				case 1:
					System.out.print("���� ��ȣ : ");
					b.id = s.nextInt();
					System.out.print("���� �� : ");
					b.name = s.next();
					System.out.print("���� ���ǻ� : ");
					b.publisher = s.next();
					System.out.print("���� ���� : ");
					b.author = s.next();
					System.out.print("�帣(1,2,3) : ");
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
					System.out.println("*** ���� ��� ���***");
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
					System.out.print("�˻� ������ȣ : ");
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
					System.out.print("�˻� ������ȣ : ");
					b.id = s.nextInt();
					System.out.println("*** ���� ���� �Է� ***");
					System.out.print("������ :");
					b.name = s.next();
					System.out.print("���� :");
					b.author = s.next();
					System.out.print("���ǻ� :");
					b.publisher = s.next();
					System.out.print("�帣(1: IT, 2: ����, 3: ��Ÿ) :");
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
					rs = psmt.executeQuery(); // �������� �� ���� �� Ȯ�� ����

					if (rs.next()) {
						b.name = rs.getString("name");
						b.author = rs.getString("author");
						b.publisher = rs.getString("publisher");
						b.genre = rs.getString("genre");
						b.print();
					}
					break;

				case 5:
					System.out.println("������ ������ȣ : ");
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
	String genre; // �帣

	void print() {
		System.out.println("������ȣ - " + id + ", ������ = " + name + ", ���� = " + author + "" + " , ���ǻ� = " + publisher
				+ ", �帣 = " + genre);
	}
}