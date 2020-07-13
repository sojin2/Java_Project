import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class MyMenu {

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
			System.out.println("test0");
			String SQL = "insert menu values (?, ?, ?)";
			Statement stmt = conn.createStatement();
			PreparedStatement psmt = conn.prepareStatement(SQL);
			while(true) {
				System.out.println("*** �޴����� �Է� ***");
				System.out.print("�޴�ID : ");
				int id = s.nextInt();
				if(id <= 0)
					break;	// �Է� ����
				System.out.print("�޴��̸� : ");
				String name = s.next();
				System.out.print("���� : ");
				int price = s.nextInt();
				
				psmt.setInt(1,  id);
				psmt.setString(2,  name);
				psmt.setInt(3,  price);
				// DB�� �߰�
				int r = psmt.executeUpdate();
				System.out.println("�޴� �߰� ��� = "  + r);
				
			}
			// ���̺� �Է³��� Ȯ��
			ResultSet rs = stmt.executeQuery("select * from menu");
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				System.out.println("id = " + id + ", �޴��̸� = " + name + ", ���� = " + price);
			}
			
		} catch(java.lang.Exception e) { 
			System.out.println("DB ó�� ���� �߻�");
		}
		/*
		// �ֹ� ó�� : �ֹ��� �޾Ƽ� id -> name�� price �����ؼ� orders�� �����ϰ� �ֹ��� ���� �� ���
		while (true)  {
			System.out.println("*** �޴� �ֹ� ***");
			Order o = new Order();
			System.out.print("�޴� ID = ");
			int id = s.nextInt();
			if(id == 0)
				break;
			// new Integer(id) �Ǵ� id + ""
			System.out.print("�ֹ����� = ");
			o.qty = s.nextInt();
			
			Menu m = (Menu)menus.get(id + "");
			o.name = m.name;
			o.price = m.price;
			orders.add(o);
		}
		System.out.println("�ֹ� ���� !!");
		e = orders.elements();
		while(e.hasMoreElements()) {
			Order o = (Order)e.nextElement();
			o.print();
		}
		*/		
	}
}
