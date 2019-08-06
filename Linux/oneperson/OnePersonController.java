package my.spring.springedu;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import dao.*;
import vo.*;

@Controller
public class OnePersonController {
	@Autowired
	OnePersonDAO dao;
	
	@RequestMapping("/one")
	String getView() {
		return "OnePersonView";
	}
	
	@RequestMapping("/one/select")
	ModelAndView select(String num) {
		ModelAndView mav = new ModelAndView();
		List<OnePersonVO> list = null;
				
		if(num.equals("1")) {
			list = dao.select1();
			mav.addObject("select1", list);
		} else if(num.equals("2")) {
			list = dao.select2();
			mav.addObject("select2", list);
		} else if(num.equals("3")) {
			list = dao.select3();
			mav.addObject("select3", list);
		} else {
			list = dao.select4();
			mav.addObject("select4", list);
		}
		 
		mav.setViewName("OnePersonView");
		return mav;
	}
	
	@RequestMapping("/one/search")
	ModelAndView search(String area) {
		ModelAndView mav = new ModelAndView();
		List<OnePersonVO> list = dao.search(area);
		mav.addObject("search", list);
		mav.setViewName("OnePersonView");
		return mav;
	}
}
