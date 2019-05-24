package jdbcexam;

import java.sql.*;
import java.util.*;

public class SearchEmp {

	public static void main(String[] args) {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver 접속 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY\"년 \"MM\"월\"'), DEPTNO "
				+ "FROM EMP "
				+ "WHERE ENAME = ?";
		
		try (	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				Scanner sc = new Scanner(System.in);) {
			
			System.out.println("Scott 계정 접속 완료");
			
			String name;
			String check;
			
			do {
				System.out.print("\n검색할 사원 이름을 입력하십시오 : ");
				
				name = sc.nextLine();
				pstmt.setString(1, name.toUpperCase());
				
				try(ResultSet rs = pstmt.executeQuery();){
					
					System.out.println();
					
					if(rs.next()) {
						System.out.println(rs.getString(1) + "직원은 근무중입니다.");
						System.out.println(rs.getString(2) + "에 입사했고 현재 " + rs.getString(3) + "부서에서 근무하고 있습니다.");
					} else {
						System.out.println(name + "직원은 근무하지 않습니다.");
					}
					
					System.out.println();
					
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				System.out.print("계속 검토하려면 Y 입력 : ");
				check = sc.nextLine();
				
			} while("Y".equals(check.toUpperCase()));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("시스템 종료");
		

	}

}
