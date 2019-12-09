<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>

<html>
<head>
</head>
<body>
<%@include file="UserMenu.jsp"%>

<div class="container">
	<div class="card">
		<div class="card-header bg-primary text-white">
			<h3>Welcome to Purchase Register Page</h3>
		</div>

		<div class="card-body">
			<form:form  id="purchaseForm" action="save" method="POST" modelAttribute="purchase">


				<div class="row">
					<div class="col-4">
						<label for="orderCode">ORDER CODE</label>
					</div>
					<div class="col-4">
						<form:input path="orderCode" 
							class="form-control" />
					</div>
					<div class="col-4" id="orderCodeError"></div>
				</div>
				

				<div class="row">
					<div class="col-4">
						<label for="shipmentMode">SHIPMENT MODE</label>
					</div>
					<div class="col-4">
						<form:select path="shipmentMode.id" class="form-control">
						<form:option value="">-SELECT-</form:option>
						<form:options items="${shipmentcode}"></form:options>
		
						</form:select>
					</div>
					<div class="col-4" id="shipmentModeError"></div>
				</div>

				<div class="row">
					<div class="col-4">
						<label for="vendor">VENDOR</label>
					</div>
					<div class="col-4">
						<form:select path="whcode.id" class="form-control">
						<form:option value="">-SELECT-</form:option>
						<form:options items="${userss}"></form:options>
						</form:select>
					</div>
					<div class="col-4" id="vendorError"></div>
				</div>


				<div class="row">
					<div class="col-4">
						<label for="refrenceNumber">REFRENCE NUMBER</label>
					</div>
					<div class="col-4">
						<form:input path="refrenceNumber" 
							class="form-control"/>
		
					</div>
					<div class="col-4" id="referenceNumberError"></div>
				</div>


				<div class="row">
					<div class="col-4">
						<label for="qualityCheck">QUALITY CHECK</label>
					</div>
					<div class="col-4">
							<form:radiobutton path="qualityCheck" value="REQUIRED" />
							Required
							<form:radiobutton path="qualityCheck" value="NOT REQUIRED" />
							Not Required
						</div>
					<div class="col-4" id="qualityCheckError"></div>
				</div>

				<div class="row">
					<div class="col-4">
						<label for="defectStatus">STATUS</label>
					</div>
					<div class="col-4">
						<form:input  path="defectStatus"
							class="form-control"  readonly="true"/>
					</div>
					<!-- <div class="col-4" id="descriptionError"></div> -->
				</div>


				<div class="row">
					<div class="col-4">
						<label for="description">DESCRIPTION</label>
					</div>
					<div class="col-4">
						<form:textarea path="description"  class="form-control"></form:textarea> 
					</div>
					<div class="col-4" id="descriptionError"></div>
				</div>
				<input type="submit" class="btn btn-success" value="Create" /> <input
					type="reset" class="btn btn-danger" value="Clear" />
			</form:form>
		</div>
		<div class="card-footer bg-info">
			<b>${msg}</b>
		</div>

	</div>
	<script type="text/javascript" src="../resources/js/Purchase.js"></script>
</div>
</body>
</html>
