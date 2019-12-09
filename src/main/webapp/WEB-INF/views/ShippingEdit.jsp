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
      <h3>Welcome to Shipping Edit Page</h3>
   </div>
   
   <div class="card-body">
      <form:form action="update" method="POST" modelAttribute="shipping">
      
      <div class="row">
		  				 <div class="col-4">
		  					 <label for="id">ID</label>  </div>
		   					<div class="col-4">
		   		  		<form:input path="id" readonly="true" class="form-control"/>
		   			</div>
				</div>
      	
      	<div class="row">
		   <div class="col-4">
		   <label for="shippingCode">Shipping Code</label>  </div>
		   <div class="col-4">
		     <form:input path="shippingCode" class="form-control"/>
		   </div>
		</div>
	   
		<div class="row">
		   <div class="col-4"> 
		    <label for="shippingRefNum">Shipment Ref. Number</label>   
		   </div>
		   <div class="col-4">
		    <form:input  path="shippingRefNum"  class="form-control"/>
		   </div>
		   </div>
		   
		   <div class="row">
		   <div class="col-4">
		   <label for="billToaddress">Bill To Address </label>
		   </div>
		   <div class="col-4">
		   <form:textarea path="billToaddress" class="form-control"/>
		  
		   </div>
		</div> 	 	
		
		<div class="row">
		   <div class="col-4"> 
		    <label for="corierRefNum">Corier Ref. Number</label>   
		   </div>
		   <div class="col-4">
		    <form:input path="corierRefNum"  class="form-control"/>
		   </div>
		</div>
		
		<div class="row">
		   <div class="col-4"> 
		    <label for="contactDetails">Contact Details </label>   
		   </div>
		   <div class="col-4">
		  <form:textarea path="contactDetails"  class="form-control"/>
		   </div>
		</div>
		
		<div class="row">
		   <div class="col-4"> 
		    <label for="saleOrderCode">Sale Order Code</label>   
		   </div>
		   <div class="col-4">
		     <form:select path="saleOrder.id" class="form-control">
					<form:option value="">-SELECT-</form:option>
					<form:options items="${sale}"/>
			</form:select>
		   </div>
		   </div>
		   
		   <div class="row">
		   <div class="col-4">
		   <label for="description">Description </label>
		   </div>
		   <div class="col-4">
		   <form:textarea path="description"  class="form-control"/>
		   </div>
		   </div>
		   
		   <div class="row">
		   <div class="col-4">
		   <label for="shipToaddress">ship To Address</label>
		   </div>
		   <div class="col-4">
		   <form:textarea path="shipToAddress"  class="form-control"/>
		   </div>
		   </div>

	
		
		   
		  <input type="submit" class="btn btn-success" value="Update"/>
     <input type="reset" class="btn btn-danger" value="Clear"/>
     </form:form>
     </div>
   <c:if test="${msg ne null }">
	<div class="card-footer bg-info text-white"><b>${msg}</b></div>
			</c:if>
    
   </div>
   </div>
   


 
 </body>
</html>

