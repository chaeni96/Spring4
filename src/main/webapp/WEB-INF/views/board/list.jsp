<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/boot_head.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>	
	
	<h1>${board} List Page</h1>
	
	<div class="container-fluid">
	<div class="col-md-9 my-2 mx-auto">
	<!-- Search Form -->	
		<form action="./list" method="get">
		
		 <div class="input-group mb-3" >
		  <select name="kind" class="form-select form-select-sm" aria-label=".form-select-sm example">
			  <option value="k1">Title</option>
			  <option value="k2">Contents</option>
			  <option value="k3">Writer</option>
		  </select>
		  
		  <input type="text" name="search" class="form-control" aria-label="Text input with dropdown button">
		  <button type="submit" class="btn btn-outline-secondary">Search</button>
		</div>
			
		</form>

		<!-- list table -->
			<table class="table table-hover">
				<tr class="table table-dark">
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				
				<c:forEach items="${list}" var="dto">
					<tr>
					<th scope="row">${dto.num}</th>
					<td><a href="./select?num=${dto.num}">
						<c:catch>
							<c:forEach begin="1" end="${dto.depth}">
								--
							</c:forEach>
						</c:catch>
					${dto.title}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.regDate}</td>
					<td>${dto.hits}</td>
					</tr>
				</c:forEach>
			</table>
				
			
			<!-- pageing -->
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="./list?kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    
			    <li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.startNum-1}&kind=${pager.kind }&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">&lt;</span>
			      </a>
			    </li>
			    
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
			    	<li class="page-item"><a class="page-link" href="./list?pn=${n}&kind=${pager.kind}&search=${pager.search}">${n}</a></li>
				</c:forEach>
			    
			       <li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.lastNum+1}&kind=${pager.kind }&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&gt;</span>
			      </a>
			    </li>
			    
			    <li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.totalPage}&kind=${pager.kind }&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
		
		<c:if test="${not empty member}">	
			<a href="./insert" class="btn btn-secondary">ADD</a>		
		</c:if>
			
		
		</div>
	</div>
</body>
</html>