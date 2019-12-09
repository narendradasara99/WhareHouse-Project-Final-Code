<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report</title>
</head>
<body>
 <table border="1" >
 
   <tr>
    <td>ID</td>
    <td>USERNAME</td>
    <td>FIRST NAME</td>
    <td>LAST NAME</td>
   </tr>
  
 
   <c:forEach items="${list}" var="ob" >
    <tr>
     <td>${ob.id }</td>
     <td>${ob.uomType }</td>
     <td>${ob.uomModel }</td>
     <td>${ob.description }</td>
     
     <spring:url value="/report/ob?=xls" var="xlsURL" />
 <spring:url value="/report/ob?=pdf" var="pdfURL" />
     
    </tr>
   </c:forEach>
   
 </table>
 <a href="${xlsURL}">Download Excel</a>
     <a href="${pdfURL}">Download PDF</a>
 </body>
</html>