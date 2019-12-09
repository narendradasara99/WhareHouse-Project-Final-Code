<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h1>Welcome to Grn Register Page</h1>
			</div>
			<div class="card-body">
				<form:form id="grnForm" action="save" method="POST"
					modelAttribute="grn">
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="code"> CODE</label>
						</div>
						<div class="col-4">
							<form:input path="code" class="form-control" />
						</div>
						<div class="col-4" id="grnCodeError"></div>
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
						<div class="col-4">PURCHASE CODE</div>
						<div class="col-4">
							<form:select path="purchase.id" cssClass="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${pobs}"/>
							</form:select>
						</div>
						<div class="col-4" id="grnModeError"></div>
					</div>
					
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="note">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="note" class="form-control" />
						</div>
						<div class="col-4" id="descriptionError"></div>
					</div>
					<input type="submit" value="Register" class="btn btn-success" />
				</form:form>
			</div>
			<div class="card-footer bg-info text-white">
				<b>${message}</b>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/grn.js"></script>
</body>
</html>