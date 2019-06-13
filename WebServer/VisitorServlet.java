package core;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		out.print("<h2>" + request.getParameter("name") +"님이 " +getToday()+ "에 남긴 글입니다.</h2>");
		out.print("<hr>");
		out.print("<p>"+ request.getParameter("text") +"</p>");
		out.print("<a href=/sedu/html/visitorForm.html>입력화면으로</a>");
		out.close();
	}
	
	String getToday() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		return dateFormat.format(date);
	}
}
