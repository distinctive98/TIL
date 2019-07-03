package model.dao;

import java.sql.*;
import java.util.*;
import model.vo.*;

public class MeetingJDBCDAO implements MeetingDAO{
	public List<MeetingVO> listAll(){
		ArrayList<MeetingVO> list = new ArrayList<>();
		
		uploadDriver();
		try(	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						 	"SELECT ID, NAME, TITLE, TO_CHAR(MEETINGDATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH\"시\" mm\"분\"') "
						+ "FROM MEETING")){
			
			MeetingVO vo;
			while(rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setMeetingDate(rs.getString(4));
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean insert(MeetingVO vo) {
		boolean result = true;
		
		uploadDriver();
		try(	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO MEETING VALUES(MEETING_SEQ.NEXTVAL, ?, ?, TO_DATE(?, 'yyyy-mm-dd\"T\"hh24:mi'))")){
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getMeetingDate().replace("%3A", ":"));
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}

	public List<MeetingVO> search(String keyword){
		ArrayList<MeetingVO> list = new ArrayList<>();
		
		uploadDriver();
		try ( Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
							"SELECT ID, NAME, TITLE, TO_CHAR(MEETINGDATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH\"시\" mm\"분\"') "
						+ "FROM MEETING "
						+ "WHERE TITLE LIKE '%" + keyword + "%'")){
			
			MeetingVO vo;
			while(rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setMeetingDate(rs.getString(4));
				list.add(vo);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean delete(int eNo) {
		boolean result = true;
		
		uploadDriver();		
		try(	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM MEETING WHERE ID = ?")){
			
			pstmt.setInt(1, eNo);
			int deleteNum = pstmt.executeUpdate();
			
			if(deleteNum != 1)
				result = false;
			
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}
	
	private void uploadDriver() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
