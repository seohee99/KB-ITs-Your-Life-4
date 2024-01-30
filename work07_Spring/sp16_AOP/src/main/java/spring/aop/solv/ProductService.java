package spring.aop.solv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductService {

    public String deleteProduct(String id) {
        System.out.println(id+" :: deleteProduct..logic..삭제 성공"); // core

        return "삭제된 상품 ID :"+id;
    }

}
