package com.example.app.controller.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.Criteria;
import com.example.app.domain.common.service.ProductService;
import com.example.app.domain.common.service.ProductServiceImpl;

public class ProductListController implements SubController{
	
	private ProductService productService;
	private ConnectionPool connectionPool;
	
	public ProductListController() {
		try {
			productService = ProductServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("ProductListController's execute() invoke");
//		
//		try {
//			//전체 갯수 조회
//			String method = request.getMethod();
//			
//			if(method.contains("GET")) {
//				//GET 요청이 들어오면 POST 방식으로 처리하는 add.jsp로 포워딩
//				Map<String, Object> resultValue = productService.getAllBooks();
//				System.out.println(resultValue);
//				return;
//			}
//			
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//			//예외페이지로 넘기기 or new ServletException("message") 처리
//		}
//	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ProductListController's execute() invoke");	
		
		try {
			String type = request.getParameter("type");
			String keyword = request.getParameter("keyword");
			String pageNo = request.getParameter("pageNo");
			
			Criteria criteria = null;
			if(pageNo == null) {
				//전달된 파라미터가 없다면 - 키워드 검색 X, 단순 조회
				criteria = new Criteria(); //default -> pageno = 1 , amount = 10
			} else {
				if(type==null||keyword==null||type.isEmpty()||keyword.isEmpty()) {
					criteria = new Criteria(Integer.parseInt(pageNo), 10);					
				} else {
					criteria = new Criteria(Integer.parseInt(pageNo), 10, type, keyword);
				}
			}
			
			//2 유효성 체크
			//생략
			
			//3 게시물 건수 가져오기
			Map<String, Object> resultValue = productService.getAllProducts(criteria);
			
			//4 넘겨주기
			request.setAttribute("list", resultValue.get("list"));
			request.setAttribute("pageDto", resultValue.get("pageDto"));
			request.setAttribute("count", resultValue.get("count"));
			
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);	
			
		} catch(Exception e) {
			e.printStackTrace();
			//예외페이지로 넘기기 or new ServletException("message") 처리
		}
	}

}
