<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 <head>
 </head>
<br><br>
 <body>   
 <%@include file="UserMenu.jsp" %>      	 
<div class="container">
 <div class="card">
   <div class="card-header bg-primary text-white">
      <h3>Welcome to shipment Register Page</h3>
   </div>
   
   <div class="card-body">
      <form:form id="myForm" action="save" method="POST" modelAttribute="shipmentType">
	   
		<div class="row">
		   <div class="col-4"> 
		    <label for="shipmentTypeMode"> Shipment Mode</label>   
		   </div>
		   <div class="col-4">
		    <form:select path="shipmentTypeMode"  class="form-control">
		        <form:option value="">-SELECT-</form:option>
				<form:option value="Air">Air</form:option>
				<form:option value=" truck">Truck</form:option>
				<form:option value="Ship">Ship</form:option>
				<form:option value="Train">Train</form:option>
		    </form:select>
		   </div>
		   <div class="col-4" id="shipmentTypeModeError"></div>
		</div>

		<div class="row">
		   <div class="col-4">
		   <label for="shipmentTypeCode">Shipment Code</label></div>
		   <div class="col-4">
		     <form:input path="shipmentTypeCode" class="form-control"/>
		   </div>
		    <div class="col-4" id="shipmentTypeCodeError"></div>
		</div>

		<div class="row">
		   <div class="col-4">
		   <label for="enableShipmentType"> EnableShipment </label>  </div>
		   <div class="col-4">

		   	<form:select path="enableShipmentType" class="form-control">
		        <form:option value="">SELECT</form:option>
				<form:option value="Yes">Yes</form:option>
				<form:option value="No">No</form:option>
		   </form:select>
		   </div>
		    <div class="col-4" id="enableShipmentTypeError"></div>
		   
		</div>


		<div class="row">
		   <div class="col-4">
		   <label for ="shipmentTypeGrade">Shipment Grade</label>  </div>
		   <div class="col-4">
		     <form:radiobutton path="shipmentTypeGrade" value="A"/> A
				<form:radiobutton  path="shipmentTypeGrade" value="B"/> B
				<form:radiobutton path="shipmentTypeGrade" value="C"/>C
		   </div>
		   <div class="col-4" id="shipmentTypeGradeError"></div>
		</div>

		<div class="row">
		   <div class="col-4">
		   <label for="description"> Description</label>
		   </div>
		   <div class="col-4">
		   
		   <form:textarea  path="description" class="form-control"></form:textarea>
		   </div>
		    <div class="col-4" id="descriptionError"></div>
		</div>
         

	 <input type="submit" class="btn btn-success" value="Create shipment"/>
     <input type="reset" class="btn btn-danger" value="Clear"/>
	  </form:form>
   </div>
   <c:if test="${msg ne null }">
	<div class="card-footer bg-info text-white"><b>${msg}</b></div>
			</c:if>
     
    </div>

  </div>
<script type="text/javascript" src="../resources/js/shipmentType.js"></script>
 </body>
</html>

