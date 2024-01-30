package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Person;

@Controller
public class AjaxController {
	
	//@Autowired ... service 생략
	
	@RequestMapping("/") // http://12.0.0.1:8888/spring/
	public String index() {
		System.out.println("context path request calling....");
		return "redirect:index.jsp";
	}
	
	@RequestMapping("synchro")
	public String synchro(Model model) {
		System.out.println("synchro request..");
		//servletreaquest에 자동 바인딩... forward 방식으로 
		model.addAttribute("info","와동통");
		return "synchro_result";
	}
	
	@RequestMapping("asynch")
	public String asynch(Model model) {
	    System.out.println("asynch request..");
	    model.addAttribute("person" , new Person("김국민","역삼동"));
	    
	    return "JsonView"; //여기선 InternalResourceViewResolver방식이 안통한다.
	}
}
