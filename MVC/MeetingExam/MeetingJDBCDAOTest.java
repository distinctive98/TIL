package model.dao;

import java.util.*;

import org.junit.*;

import model.vo.*;

public class MeetingJDBCDAOTest {
	
	MeetingJDBCDAO dao = new MeetingJDBCDAO();
	/*
	@Test
	public void test1() {
		ArrayList<MeetingVO> list = (ArrayList<MeetingVO>) dao.listAll();;
		for(MeetingVO data : list)
			System.out.println(data);
		
		System.out.println("test1 완료");
	}
	*/
	
	/*
	@Test
	public void test2() {
		ArrayList<MeetingVO> list = (ArrayList<MeetingVO>) dao.search("왈왈");
		for(MeetingVO data : list)
			System.out.println(data);
		System.out.println("test2 완료");
	}
	*/
	
	/*
	@Test
	public void test3() {
		MeetingVO vo = new MeetingVO();
		vo.setName("김도라지");
		vo.setTitle("도라지캐기2");
		vo.setMeetingDate("2009-04-05T04%3A05");
		
		dao.insert(vo);
		System.out.println("test3 완료");
	}
	*/
	
	
	@Test
	public void test4() {
		boolean result = dao.delete(33);
		System.out.println(result);
	}
	
}
