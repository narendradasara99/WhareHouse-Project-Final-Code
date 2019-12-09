<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h3>Welcome to Uom view one Page</h3>
			</div>
		
			<div class="card-body"></div>
				<table border="1" class="table table-bordered table-hover">
					<tr class="table-success">
					<tr>
				
						<th>ID</th>
						<td>${ob.id}</td>
					</tr>

					<tr>
						<th>TYPE</th>
						<td>${ob.uomType}</td>
					</tr>
					<tr>
						<th>MODEl</th>
						<td>${ob.uomModel}</td>
					</tr>
					<tr>
						<th>NOTE</th>
						<td>${ob.description}</td>
							
					</tr>
					
			 </table>
			 </div>
			 <a href="excel?id=${ob.id }"><img src="../resources/images/excel.png" width="30",height="50"></a>
			<a href="pdf?id=${ob.id }"><img src="../resources/images/pdf.png" width="30",height="50"></a>				
			 </div>
			 
			
	</body>
</html>