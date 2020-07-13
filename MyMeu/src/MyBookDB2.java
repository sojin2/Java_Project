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
			{ System.out.println("**** DB 로딩 오류 !!! ****");
			System.exit(0); } 
		System.out.print("*** DB 로딩 통과 *** "); ; 
		try { Connection conn = 
		DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bookdb?serverTimezone=UTC",
				"root", "root");

			Statement stmt = conn.createStatement();
			while(true) {
				System.out.println("*** 도서관리 ***");
				System.out.print("1. 도서 대여 : ");
				System.out.print("2. 도서 대여목록: ");
				System.out.print("3. 도서 반납 : ");
				System.out.print("0. 종료 : ");
				
				int t = s.nextInt();
				if (t == 0)
					break; // 시스템 종료
				switch (t) {
				case 1:
					System.out.print("도서 대여번호 : ");
					r.id = s.nextInt();
					System.out.print("대여 도서명 : ");
					r.name = s.next();
					System.out.print("대여자 이름 : ");
					r.user = s.next();
					System.out.print("대여일자 (YYMMDD) : ");
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
			System.out.println("*** 도서 대여 목록 출력***");
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
			System.out.print("도서 대여번호 : ");
		     r.id = s.nextInt();
		     System.out.print("도서반납일자(YYMMDD) : ");
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
		System.out.println("대여번호 = " + id + ", 대여 도서명  = " + name + " , 대여자 이름 = " + user + ", 대여일자 = " + date1 + ", 반납일자 = " + date2);
	}
}
