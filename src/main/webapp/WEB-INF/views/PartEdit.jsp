
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<div class="continer">
	<%@include file="UserMenu.jsp" %>
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h3>Welcome to Part Register Page</h3>
			</div>
			<div class="card-body">
				<form:form id="myForm" action="update" method="POST" modelAttribute="part">
				<div class="row">
		  				 <div class="col-4">
		  					 <label for="id">ID</label>  </div>
		   					<div class="col-4">
		   		  		<form:input path="id" readonly="true" class="form-control"/>
		   			</div>
				</div>
					<!--1st row-->
					<div class="row">
						<div class="col-4">
							<label for="code">Code</label>
						</div>
						<div class="col-4">
							<form:input path="code"  class="form-control" />
						</div>
					</div>
					
						<div class="row">
                    <div class="col-4">
							<label for="code">Dimension</label>
							</div>
							 <div class="col-0">
							<label for="code">W</label>
							</div>
						<div class="col-1">
							<form:input path="width" id="code"
								class="form-control" />
						</div>
						<div class="col-0">
							<label for="">L</label>
							</div>
						<div class="col-1">
							<form:input path="length" id="code"
								class="form-control" />
						</div>
						<div class="col-0">
							<label for="code">H</label>
							</div>
						<div class="col-1">
							<form:input path="heigth" 
								class="form-control" />
						</div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="baseCost">Base Cost</label>
						</div>
						<div class="col-4">
							<form:input path="baseCost" id="baseCost"
								class="form-control" />
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="baseCurrency">Base Currency</label>
						</div>
						<div class="col-4">
							<form:select path="baseCurrency"
								class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="inr">INR</form:option>
								<form:option value="usd">USD</form:option>
								<form:option value="aus">AUS</form:option>
								<form:option value="eru">ERU</form:option>
							</form:select>
						</div>
						</div>
			
						<div class="row">
							<div class="col-4">
								<label for="uom">Uom</label>
							</div>
							<div class="col-4">
								<form:select path="uom.id" class="form-control">
									<form:option value="">-SELECT-</form:option>
									<form:options items="${uoms}"/>
								</form:select>
							</div>
							</div>
							
							
							<div class="row">
							<div class="col-4">
								<label for="orderMethodCode">Order Method Code</label>
							</div>
							<div class="col-4">
								<form:select path="ordermethod.id" 
									class="form-control">
									<form:option value="">-SELECT-</form:option>
									<form:options items="${ordermethods}"/>
								</form:select>
							</div>
						</div>
						
					<input type="submit" class="btn btn-success" value="Update" class="form-control"/>
					<input type="reset" class="btn btn-danger" value="Clear" />

				</form:form>

			</div>
			<c:if test="${msg ne null }">
				<div class="card-footer bg-info text-white"><b>${msg}</b></div>
			</c:if>
		</div>
	</div>
</body>
</html>
    

