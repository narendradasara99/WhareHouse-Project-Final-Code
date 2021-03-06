<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@include file="UserMenu.jsp" %>
<div class="container">
 <div class="card">
   <div class="card-header bg-primary text-white">
      <h3>Welcome to Shipping Register Page</h3>
   </div>
   
   <div class="card-body">
      <form:form  id="shippingForm" action="save" method="POST" modelAttribute="shipping">
      	
      	<div class="row">
		   <div class="col-4">
		   <label for="shippingCode">SHIPPING CODE</label>  </div>
		   <div class="col-4">
		     <form:input path="shippingCode" class="form-control"/>
		   </div>
		   <div class="col-4" id="shippingCodeError"></div>
		</div>
	   
		<div class="row">
		   <div class="col-4"> 
		    <label for="shippingRefNum">SHIPMENT REF. NUMBER</label>   
		   </div>
		   <div class="col-4">
		    <form:input  path="shippingRefNum"  class="form-control"/>
		   </div>
		   <div class="col-4" id="shippingRefNumberError"></div>
		   </div>
		   
		   <div class="row">
		   <div class="col-4">
		   <label for="billToaddress">BILL TO ADDRESS </label>
		   </div>
		   <div class="col-4">
		   <form:textarea path="billToaddress" class="form-control"/>
		  
		   </div>
		   <div class="col-4" id="billToAddressError"></div>
		</div> 	
		
		
		 <div class="row">
		   <div class="col-4">
		   <label for="shipToaddress">SHIP TO ADDRESS</label>
		   </div>
		   <div class="col-4">
		   <form:textarea path="shipToAddress"  class="form-control"/>
		   </div>
		   <div class="col-4" id="shipToAddressError"></div>
		   </div> 	
		
		<div class="row">
		   <div class="col-4"> 
		    <label for="corierRefNum">CORIER REF.NUMBER</label>   
		   </div>
		   <div class="col-4">
		    <form:input path="corierRefNum"  class="form-control"/>
		   </div>
		   <div class="col-4" id="courierRefNumberError"></div>
		</div>
		
		<div class="row">
		   <div class="col-4"> 
		    <label for="contactDetails">CONTACT DETAIL</label>   
		   </div>
		   <div class="col-4">
		  <form:textarea path="contactDetails"  class="form-control"/>
		   </div>
		   <div class="col-4" id="contactDetailsError"></div>
		</div>
		
		<div class="row">
		   <div class="col-4"> 
		    <label for="saleOrderCode">SALE ORDER CODE</label>   
		   </div>
		   <div class="col-4">
		     <form:select path="saleOrder.id" class="form-control">
					<form:option value="">-SELECT-</form:option>
					<form:options items="${sale}"/>
			</form:select>
		   </div>
		  <!--  <div class="col-4" id="saleOrderCodeError"></div> -->
		   </div>
		   
		   <div class="row">
		   <div class="col-4">
		   <label for="description">DESCRIPTION</label>
		   </div>
		   <div class="col-4">
		   <form:textarea path="description"  class="form-control"/>
		   </div>
		   <div class="col-4" id="descriptionError"></div>
		   </div>
		   
		  

		  <input type="submit" class="btn btn-success" value="Create shipping"/>
     <input type="reset" class="btn btn-danger" value="Clear"/>
     </form:form>
     </div>
   <c:if test="${msg ne null }">
	<div class="card-footer bg-info text-white"><b>${msg}</b></div>
			</c:if>
    
   </div>
   </div>
  
 <script type="text/javascript" src="../resources/js/shipping.js"></script>
 </body>
</html>

