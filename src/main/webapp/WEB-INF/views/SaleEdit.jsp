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
				<h3>Welcome to Sale Edit Page</h3>
			</div>
	

			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="sale">
				
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
							<form:input path="orderCode" class="form-control" />
						</div>
					</div>
					
					
					<div class="row">
						<div class="col-4">
							<label for="shipmentMode">ShipmentMode</label>
						</div>
						<div class="col-4">
							<form:select path="shipmentMode.id" class="form-control">
							<form:option value="">-SLECT-</form:option>
							<form:options items="${shipmentcode}"></form:options>
							</form:select>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="customer">Customer</label>
						</div>
						<div class="col-4">
							<form:select path="whcode.id" class="form-control">
							<form:option value="">-Select-</form:option>
							<form:options items="${userss}"></form:options>
							</form:select>
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="refNumber">Ref Number </label>
						</div>
						<div class="col-4">
							<form:input path="refNumber" class="form-control" />
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="stockMode">Stock Mode</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="stockMode" value="GRADE"/>GRADE
							<form:radiobutton path="stockMode" value="MARGIN"/>MARGIN

						</div>
					</div>
					

					<div class="row">
						<div class="col-4">
							<label for="stockSource">Stock Source</label>
						</div>
						<div class="col-4">
							<form:select path="stockSource" class="form-control">
								<form:option value="">Select</form:option>
								<form:option value="OPEN">OPEN</form:option>
								<form:option value="AVAIL">AVAIL</form:option>
								<form:option value="REFUND">REFUND</form:option>
							</form:select>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="description">Description </label>
						</div>
						<div class="col-4">
							<form:textarea path="description" class="form-control"></form:textarea>
							
						</div>
					</div>
					<input type="submit" class="btn btn-success"
						value="Update" />
					<input type="reset" class="btn btn-danger" value="Clear" />
				</form:form>
			</div>
			<div class="card-footer bg-info">
				<b>${msg}</b>
			</div>

		</div>
	</div>
</body>
</html>
