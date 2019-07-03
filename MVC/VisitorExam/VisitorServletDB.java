package controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import model.dao.*;
import model.vo.*;

@WebServlet("/visitor")
public class VisitorServletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("id");
		VisitorDAO dao = new VisitorDAO();
		
		if(id != null) {
			boolean result = dao.delete(Integer.parseInt(id));
			if(result) {
				request.setAttribute("msg", "글이 성공적으로 삭제되었어요!");
			} else {
				request.setAttribute("msg", "글 삭제를 실패했어요!");
			}
		} else if(keyword == null) {
			request.setAttribute("list", dao.listAll());
		} else {
			ArrayList<VisitorVO> list = dao.search(keyword);
			if(list.size() == 0) {
				request.setAttribute("msg", keyword + "를 담고있는 글은 검색되지 않습니다.");
			} else {
				request.setAttribute("list", list);
			}
		}
		
		request.getRequestDispatcher("/jspexam/visitorView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String memo = request.getParameter("text");
		
		VisitorDAO dao = new VisitorDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName(name);
		vo.setMemo(memo);
		
		boolean result = dao.insert(vo);
		if(result) {
			request.setAttribute("msg", name + "님의 글이 성공적으로 입력되었습니다.");
		}else {
			request.setAttribute("msg", name + "님의 글이 성공적으로 입력되지 않았습니다.");
		}
		
		request.getRequestDispatcher("/jspexam/visitorView.jsp").forward(request, response);
	}

}
