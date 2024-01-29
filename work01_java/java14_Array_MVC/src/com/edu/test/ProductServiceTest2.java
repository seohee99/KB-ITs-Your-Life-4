package com.edu.test;

import com.edu.service.ProductService;
import com.edu.vo.Product;

public class ProductServiceTest2 {

	public static void main(String[] args) {
		Product[] products = 
			{ 		new Product("신라면", 1200, 10, "농심"), 
					new Product("삼다수 생수", 1100, 2, "농심"),
					new Product("옥시크린", 33000, 1, "LG"), 
					new Product("IPhone", 1000000, 1, "애플") };
		
		// Service 클래스 객체 생성
		// ProductService 클래스의 기능들이 메모리에 올라가고 
		// 호출해서 사용
		
		ProductService service = new ProductService();
		
		System.out.println(service.getTotalPrice(products));
		Product[] temp = service.getOverPrice(products, 10000);
		for (Product p : temp) {
			if (p==null) continue;
			System.out.println(p);
		};
	}

}
