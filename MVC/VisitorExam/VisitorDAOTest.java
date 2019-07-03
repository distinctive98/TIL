package model.dao;

import java.util.*;

import org.junit.*;

import model.vo.*;

public class VisitorDAOTest {

	@Test
	public void test() {
		VisitorDAO dao = new VisitorDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName("불금도라지");
		vo.setMemo("오늘은 불금!!!");
		dao.insert(vo);
		
		ArrayList<VisitorVO> list = dao.listAll();
		for(VisitorVO data : list)
			System.out.println(data);
		System.out.println("불금이 들어간 글2");
		
		list = dao.search("파이리");
		for(VisitorVO data : list)
			System.out.println(data);
	}
}
