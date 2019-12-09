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
			<h3>Welcome to Purchase Update Page</h3>
		</div>

		<div class="card-body">
			<form:form action="update" method="POST" modelAttribute="purchase">
			
			<div class="row">
		  				 <div class="col-4">
		  					 <label for="id">ID</label>  </div>
		   					<div class="col-4">
		   		  		<form:input path="id" readonly="true" class="form-control"/>
		   			</div>
				</div>

				<div class="row">
					<div class="col-4">
						<label for="orderCode">Order Code</label>
					</div>
					<div class="col-4">
						<form:input path="orderCode" 
							class="form-control" />
					</div>
				</div>

				<div class="row">
					<div class="col-4">
						<label for="shipmentMode">shipment Mode</label>
					</div>
					<div class="col-4">
						<form:select path="shipmentMode.id" class="form-control">
						<form:option value="">-SELECT-</form:option>
						<form:options items="${shipmentcode}"></form:options>
		
						</form:select>
					</div>
				</div>

				<div class="row">
					<div class="col-4">
						<label for="vendor">Vendor </label>
					</div>
					<div class="col-4">
						<form:select path="whcode.id" class="form-control">
						<form:option value="">-SELECT-</form:option>
						<form:options items="${userss}"></form:options>
						</form:select>
					</div>
				</div>


				<div class="row">
					<div class="col-4">
						<label for="refrenceNumber">Refrence Number</label>
					</div>
					<div class="col-4">
						<form:input path="refrenceNumber" 
							class="form-control"/>
		
					</div>
				</div>


				<div class="row">
					<div class="col-4">
						<label for="qualityCheck">Quality Check</label>
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
						<label for="defectStatus"> defect Status</label>
					</div>
					<div class="col-4">
						<form:input  path="defectStatus"
							class="form-control"  readonly="true"/>
					</div>
				</div>


				<div class="row">
					<div class="col-4">
						<label for="description"> DESCRIPTION </label>
					</div>
					<div class="col-4">
						<form:textarea path="description"  class="form-control"></form:textarea> 
					</div>
				</div>
				<input type="submit" class="btn btn-success" value="Update" /> <input
					type="reset" class="btn btn-danger" value="Clear" />
			</form:form>
		</div>
		<div class="card-footer bg-info">
			<b>${msg}</b>
		</div>

	</div>
</div>
</body>
</html>
