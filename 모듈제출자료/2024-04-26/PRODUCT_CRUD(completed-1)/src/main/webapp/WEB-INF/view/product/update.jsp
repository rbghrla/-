<%@page import="com.example.app.domain.common.dto.productDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% String GD_CODE = request.getParameter("GD_CODE"); %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
        <form action="${pageContext.request.contextPath}/product/update" method="post">
            GD_CODE :<div><input type="number" name="GD_CODE" value ="<%=GD_CODE%>" readonly></div>
            GD_NM :<div><input type="text" name="GD_NM"></div>
            FMLY_PRCE :<div><input type="number" name="FMLY_PRCE"></div>
            SPLY_CO_NM :<div><input type="text" name="SPLY_CO_NM"></div>
            OGPL_NM :<div><input type="text" name="OGPL_NM"></div>
            <button>수정하기</button>
        </form>
    </div>
</body>
</html>