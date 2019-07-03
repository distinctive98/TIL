package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import model.dao.*;
import model.vo.*;

@WebServlet("/meeting")
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("id");
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		
		if(id != null) {
			boolean result = dao.delete(Integer.parseInt(id));
			if(result) {
				request.setAttribute("msg", "삭제되었습니다.");
			} else {
				request.setAttribute("msg", "삭제 실패하였습니다.");
			}
		} else {
			
			if(keyword == null) {
				request.setAttribute("list", dao.listAll());
			} else {
				request.setAttribute("list", dao.search(keyword));
			}
		}
		
		
		
		request.getRequestDispatcher("/jspexam/meetingView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String meetingDate = request.getParameter("meetingDateTime");
		
		MeetingVO vo = new MeetingVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(meetingDate);
		
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		boolean result = dao.insert(vo);
		if(result) {
			request.setAttribute("msg", "성공적으로 입력되었습니다.");
		} else {
			request.setAttribute("msg", "입력에 실패하였습니다.");
		}
		
		request.getRequestDispatcher("/jspexam/meetingView.jsp").forward(request, response);
	}
	
}
