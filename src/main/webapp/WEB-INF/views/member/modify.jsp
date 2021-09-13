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
	
	<div class="container-fluid">
		<form id="frm" class="col-md-5 mx-auto" action="modify" method="POST">
			
			<div class="mb-3">
				<label for="id" class="form-label">ID</label> 
				<input type="text" class="form-control my" name="id" id="id" value="${member.id}" readonly="readonly">
			</div>
			
			
			<div class="mb-3">
				<label for="pw" class="form-label">PassWord</label> 
				<input type="password" class="form-control my pws" name="pw" id="pw1" placeholder="Enter password">
			</div>
			
			<div class="mb-3">
				<label for="pw2" class="form-label">PassWord 확인</label> 
				<input type="password" class="form-control my pws"  id="pw2" placeholder="Enter password again">
				<div id="pwCheck" style="color:red;"></div>
			</div>
			
			
			<div class="mb-3">
				<label for="name" class="form-label">Name</label> 
				<input type="text" class="form-control my" name="name" id="name" readonly="readonly" placeholder="Enter name" value="${member.name}">
			</div>
			
			
			<div class="mb-3">
				<label for="phone" class="form-label">전화번호</label> 
				<input type="tel" class="form-control my" name="phone" id="phone" value="${member.phone}">
			</div>
			
			
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> 
				<input type="email" class="form-control my" name="email" id="email"  value="${member.email}" >
			</div>
			
			<div class="mt-3 ml-0" id="modify">
				<button id="btn" type="submit" class="btn btn-primary">Okay</button>
			</div>
		</form>
	</div>
	
	<script type="text/javascript" src="../resources/js/modify.js"></script>
</body>
</html>