package com.edu.test;

import com.edu.vo.Product;

public class ProductArrayTest1 {

	public static void main(String[] args) {
		// Homogeneous Collection(same data type)
		Product[] products = {
				new Product("신라면", 1200, 10, "농심"),
				new Product("삼다수 생수", 1100, 2, "농심"),
				new Product("옥시크린", 33000, 1, "LG"),
				new Product("IPhone", 1000000, 1, "애플")
		};
		// 기능들로만 구성된 클래스 : Service Class, Manage Class
		System.out.println("==============1. 상품들의 Maker만 출력합니다=================");
		for(Product p : products) {
			System.out.println(p.getMaker());
		}
		
		System.out.println("==============2. 10만원 이상의 고가 제품 정보를 출력합니다=================");
		for(Product p : products) {
			if (p.getPrice() >= 100000) System.out.println(p.getPrice());
		}	
				
		System.out.println("==============3. 구매한 상품의 총합을 출력=================");
		int sum = 0;
		for(Product p : products) {
			sum += p.getPrice() * p.getQuantity();
		}	
		System.out.println("총합 : " + sum);
		

	}

}
