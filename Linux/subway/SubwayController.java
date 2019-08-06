package my.spring.springedu;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import dao.*;
import vo.*;

@Controller
public class SubwayController {
	@Autowired
	SubwayDAO dao;
	
	@RequestMapping("/subway")
	ModelAndView select(String linep) {
		ModelAndView mav = new ModelAndView();
		List<SubwayVO> vo = dao.select(linep);
		mav.addObject("vo", vo);
		mav.setViewName("subwayView");
		return mav;
	}
}
