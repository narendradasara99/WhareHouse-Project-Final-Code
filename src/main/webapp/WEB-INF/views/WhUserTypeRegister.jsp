<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<br>
<br>
<BODY>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white" align="center">
				<h3>Welcome to WhUserType Register Page</h3>
			</div>

			<div class="card-body">
				<form:form id="whuserForm" action="save" method="POST"
					modelAttribute="whUserType"  enctype="multipart/form-data">
		
					<div class="row">
						<div class="col-4">
							<label for="whuserType">USER TYPE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="whuserType" value="Vendor" />
							vendor
							<form:radiobutton path="whuserType" value="Customer" />
							Customer
						</div>
						<div class="col-4" id="utypeError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="whuserFor">USER FOR</label> 
						</div>
						<div class="col-4">
							<form:input path="whuserFor" class="form-control" readonly="true" />
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="whuserCode">USER CODE</label>
						</div>
						<div class="col-4">
							<form:input path="whuserCode" class="form-control" />
						</div>
						<div class="col-4" id="ucodeError"></div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="whuserEmail">USER EMAIL</label>
						</div>

						<div class="col-4">
							<form:input type="email" path="whuserEmail" class="form-control" />
						</div>
						<div class="col-4" id="uemailError"></div>
					</div>

						<div class="row">
						<div class="col-4">
							<label for="whuserContact"> CONTACT</label>
						</div>
						<div class="col-4">
							<form:input path="whuserContact" class="form-control"/>
						</div>
						<div class="col-4" id="ucontactError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="whuserIdType">USER ID TYPE</label>
						</div>
						<div class="col-4">
							<form:select path="whuserIdType" class="form-control">
								<form:option value="">-SELECT ID-</form:option>
								<form:option value="PANCARD">PAN CARD</form:option>
								<form:option value="ADHAR CARD">ADHAR CARD</form:option>
								<form:option value="VOTERID">VOTERID</form:option>
								<form:option value="OTHER">OTHER</form:option>
							</form:select>
						</div>
						<div class="col-4" id="uidtypeError"></div>

					</div>

					<div class="row">
						<div class="col-4">
							<label for="whuserIdOther">IF OTHER</label>
						</div>
						<div class="col-4">
							<form:input path="whuserIdOther" class="form-control" />
						</div>
						
					</div>

					<div class="row">
						<div class="col-4">
							<label for="whuserIdNumber">ID NUMBER </label>
						</div>
						<div class="col-4">
							<form:input path="whuserIdNumber" class="form-control" />
						</div>
						<div class="col-4" id="idnoError"></div>
					</div>
						
						
						
                   <!--new Row for email -->
					<div class="row">
						<div class="col-4">
							<label for="note">DOCUMENT</label>
						</div>
						<div class="col-4">
							<input type="file" name="fileDoc" class="form-control" />
						</div>
					</div>


					<input type="submit" class="btn btn-success" value="Create User" />
					<input type="reset" class="btn btn-danger" value="Clear" />
				</form:form>
			</div>
			<c:if test="${msg ne null }">
				<div class="card-footer bg-info text-white">
					<b>${msg}</b>
				</div>
			</c:if>
		</div>
	</div>

	<script type="text/javascript"
		src="../resources/js/whuserAutofillCode.js"></script>
	<script type="text/javascript"
		src="../resources/js/whusertypevalidate.js"></script>
		
			<script type="text/javascript" src="../resources/js/whuser.js"></script>

</body>
</html>
