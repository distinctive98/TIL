package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/edu")
public class EduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//반드시 쿼리 추출 전에 setCharacterEncoding을 해야 함
		request.setCharacterEncoding("UTF-8");
		int score = Integer.parseInt(request.getParameter("score"));
		
		String grade;
		if(score >= 90) 
			grade = "A";
		else if(80 <= score && score <= 89)
			grade = "B";
		else if(70 <= score && score <= 79)
			grade = "C";
		else
			grade = "D";
		
		request.setAttribute("grade", grade);
		request.getRequestDispatcher("/jspexam/grade"+grade+".jsp").forward(request, response);
	}
}
