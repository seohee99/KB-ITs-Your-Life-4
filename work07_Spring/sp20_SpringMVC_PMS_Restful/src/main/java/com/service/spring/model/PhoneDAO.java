package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

public interface PhoneDAO {
	
	int insert(Phone phone);
	int delete(List<String> list);
	Phone select(Phone phone);
	//Phone select(String num);	
	List<Phone> select();
	UserInfo select(UserInfo user);
	
	// 추가
	int update(Phone phone);
}
