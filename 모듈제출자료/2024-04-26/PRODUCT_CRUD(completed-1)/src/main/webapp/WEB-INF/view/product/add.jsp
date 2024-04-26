<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
        <form action="${pageContext.request.contextPath}/product/insert" method="post">
            GD_CODE :<div><input type="text" name="GD_CODE"></div>
            GD_NM :<div><input type="text" name="GD_NM"></div>
            FMLY_PRCE :<div><input type="text" name="FMLY_PRCE"></div>
            SPLY_CO_NM :<div><input type="text" name="SPLY_CO_NM"></div>
            OGPL_NM :<div><input type="text" name="OGPL_NM"></div>
            <button>등록하기</button>
        </form>
    </div>
</body>
</html>