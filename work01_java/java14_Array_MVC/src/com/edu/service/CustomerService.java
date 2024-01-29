package com.edu.service;
/*
 * Outlet에서 상품을 구매하는 고객에 대한 기능을 다루는 서비스 클래스
 * 기능들만 정의되어져 있다
 * 하나의 기능은 독자적인 완벽한 서비스로 이해하자.
 * 
 * Method Overloading **
 *  - 하나의 클래스에서 하는 일은 같지만 처리하는 데이터를 달리할 때 쓰는 기법
	- 메소드 이름은 같지만 args 값 다름
	1. 메소드 이름은 일치
	2. args list는 달라야 함
	3. return 타입은 상관 없다!!
 */

import com.edu.vo.Customer;
import com.edu.vo.Product;

public class CustomerService {
	
	// 1. 특정 고객이 구입한 상품을 리턴하는 기능
	public Product[] getProducts(Customer c) {
		return c.getProducts();
		
	}
	
	// 2. 특정 고객이 구입한 상품들의 메이커들만 리턴
	public String[] getAllProductMaker(Customer c) {
		String[] temp = new String[c.getProducts().length];
		
		int i = 0;
		for (Product p : c.getProducts()) {
			temp[i++] = p.getMaker();
		}
		return temp;
	}
	
	// 3. 모든 고객 중에서 특정한 고객을 검색 -> find~ / search~
	public Customer findCustomer(Customer[] cust, int ssn) {
		Customer customer = null;
		for (Customer c:cust) {
			if (c.getSsn() == ssn) {
				customer = c;
			}
		}
		return customer;
	}
	
	// 4. 모든 고객 중에서 특정한 동네에 사는 고객을 검색 
	// overloading, 함수 이름은 같지만 args 값 다름***
	public Customer[] findCustomer(Customer[] custs, String address) {
		Customer[] temp = new Customer[custs.length];
		return temp;
	}
	
	// 5. 모든 고객 중에서 ...

}
