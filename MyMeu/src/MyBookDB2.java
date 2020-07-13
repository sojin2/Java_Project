import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MyBookDB2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		Rent r = new Rent();

		try { Class.forName("com.mysql.cj.jdbc.Driver"); }
		catch (ClassNotFoundException e) 
			{ System.out.println("**** DB �ε� ���� !!! ****");
			System.exit(0); } 
		System.out.print("*** DB �ε� ��� *** "); ; 
		try { Connection conn = 
		DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bookdb?serverTimezone=UTC",
				"root", "root");

			Statement stmt = conn.createStatement();
			while(true) {
				System.out.println("*** �������� ***");
				System.out.print("1. ���� �뿩 : ");
				System.out.print("2. ���� �뿩���: ");
				System.out.print("3. ���� �ݳ� : ");
				System.out.print("0. ���� : ");
				
				int t = s.nextInt();
				if (t == 0)
					break; // �ý��� ����
				switch (t) {
				case 1:
					System.out.print("���� �뿩��ȣ : ");
					r.id = s.nextInt();
					System.out.print("�뿩 ������ : ");
					r.name = s.next();
					System.out.print("�뿩�� �̸� : ");
					r.user = s.next();
					System.out.print("�뿩���� (YYMMDD) : ");
					r.date1 = s.next();
					String SQL = "insert into rent values(?,?,?,?,?)";
					PreparedStatement psmt = conn.prepareStatement(SQL);
					psmt.setInt(1, r.id);
					psmt.setString(2, r.name);
					psmt.setString(3, r.user);
					psmt.setString(4, r.date1);
					psmt.setString(5, r.date2);
					psmt.executeUpdate();
					
					break;
				
		case 2:
			System.out.println("*** ���� �뿩 ��� ���***");
			ResultSet rs = stmt.executeQuery("select * from rent");
			while(rs.next()) {
				r.id = rs.getInt("id");
				r.name = rs.getString("name");
				r.user = rs.getString("user");
				r.date1 = rs.getString("date1");
				r.date2 = rs.getString("date2");
				r.print();
			}
			break;
			
		case 3:
			System.out.print("���� �뿩��ȣ : ");
		     r.id = s.nextInt();
		     System.out.print("�����ݳ�����(YYMMDD) : ");
		     r.date2= s.next();

		     SQL = "update rent set name=?, user=?, date1=?, date2=? where id=?";
		     psmt = conn.prepareStatement(SQL);
		     psmt.setString(1, r.name);
		     psmt.setString(2, r.user);
		     psmt.setString(3, r.date1);
		     psmt.setString(4, r.date2);
		     psmt.setInt(5, r.id);
		     int e = psmt.executeUpdate();

		     SQL = "select * from rent where id = ?";
		     psmt = conn.prepareStatement(SQL);
		     psmt.setInt(1, r.id);
		     rs = psmt.executeQuery();

		     if (rs.next()) {
		      r.name = rs.getString("name");
		      r.user= rs.getString("user");
		      r.date1= rs.getString("date1");
		      r.date2= rs.getString("date2");
		      r.print();
		     }
		     break;
				}
			}
				}catch (java.lang.Exception e) {
					e.printStackTrace();
			
			}
	}
}
class Rent{
	int id;
	String name;
	String user;
	String date1;
	String date2;
	
	void print() {
		System.out.println("�뿩��ȣ = " + id + ", �뿩 ������  = " + name + " , �뿩�� �̸� = " + user + ", �뿩���� = " + date1 + ", �ݳ����� = " + date2);
	}
}
