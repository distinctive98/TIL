package core;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String url = null;
		
		if(action == null) {
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().print("<h2>전달된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니당...</h2>");
		}
		else {
			if(action.equals("naver"))
				url = "http://www.naver.com";
			else if(action.equals("daum"))
				url = "http://www.daum.net";
			else if(action.equals("google"))
				url = "http://www.google.com";
			else{
				
			}
			response.sendRedirect(url);
		}	
	}
}
