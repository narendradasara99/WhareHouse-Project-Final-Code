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
				<h3>Welcome to sale View Page</h3>
			</div>
			<div class="card-body">
				<table border="1" class="table table-bordered table-hover">
					<tr class="table-success">
					<tr>
						<th>Id</th>		
						<td>${ob.id}</td>
						</tr>
						<tr>
						<th>CODE</th>	
						<td>${ob.code}</td>
						</tr>
						<tr>
						<th>WIDTH</th>	
						<td>${ob.width}</td>
						</tr>
						<tr>
						<th>LENGTH</th>	
						<td>{ob.length}</td>
						</tr>
						<tr>
						<th>LENGTH</th>	
						<td>{ob.heigth}</td>
						</tr>
						<tr>
						<th>COST</th>	
						<td>${ob.baseCost}</td>
						</tr>
						<tr>
						<th>BASE CURRENCY</th>	
						<td>${ob.baseCurrency}</td>
						</tr>
						<tr>
						<th>UOM</th>	
						<td>${ob.uom.uomModel}</td>
						</tr>
						<tr>
						<th>ORDERMETHOD</th>	
						<td>${ob.ordermethod.orderCode}</td>
						</tr>
						<tr>
						<th>Note</th>	
						<td>${ob.description}</td>
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

