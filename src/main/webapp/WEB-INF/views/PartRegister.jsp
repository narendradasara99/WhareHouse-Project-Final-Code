
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
				<form:form id="partForm" action="save" method="POST" modelAttribute="part">
					<!--1st row-->
					<div class="row">
						<div class="col-4">
							<label for="code">CODE</label>
						</div>
						<div class="col-4">
							<form:input path="code"  class="form-control" />
						</div>
						<div class="col-4" id="codeError"></div>
					</div>
					
						<div class="row">
                    <div class="col-4">
							<label for="code">DIMENSION</label>
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
					
						<!-- <div class="col-4" id="heigthError"></div>
						<div class="col-4" id="widthError"></div>
						<div class="col-4" id="lengthError"></div> -->
					
					</div>
						

					
					<div class="row">
						<div class="col-4">
							<label for="baseCost">BASE COST</label>
						</div>
						<div class="col-4">
							<form:input path="baseCost" id="baseCost"
								class="form-control" />
						</div>
						<div class="col-4" id="basecostError"></div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="baseCurrency">BASE CURRENCY</label>
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
						<div class="col-4" id="baseCurrencyError"></div>
						</div>
			
						<div class="row">
							<div class="col-4">
								<label for="uom.id">UOM</label>
							</div>
							<div class="col-4">
								<form:select path="uom.id" class="form-control">
									<form:option value="">-SELECT-</form:option>
									<form:options items="${uoms}"/>
								</form:select>
							</div>
							<div class="col-4" id="uomError"></div>
							</div>
							
							
							<div class="row">
							<div class="col-4">
								<label for="Sale">SALE</label>
							</div>
							<div class="col-4">
								<form:select path="ordermethodSale.id" 
									class="form-control">
									<form:option value="">-SELECT-</form:option>
									<form:options items="${sales}"/>
								</form:select>
							</div>
							<div class="col-4" id="orderMethodError"></div>
						</div>
						
						
						
						<div class="row">
							<div class="col-4">
								<label for="Sale">PURCHASE</label>
							</div>
							<div class="col-4">
								<form:select path="omPurchase.id" 
									class="form-control">
									<form:option value="">-SELECT-</form:option>
									<form:options items="${purchases}"/>
								</form:select>
							</div>
							<div class="col-4" id="grnCodeError"></div>
						</div>
						
						<div class="row">
						<div class="col-4">
							<label for="description">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:input path="description" 
								class="form-control" />
						</div>
						<div class="col-4" id="descriptionError"></div>
					</div>
						
					<input type="submit" class="btn btn-success" value="Register" class="form-control"/>
					<input type="reset" class="btn btn-danger" value="Clear" />

				</form:form>

			</div>
			<c:if test="${msg ne null }">
				<div class="card-footer bg-info text-white"><b>${msg}</b></div>
			</c:if>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/part.js"></script>
</body>
</html>
    

