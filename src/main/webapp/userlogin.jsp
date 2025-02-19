<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix = "c" %>
	<c:set var="msgColor" value=""/>
	<c:set var="msgContent" value=""/>
	
	<c:if test="${param.msg == 'loginerror'}">
		<c:set var="msgContent" value="invalid login
		credentials"/>
		<c:set var="msgColor" value="red"/>
	</c:if>
    
    
    
    
    
    
    
    
    
 <!doctype html>
<html lang="en">
  <head>
  	<title>Customer Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="Homepage/css/style.css">

	</head>
	<style>
	#btn{
	background-color:#1997cc;
	}
	#btn2{
	background-color:#1997cc;
	}
	
	</style>
	<body class="img js-fullheight" style="background-image: url(Homepage/assets/img/pharmacy.jpg);">
	<section class="ftco-section" >
		<div class="container">
			<div class="row justify-content-center" >
				<div class="col-md-6 text-center mb-5">
					
				</div>
			</div>
			<div class="row justify-content-center" >
				<div class="col-md-12 col-lg-10" id="new" >
					<div class="wrap d-md-flex" >
						<div class="text-wrap p-4 p-lg-5 text-center d-flex align-items-center order-md-last" >
							<div class="text w-100"  >
								<h2 >Welcome to login</h2>
								<p>Don't have an account?</p>
								<a href="userregistration.html" class="btn btn-white btn-outline-white" id="btn2">Sign Up</a>
							</div>
			      </div>
						<div class="login-wrap p-4 p-lg-5">
			      	<div class="d-flex">
			      		<div class="w-100">
			      			<h3 class="mb-4">Sign In</h3>
			      		</div>
								<div class="w-100">
									<p class="social-media d-flex justify-content-end">
										<a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-facebook"></span></a>
										<a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-twitter"></span></a>
									</p>
								</div>
			      	</div>
							<form action="validateUserLogin" class="form" method="post">
			      		<div class="form-group mb-3">
			      			<label class="label" for="txtUid">Username</label>
			      			<input type="text" class="form-control" placeholder="Username" id="txtUid" name="txtUid" required>
			      		</div>
		            <div class="form-group mb-3">
		            	<label class="label" for="txtPassword">Password</label>
		              <input type="password" class="form-control" placeholder="Password" name ="txtPassword" id="txtPassword" required>
		            </div>
		            <div class="form-group">
		            	<button type="submit" class="form-control btn  submit px-3" id="btn">Sign In</button>
		            </div>
		            <div class="form-group d-md-flex">
		            	<div class="w-50 text-left">
			            	
									</div>
									<div class="w-50 text-md-right">
										<a href="#">Forgot Password</a>
									</div>
		            </div>
		          </form>
		        </div>
		      </div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>

	</body>
</html>

 