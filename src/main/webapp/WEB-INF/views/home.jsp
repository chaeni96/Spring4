<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<c:import url="./temp/boot_head.jsp"></c:import>
	<script type="text/javascript">
		alert('Hellow world')
	</script>
</head>
<body>
	<c:import url="./temp/boot_nav.jsp"></c:import>
<h1>
	Hello Welcome!  
</h1>
	
	<script type="text/javascript">
		console.log('body Script');
	</script>

</body>
</html>
