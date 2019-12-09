<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp" %>
	<div class="container">

		<div class="card">
			<div class="card-header bg-info text-white">
				<h2>Welcome to Purchase Order Data Page!!</h2>
			</div>



			<div class="card-body">
				Order Code : <input type="text" value="${parent.orderCode}"
					class="form-control bg-light" readonly="readonly"> <br />
				Order Status : <input type="text" value="${parent.defectStatus}"
					class="form-control bg-light" readonly="readonly"> <br />					
				<br />
				
				
				
				<form:form action="add" method="POST"
					modelAttribute="purchaseDtl" cssClass="form-inline">
					<form:hidden path="parent.id"/>
                Choose Parts:
				<form:select path="part.id" class="form-control">
						<form:option value="">--SELECT--</form:option>
						<form:options items="${parts}" />
					</form:select>
				Quantity :	<form:input path="qty" class="form-control" />
					<input type="submit" value="ADD" class="btn btn-success">
				</form:form>
			
				
				
			</div>  <!-- card body end -->


			<!-- It will display all child items in Purchase if exist -->
			
				<div class="card-footer">
					<table class="table table-hover table-bordered">
						<tr>
						
							<th>SL NO</th>
							<th>ITEM CODE</th>
							<th>BASE COST</th>
							<th>QTY</th>
							<c:if test="${parent.defectStatus eq 'PICKING' }">
							<th>OPERATION</th>
							</c:if>
							
						</tr>
						<c:forEach items="${parent.childs}" var="ob">
							<tr>

		
		<td><c:out  value="${ob.slno}"/></td>
		<td><c:out  value="${ob.part.code}"/></td>
		<td><c:out  value="${ob.part.baseCost}"/></td>
		<td><c:out  value="${ob.qty}"/></td>
		
		
								
									<td>
									<c:if test="${parent.defectStatus eq 'PICKING' }">
									<a href="remove?id=${parent.id}&dtlId=${ob.id}"
										class="btn btn-danger"><img src="../resources/images/delete.png" width="30"height="50"> </a>
										</c:if>
										</td>
										
							
							</tr>
						</c:forEach>
						
					</table>
					
					<c:if test="${parent.defectStatus eq 'PICKING'}">
	<a href="updateStatus?id=${parent.id}&defectStatus=ORDERED" class="btn btn-success">PLACE ORDER</a>
</c:if>
				</div>
		</div>

	</div>
</body>
</html>