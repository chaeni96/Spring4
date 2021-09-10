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
	
      <h1>Register</h1>
	
	<div class="container-fluid">
	
	<form class="form-horizontal" action='' method="POST">


    <div class="control-group">
      <!-- userID -->
      <label class="control-label"  for="userId">userId</label>
      <div class="controls">
        <input type="text" id="userId" name="userId" placeholder="" class="input-xlarge">
        <p class="help-block">Id should be at least 4 characters</p>
      </div>
    </div>
 
    <div class="control-group">
    
    
 	     <!-- Password-->
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
        <p class="help-block">Password should be contain any letters and numbers</p>
      </div>
    </div>
 
    <div class="control-group">
    
      <!-- Password check -->
      <label class="control-label"  for="password_confirm">Password (Confirm)</label>
      <div class="controls">
        <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">
        <p class="help-block">Please confirm password</p>
      </div>
    </div>
    <div class="control-group">
    
    
      <!-- Name -->
      <label class="control-label" for="userName">userName</label>
      <div class="controls">
        <input type="text" id="userName" name="userName" placeholder="" class="input-xlarge">
        <p class="help-block">Please provide your name</p>
      </div>
    </div>
 
    <div class="control-group">
    
 	 <!-- PHONE -->
      <label class="control-label" for="phone">Phone</label>
      <div class="controls">
        <input type="tel" id="phone1" name="phone1" placeholder="" class="input-xlarge">-
        <input type="tel" id="phone2" name="phone2" placeholder="" class="input-xlarge">-
        <input type="tel" id="phone3" name="phone3" placeholder="" class="input-xlarge">
        <p class="help-block">Please provide your Phone-number</p>
      </div>
    </div>
 
    <div class="control-group">
 
  <!-- E-mail -->
      <label class="control-label" for="email">E-mail</label>
      <div class="controls">
        <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
        <p class="help-block">Please provide your E-mail</p>
      </div>
    </div>
 
    <div class="control-group">
 
    
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">Register</button>
      </div>
    </div>
  
</form>
	
	
	
	</div>
</body>
</html>