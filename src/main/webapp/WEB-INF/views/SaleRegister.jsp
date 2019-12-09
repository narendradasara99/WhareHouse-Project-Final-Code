<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h3>Welcome to Sale Register Page</h3>
			</div>

			<div class="card-body">
				<form:form  id="saleForm" action="save" method="POST" modelAttribute="sale">

					<div class="row">
						<div class="col-4">
							<label for="orderCode">ORDER CODE</label>
						</div>
						<div class="col-4">
							<form:input path="orderCode" class="form-control" />
						</div>
						<div class="col-4" id="orderCodeError"></div>
					</div>
					
					
					<div class="row">
						<div class="col-4">
							<label for="shipmentMode">SHIPMENT MODE</label>
						</div>
						<div class="col-4">
							<form:select path="shipmentMode.id" class="form-control">
							<form:option value="">-SLECT-</form:option>
							<form:options items="${shipmentcode}"></form:options>
							</form:select>
						</div>
						<div class="col-4" id="shipmentModeError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="customer">CUSTOMER</label>
						</div>
						<div class="col-4">
							<form:select path="whcode.id" class="form-control">
							<form:option value="">-Select-</form:option>
							<form:options items="${userss}"></form:options>
							</form:select>
						</div>
						<div class="col-4" id="customerError"></div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="refNumber">REFRENCE NUMBER </label>
						</div>
						<div class="col-4">
							<form:input path="refNumber" class="form-control" />
						</div>
						<div class="col-4" id="refNumberError"></div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="stockMode">STOCK MODE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="stockMode" value="GRADE"/>GRADE
							<form:radiobutton path="stockMode" value="MARGIN"/>MARGIN

						</div>
						<div class="col-4" id="stockModeError"></div>
					</div>
					

					<div class="row">
						<div class="col-4">
							<label for="stockSource">STOCK SOURCE</label>
						</div>
						<div class="col-4">
							<form:select path="stockSource" class="form-control">
								<form:option value="">Select</form:option>
								<form:option value="OPEN">OPEN</form:option>
								<form:option value="AVAIL">AVAIL</form:option>
								<form:option value="REFUND">REFUND</form:option>
							</form:select>
						</div>
						<div class="col-4" id="stockSourceError"></div>
					</div>
					
					<div class="row">
					<div class="col-4">
						<label for="saleOrderStatus">STATUS</label>
					</div>
					<div class="col-4">
						<form:input  path="saleOrderStatus"
							class="form-control"  readonly="true"/>
					</div>
					
				</div>

					<div class="row">
						<div class="col-4">
							<label for="description">DESCRIPTION </label>
						</div>
						<div class="col-4">
							<form:textarea path="description" class="form-control"></form:textarea>
							
						</div>
						<div class="col-4" id="descriptionError"></div>
					</div>
					<input type="submit" class="btn btn-success"
						value="Create Sale Order" />
					<input type="reset" class="btn btn-danger" value="Clear" />
				</form:form>
			</div>
			<div class="card-footer bg-info">
				<b>${msg}</b>
			</div>

		</div>
	</div>
	<script type="text/javascript" src="../resources/js/sale.js"></script>
</body>
</html>
