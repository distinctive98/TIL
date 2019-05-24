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
			//sequence 사용법 확인
			pstmt = conn.prepareStatement("INSERT into meeting values(meeting_seq.nextval, ?, ?, ?)");
			
			sc1 = new Scanner(System.in);
			System.out.print("이름 : ");
			String name = sc1.nextLine();
			System.out.print("메모를 입력하세요 : ");
			String text = sc1.nextLine();
			System.out.print("시간입력 (yyyy mm dd hh mi) :");
			String date = sc1.nextLine();

			pstmt.setString(1, name);
			pstmt.setString(2, text);
			
			//SimpleDateFormat 사용법 확인
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH mm");
			//parse할 때는 java.util.Date 사용(자바 객체이기 때문)
			java.util.Date d = sdf.parse(date);
			//setDate할 때는 java.sql.Date 사용 (DB에 넣어야 하기 때문)
			//getTime()은 timeStamp가 반환됨(밀리세컨드 초단위)
			//이를 통해서 DB에 삽입해야 함
			pstmt.setDate(3, new java.sql.Date(d.getTime()));
			pstmt.executeUpdate();
			
			System.out.println("데이터 저장 성공");
			//Data Parse하는 과정에서 ParseException 처리해야 함
		} catch (ParseException pe) {
			pe.printStackTrace();
			System.out.println("파싱 오류");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("드라이버 로딩 오류");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("데이터 저장 실패");
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
