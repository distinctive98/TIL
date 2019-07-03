package model.dao;

import java.sql.*;
import java.util.*;

import model.vo.*;

public class NewsDAO {
	
	public List<NewsVO> listAll(){
		ArrayList<NewsVO> list = new ArrayList<>();
		
		Connection conn = connectDB();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = 
					"SELECT ID, WRITER, TITLE, CONTENT, TO_CHAR(WRITEDATE, 'YYYY-MM-DD'), CNT "
				+ "FROM NEWS";
		NewsVO vo;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(conn, stmt, rs);		
		}
		
		return list;
	}
	
	public List<NewsVO> listWriter(String writer){
		ArrayList<NewsVO> list = new ArrayList<>();
		
		Connection conn = connectDB();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = 
				"SELECT ID, WRITER, TITLE, TO_CHAR(WRITEDATE, 'YYYY-MM-DD'), CNT "
			+ "FROM NEWS "
			+ "WHERE WRITER = '" + writer + "'";
		
		NewsVO vo;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setWritedate(rs.getString(4));
				vo.setCnt(rs.getInt(5));
				list.add(vo);
			}
		} catch(Exception e) {
			
		} finally {
			close(conn, stmt, rs);
		}
		
		return list;
	}
	
	public List<NewsVO> search(String key, String searchType){
		ArrayList<NewsVO> list = new ArrayList<>();
		
		Connection conn = connectDB();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = 
					"SELECT ID, WRITER, TITLE, TO_CHAR(WRITEDATE, 'YYYY-MM-DD'), CNT "
				+ "FROM NEWS "
				+ "WHERE " + searchType + " LIKE '%" +key+ "%'";
		
		NewsVO vo;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setWritedate(rs.getString(4));
				vo.setCnt(rs.getInt(5));
				list.add(vo);
			}
		} catch(Exception e) {
			
		} finally {
			close(conn, stmt, rs);
		}
		
		return list;
	}
	
	public NewsVO listOne(int id) {
		NewsVO vo = new NewsVO();
		
		Connection conn = connectDB();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = 
					"SELECT ID, WRITER, TITLE, CONTENT, TO_CHAR(WRITEDATE, 'YYYY-MM-DD'), CNT "
				+ "FROM NEWS "
				+ "WHERE ID = " + id;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			rs.next();
			vo.setId(rs.getInt(1));
			vo.setWriter(rs.getString(2));
			vo.setTitle(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setWritedate(rs.getString(5));
			vo.setCnt(rs.getInt(6));
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close(conn, stmt, rs);
		}
		
		return vo;
	}

	public boolean insert(NewsVO vo) {
		Connection conn = connectDB();
		PreparedStatement pstmt = null;
		
		String sql = 
				"INSERT INTO NEWS "
			+ "VALUES(NEWS_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 0)";
		boolean result = true;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			result = false;
		} finally {
			close(conn, pstmt);
		}
		
		return result;
	}
	
	public boolean update(NewsVO vo) {
		Connection conn = connectDB();
		PreparedStatement pstmt = null;
		
		String sql = 
					"UPDATE NEWS SET "
				+ "WRITER = ?, "
				+ "TITLE = ?, "
				+ "CONTENT = ?, "
				+ "CNT = ? "
				+ "WHERE ID = ?";
		boolean result = true;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getCnt()+1);
			pstmt.setInt(5, vo.getId());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			result = false;
			System.out.println(e.getMessage());
		} finally {
			close(conn, pstmt);
		}
		
		return result;
	}
	
	public boolean delete(int id) {
		Connection conn = connectDB();
		PreparedStatement pstmt = null;
		
		String sql =
					"DELETE FROM NEWS "
				+ "WHERE ID = ?";
		boolean result = true;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			int deleteNum = pstmt.executeUpdate();
			if(deleteNum != 1)
				result = false;
			
		} catch(Exception e) {
			result = false;
			System.out.println(e.getMessage());
		} finally {
			close(conn, pstmt);
		}
		
		return result;
	}
	
	private Connection connectDB() {	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(Exception e) {
			e.getMessage();
		}
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	
	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			conn.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}

