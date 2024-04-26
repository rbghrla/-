package com.example.app.controller.product;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.productDto;
import com.example.app.domain.common.service.ProductService;
import com.example.app.domain.common.service.ProductServiceImpl;

public class ProductUpdateController implements SubController {

	private ProductService productSerivce;
	private ConnectionPool connectionPool;

	public ProductUpdateController() {
		try {
			productSerivce = ProductServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ProductUpdateController's execute() invoke");

		try {
			//
			
			
			// GET 요청
			String method = request.getMethod();
			if (method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/product/update.jsp").forward(request, response);
				return;
			}
			// POST 요청
			// 1 파라미터 받기
			String GD_CODE = request.getParameter("GD_CODE");
			String GD_NM = request.getParameter("GD_NM");
			String FMLY_PRCE = request.getParameter("FMLY_PRCE");
			String SPLY_CO_NM = request.getParameter("SPLY_CO_NM");
			String OGPL_NM = request.getParameter("OGPL_NM");

			// 2 데이터 유효성 체크
			if (!isValid(GD_NM, FMLY_PRCE, SPLY_CO_NM, OGPL_NM)) {
				return;
			}

			// 3 비즈니스 로직 처리
			productDto productDto = new productDto(Integer.parseInt(GD_CODE), GD_NM, Integer.parseInt(FMLY_PRCE),SPLY_CO_NM, OGPL_NM);

			boolean isupdated = productSerivce.productUpdate(productDto);

			// 4 뷰로 전달
			if (isupdated) {
				response.sendRedirect(request.getContextPath() + "/");
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

	private boolean isValid(String GD_NM, String FMLY_PRCE, String SPLY_CO_NM, String OGPL_NM) {
		
		if (GD_NM == null || GD_NM.isEmpty()) {
			return false;
		}
		if (FMLY_PRCE == null || FMLY_PRCE.isEmpty()) {
			return false;
		}
		if (SPLY_CO_NM == null || SPLY_CO_NM.isEmpty()) {
			return false;
		}
		if (OGPL_NM == null || OGPL_NM.isEmpty()) {
			return false;
		}

		return true;
	}

}
