package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FrontController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 1. 폼값받아서
		 * 2. VO 생성
		 * 3. DAO 리턴 받고...비즈니스 로직 호출
		 * 4. 반환값 바인딩
		 * 5. 네비게이션
		 * 
		 * 1-4번 했다 치고 5번만 구현!
		 * String 리턴 -> ModelAndView 객체 생성해서 리턴
		 */
		
		return new ModelAndView("result", "message", "Hello First Spring MVC Framework"); // ${message}(EL기법)으로 찾아오면 저장된 값을 찾아온다
	}

}
