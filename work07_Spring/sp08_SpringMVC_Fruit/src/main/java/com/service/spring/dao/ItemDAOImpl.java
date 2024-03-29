package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Item;

@Repository("itemDAOImpl")
public class ItemDAOImpl implements ItemDAO{
	@Autowired
	private SqlSession sqlSession;
	public static final String NS = "ns.sql.ItemMapper.";

	@Override
	public List<Item> getListItem() throws Exception {
		return sqlSession.selectList(NS + "getListItem");
	}

	@Override
	public Item getItem(Integer itemid) throws Exception {
		return sqlSession.selectOne(NS + "getItem",itemid);
	}

}
