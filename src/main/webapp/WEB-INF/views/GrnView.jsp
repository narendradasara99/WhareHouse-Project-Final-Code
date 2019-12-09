<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
</head>
<br>
<br>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h3>Welcome to Grn View Page</h3>
			</div>
			<div class="card-body">
				<table border="1" class="table table-bordered table-hover">
					<tr class="table-success">
					
						<tr>
						<th>GRN CODE</th>
						<td>${ob.code}</td>
						</tr>
						<tr>
						<th>GRN TYPE</th>
						<td>${ob.grnType}</td>
						</tr>
						<tr>
						<th>ORDER CODE</th>
						<td>${ob.purchase.orderCode}</td>
						</tr>
						<tr>
						<th>DESCRIPTION</th>
						<td>${ob.note}</td>
						</tr>
					</table>
				
					
		
	<a href="excel?id=${ob.id }"><img src="../resources/images/excel.png" width="30",height="50"></a>
	<a href="pdf?id=${ob.id }"><img src="../resources/images/pdf.png" width="30",height="50"></a>
			</div>
			<div class="card-footer bg-info">
				<b> ${msg}</b>
			</div>
		</div>
	</div>
</body>
</html>

