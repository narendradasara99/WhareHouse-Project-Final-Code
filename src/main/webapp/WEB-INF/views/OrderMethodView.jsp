<%@page import="org.springframework.web.util.UriBuilderFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h3>Welcome to Order Method View Page</h3>
			</div>
			<div class="card-body">
				<table border="1" class="table table-bordered table-hover">
					<tr class="table-success">
					<tr>
						<th>Id</th>
						<td><c:out value="${ob.id}" /></td>
					</tr>
					<tr>
						<th>ORDER MODEL</th>
						<td><c:out value="${ob.orderMode}" /></td>
					</tr>
					<tr>
						<th>ORDER CODE</th>
						<td><c:out value="${ob.orderCode}" /></td>
					</tr>
					<tr>

						<th>ORDER TYPE</th>
						<td><c:out value="${ob.orderType}" /></td>
					</tr>
					<tr>
						<th>ORDER ACCEPT</th>
						<td><c:out value="${ob.orderAccept}" /></td>
					</tr>
					<tr>
						<th>DESCRIPTION</th>
						<td><c:out value="${ob.description}" /></td>
					</tr>

				</table>

				<a href="excel?id=${ob.id}">EXCEL </a> <a href="pdf?id=${ob.id}">PDF
				</a>
			</div>
		</div>
	</div>
</body>
</html>