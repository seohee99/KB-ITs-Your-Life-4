package com.service.spring.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.domain.Phone;
import com.service.spring.model.PhoneService;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@RestController
public class PhoneRestController {
	@Autowired
	private PhoneService phoneService;
	
	// 모든 폰을 가져오는 요청
	@GetMapping("/phone")
	public ResponseEntity select() {
		try {
			List<Phone> selected = phoneService.select();
			
			return new ResponseEntity(selected, HttpStatus.OK); // ResponseEntity : 데이터 집어넣고 성공 여부도 함께 넣을 수 있음
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	// 특정 폰을 가져오는 요청
	/*
	 * 특정한 파라미터 값을 {num} 형태로 작성해야한다
	 * @PathVariable 어노테이션으로 가져올 파라미터 값을 받아간다 
	 */
	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num) {
		try {
			Phone phone = new Phone();
			phone.setNum(num);
			Phone selected = phoneService.select(phone);
			
			return new ResponseEntity(selected, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	// 특정 폰을 추가하는 요청
	/*
	 * GET 요청에서는 추가되는 객체를 받을 때 @RequestParam을 사용한다
	 * POST 요청에서는 추가되는 객체를 받을 때 @RequestBody을 사용한다
	 */
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) {
		try {
			phoneService.insert(phone);
			return new ResponseEntity(HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	// 특정폰 혹은 여러개의 폼을 삭제하는 요청..특정폰
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		try {
			int result = phoneService.delete(Arrays.asList(num));
			return new ResponseEntity(HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	// 특정 폰을 수정하는 요청..throws Exception 사용
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) throws Exception{
		int result = phoneService.update(phone);
		
		if(result > 0) return new ResponseEntity(HttpStatus.OK); 
		else return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
