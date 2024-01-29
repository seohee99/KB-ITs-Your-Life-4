package com.card.dao;

import com.card.vo.Card;
import com.card.vo.Cust;

public interface CustDAO {
	void registerInfo(Cust customer);
	void registerInfo(Card card);
	
	void deleteInfo(Cust customer);
	void deleteInfo(Card card);
	
	void updateAddress(String address);
	void updatePhonenumber(String phonenumber);
}
