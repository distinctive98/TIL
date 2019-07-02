package my.spring.springedu;


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
	public String handle(@ModelAttribute("product") ProductVO vo, String pid, SessionStatus s){
		
		if(pid != null) {
			int id = Integer.parseInt(pid.replace("p", ""));	
			if(id==1) vo.setApple(1);
			if(id==2) vo.setBanana(1);
			if(id==3) vo.setOrange(1);
		} else {
			s.setComplete();
			return "msg";
		}
		
		return "productView";
	}
}
