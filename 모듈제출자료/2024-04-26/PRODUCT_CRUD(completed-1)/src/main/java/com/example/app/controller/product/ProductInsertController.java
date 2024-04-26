package com.example.app.controller.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.productDto;
import com.example.app.domain.common.service.ProductService;
import com.example.app.domain.common.service.ProductServiceImpl;

public class ProductInsertController implements SubController{

	private ProductService productService;
	private ConnectionPool connectionPool;
	
	public ProductInsertController() {
		try {
			productService = ProductServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("productInsertController's execute() invoke..");
		
		try {
			//Get 요청
			String method = request.getMethod();
			if(method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/product/add.jsp").forward(request, response);
				return;
			}
			
			//Post 요청(etc Method)
			//1
			String GD_CODE = request.getParameter("GD_CODE");
			String GD_NM = request.getParameter("GD_NM");
			String FMLY_PRCE = request.getParameter("FMLY_PRCE");
			String SPLY_CO_NM = request.getParameter("SPLY_CO_NM");
			String OGPL_NM = request.getParameter("OGPL_NM");
			
			
			//2 유효성체크
			
			//3 서비스 실행
			productDto productDto = new productDto(Integer.parseInt(GD_CODE), GD_NM, Integer.parseInt(FMLY_PRCE), SPLY_CO_NM, OGPL_NM);
			boolean isadded = productService.productRegister(productDto);
			
			
			
			//뷰
			if(isadded) {
				response.sendRedirect(request.getContextPath()+"/");
				//request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);	
				
			}else {
				request.getRequestDispatcher("/WEB-INF/view/product/add.jsp").forward(request, response);
			}
			
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				connectionPool.txRollBack();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		
		
	}
	
	

}
