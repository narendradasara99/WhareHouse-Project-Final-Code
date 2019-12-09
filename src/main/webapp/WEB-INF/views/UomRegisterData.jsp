<%@page import="org.springframework.web.util.UriBuilderFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
 
</head>
<body>
<%@include file="UserMenu.jsp" %>
<div class="container">
 <div class="card">
   <div class="card-header bg-primary text-white">
      <h3>Welcome to shipment Register Page</h3>
   </div>
   <div class="card-body">
   
    <a href="excel"><img src="../resources/images/excel.png" width="70",height="40"></a> 
     <a href="pdf"><img src="../resources/images/pdf.png" width="70",height="40"></a>
  <table border="1" class="table table-bordered table-hover">
	<tr class="table-success">
		<tr>
			<th>Id</th>
			<th>TYPE</th>
			<th>MODEL</th> 
			<th>DESCRIPTION</th>
			<th colspan="3">OPERATIONS</th>
			</tr>
			
			<c:forEach items="${list}" var ="ob">
			<tr>
			<td><c:out value="${ob.id}"/></td>
			<td><c:out value="${ob.uomType}"/></td>
			<td><c:out value="${ob.uomModel}"/></td>
			<td><c:out value="${ob.description}"/></td>
		
			<td> <a href="delete?id=${ob.id}"><img src="../resources/images/delete.png" width="30",height="50"> </a></td>
			<td><a href="edit?id=${ob.id}"><img src="../resources/images/edit.png" width="30",height="50"> </a></td>
			<td><a href="view?id=${ob.id}"><img src="../resources/images/view.png" width="30",height="50"> </a></td>
			 
				</tr>
				</c:forEach>		 
				</table>
			</div>
			<c:if test="${msg ne null }">
				<div class="card-footer bg-info text-white"><b>${msg}</b></div>
			</c:if>
			
			</div>
		</div>
		</div>
	</body>
</html>