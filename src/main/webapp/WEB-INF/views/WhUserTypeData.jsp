<%@page import="org.springframework.web.util.UriBuilderFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
	
</head>
<body>
<%@include file="UserMenu.jsp" %>
<div class="container">
 <div class="card">
   <div class="card-header bg-primary text-white">
      <h3>Welcome to WhUserType Data Page</h3>
   </div>
   <div class="card-body">
    <a href="excel"><img src="../resources/images/excel.png" width="70",height="40"></a> 
     <a href="pdf"><img src="../resources/images/pdf.png" width="70",height="40"></a>
 		 <table border="1" class="table table-bordered table-hover">
			<tr class="table-success">
				<tr>

             <th>Id</th>
			<th>WHUSER TYPE</th>
			<th>WHUSER CODE</th> 
			<th>WHUSER FOR</th> 
			<th>WHUSER EMAIL</th> 
			<th>WHUSER CONTACT</th> 
			<th>WHUSER ID TYPE</th> 
			<th>WHUSER ID IF OTHER</th> 
			<th>WHUSER ID NUMBER</th> 
			<th colspan="3">OPERATION</th> 
			</tr>
			
			<c:forEach items="${list}" var ="ob">
			<tr>
			<td><c:out value="${ob.id}"/></td>
			<td><c:out value="${ob.whuserType}"/></td>
			<td><c:out value="${ob.whuserCode}"/></td>
			<td><c:out value="${ob.whuserFor}"/></td>
			<td><c:out value="${ob.whuserEmail}"/></td>
			<td><c:out value="${ob.whuserContact}"/></td>
			<td><c:out value="${ob.whuserIdType}"/></td>
			<td><c:out value="${ob.whuserIdOther}"/></td>
			<td><c:out value="${ob.whuserIdNumber}"/></td>
			
			<td><a href="delete?id=${ob.id}"><img src="../resources/images/delete.png" width="30",height="50"></a></td>
			<td><a href="edit?id=${ob.id}"><img src="../resources/images/edit.png" width="30",height="50"></a></td>
			<td><a href="view?id=${ob.id}"><img src="../resources/images/view.png" width="30",height="50"></a></td>
			</tr>
			</c:forEach>		

			</table>
			</div>
			<div class="card-footer bg-info" align="center">
			<b>${msg}</b>
			</div>
		</div>
		</div>
	</body>
</html>