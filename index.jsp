<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="product_info" style="">
        <table style="border: 1px solid;">   
        <tr>
            <td>GD_CODE</td>
            <td>GD_NM</td>
            <td>FMLY_PRCE</td>
            <td>SPLY_CO_NM</td>
            <td>OGPL_NM</td>
        </tr>
       <c:forEach var="productDto" items="${ㅋㅋ}" varStatus = "status">
	        <tr>
	            <td>${GD_CODE}</td>
	            <td>${GD_NM}</td>
	            <td>${FMLY_PRCE}</td>
	            <td>${SPLY_CO_NM}</td>
	            <td>${OGPL_NM}</td>
	            <td><button>삭제</button></td>    
	            <td><a>수정</a></td>    
	        </tr>
        </c:forEach>

    </table>
    </div>
</body>
</html>