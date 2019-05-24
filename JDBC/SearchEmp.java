package jdbcexam;

import java.sql.*;
import java.util.*;

public class SearchEmp {

	public static void main(String[] args) {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver ���� �Ϸ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY\"�� \"MM\"��\"'), DEPTNO "
				+ "FROM EMP "
				+ "WHERE ENAME = ?";
		
		try (	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				Scanner sc = new Scanner(System.in);) {
			
			System.out.println("Scott ���� ���� �Ϸ�");
			
			String name;
			String check;
			
			do {
				System.out.print("\n�˻��� ��� �̸��� �Է��Ͻʽÿ� : ");
				
				name = sc.nextLine();
				pstmt.setString(1, name.toUpperCase());
				
				try(ResultSet rs = pstmt.executeQuery();){
					
					System.out.println();
					
					if(rs.next()) {
						System.out.println(rs.getString(1) + "������ �ٹ����Դϴ�.");
						System.out.println(rs.getString(2) + "�� �Ի��߰� ���� " + rs.getString(3) + "�μ����� �ٹ��ϰ� �ֽ��ϴ�.");
					} else {
						System.out.println(name + "������ �ٹ����� �ʽ��ϴ�.");
					}
					
					System.out.println();
					
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				System.out.print("��� �����Ϸ��� Y �Է� : ");
				check = sc.nextLine();
				
			} while("Y".equals(check.toUpperCase()));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("�ý��� ����");
		

	}

}
