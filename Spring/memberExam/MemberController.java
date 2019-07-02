package my.spring.springedu;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import vo.*;

@Controller
public class MemberController {

	@RequestMapping(value="member", method=RequestMethod.POST)
	public String memberHandler(@ModelAttribute("info") MemberVO vo) {
		
		if(vo.getName().equals("")) vo.setName("없음");
		if(vo.getNumber().equals("")) vo.setNumber("없음");
		if(vo.getAccount().equals("")) vo.setAccount("없음");
		if(vo.getPassword().equals("")) vo.setPassword("없음");
		
		return "memberView";
	}
}
