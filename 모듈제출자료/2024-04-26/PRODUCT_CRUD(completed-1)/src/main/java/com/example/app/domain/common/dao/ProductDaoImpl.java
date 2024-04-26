package com.example.app.domain.common.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.app.domain.common.dao.common.CommonDao;
import com.example.app.domain.common.dto.Criteria;
import com.example.app.domain.common.dto.productDto;

public class ProductDaoImpl extends CommonDao implements ProductDao{
	
	// 싱글톤 패턴 적용 (ProductDao 하나만 연결)
	private static ProductDao instance ;
	public static ProductDao getInstance() throws Exception {
		if(instance==null)
			instance=new ProductDaoImpl();
		return instance;
	}
	
	// ProductDao 연결 확인
	public ProductDaoImpl() throws Exception {
		System.out.println("[DAO] BookDaoImpl's INIT.." + conn);
	}
	
	// ProductDto CRUD
	// INSERT
	@Override
	public boolean Insert(productDto dto) throws Exception {
		pstmt = conn.prepareStatement("insert into product values(?,?,?,?,?)");
		pstmt.setInt(1, dto.getGD_CODE());
		pstmt.setString(2, dto.getGD_NM());
		pstmt.setInt(3, dto.getFMLY_PRCE());
		pstmt.setString(4, dto.getSPLY_CO_NM());
		pstmt.setString(5, dto.getOGPL_NM());
		int result = pstmt.executeUpdate();
		
		freeConnection(pstmt);
		return result>0;
	}
	
	// 단순 전체 개수 조회
	@Override
	public List<productDto> selectAll() throws SQLException {
		pstmt = conn.prepareStatement("select * from product order by GD_CODE desc");
		rs =  pstmt.executeQuery();
		List<productDto> list = new ArrayList();
		productDto dto = null;
		if(rs!=null)
		{
			while(rs.next()) {
				dto = new productDto();
				dto.setGD_CODE(rs.getInt("GD_CODE"));
				dto.setGD_NM(rs.getString("GD_NM"));
				dto.setFMLY_PRCE(rs.getInt("FMLY_PRCE"));
				dto.setSPLY_CO_NM(rs.getString("SPLY_CO_NM"));
				dto.setOGPL_NM(rs.getString("OGPL_NM"));
				list.add(dto);
			}
		}	
		
		freeConnection(pstmt,rs);
		return list;
	}
	
	// COUNT
	@Override
	public int Count() throws Exception {
		//DB에 저장된 전체 도서 개수 조회
		pstmt = conn.prepareStatement("select count(*) from product");
		rs =  pstmt.executeQuery();
		
		int cnt = 0;
		if(rs.next())
		{
			cnt = rs.getInt(1);
		}	
		
		freeConnection(pstmt,rs);
		return cnt;
	}
	
	// PAGE SELECT (페이지 조회)
	public List<productDto> selectAll(int offset, int amount) throws Exception {
		pstmt = conn.prepareStatement("select * from product order by GD_Code desc limit ?,?");
		pstmt.setInt(1, offset);
		pstmt.setInt(2, amount);
		rs =  pstmt.executeQuery();
		List<productDto> list = new ArrayList();
		productDto dto = null;
		if(rs!=null)
		{
			while(rs.next()) {
				dto = new productDto();
				dto.setGD_CODE(rs.getInt("GD_CODE"));
				dto.setGD_NM(rs.getString("GD_NM"));
				dto.setFMLY_PRCE(rs.getInt("FMLY_PRCE"));
				dto.setSPLY_CO_NM(rs.getString("SPLY_CO_NM"));
				dto.setOGPL_NM(rs.getString("OGPL_NM"));
				list.add(dto);
			}
		}	
		
		freeConnection(pstmt,rs);
		return list;
	}
	
	public int Count(Criteria criteria) throws Exception{
		pstmt = conn.prepareStatement("select count(*) from product where " + criteria.getType() + " like '%" + criteria.getKeyword() + "%'");
		rs =  pstmt.executeQuery();
		
		int cnt = 0;
		if(rs.next())
		{
			cnt = rs.getInt(1);
		}	
		
		freeConnection(pstmt,rs);
		return cnt;
	}

	// KEYWORD SELECT (키워드 조회)
	@Override
	public List<productDto> selectAll(int offset, int amount, Criteria criteria) throws Exception {
		pstmt = conn.prepareStatement("select * from product where " + criteria.getType() + " like '%"+ criteria.getKeyword()+ "%' order by GD_Code desc limit ?,?");
		pstmt.setInt(1, offset);
		pstmt.setInt(2, amount);
		rs =  pstmt.executeQuery();
		List<productDto> list = new ArrayList();
		productDto dto = null;
		if(rs!=null)
		{
			while(rs.next()) {
				dto = new productDto();
				dto.setGD_CODE(rs.getInt("GD_CODE"));
				dto.setGD_NM(rs.getString("GD_NM"));
				dto.setFMLY_PRCE(rs.getInt("FMLY_PRCE"));
				dto.setSPLY_CO_NM(rs.getString("SPLY_CO_NM"));
				dto.setOGPL_NM(rs.getString("OGPL_NM"));
				list.add(dto);
			}
		}	
		
		
		freeConnection(pstmt,rs);
		return list;
	}

	// DELETE
	public boolean Delete(productDto dto) throws Exception{

		pstmt = conn.prepareStatement("delete from product where GD_CODE=?");
		pstmt.setInt(1, dto.getGD_CODE());
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		System.out.println("delete started...");
		return result>0;
	}
	
	// UPDATE
	@Override
	public boolean Update(productDto dto) throws Exception {
		
		pstmt = conn.prepareStatement("update product set GD_NM=?, FMLY_PRCE=?, SPLY_CO_NM=?, OGPL_NM=? where GD_CODE=?");
		pstmt.setString(1, dto.getGD_NM());
		pstmt.setInt(2, dto.getFMLY_PRCE());
		pstmt.setString(3, dto.getSPLY_CO_NM());
		pstmt.setString(4, dto.getOGPL_NM());
		pstmt.setInt(5, dto.getGD_CODE());
		
		int result = pstmt.executeUpdate();
		pstmt.close();
		System.out.println("update successed");
		
		freeConnection(pstmt);
		return result > 0;
	}



}
