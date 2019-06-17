package core;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/basket1")
public class BasketServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		try {
			File f = new File("C:/logtest");
			if(!f.exists())
				f.mkdir();						
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:/logtest/mylog.txt", true));
			bw.write(getCurrentTime() + " " + id);
			bw.newLine();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("application/json; charset=utf-8");
		String obj = "";
		obj = "{"
				+"\"id\"" + ":" + "\"" + id + "\""
				+"}";
		response.getWriter().print(obj);
	}
	
	String getCurrentTime() {
		return new SimpleDateFormat("yyyymmddhhmm").format(new Date(System.currentTimeMillis())); 
	}
}
