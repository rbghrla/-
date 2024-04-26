package com.example.app.domain.common.dao;

import java.util.List;

import com.example.app.domain.common.dto.Criteria;
import com.example.app.domain.common.dto.productDto;


public interface ProductDao {
	
	// ProductDto CRUD
	//Insert
	boolean Insert(productDto dto) throws Exception;
	
	// SELECTALL
	List<productDto> selectAll() throws Exception;
	int Count() throws Exception;
	
	List<productDto> selectAll(int offset, int amount) throws Exception;
	int Count(Criteria criteria) throws Exception;
	
	List<productDto> selectAll(int offset, int amount, Criteria criteria) throws Exception;
	
	// DELETE
	boolean Delete(productDto dto) throws Exception;
	
	// UPDATE
	boolean Update(productDto dto) throws Exception;
	
}
