<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Notice Select Page</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>


<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>Select Page</h1>
	
	<div class="container-fluid">
		<h3>NUM : ${dto.num}</h3>
		<h3>Title : ${dto.title}</h3>
		<h3>Contents : ${dto.contents}</h3>
		<h3>WRITE : ${dto.write}</h3>
		<h3>REGDATE : ${dto.regDate}</h3>
		<h3>HITS : ${dto.hits}</h3>
	
	</div>
</body>
</html>