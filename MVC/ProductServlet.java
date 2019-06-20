package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import model.vo.*;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("product") == null) {
			session.setAttribute("product", new ProductVO());
		}
		
		/*
		int pid = Integer.parseInt(request.getParameter("pid").replace("p", ""));
		ProductVO product = (ProductVO)session.getAttribute("product");
		product.setProduct(pid-1);
		*/
		
		String pid = request.getParameter("pid");	
		String url;
		if(pid == null) {
			session.invalidate();
			url = "/jspexam/msg.jsp";
		}
		else {
			ProductVO product = (ProductVO)session.getAttribute("product");			
			if(pid.equals("p001"))
				product.setApple();
			else if(pid.equals("p002"))
				product.setBanana();
			else //pid.equals("p003")
				product.setOrange();
			
			url = "/jspexam/productView.jsp";
		}

		request.getRequestDispatcher(url).forward(request, response);
	}
}
