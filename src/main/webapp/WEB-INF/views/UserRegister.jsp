<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UiMenu.jsp"  %>
<div class="continer">
		<div class="card">
				<div class="card-header bg-primary text-white">
					<h3>Welcome to User Register page!</h3>
				</div>
			<div class="card-body">
			
			<div>
			<p style="text-align:center;"><img src="../resources/images/reglogo.png" width="50"height="80"></p>
			</div>
			<marquee behavior="alternate"><h3><span style="color:red">REGISTER</span><span style="color:green">HERE</span></h3></marquee>
	<form action="save" method="post">

					<!--1st row-->
					<div class="row">
							<div class="col-4">
							<label for="userName">UserName</label>
						</div>
						
						<div class="col-4">
								<input type="text"  name="userName"
								class="form-control" maxlength="50"/>
						</div>
						<div class="col-4" id="userNameError"></div>
					</div>
					
					<!--2nd row-->
					<div class="row">
						<div class="col-4">
							<label for="password">Email</label>
						</div>
						<div class="col-4">
							<input type="text"  name="userEmail"
								class="form-control"/>
						</div>
						<div class="col-4" id="userEmailError">
				</div>
			</div>
			
			<!--3nd row-->
					<div class="row">
						<div class="col-4">
							<label for="password">Password</label>
						</div>
						<div class="col-4">
							<input type="password"  name="userPwd"
								class="form-control"/>
						</div>
						<div class="col-4" id="userpasswordError">
				</div>
			</div>
			
			<!--3nd row-->
					<div class="row">
						<div class="col-4">
							<label for="password">Roles</label>
						</div>
						<div class="col-4">
							<input type="checkbox"  name="roles" value="ADMIN"
								/>ADMIN
								<input type="checkbox"  name="roles" value="APPUSER"
								/>APPUSER
						</div>
						<div class="col-4" id="userpasswordError">
				</div>
			</div>
<!-- User Name  : <input type="text" name="userName"/>
Email      : <input type="text" name="userEmail"/>
Password   : <input type="password" name="userPwd"/>
Roles      :
	<input type="checkbox" name="roles" value="ADMIN"> ADMIN
	<input type="checkbox" name="roles" value="APPUSER"> APP USER -->
<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}">	
	<p style="text-align:center;"><input type="submit" class="btn btn-success" value="Register" /></p>
</form>
</div>
</div>
</div>
${message}
</body>
</html>