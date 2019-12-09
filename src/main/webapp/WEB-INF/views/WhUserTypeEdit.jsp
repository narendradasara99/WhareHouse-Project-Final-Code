<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<HTML>
<HEAD>
</HEAD>
<br>
<br>
<BODY>
<%@include file="UserMenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white" align="center">
				<h3>Welcome to WhUserType Register Page</h3>
			</div>

			<div class="card-body">

				
				<form:form  action="update" method="POST" modelAttribute="user">


					<div class="row">
		   <div class="col-4">
		   <label for="uid">ID</label>  </div>
		   <div class="col-4">
		     <form:input path="id" readonly="true" class="form-control"/>
		   </div>
		</div>


					<div class="row">
						<div class="col-4">
							<label for="whuserType">User Type</label>
						</div>
						<div class="col-4">
							<form:radiobutton  path="whuserType" value="Vendor"/>
							vendor <form:radiobutton  path="whuserType" value="Customer"/>Customer

						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="whuserCode">User Code</label>
						</div>
						<div class="col-4">
							<form:input  path="whuserCode" id="usercode"
								class="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="whuserFor">User For</label> <br>(auto fill) 
						</div>
						<div class="col-4">
							<form:input  path="whuserFor" id="whuserFor"
								class="form-control" placeholder="Purchase/Sale" />
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="whuserEmail">User Email</label>
						</div>

						<div class="col-4">
							<form:input  path="whuserEmail" id="whuserEmail"
								class="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="whuserContact">User Contact</label>
						</div>
						<div class="col-4">
							<form:input path="whuserContact" id="whuserContact"
								class="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="whuserIdType"> User IdType</label>
						</div>
						<div class="col-4">
							<form:select path="whuserIdType" id="whuserIdType"
								class="form-control">
								<form:option value="">-SELECT ID-</form:option>
								<form:option value="PANCARD">PAN CARD</form:option>
								<form:option value="ADHAR CARD">ADHAR CARD</form:option>
								<form:option value="VOTERID">VOTERID</form:option>
								<form:option value="OTHER">OTHER</form:option>
							</form:select>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="whuserIdOther"> If Other </label>
						</div>
						<div class="col-4">
							<form:input path="whuserIdOther" id="whuserIdOther"
								class="form-control"/>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="whuserIdNumber"> IDNumber </label>
						</div>
						<div class="col-4">
							<form:input path="whuserIdNumber" id="whuserIdNumber"
								class="form-control"/>
						</div>
					</div>



					<input type="submit" class="btn btn-success" value="Update" /> <input
						type="reset" class="btn btn-danger" value="Clear" />
				</form:form>
			</div>
			<div class="card-footer bg-info" align="center">
				<b>${msg}</b>
			</div>

		</div>

	</div>
</BODY>
</HTML>
