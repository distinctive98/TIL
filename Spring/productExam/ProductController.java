package my.spring.springedu;


import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.*;

import vo.*;

@Controller
@SessionAttributes("product")
public class ProductController{

	@ModelAttribute("product")
	public ProductVO createProductModel() {
		return new ProductVO();
	}
	
	@RequestMapping(value="/product")
	public String handle(@ModelAttribute("product") ProductVO vo, String pid){
		
		if(pid != null) {
			int id = Integer.parseInt(pid.replace("p", ""));	
			if(id==1) vo.setApple(1);
			if(id==2) vo.setBanana(1);
			if(id==3) vo.setOrange(1);
		}
		
		return "productView";
	}
	
	@RequestMapping(value="/product/msg", produces="application/json; charset=utf-8")
	@ResponseBody
	public HashMap<String, String> msgHandle(SessionStatus s) {
		s.setComplete();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("msg", "장바구니가 비워졌어요!");
		return map;
	}
}
