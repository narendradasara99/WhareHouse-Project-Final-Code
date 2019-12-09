
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
				<h3>Welcome to <span style="color:red">Uom Register</span> Page.</h3>			</div>
			<div class="card-body">
				<form:form id="myForm" action="save" method="POST" modelAttribute="uom">
					<!--1st row-->
					<div class="row">
						<div class="col-4">
							<label for="uomType">UOM TYPE</label>
						</div>
						<div class="col-4">
							<form:select path="uomType" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="PACKING">PACKING</form:option>
								<form:option value="NO PACKING">NO PACKING</form:option>
								<form:option value="NA">NA</form:option>
							</form:select>
						</div>
						<div class="col-4" id="uomTypeError"></div>
					</div>

					<!--2nd row-->
					<div class="row">
						<div class="col-4">
							<label for="uomModel">UOM MODEL</label>
						</div>
						<div class="col-4">
							<form:input  path="uomModel"
								class="form-control" maxlength="8"/>
						</div>
						<div class="col-4" id="uomModelError"></div>
					</div>

					<!--3rd row-->
					<div class="row">
						<div class="col-4">
							<label for="description">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="description"
								class="form-control"/>
						</div>
						<div class="col-4" id="descriptionError"></div>
					</div>

					<input type="submit" class="btn btn-success" value="Register" />
					<input type="reset" class="btn btn-danger" value="Clear" />

				</form:form>

			</div>
			<c:if test="${msg ne null }">
				<div class="card-footer bg-info text-white"><b>${msg}</b></div>
			</c:if>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/uom.jsp"></script>

</body>
</html>
    

