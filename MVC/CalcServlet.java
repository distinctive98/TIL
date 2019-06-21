package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int op1 = Integer.parseInt(request.getParameter("operand1"));
		int op2 = Integer.parseInt(request.getParameter("operand2"));
		String oper = request.getParameter("operator");
		String url;
		Object result;
		
		if(op2 == 0 && oper.equals("divide")) {
			url = "jspexam/errorResult.jsp";
			result = "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!";
		}else {
			url = "jspexam/calcResult.jsp";
			result = getResult(op1, op2, oper);
		}
		
		request.setAttribute("result", result);
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	int getResult(int op1, int op2, String oper){
		if(oper.equals("plus"))
			return op1+op2;
		else if(oper.equals("minus"))
			return op1-op2;
		else if(oper.equals("multiply"))
			return op1*op2;
		else
			return op1/op2;
	}
}
