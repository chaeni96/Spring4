<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/boot_head.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
<h1>Check page</h1>
	
	<div class="container-fluid">
		
		<div class="form-check">
	  	<input class="form-check-input" type="checkbox" value="" id="all">
	  	<label class="form-check-label" for="all">
	    	Check All
	  	</label>
		</div>
			
		<div class="form-check">
		  <input class="form-check-input checks" type="checkbox" value="" id="flexCheckDefault">
		  <label class="form-check-label" for="flexCheckDefault">
		  	 약관 1
		  </label>
		</div>
		
		<div class="form-check">
		  <input class="form-check-input checks" type="checkbox" value="" id="flexCheckDefault">
		  <label class="form-check-label" for="flexCheckDefault">
		    약관2
		  </label>
		</div>
		
		<div class="form-check">
		  <input class="form-check-input checks" type="checkbox" value="" id="flexCheckDefault">
		  <label class="form-check-label" for="flexCheckDefault">
		    약관3
		  </label>
		</div>
		
		<div class="form-check">
		  <input class="form-check-input checks" type="checkbox" value="" id="flexCheckDefault">
		  <label class="form-check-label" for="flexCheckDefault">
		    약관3
		  </label>
		</div>
		
		<div class="form-check">
		  <input class="form-check-input checks" type="checkbox" value="" id="flexCheckDefault">
		  <label class="form-check-label" for="flexCheckDefault">
		    약관4(광고성)
		  </label>
		</div>
		
		<button id="btn">회원가입</button>
		
		
		
</div>		
<script type="text/javascript" src="../resources/js/member.js"></script>
</body>
</html>