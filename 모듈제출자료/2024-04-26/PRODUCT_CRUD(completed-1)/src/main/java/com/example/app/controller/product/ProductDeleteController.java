package com.example.app.controller.product;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.productDto;
import com.example.app.domain.common.service.ProductService;
import com.example.app.domain.common.service.ProductServiceImpl;

public class ProductDeleteController implements SubController {

	private ProductService productService;
	private ConnectionPool connectionPool;
	
	public ProductDeleteController() {
		try {
			productService = ProductServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 {
				System.out.println("productDeleteController's execute() invoke..");
				
				
					//Get 요청
					String method = request.getMethod();
					


					
					//Post 요청(etc Method)
					//1
					String GD_CODE = request.getParameter("GD_CODE");
					
					
					//2 유효성체크
					
					//3 서비스 실행
					
					productDto productDto = new productDto(Integer.parseInt(GD_CODE));
					System.out.println(productDto.getGD_CODE());
					boolean isDeleted = productService.productDelete(productDto);
					System.out.println("isDeleted"  + isDeleted);
					
					//뷰
					if(isDeleted) {
						response.sendRedirect(request.getContextPath()+"/");
						//request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);	
						
					}else {
						request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
					}
					

				
				
				}
				
				
			}
			
	}

