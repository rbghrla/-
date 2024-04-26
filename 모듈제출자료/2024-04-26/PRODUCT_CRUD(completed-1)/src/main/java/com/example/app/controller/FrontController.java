package com.example.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.product.ProductDeleteController;
import com.example.app.controller.product.ProductInsertController;
import com.example.app.controller.product.ProductListController;
import com.example.app.controller.product.ProductUpdateController;

	public class FrontController extends HttpServlet{
		
		private Map<String, SubController> map;
		
		@Override
		public void init(ServletConfig config) throws ServletException {
			System.out.println("FrontController's init() invoke..");
			
			map = new HashMap();
			
			String path = config.getServletContext().getContextPath();
			// '/'
			map.put(path+ "/", new ProductListController());
			
			// porduct 경로
			map.put(path + "/product/insert", new ProductInsertController());	// 상품 등록 경로
			map.put(path + "/product/delete", new ProductDeleteController());	// 상품 삭제 경로
			map.put(path + "/product/update", new ProductUpdateController());	// 상품 수정 경로
		}

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String uri = request.getRequestURI();
			System.out.println("FrontController's service() invoke.." + uri);
			
			SubController controller = map.get(uri);
			if (controller == null) {
				throw new ServletException("해당 페이지는 존재하지 않습니다..");
			}
			try {
				controller.execute(request, response);
				System.out.println("오류 안생김");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
}
