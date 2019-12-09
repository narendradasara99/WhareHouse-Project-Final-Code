<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h1>Welcome to Grn Update Page</h1>
			</div>
			<div class="card-body">
				<form:form id="myForm" action="update" method="POST"
					modelAttribute="grn">
					
					
					<div class="row">
		  				 <div class="col-4">
		  					 <label for="id">ID</label>  </div>
		   					<div class="col-4">
		   		  		<form:input path="id" readonly="true" class="form-control"/>
		   			</div>
				</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="code"> CODE</label>
						</div>
						<div class="col-4">
							<form:input path="code" class="form-control" />
						</div>
						<div class="col-4" id="codeError"></div>
					</div>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="grnType"> GRNTYPE</label>
						</div>
						<div class="col-4">
							<form:input path="grnType" class="form-control" />
						</div>
						<div class="col-4" id="grnTypeError"></div>
					</div>
					
					<div class="row">
						<div class="col-4">Purchase Code</div>
						<div class="col-4">
							<form:select path="purchase.id" cssClass="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${pobs}"/>
							</form:select>
						</div>
						<div class="col-4"></div>
					</div>
					
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="note"> NOTE</label>
						</div>
						<div class="col-4">
							<form:textarea path="note" class="form-control" />
						</div>
						<div class="col-4" id="noteError"></div>
					</div>
					<input type="submit" value="Update" class="btn btn-success" />
				</form:form>
			</div>
			<div class="card-footer bg-info text-white">
				<b>${message}</b>
			</div>
		</div>
	</div>
</body>
</html>