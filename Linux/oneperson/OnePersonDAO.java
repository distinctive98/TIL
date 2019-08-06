package dao;

import java.sql.*;
import java.util.*;

import javax.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import vo.*;

@Repository
public class OnePersonDAO {
	@Autowired
	@Qualifier("hiveDataSource")
	DataSource ds;
	
	public List<OnePersonVO> select1(){
		List<OnePersonVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from oneperson order by cnt desc");
			OnePersonVO vo = null;
			while(rs.next()) {
				vo = new OnePersonVO();
				vo.setArea1(rs.getString(1));
				vo.setArea2(rs.getString(2));
				vo.setCnt(rs.getInt(3));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();				
			} 
		}
		return list;
	}
	
	public List<OnePersonVO> select2(){
		List<OnePersonVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select area1, sum(cnt) from oneperson group by area1");
			OnePersonVO vo = null;
			while(rs.next()) {
				vo = new OnePersonVO();
				vo.setArea1(rs.getString(1));
				vo.setCnt(rs.getInt(2));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();				
			} 
		}
		return list;
	}
	
	public List<OnePersonVO> select3(){
		List<OnePersonVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from oneperson order by cnt desc limit 1");
			OnePersonVO vo = null;
			while(rs.next()) {
				vo = new OnePersonVO();
				vo.setArea1(rs.getString(1));
				vo.setArea2(rs.getString(2));
				vo.setCnt(rs.getInt(3));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();				
			} 
		}
		return list;
	}
	
	public List<OnePersonVO> select4(){
		List<OnePersonVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select area1,sum(cnt) as c from oneperson group by area1 order by c desc limit 1");
			OnePersonVO vo = null;
			while(rs.next()) {
				vo = new OnePersonVO();
				vo.setArea1(rs.getString(1));
				vo.setCnt(rs.getInt(2));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();				
			} 
		}
		return list;
	}
	
	public List<OnePersonVO> search(String area){
		List<OnePersonVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from oneperson where area1='" + area + "'");
			OnePersonVO vo = null;
			while(rs.next()) {
				vo = new OnePersonVO();
				vo.setArea1(rs.getString(1));
				vo.setArea2(rs.getString(2));
				vo.setCnt(rs.getInt(3));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();				
			} 
		}
		return list;
	}
}
