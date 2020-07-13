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
			System.out.println("DB 로딩 오류 !!");
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
				System.out.println("*** 메뉴정보 입력 ***");
				System.out.print("메뉴ID : ");
				int id = s.nextInt();
				if(id <= 0)
					break;	// 입력 종료
				System.out.print("메뉴이름 : ");
				String name = s.next();
				System.out.print("가격 : ");
				int price = s.nextInt();
				
				psmt.setInt(1,  id);
				psmt.setString(2,  name);
				psmt.setInt(3,  price);
				// DB에 추가
				int r = psmt.executeUpdate();
				System.out.println("메뉴 추가 결과 = "  + r);
				
			}
			// 테이블 입력내용 확인
			ResultSet rs = stmt.executeQuery("select * from menu");
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				System.out.println("id = " + id + ", 메뉴이름 = " + name + ", 가격 = " + price);
			}
			
		} catch(java.lang.Exception e) { 
			System.out.println("DB 처리 오류 발생");
		}
		/*
		// 주문 처리 : 주문을 받아서 id -> name과 price 변경해서 orders에 저장하고 주문이 종료 후 출려
		while (true)  {
			System.out.println("*** 메뉴 주문 ***");
			Order o = new Order();
			System.out.print("메뉴 ID = ");
			int id = s.nextInt();
			if(id == 0)
				break;
			// new Integer(id) 또는 id + ""
			System.out.print("주문수량 = ");
			o.qty = s.nextInt();
			
			Menu m = (Menu)menus.get(id + "");
			o.name = m.name;
			o.price = m.price;
			orders.add(o);
		}
		System.out.println("주문 내역 !!");
		e = orders.elements();
		while(e.hasMoreElements()) {
			Order o = (Order)e.nextElement();
			o.print();
		}
		*/		
	}
}
