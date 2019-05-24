package jdbcexam;

import java.io.*;
import java.sql.*;

public class BlobSave {
	public static void main(String args[]) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
		
		//InputStream 객체로 이미지 저장(바이트 단위로 읽어야 하기 때문)
		File file = new File("c:/iotest/totoro.png");
		InputStream is = new FileInputStream(file);
		
		PreparedStatement pstmt = conn.prepareStatement("insert into imgtest values (?, ?)");
		pstmt.setString(1, "totoro.png");
		//image를 삽입하는 방법 -> setBinaryStream()
		pstmt.setBinaryStream(2, is, file.length());
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		System.out.println("저장 성공!!");
	}
}
