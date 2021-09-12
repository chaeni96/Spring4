<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/boot_head.jsp"></c:import>
<title>Mypage</title>
</head>
<c:import url="../temp/boot_nav.jsp"></c:import>
<body>

	<h1>My Page</h1>
	<h3>ID : ${member.id}</h3>
	<h3>Name : ${member.name }</h3>
	<h3>Email : ${member.email}</h3>
	<h3>Phone : ${member.phone}</h3>
	
	<button id="modify" class="btn btn-secondary" >정보 수정</button>
	<button id="delete" class="btn btn-danger" value="${member.id}">회원탈퇴</button>
		
	<script type="text/javascript" src="../resources/js/mypage.js"></script>
</body>
</html>