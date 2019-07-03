package model.dao;

import java.sql.*;
import java.util.*;

import model.vo.*;

public class VisitorDAO {
	public ArrayList<VisitorVO> listAll(){
		ArrayList<VisitorVO> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try(	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						 	"SELECT ID, NAME, TO_CHAR(WRITEDATE, 'YYYY\"년\" MM\"월\" DD\"일\"'), MEMO "
						+ "FROM VISITOR")){
			
			VisitorVO vo;
			while(rs.next()) {
				vo = new VisitorVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setWriteDate(rs.getString(3));
				vo.setMemo(rs.getString(4));
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<VisitorVO> search(String keyword){
		ArrayList<VisitorVO> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try(	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						 	"SELECT ID, NAME, TO_CHAR(WRITEDATE, 'YYYY\"년\" MM\"월\" DD\"일\"'), MEMO "
						+ "FROM VISITOR "
						+ "WHERE MEMO LIKE '%" + keyword + "%'")){
			
			VisitorVO vo;
			while(rs.next()) {
				vo = new VisitorVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setWriteDate(rs.getString(3));
				vo.setMemo(rs.getString(4));
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean insert(VisitorVO vo) {
		
		boolean result = true;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try(	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO VISITOR VALUES(?, SYSDATE, ?, VISITOR_SEQ.NEXTVAL)")){
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMemo());
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean delete(int id) {
		boolean result = true;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try(	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM VISITOR WHERE ID = ?")){
			
			pstmt.setInt(1, id);
			int deleteNum = pstmt.executeUpdate();
			
			if(deleteNum != 1)
				result = false;
			
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		
		
		return result;
	}
}
