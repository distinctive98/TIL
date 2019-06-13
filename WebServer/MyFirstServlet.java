package core;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet("/myfirst")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<h2>"+ name + "�� �ݰ�����.. ������ " +getWeek()+"�����Դϴ�!!</h2>");
		out.close();
	}
	
	char getWeek() {
		char[] weeks = {'��', '��', 'ȭ', '��', '��', '��', '��'};
		Calendar cal = Calendar.getInstance();
		
		return weeks[cal.get(Calendar.DAY_OF_WEEK)-1];
	}

}
