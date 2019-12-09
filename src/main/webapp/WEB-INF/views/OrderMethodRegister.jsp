<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<h3>Welcome to OrderMethod Register  Page</h3>
			</div>

			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="orderMethod" id="orderForm">
					<div class="row">
						<div class="col-4">
							<label for="orderMode">ORDER MODE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="orderMode" value="Sale" />
							Sale
							<form:radiobutton path="orderMode" value="Purchase" />
							Purchase
						</div>
						<div class="col-4" id="orderModeError"></div>
					</div>
					
		

						<div class="row">
							<div class="col-4">
							<label for="orderCode">ORDER CODE</label>
							</div>
						<div class="col-4">
							<form:input path="orderCode" 
							class="form-controll"/>
						</div>
						<div class="col-4" id="orderCodeError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="orderType">ORDER TYPE</label>
						</div>
						<div class="col-4">
						
						<form:select path="orderType" class="form-controll">
						        <form:option value="">-SELECT-</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value=" LIFO">LIFO</form:option>
								<form:option value="FCFO">FCFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
								</form:select>	
						</div>
						<div class="col-4" id="orderTypeError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="orderAccept">ORDER ACCEPT</label>
						</div>
						<div class="col-4">
							<form:checkbox path="orderAccept" value="Multi-Model"/>Multi-Model
								
								 <form:checkbox path="orderAccept"  value="Asscep Return"/>AcceptReturn
						</div>
						<div class="col-4" id="orderAcceptError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="description">DESCRIPTION</label>
						
						</div>
						<div class="col-4">
							<form:textarea path="description" class="form-comtroll"></form:textarea>
								
						</div>
						<div class="col-4" id="descriptionError"></div>
					</div>
					<input type="submit" class="btn btn-success"
						value="Create Order Method" />
					<input type="reset" class="btn btn-danger" value="Clear" />
				</form:form>
			</div>
			</div>
			<c:if test="${msg ne null }">
				<div class="card-footer bg-info text-white"><b>${msg}</b></div>
			</c:if>
			</div>
	<script type="text/javascript" src="../resources/js/orderMethod.js"></script>
</body>
</html>

