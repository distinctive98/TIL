package core;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reqNum = Integer.parseInt(request.getParameter("number"));
		int lottoNum = new Random().nextInt(6)+1;
		
		System.out.printf("전달된 값 : %d, 추출된 값 : %d\n", reqNum, lottoNum);
		
		String url;
		if(reqNum==lottoNum)
			url = "/jspexam/success.jsp";
		else
			url = "/jspexam/fail.jsp";
			
		request.getRequestDispatcher(url).forward(request, response);
	}

}
