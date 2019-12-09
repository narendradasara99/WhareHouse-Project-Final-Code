<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="continer">
	<%@include file="UserMenu.jsp" %>
	
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h3>Welcome to Documents Page</h3>
			</div>
			
			<div class="card-body">
	<form action="upload" id="documentForm" method="POST" enctype="multipart/form-data">
				<!--1nd row-->
					<div class="row">
						<div class="col-4">
							<label for="fid"><span style="color:red">ID</span></label>
						</div>
							<div class="col-4">
							 <input type="text" name="fid" id="fid" class="form-control"/>
						</div>	
						<div class="col-4" id="fIdError"></div>
					</div>
					
					<!--2nd row-->
					<div class="row">
						<div class="col-4">
							<label for="fdoc"><span style="color:red">DOCUMENT</span></label>
						</div>
							<div class="col-4">
							<input type="file" name="fdoc"  class="form-control"/>
						</div>	
					</div>
							<input type="submit" value="Upload" class="btn btn-success" class="form-control"   required/>		
							</form>

	<table class="table table-bordered">
		<tr>
		<td><span style="color:red">FILE NAME</span></td>
		<td><span style="color:red">LINK</span></td>
				</tr>
					<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob[1]}</td>
					<td><a href="download?fid=${ob[0]}">Download</a></td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	</div>
	<script type="text/javascript" src="../resources/js/document.js"></script>
	</body>
</html>