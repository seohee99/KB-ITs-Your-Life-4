package com.service.spring.aop.model;

import java.util.List;

public interface ReportService {
	void saveReport(String word) throws Exception; // AOP 적용
	List selectReport() throws Exception; // 랭킹순위 결과 페이지 

}
