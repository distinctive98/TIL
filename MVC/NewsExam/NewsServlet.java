package controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import model.dao.*;
import model.vo.*;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsDAO dao = new NewsDAO();
		String action = request.getParameter("action");
		ArrayList<NewsVO> list = null;
		
		HttpSession session = request.getSession();
		
		if(action != null) {
			if(action.equals("read") || action.equals("delete")) {
				int id = Integer.parseInt(request.getParameter("newsid"));

				//action==read
				if(action.equals("read")) {
					NewsVO vo = dao.listOne(id);
					dao.update(vo);
					request.setAttribute("listOne", vo);
					
				//action==delete
				} else {
					boolean result = dao.delete(id);
					
					if(result) {
						request.setAttribute("msg", "삭제 완료");
					} else {
						request.setAttribute("msg", "삭제 실패");
					}
				}
				
				if(session.getAttribute("selectedList") == null) {
					list = (ArrayList<NewsVO>) dao.listAll();
				} else {
					list = (ArrayList<NewsVO>) session.getAttribute("selectedList");
				}
				
			} else {
				//action==search
				if(action.equals("search")) {
					String searchType = request.getParameter("searchType");
					String key = request.getParameter("key");
					list = (ArrayList<NewsVO>) dao.search(key, searchType);
				//action==listwriter
				} else {
					String writer = request.getParameter("writer");
					list = (ArrayList<NewsVO>) dao.listWriter(writer);
				}
				
				if(session.getAttribute("selectedList") == null) {
					session.setAttribute("selectedList", list);
				}
				
				request.setAttribute("isSearch", "true");
			}
		} else {
			session.invalidate();
		}
		 
		request.setAttribute("list", list != null ? list : dao.listAll());
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		
		if(action.equals("insert")) {
			boolean result = dao.insert(vo);
			if(result) {
				request.setAttribute("msg", "삽입 완료");
			} else {
				request.setAttribute("msg", "삽입 실패");
			}
			//action==update
		} else {
			vo.setId(Integer.parseInt(request.getParameter("id")));
			boolean result = dao.update(vo);
			if(result) {
				request.setAttribute("msg", "수정 완료");
			} else {
				request.setAttribute("msg", "수정 실패");
			}
		}
		
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}

}
