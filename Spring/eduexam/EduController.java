package my.spring.springedu;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class EduController{
	
	@RequestMapping("edu")
	public ModelAndView edu(String name, int score) {
		ModelAndView mav = new ModelAndView();
		
		String viewName;
		if(score >= 90) 
			viewName = "gradeA";
		else if(80 <= score && score <= 89)
			viewName = "gradeB";
		else if(70 <= score && score <= 79)
			viewName = "gradeC";
		else
			viewName = "gradeD";
		
		mav.addObject("name", name);
		mav.setViewName(viewName);
		
		return mav;
	}
}
