<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/boot_head.jsp"></c:import>
<title>Insert Page</title>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	
	<h1>Insert</h1>
	
	<div class="container-fluid">
		<form class="col-md-5 mx-auto" action="./insert" method="POST">
		
		<div class="mb-3">
		  	<label for="title" class="form-label">Title</label>
		  	<input type="text" class="form-control" name="title" id="title" placeholder="Enter Title">
		</div>
			
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label> 
				<input type="text" class="form-control" name="writer" id="writer" placeholder="Enter writer">
			</div>
		
			<div class="mb-3">
				<label for="contents" class="form-label">Contents</label>
				<textarea id="contents" name="contents" rows="10" cols="110" placeholder="Input some text."></textarea>
			</div>
		
		
		<div align="right" class="mt-3">
			<button type="submit" class="btn btn-success">Add</button>
			
		</div>
		
		</form>
	
	</div>
</body>
</html>