<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>\
<div class="container">

		<div class="card">
			<div class="card-header bg-info text-white">
				<h3>Welcome to Shipping PARTS</h3>
			</div>



			<div class="card-body">

<table class="table table-bordered">
<tr>
						
							<th>ITEMCODE</th>
							<th>BASE COST</th>
							<th>QUANTITY</th>
							<th>ITEM VALUE</th>
							<th colspan="2">OPERATIONS</th>
						</tr>

	<c:forEach  items="${childs}" var= "ob">
	<tr>
	
<td><c:out value ="${ob.itemCode}"/></td>
<td><c:out value ="${ob.baseCost}"/></td>
<td><c:out value ="${ob.qnty}"/></td>
<td><c:out value ="${ob.itemVal}"/></td>
<td><a href="#" class ="btn btn-success">ACCEPT</a></td>
<td><a href="#" class ="btn btn-danger">REJECT</a></td>
	
	
	</tr>
	</c:forEach>
</table>
</div>
</div>
</div>

</body>
</html>


