package com.service.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

import utill.FactoryService;



public class MySawonAppTest03 {

	public static void main(String[] args) throws Exception {
		
		SqlSessionFactory factory = FactoryService.getFactory();
		// 3. Sqlsession 리턴받고
		SqlSession session = factory.openSession();
		System.out.println("SqlSession이만들어졌습니다.");
		
		// 4. selectList() 호출
		List<MySawon> list = session.selectList("SawonMapper.sawonList");
		for(MySawon vo : list) System.out.println(vo);

	}

}
