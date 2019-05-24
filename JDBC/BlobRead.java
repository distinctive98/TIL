package jdbcexam;

import java.io.*;
import java.sql.*;

class BlobRead {
	public static void main(String args[]) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select imgcontent ic from imgtest " + "where name ='totoro.png'");
		
		if (rset.next()) {
			//getBlob()을 통해 image를 받는다.
			Blob blob = rset.getBlob("ic");
			//Byte 단위의 크기 출력
			System.out.println(blob.length());
			
			//그냥 보내면 깨지기 때문에 InputStream을 새 파일로 내보냄
			InputStream is = blob.getBinaryStream();
			FileOutputStream fo = new FileOutputStream("c:/iotest/totoro2.jpg");
			
			int c = 0;
			//파일을 계속 리드&라이트
			//한 번에 imgae 파일을 읽어올 수 없음
			while ((c = is.read()) != -1)
				fo.write(c);
			
			if (fo != null)
				fo.close();
			if (is != null)
				is.close();
			
			//크롬을 기동시키는 방법
			Runtime.getRuntime()
					.exec("C:/Program Files (x86)/Google/Chrome/Application" + "/chrome.exe c:/iotest/totoro2.jpg");
			
		} else {
			System.out.println("추출된 데이터가 없습니다!!");
		}
		
		if (rset != null)
			rset.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}
}
