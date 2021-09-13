<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 
<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/boot_head.jsp"></c:import>

<title>Join</title>
</head>
<c:import url="../temp/boot_nav.jsp"></c:import>
<body>
	
      <h1 >Register</h1>
	
		<form  id = "frm" action="join" method="post" class="col-md-6 mx-auto" >
	  
	  <div class="mb-3">
	    <label for="text" class="form-label">ID</label>
	    <input type="text" class="form-control put" id="id" name="id">
	    <button id="idCheck" type="button">ID 중복확인</button>
	    <div id= "idResult"></div>
	  
	  </div>
	  
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Password</label>
	    <input type="password" class="form-control put pw " id="pw1" name="pw">
	  </div>
	
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Password 확인</label>
	    <input type="password" class="form-control put pw" id="pw2"  placeholder="password를 한번더 입력하세요">
	  	<div id="pwCheck" style="color:red;"></div>
	  </div>
	  
	  <div class="mb-3">
	    <label for="text" class="form-label">Name</label>
	    <input type="text" class="form-control put" id="name" name="name">
	  
	  </div>
	  
	  <div class="mb-3">
    	<label for="text" class="form-label">Phone</label>
    	<input type="tel" class="form-control put" id="phone" name="phone" placeholder="01012345678">
  	</div>
	  
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Email</label>
	    <input type="email" class="form-control put" name="email" id="email" aria-describedby="emailHelp" placeholder="email@email.com">
	  
	  </div>
	  
	    <div class="mb-3 my-4" id="files">
	    <label class="form-label"></label>
	    <button id="add" type="button" class="btn btn-info">File Add</button>
	  </div>
	  
	  <!-- input file 추가영역 -->
	  <div id="addResult">
	  	
	  
	  </div>
	  
	  
	  <div class="mb-3 my-4">
	    <label class="form-label"></label>
	    <button id="btn" type="button" class="btn btn-primary">Register</button>
	  
	  </div>
	  
	  
	</form>
	
	  <!-- <div class="mb-3" id="f">
	    <label for="photo" class="form-label">Photo</label>
	    <input type="file" class="form-control put" name="photo" id="photo">	  
	  </div>
	   -->
	
<script type="text/javascript" src="../resources/js/join.js"></script>
<script type="text/javascript" src="../resources/js/file.js"></script>
</body>
</html>