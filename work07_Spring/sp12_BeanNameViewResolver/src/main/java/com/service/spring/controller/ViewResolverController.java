package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewResolverController {
	// Service wired...
	@RequestMapping("findBoard.do")
	public String findBoard() {
		System.out.println("Service call...데이터 리턴...바인딩...1");
		return "board_result"; // 위치 정보, 확장자...ViewResolver
	}
	
	@RequestMapping("findProduct.do")
	public String findProduct() {
		System.out.println("Service call...데이터 리턴...바인딩...2");
		return "product_result";
	}
	
	@RequestMapping("register.do")
	public String register() {
		System.out.println("Service call...데이터 리턴...바인딩...3");
		return "register_result";
	}
}
