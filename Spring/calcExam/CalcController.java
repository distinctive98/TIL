package my.spring.springedu;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class CalcController {

	@RequestMapping("calc")
	public ModelAndView calc(int op1, int op2, String oper) {
		ModelAndView mav = new ModelAndView();
		
		String viewName;
		Object result;
		
		if(op2 == 0 && oper.equals("divide")) {
			viewName = "errorResult";
			result = "0을 나눌 수 없습니다!!";
		}else {
			viewName = "calcResult";
			result = getResult(op1, op2, oper);
		}
		
		mav.addObject("result", result);
		mav.setViewName(viewName);
		
		return mav;
	}
	
	int getResult(int op1, int op2, String oper){
		if(oper.equals("plus"))
			return op1+op2;
		else if(oper.equals("minus"))
			return op1-op2;
		else if(oper.equals("multiply"))
			return op1*op2;
		else
			return op1/op2;
	}
}
