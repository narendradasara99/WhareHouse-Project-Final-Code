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
   <h3>Welcome to Shipping Data Page</h3>
   </div>
   <div class="card-body">
   
    <a href="excel"><img src="../resources/images/excel.png" width="70" height="40"></a> 
     <a href="pdf"><img src="../resources/images/pdf.png" width="70" height="40"></a>
 		 <table border="1" class="table table-bordered table-hover">
			<tr class="table-success">
				<tr>

             <th>Id</th>
			<th>SHIPPING CODE</th>
			<!-- <th>SHIPPING Ref Num</th>  -->
			<!-- <th>CORIER Ref Num</th>  -->
		<!-- 	<th>CONTACT DETAILS</th>  -->
			<!-- <th>SALE ORDER CODE</th>  -->
			<th>BILL TO ADDRESS</th> 
			<th>SHIP TO ADDRESS</th> 
			<!-- <th>DESRIPTION<th> -->
			<th colspan="4">OPERATION</th> 
			</tr>
			<c:forEach items="${list}" var ="ob">
	
			<tr>
			<td><c:out value="${ob.id}"/></td>
			<td><c:out value="${ob.shippingCode}"/></td>
			<%-- <td><c:out value="${ob.shippingRefNum}"/></td> --%>
			<td><c:out value="${ob.billToaddress}"/></td>
			<%-- <td><c:out value="${ob.corierRefNum}"/></td> --%>
			<%-- <td><c:out value="${ob.contactDetails}"/></td> --%>
			<%-- <td><c:out value="${ob.saleOrder}"/></td> --%>
			<td><c:out value="${ob.shipToAddress}"/></td>
			<%-- <td><c:out value="${ob.description}"/></td> --%>
			
			<td><a href="delete?id=${ob.id}"><img src="../resources/images/delete.png" width="20"height="40"></a></td>
			<td><a href="edit?id=${ob.id}"><img src="../resources/images/edit.png" width="20" height="40"></a></td>
			<td><a href="view?id=${ob.id}"><img src="../resources/images/view.png" width="20"height="40"></a></td>
			<td><a href="parts?id=${ob.id}"><img src="../resources/images/items2.png" width="20"height="40"> </a></td>
			</tr>
			</c:forEach>		
			</table>
			</div>
			<div class="card-footer bg-info" align="center">
			<b>${msg}</b>
			</div>
		</div>
		</div>
	</body>
</html>