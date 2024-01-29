package com.edu.service;

import com.edu.vo.Product;

// Product들을 관리하는 기능만으로 구성된 서비스 클래스...
// 메소드 identifier / return type, 인자값

// ** "메소드" 하나당 완벽한 service 1개 **
public class ProductService {
	// 1. 배열 안에 있는 모든 상품들의 메이커를 출력하는 기능 -> 모든 : all / s 
	public void printAllProductMaker(Product[] product) { // 인자가 없으면 Hasing 관계 성립 X
		for (Product p : product) {
			System.out.println(p.getMaker());
		};
	}
	
	// 2. 상품들의 총 구입액을 리턴하는 기능
	// 코드의 명료성
	public int getTotalPrice(Product[] product) {
		// 로컬 변수 먼저 선언하고 구현
		int total = 0;
		for (Product p : product) {
			total += p.getPrice() * p.getQuantity();
		};
		return total;
	}
	
	// 3. 특정 금액 이상의 상품을 리턴하는 기능
	public Product[] getOverPrice(Product[] product, int price) {
		Product[] temp = new Product[product.length]; // 이때 사이즈는 최대치로 잡아놓을것
		int index = 0;
		for (Product p : product) {
			if(p.getPrice() >= price) {
				temp[index ++] = p; // index++을 안에 넣어버리자
			}
		};
		
		return temp;
	}
	
	// 4. 동일한 회사의 제품들만 리턴하는 기능
	public Product[] getCertainCompany(Product[] product, String company) {
		Product[] temp = new Product[product.length]; 
		return temp;
	}
	
	
	// 5. 구입한 상품들의 평균 가격을 리턴하는 기능
	// 자주 쓰이는 건 미리 재정의(getTotalPrice)
	public int getAvgPrice(Product[] product) {		
		return getTotalPrice(product) / product.length;
	}
}
