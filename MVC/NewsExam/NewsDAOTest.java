package model.dao;

import java.util.*;

import org.junit.*;

import model.vo.*;

public class NewsDAOTest {

	NewsDAO dao = new NewsDAO();
	/*
	@Test
	public void testInsert() {
		NewsVO vo = new NewsVO();
		vo.setWriter("Test");
		vo.setTitle("Test Title");
		vo.setContent("Test Content");
		//vo.setWritedate("2019-02-26");
		boolean result = dao.insert(vo);
		System.out.println("insert 결과 : " + result);
	}
	
	@Test
	public void testUpdate() {
		NewsVO vo = new NewsVO();
		vo.setWriter("Test");
		vo.setTitle("Update Title");
		vo.setContent("Update Content");
		vo.setWritedate("2019-02-10");
		vo.setId(5);
		boolean result = dao.update(vo);
		System.out.println("update 결과 : " + result);
	}
	*/
	
	/*
	@Test
	public void testDelete() {
		boolean result = dao.delete(5);
		System.out.println("delete 결과 : " + result);
	}
	
	@Test
	public void testListAll() {
		ArrayList<NewsVO> list = (ArrayList<NewsVO>)dao.listAll();
		
		for(NewsVO vo : list)
			System.out.println(vo.toString());
	}
	
	@Test
	public void testListOne() {
		NewsVO vo = dao.listOne(8);
		System.out.println(vo.toString());
	}
	*/
	/*
	@Test
	public void testListWriter() {
		ArrayList<NewsVO> list = (ArrayList<NewsVO>)dao.listWriter("듀크");
		
		for(NewsVO vo : list)
			System.out.println(vo.toString());
	}
	*/
	
	@Test
	public void testSearch() {
		ArrayList<NewsVO> list = (ArrayList<NewsVO>)dao.search("도라지", "content");
		
		for(NewsVO vo : list)
			System.out.println(vo.toString());
	}
	
}
