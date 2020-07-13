import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MyOrder {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Class.forName("org.gjt.mm.mysql.Driver");
		} catch(ClassNotFoundException e) {
			System.out.println("DB �ε� ���� !!");
			System.exit(0);
		}
		try {
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/menudb?serverTimezone=UTC", "root", "root");
			
			Statement stmt = conn.createStatement();
			
			while(true) {
				System.out.println("*** �޴� �ֹ� ***");
				System.out.print("�޴� ID : ");
				int id = s.nextInt();
				String name = null;
				int price = 0;
				if(id <= 0)
					break;	// �ֹ� ����
				String SQL = "select * from menu where id = ?";
				PreparedStatement psmt = conn.prepareStatement(SQL);
				psmt.setInt(1,  id);
				ResultSet rs = psmt.executeQuery();
				
				if(rs.next()) {
					name = rs.getString(2);
					price = rs.getInt(3);
				}
				else {
					System.out.println("�޴� Ȯ�� �Ұ� !!");
					continue;
				}
				System.out.print("���� = ");
				int qty = s.nextInt();
				SQL = "insert into orders values(?, ?, ?)";
				psmt = conn.prepareStatement(SQL);
				psmt.setString(1,  name);
				psmt.setInt(2,  price);
				psmt.setInt(3, qty);
				// DB ���̺� ����
				int r = psmt.executeUpdate();
			}
			
			ResultSet rs = stmt.executeQuery("select * from order");
			while(rs.next()) {
				String name = rs.getString(1);
				int price = rs.getInt(2);
				int qty = rs.getInt(3);
				System.out.println("�޴��̸� = " + name + ", ���� = " + price + ", ����" + qty);
			}
			
			
		} catch (java.lang.Exception e) {
			System.out.println("DB ó�� ����!!");
		}
	}

}
