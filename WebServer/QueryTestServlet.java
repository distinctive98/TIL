package core;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/querytest")
public class QueryTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String[] habits = request.getParameterValues("habit");
		String color = request.getParameter("color");
		String[] foods = request.getParameterValues("food");
		String opinion = request.getParameter("opinion");
		String secret1 = request.getParameter("secret1");
		String secret2 = request.getParameter("secret2");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<h2>전달된내용<h2>");
		out.print("<hr>");
		
		out.print("<ul>");
		out.print("<li> 이름 : "+name);
		out.print("<li> 암호 : "+password);
		out.print("<li> 나이 : "+age);
		out.print("<li> 성별 : "+gender);
		out.print("<li> 취미 : "); 
		if(habits == null) 
			out.print("없음");
		else 
			out.print(printValue(habits));
		out.print("<li> 좋아하는 색 : ");
		if(color.equals("")) 
			out.print("없음");
		else 
			out.print(color);
		out.print("<li> 좋아하는 음식 : ");
		if(foods == null) 
			out.print("없음");
		else 
			out.print(printValue(foods));
		out.print("<li> 의견 : "+opinion);
		out.print("<li> 비밀1 : "+secret1);
		out.print("<li> 비밀2 : "+secret2);
		out.print("</ul>");
		out.print("<a href=/sedu/html/queryForm.html>입력화면으로</a>");
	}
	
	String printValue(String[] values) {
		String str = "";
		for(int i=0; i<values.length; i++) {
			if(i == values.length-1) {
				str+=values[i];
				break;
			}
			str += values[i] + ", ";
		}
		return str;
	}

}
