<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<h3>Welcome to Shipping View Page</h3>
			</div>
			<div class="card-body">
				<table border="1" class="table table-bordered table-hover">
					<tr class="table-success">
					<tr>		
			
			<th>Id</th>
			<td>${ob.id}</td>
			</tr>
			<tr>
			<th>SHIPPING CODE</th>
			<td>${ob.shippingCode}</td>
			</tr>
			<tr>
			<th>SHIPPING Ref Num</th> 
			<td>${ob.shippingRefNum}</td>
			</tr>
			<tr>
			<th>BILL TO ADDRESS</th>
			<td>${ob.billToaddress}</td>
			</tr>
			<tr>
			<th>CORIER Ref Num</th>
			<td>${ob.corierRefNum}</td>
			</tr>
			<tr>
			<th>CONTACT DETAILS</th>
			<td>${ob.contactDetails}</td>
			</tr>
			<tr>
			<th>SALE ORDERCODE</th> 
			<td>${ob.saleOrder}</td>
			</tr>
			<tr>
			 <th>SHIP TO ADDRESS</th>
			<td>${ob.shipToAddress}</td>
			</tr>
			<tr>
			 <th>NOTE</th>
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

