<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<%@include file="UserMenu.jsp" %>

	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h3>Welcome to WhUserType view one Page</h3>
			</div>
		</div>
	</div>
	<div class="card-body"></div>
	<table border="1" class="table table-bordered table-hover">
		<tr class="table-success">


		<tr>
			<th>Id</th>
			<td>${ob.id}</td>
		</tr>
		<tr>
			<th>WHUSER TYPE</th>
			<td>${ob.whuserType}</td>
		</tr>
		<tr>
			<th>WHUSER CODE</th>
			<td>"${ob.whuserCode}</td>
		</tr>
		<tr>
			<th>WHUSER FOR</th>
			<td>${ob.whuserFor}</td>
		</tr>
		<tr>
			<th>WHUSER EMAIL</th>
			<td>${ob.whuserEmail}</td>
		</tr>
		<tr>
			<th>WHUSER CONTACT</th>
			<td>${ob.whuserContact}</td>
		</tr>
		<tr>
			<th>WHUSER ID TYPE</th>
			<td>${ob.whuserIdType}</td>
		</tr>
		<tr>

			<th>WHUSER ID IF OTHER</th>
			<td>${ob.whuserIdOther}></td>
		</tr>
		<tr>
			<th>WHUSER ID NUMBER</th>
			<td>${ob.whuserIdNumber}</td>
		</tr>

	</table>

	<a href="excel?id=${ob.id }"><img src="../resources/images/excel.png" width="30",height="50"></a>
	<a href="pdf?id=${ob.id }"><img src="../resources/images/pdf.png" width="30",height="50"></a>
</body>
</html>