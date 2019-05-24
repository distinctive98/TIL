package jdbcexam;

import java.sql.*;
import java.text.*;
import java.util.*;

public class InsertMeeting {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc1 = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
			//sequence ���� Ȯ��
			pstmt = conn.prepareStatement("INSERT into meeting values(meeting_seq.nextval, ?, ?, ?)");
			
			sc1 = new Scanner(System.in);
			System.out.print("�̸� : ");
			String name = sc1.nextLine();
			System.out.print("�޸� �Է��ϼ��� : ");
			String text = sc1.nextLine();
			System.out.print("�ð��Է� (yyyy mm dd hh mi) :");
			String date = sc1.nextLine();

			pstmt.setString(1, name);
			pstmt.setString(2, text);
			
			//SimpleDateFormat ���� Ȯ��
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH mm");
			//parse�� ���� java.util.Date ���(�ڹ� ��ü�̱� ����)
			java.util.Date d = sdf.parse(date);
			//setDate�� ���� java.sql.Date ��� (DB�� �־�� �ϱ� ����)
			//getTime()�� timeStamp�� ��ȯ��(�и������� �ʴ���)
			//�̸� ���ؼ� DB�� �����ؾ� ��
			pstmt.setDate(3, new java.sql.Date(d.getTime()));
			pstmt.executeUpdate();
			
			System.out.println("������ ���� ����");
			//Data Parse�ϴ� �������� ParseException ó���ؾ� ��
		} catch (ParseException pe) {
			pe.printStackTrace();
			System.out.println("�Ľ� ����");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("����̹� �ε� ����");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("������ ���� ����");
		} finally {
			try {
				if (sc1 != null)
					sc1.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

}
