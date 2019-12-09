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
				<h3>Welcome to sale Update Page</h3>
			</div>
			<div class="card-body">

				<a href="excel"><img src="../resources/images/excel.png" width="70"height="40"></a> 
    			 <a href="pdf"><img src="../resources/images/pdf.png" width="70"height="40"></a>
    			 
				<table border="1" class="table table-bordered table-hover">
					<tr class="table-success">
					<tr>		
						<th>Id</th>
						<th>ORDER CODE</th>
						<th>SHIPMENT MODE</th>
						<th>CUSTOMER</th>
						<th>REFRENCE NUMBER</th>
						<th>STOCK MODE</th>
						<th>STATUS</th>
						<th>DESCRIPTION</th>
						<th colspan="5">OPERATIONS</th>
					</tr>
					<c:forEach items="${list}" var ="ob">
					

					<tr>
						<td><c:out value="${ob.id}"/></td>
						<td><c:out value="${ob.orderCode}"/></td>
						<td><c:out value="${ob.whcode.whuserCode}" /></td>
						<td><c:out value="${ob.shipmentMode.shipmentTypeMode}" /></td>
						<td><c:out value="${ob.refNumber}"/></td>
						<td><c:out value="${ob.stockMode}"/></td>
						<td><c:out value="${ob.saleOrderStatus}"/></td>
						<td><c:out value="${ob.description}"/></td>
						
						<td>
							<c:choose>
								<c:when test="${ob.saleOrderStatus eq 'CONFIRM' }">
									<a href="updateStatus?id=${ob.id}&saleOrderStatus=INVOICED" class="btn btn-info">Get Invoice</a>
								</c:when>
								<c:when test="${ob.saleOrderStatus eq 'INVOICED' || ob.saleOrderStatus eq 'RECEIVED' }">
									<a href="CumInvoice?id=${ob.id}" class="btn btn-info">Print Invoice</a>
								</c:when>
							</c:choose>
						
						<td><a href="delete?id=${ob.id}"><img src="../resources/images/delete.png" width="20"height="40"></a></td>
			<td><a href="edit?id=${ob.id}"><img src="../resources/images/edit.png" width="20"height="40"></a></td>
			<td><a href="view?id=${ob.id}"><img src="../resources/images/view.png" width="20"height="40"></a></td>
			<td><a href="parts?id=${ob.id}"><img src="../resources/images/items2.png" width="20"height="40"> </a></td>
			 <%-- <td><a href="venInvoice?id=${ob.id}">Vendor Invoice</a></td> --%>
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

