package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import model.vo.*;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = getParam(request.getParameter("name"));
		String number = getParam(request.getParameter("number"));
		String account = getParam(request.getParameter("account"));
		String password = getParam(request.getParameter("password"));
		
		MemberVO memberInfo = new MemberVO();
		memberInfo.setName(name);
		memberInfo.setNumber(number);
		memberInfo.setAccount(account);
		memberInfo.setPassword(password);
		
		request.setAttribute("info", memberInfo);
		request.getRequestDispatcher("/jspexam/memberView.jsp").forward(request, response);
	}
	
	String getParam(String info) {
		if(!info.equals(""))
			return info;
		else
			return "¾øÀ½";
	}

}
