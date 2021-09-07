
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
	
	<div>
	<h1>${board} Select Homepage</h1>
	
		<h3>NUM : ${dto.num}</h3>
		<h3>Title : ${dto.title}</h3>
		<h3>Contents : ${dto.contents}</h3>
		<h3>WRITE : ${dto.writer}</h3>
		<h3>REGDATE : ${dto.regDate}</h3>
		<h3>HITS : ${dto.hits}</h3>
		
		<!-- 게시글 삭제 page 이동 -->
		<a href="./update?num=${dto.num}" class="btn btn-primary">Update</a>
		<a href="./delete?num=${dto.num}" class="btn btn-danger">Delete</a>
		
		<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}" class="btn btn-warning">Reply</a>
		</c:if>
	
	</div>


</body>

</html>