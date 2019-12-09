<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url"
	value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- ****************MENU BAR STARTS HERE********* -->

<nav class="navbar navbar-expand-sm bg-dark navbar-dark ">
	<!-- Brand -->
	<a class="navbar-brand " href="#"><img
		src="../resources/images/logo.png" width="100" height="60" /></a>

	<!-- Links -->
	<ul class="navbar-nav">
		



		<!-- **** START: Uom ***-->
		<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle text-white"
			href="#" id="navbardrop" data-toggle="dropdown"> <b> UOM </b> </a>
			<div class="dropdown-menu">
				<a class="dropdown-item " href="${url}/uom/register">Register</a> 
				<a class="dropdown-item" href="${url}/uom/all">View All</a>
				<a class="dropdown-item" href="${url}/uom/charts">Charts</a>
			</div>
       </li>
       <!--** END UOM **-->
       
       
       
       
       <!-- **** START: orderMethod ***-->
		<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle text-white"
			href="#" id="navbardrop" data-toggle="dropdown"> <b> ORDER METHOD </b> </a>
			<div class="dropdown-menu">
				<a class="dropdown-item " href="${url}/ordermethod/register">Register </a> 
					<a class="dropdown-item" href="${url}/ordermethod/all">View All</a>
				<a class="dropdown-item" href="${url}/ordermethod/charts">Charts</a>
			</div>
       </li>
       <!--** END OM **-->
       
        
       <!-- **** START: PART ***-->
		<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle text-white"
			href="#" id="navbardrop" data-toggle="dropdown"> <b> PART </b> </a>
			<div class="dropdown-menu">
				<a class="dropdown-item " href="${url}/part/register">Register</a> 
				<a class="dropdown-item" href="${url}/part/all">View All</a>
				<a class="dropdown-item" href="${url}/part/charts">Charts</a>
			</div>
       </li>
       <!--** END : PART **-->
       
       
       
       
       <!-- **** START: Shipment Type ***-->
		<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle text-white"
			href="#" id="navbardrop" data-toggle="dropdown"> <b> SHIPMENT TYPE </b> </a>
			<div class="dropdown-menu">
				<a class="dropdown-item " href="${url}/ship/register">Register</a> 
				<a class="dropdown-item" href="${url}/ship/all">View All</a>
				<a class="dropdown-item" href="${url}/ship/charts">Charts</a>
			</div>
       </li>
       <!--** END : Shipment Type **-->
       
       
       
       
       <!-- **** START: WhUserType ***-->
		<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle text-white"
			href="#" id="navbardrop" data-toggle="dropdown"> <b>WHUSER TYPE </b> </a>
			<div class="dropdown-menu">
				<a class="dropdown-item " href="${url}/whuser/register">Register</a> 
				<a class="dropdown-item" href="${url}/whuser/all">View All</a>
				<a class="dropdown-item" href="${url}/whuser/charts">Charts</a>
			</div>
       </li>
       <!--** END : WhUserType**-->
       
       
       <!-- **** START: PURCHASE ***-->
		<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle text-white"
			href="#" id="navbardrop" data-toggle="dropdown"> <b> PURCHASE </b> </a>
			<div class="dropdown-menu">
				<a class="dropdown-item " href="${url}/purchase/register">Register</a> 
				<a class="dropdown-item" href="${url}/purchase/all">View All</a>
				<a class="dropdown-item" href="${url}/purchase/charts">Charts</a>
			</div>
       </li>
       <!--** END : PURCHASE **-->
       
       <!-- **** START: Grn ***-->
		<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle text-white"
			href="#" id="navbardrop" data-toggle="dropdown"> <b> GRN </b> </a>
			<div class="dropdown-menu">
				<a class="dropdown-item " href="${url}/grn/register">Register</a> 
				<a class="dropdown-item" href="${url}/grn/all">View All</a>
				<a class="dropdown-item" href="${url}/grn/charts">Charts</a>
			</div>
       </li>
       <!--** END : Grn **-->
       
        <!-- **** START: Sale ***-->
		<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle text-white"
			href="#" id="navbardrop" data-toggle="dropdown"> <b> SALE </b> </a>
			<div class="dropdown-menu">
				<a class="dropdown-item " href="${url}/sale/register">Register</a> 
				<a class="dropdown-item" href="${url}/sale/all">View All</a>
				<a class="dropdown-item" href="${url}/sale/charts">Charts</a>
			</div>
       </li>
       <!--** END : Sale**-->
       
       
       
       
       <!-- **** START: Shipping ***-->
		<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle text-white"
			href="#" id="navbardrop" data-toggle="dropdown"> <b> SHIPPING </b> </a>
			<div class="dropdown-menu">
				<a class="dropdown-item " href="${url}/shipping/register">Register</a> 
				<a class="dropdown-item" href="${url}/shipping/all">View All</a>
				<a class="dropdown-item" href="${url}/shipping/charts">Charts</a>
			</div>
       </li>
       <!--** END : Shipping **-->
       
       
      
       
     
       
       <!-- **** START: USER ***-->
		<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle text-white"
			href="#" id="navbardrop" data-toggle="dropdown"> <b> USER </b> </a>
			<div class="dropdown-menu">
				<a class="dropdown-item " href="${url}/user/register">Register</a> 
				
			</div>
       </li>
       <!--** END : USER **-->
       
       
       
       
       
       
       
       
       
      
       
       
       
       
       <!-- Documents -->
       <li class="nav-item"><a class="nav-link text-white" href="${url}/document/register"><b>DOCUMENTS</b></a></li>
       
		

		<!-- Logout Link -->
		<li class="nav-item"><a class="nav-link text-white" href="${url}/logout"><b>LOGOUT</b></a></li>
		
	</ul>
</nav>
<h3><span style="color:green">Welcome To user</span><span style="color:red">::</span> ${userName}</h3>
