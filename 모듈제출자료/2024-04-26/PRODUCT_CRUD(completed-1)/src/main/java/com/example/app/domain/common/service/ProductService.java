package com.example.app.domain.common.service;

import java.util.Map;

import com.example.app.domain.common.dto.Criteria;
import com.example.app.domain.common.dto.productDto;

public interface ProductService {
	
	// 상품 조회
	public Map<String, Object> getAllProducts() throws Exception;
	public Map<String, Object> getAllProducts(Criteria criteria) throws Exception;
	
	// 상품 등록
	boolean productRegister(productDto dto) throws Exception;
	
	// 상품 삭제
	boolean productDelete(productDto dto) throws Exception;
	
	// 상품 정보 수정
	boolean productUpdate(productDto dto) throws Exception;
	
}
