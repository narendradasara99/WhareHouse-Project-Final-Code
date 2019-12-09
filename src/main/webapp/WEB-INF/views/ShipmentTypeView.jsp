<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
 <head>
 </head>
<br>
 <body>
 <%@include file="UserMenu.jsp" %>
<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.id}</td>
		</tr>

		<tr>
			<th>SHIPMENTMODE</th>
			<td>${ob.shipmentTypeMode}</td>
		</tr>
		<tr>
			<th>SHIPMENTCODE</th>
			<td>${ob.shipmentTypeCode}</td>
		</tr>
		<tr>
			<th>ENABLESHIPMENT</th>
			<td>${ob.enableShipmentType}</td>
			
			
		</tr>
		<tr>
			<th>SHIPMNTGRADE</th>
			<td>${ob.shipmentTypeGrade}</td>
		</tr>
		<tr>
			<th>DESCRIPTION</th>
			<td>${ob.description}</td>
			
		
		</tr>
	</table>
	<a href="excel?id=${ob.id }"><img src="../resources/images/excel.png" width="30",height="50"></a>
	<a href="pdf?id=${ob.id }"><img src="../resources/images/pdf.png" width="30",height="50"></a>
	
 </body>
</html>

