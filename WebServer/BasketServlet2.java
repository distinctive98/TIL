package core;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<h1>선택한 상품 리스트</h1>");
		out.print("<hr>");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new int[10]);
		}
		
		String id = request.getParameter("id");
		if(id != null) {
			int index = getIndex(id);
			
			int[] count = (int[])session.getAttribute("cnt");
			count[index]++;
			
			out.print("<ul>");
			for(int i=0; i<count.length; i++) {
				if(count[i] > 0)
					out.print("<li>" + getId(i) + "상품" + count[i] + "개");
			}
			out.print("</ul>");
			
			out.print("<a href="+request.getHeader("referer")+">상품 선택 화면</a>");
			out.print("<br>");
			out.print("<a href='http://localhost:8000/sedu/basket2'>상품 비우기</a>");
		}
		else {
			session.removeAttribute("cnt");
			out.print("<h2>상품이 모두 삭제되었습니다.</h2>");
			out.print("<a href='http://localhost:8000/sedu/html/productlog2.html'>상품 선택 화면</a>");
		}	
	}
	
	int getIndex(String id) {
		switch(id) {
		case "p001" : return 0;
		case "p002" : return 1;
		case "p003" : return 2;
		case "p004" : return 3;
		case "p005" : return 4;
		case "p006" : return 5;
		case "p007" : return 6;
		case "p008" : return 7;
		case "p009" : return 8;
		case "p010" : return 9;
		default : return -1;
		}
	}
	
	String getId(int index) {
		switch(index) {
		case 0 : return "p001";
		case 1 : return "p002";
		case 2 : return "p003";
		case 3 : return "p004";
		case 4 : return "p005";
		case 5 : return "p006";
		case 6 : return "p007";
		case 7 : return "p008";
		case 8 : return "p009";
		case 9 : return "p010";
		default : return "-1";
		}
	}
}
