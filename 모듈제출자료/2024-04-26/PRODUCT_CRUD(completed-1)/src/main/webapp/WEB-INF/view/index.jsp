<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


</head>
<body>
    <div class="product_info" style="">
       <main class=layout-150>

            <h1>PRODUCT LIST</h1>
            
            <section class="search-block">
            	<form action="${pageContext.request.contextPath}/">          		
            		<div class="m-2">
	            		<select name="type" id="" class="form-select">
	            			<option value="GD_CODE" selected>상품코드</option>
	            			<option value="GD_NM">상품명</option>
	            			<option value="FMLY_PRCE">가격</option>
	            			<option value="SPLY_CO_NM">공급업체</option>
	            			<option value="OGPL_NM">원산지</option>
	            		</select>
            		</div>
            		<div class="m-2">
            			<input name="keyword" placeholder="KEYWORD" class="form-control">
            		</div>	
            		<div class="m-2">
            			<input type="hidden" name="pageNo" value="${pageDto.criteria.pageno}">
            		</div>
            		<div class="m-2">
            			<button class="btn btn-secondary">조회</button>
            			<button type="button" onclick="location.href='${pageContext.request.contextPath}/product/insert'"> 등록
            			<%-- <a href="${pageContext.request.contextPath}/product/insert">등록</a> --%>
            			</button>
            		</div>
            	</form>
            </section>

            <section>
            	<%-- ${pageDto} --%>
         		<div>
            		<div>전체 게시물 개수 : <span> ${count}</span> </div>            		  
            		<div>전체 페이지 개수: <span>${pageDto.totalpage}</span> </div>
            		<div>전체 페이징 블럭 개수: <span>${pageDto.totalBlock}</span> </div>
            		<div>현재 페이징 블럭 번호: <span>${pageDto.nowBlock}</span> </div>
            		<div>현재 페이지 번호: <span>${pageDto.criteria.pageno}</span> </div>
            	</div> 
            </section>
            
            <section class="show-block p-3">
            	<table class=table>
            		<tr>
            			<td>상품코드</td>
            			<td>상품명</td>
            			<td>가격</td>
            			<td>공급업체</td>
            			<td>원산지</td>
            		</tr>
					<c:forEach var="productDto" items="${list}"  varStatus="status">
		            	<tr>	
							<td>${productDto.GD_CODE}</td>
							<td>${productDto.GD_NM}</td>
							<td>${productDto.FMLY_PRCE}</td>
							<td>${productDto.SPLY_CO_NM}</td>
							<td>${productDto.OGPL_NM}</td>
							<td><a href="${pageContext.request.contextPath}/product/delete?GD_CODE=${productDto.GD_CODE}">삭제</a></td>
							<td><a href="${pageContext.request.contextPath}/product/update?GD_CODE=${productDto.GD_CODE}">수정</a></td>
						</tr>																										
					</c:forEach>
            	</table>      
            </section>
            
            <!-- paging -->
            <section>
            	<nav aria-label="Page navigation example">
				  <ul class="pagination">
				    <!-- prev -->
				    <c:if test="${pageDto.prev}">
					    <li class="page-item">
						   <a class="page-link" href="${pageContext.request.contextPath}/?pageNo=${pageDto.nowBlock*pageDto.pagePerBlock-pageDto.pagePerBlock*2+1}&type=${pageDto.criteria.type}&keyword=${pageDto.criteria.keyword}" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						   </a>
						</li>
				    </c:if>
				    
				    
				    <!-- paging -->
				    <!-- step 값만큼 증가한 값을 pageNo로 넘겨줌 -->
				    <c:forEach var="pageNo" begin="${pageDto.startPage}" end="${pageDto.endPage}" step="1">
				    	<li class="page-item">
				    		<a class="page-link" href="${pageContext.request.contextPath}/?pageNo=${pageNo}&type=${pageDto.criteria.type}&keyword=${pageDto.criteria.keyword}">${pageNo}</a>
				    	</li>
				    </c:forEach>
					
				    
				    <!-- next -->
				    <c:if test="${pageDto.next}">
					    <li class="page-item">
					    	<a class="page-link" href="${pageContext.request.contextPath}/?pageNo=${pageDto.nowBlock*pageDto.pagePerBlock+1}&type=${pageDto.criteria.type}&keyword=${pageDto.criteria.keyword}" aria-label="Next">
				        		<span aria-hidden="true">&raquo;</span>
					      	</a>
						</li>
				    </c:if>
				  </ul>
				</nav>
            </section>
            
        </main>

    </div>
</body>
</html>