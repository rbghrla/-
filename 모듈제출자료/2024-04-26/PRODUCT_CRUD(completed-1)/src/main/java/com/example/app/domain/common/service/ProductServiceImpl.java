package com.example.app.domain.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.app.domain.common.dao.ProductDao;
import com.example.app.domain.common.dao.ProductDaoImpl;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.Criteria;
import com.example.app.domain.common.dto.PageDto;
import com.example.app.domain.common.dto.productDto;

public class ProductServiceImpl implements ProductService{
	private ProductDao dao;
	private ConnectionPool connectionPool;
	
	private static ProductService instance ;
	public static ProductService getInstance() throws Exception {
		if(instance==null)
			instance=new ProductServiceImpl();
		return instance;
	}
	
	private ProductServiceImpl() throws Exception{
		dao = ProductDaoImpl.getInstance();
		this.connectionPool = ConnectionPool.getInstance();
	}
	
	// 상품 조회
	@Override
	public Map<String, Object> getAllProducts() throws Exception {
		//TX 처리
		connectionPool.txStart();			
		
		Map<String, Object> resultValue = new HashMap();
		
		//키워드가 없는 경우
		int cnt = dao.Count();
		System.out.println("total count : " + cnt);
		
//		List<productDto> list = dao.selectAll();
//		System.out.println("list : " + list);
//
//		resultValue.put("list", list);			//해당 페이지에 표시할 게시물들
		resultValue.put("count", cnt); 			//전체 게시물 건수
			

		connectionPool.txCommit();
		return resultValue;
	}
	
	@Override
	public Map<String, Object> getAllProducts(Criteria criteria) throws Exception {
		
		//TX 처리
		connectionPool.txStart();			
		
		Map<String, Object> resultValue = new HashMap();
		
		if(criteria.getType()==null || criteria.getKeyword()==null) {
			//키워드가 없는 경우
			int cnt = dao.Count();
			System.out.println("total count : " + cnt);
			PageDto pageDto = new PageDto(cnt, criteria);
			System.out.println(pageDto);
			
			System.out.println(1);
			int offset = (criteria.getPageno() - 1)*criteria.getAmount(); //offset 상댓값
			//표시할 도서 인덱스 - 해당 페이지의 첫 번째 도서
			System.out.println(2);
			List<productDto> list = dao.selectAll(offset, criteria.getAmount());
			System.out.println(3);
			System.out.println("list : " + list);
			
			resultValue.put("pageDto", pageDto);	//페이징처리에 필요한 요소들
			resultValue.put("list", list);			//해당 페이지에 표시할 게시물들
			resultValue.put("count", cnt); 			//전체 게시물 건수
			
		} else {
			//키워드가 있는 경우
			int cnt = dao.Count(criteria);
			System.out.println("total count : " + cnt);
			PageDto pageDto = new PageDto(cnt, criteria);
			System.out.println(pageDto);
			
			int offset = (criteria.getPageno() - 1)*criteria.getAmount(); //offset 상댓값
			List<productDto> list = dao.selectAll(offset, criteria.getAmount(), criteria);
			System.out.println("list : " + list);
			
			resultValue.put("pageDto", pageDto);	//페이징처리에 필요한 요소들
			resultValue.put("list", list);			//해당 페이지에 표시할 게시물들
			resultValue.put("count", cnt); 			//전체 게시물 건수
			
		}
		connectionPool.txCommit();
		return resultValue;
	}

	
	// 상품 등록
	@Override
	public boolean productRegister(productDto dto) throws Exception{
		
		connectionPool.txStart();
		boolean result = dao.Insert(dto);
		connectionPool.txCommit();
		
		return result;
	}
	
	// 상품 삭제
	@Override
	public boolean productDelete(productDto dto) throws Exception{
		
		connectionPool.txStart();
		System.out.println("delete SERVICE invoked,,");
		boolean result = dao.Delete(dto);
		connectionPool.txCommit();
		
		return result;
	}
	
	// 상품 정보 수정	
	@Override
	public boolean productUpdate(productDto dto) throws Exception {
		
		// TX
		connectionPool.txStart();
		boolean result = dao.Update(dto);
		connectionPool.txCommit();
		
		return result;
	}
}
