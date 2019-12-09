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
				<h3>Welcome to Grn Data Page</h3>
			</div>
			<div class="card-body">

				<a href="excel"><img src="../resources/images/excel.png" width="70",height="40"></a> 
    			 <a href="pdf"><img src="../resources/images/pdf.png" width="70",height="40"></a>
				<table class="table table-bordered table-hover">
					<tr class="bg-warning ">
						<td>CODE</td>
						<td>GRNTYPE</td>
						<td>PURCHASE CODE</td>
						<td>NOTE</td>
						<td colspan='4'>OPERATIONS</td>
					</tr>
					<c:forEach items="${list}" var="ob">
						<tr>
							<td><c:out value="${ob.code}" /></td>
							<td><c:out value="${ob.grnType}" /></td>
							<td><c:out value="${ob.purchase.orderCode}" /></td>
							<td><c:out value="${ob.note}" /></td>
							
			<td><a href="delete?id=${ob.id}"><img src="../resources/images/delete.png" width="30"height="50"></a></td>
			<td><a href="edit?id=${ob.id}"><img src="../resources/images/edit.png" width="30"height="50"> </a></td>
			<td><a href="view?id=${ob.id}"><img src="../resources/images/view.png" width="30"height="50"> </a></td>
			<td><a href="parts?id=${ob.id}"><img src="../resources/images/items2.png" width="30"height="50"> </a></td>
					</tr>
					</c:forEach>
				</table>
				<div class="card-footer bg-info">
				<b>${msg}</b>
			</div>
			</div>
		</div>
	</div>
	
</body>
</html>

