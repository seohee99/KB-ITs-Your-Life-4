package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.Item;

public interface ItemCatalog {
	List<Item> getListItem() throws Exception;
	Item getItem(Integer itemid) throws Exception;
}
