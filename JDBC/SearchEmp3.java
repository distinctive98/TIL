package jdbcexam;

import java.sql.*;
import java.util.*;

public class SearchEmp3 {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver ���� �Ϸ�");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//�ܺ��������� �˻��ϴ� ���
		String sql = "SELECT ENAME "
						+ "FROM EMP RIGHT JOIN DEPT USING(DEPTNO) "
						+ "WHERE DNAME = ?";
		
		try ( Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				Scanner sc = new Scanner(System.in);) {
			
			System.out.println("Scott ���� ���� �Ϸ�");
			
			String dName;
			boolean check = true;
			
			do {
				System.out.print("\n�˻��� �μ� �̸��� �Է��Ͻʽÿ� : ");
			
				dName = sc.nextLine().toUpperCase();
				pstmt.setString(1,  dName);
				
				try (ResultSet rs = pstmt.executeQuery()){
					//�����Ͱ� �˻��Ǵ� ���
					if(rs.next()) {
						//NULL�� �ƴ� ���
						if(rs.getString(1) != null) {
							System.out.println(dName + " �μ����� �ٹ��ϴ� ������");
							do {
								System.out.println("\t" + rs.getString(1));
							} while(rs.next());
						}
						//NULL�� ���
						else {
							System.out.println(dName + "�μ����� �ٹ��ϴ� ������ �����ϴ�.");
						}
					}
					//������ �˻��� �� �Ǵ� ���
					else
						System.out.println(dName + "�μ��� �������� �ʽ��ϴ�.");
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				
				System.out.print("\n��� �˻��Ϸ��� Y �Է�(�� �ܿ� ����) : ");
				if(!"Y".equals(sc.nextLine().toUpperCase()))
					check = false;
			
			} while(check);
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		System.out.println("�ý��� ����");
	}

}
