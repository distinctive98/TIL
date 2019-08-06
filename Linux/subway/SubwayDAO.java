package dao;

import java.sql.*;
import java.util.*;

import javax.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import vo.*;

@Repository
public class SubwayDAO {
	@Autowired
	@Qualifier("hiveDataSource")
	DataSource ds;
	
	public List<SubwayVO> select(String linep){
		List<SubwayVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from subway where linep='" + linep +"'");
			SubwayVO vo = null;
			while(rs.next()) {
				vo = new SubwayVO();
				vo.setLine(rs.getString(1));
				vo.setTime(rs.getString(2));
				vo.setRide(rs.getInt(3));
				vo.setTakeoff(rs.getInt(4));
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
