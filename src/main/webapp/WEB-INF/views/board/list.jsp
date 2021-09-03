<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/boot_head.jsp"></c:import>
<title>Notice List</title>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>

	<h1>Notice list</h1>
	
	<div class="container-fluid">
		<div class="col-md-9 my-2 mx-auto">
			<table class="table table-hover">
				<tr class="table table-dark">
					<th>번호</th><th>제목</th><th>내용</th><th>작성자</th><th>작성일</th><th>조회수</th>
				</tr>
				
				<c:forEach items="${list}" var="dto">
					<tr>
					<td>${dto.num}</td>
					<td><a href="./select?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.contents}</td>
					<td>${dto.writer}</td>
					<td>${dto.regDate}</td>
					<td>${dto.hits}</td>
					</tr>
				
				
				</c:forEach>
			</table>
		
		</div>
	
	</div>

</body>
</html>