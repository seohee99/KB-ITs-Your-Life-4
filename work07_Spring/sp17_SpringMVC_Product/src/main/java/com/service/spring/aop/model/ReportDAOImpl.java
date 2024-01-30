package com.service.spring.aop.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ReportDAOImpl implements ReportDAO{
	@Autowired
	private SqlSession sqlSession;
	public static final String NS = "ns.sql.ReportMapper.";
	
	@Override
	public int insertReport(String word) throws Exception {
		return (int) sqlSession.insert(NS + "insertReport", word);
	}

	@Override
	public int updateReport(String word) throws Exception {
		return (int) sqlSession.update(NS + "updateReport", word);
	}

	@Override
	public List selectReport() throws Exception {
		return sqlSession.selectList(NS + "selectReport");
	}

}
