package edu.spring.redu;

import java.io.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import service.*;

@Controller
public class OnePersonController {
	@Autowired
	OnePersonService service;
	
	@RequestMapping("/map7")
	public ModelAndView map7(HttpServletRequest req, String gu) {
		ModelAndView mav = new ModelAndView();
		String real_path = req.getSession().getServletContext().getRealPath("/");
		//System.out.println(real_path);
	    real_path = real_path.replace("\\", "/");
	    System.out.println(real_path);		
		File f = new File(real_path+"/resources/map7");
		if(!f.exists()) f.mkdir();
		String result = service.returnLeaflet(real_path+"/resources/map7", gu);
		mav.addObject("leafletChartName", "http://localhost:8000/redu/resources/map7/"+result);
		mav.setViewName("oneView");
		return mav;
	}	
	
}
