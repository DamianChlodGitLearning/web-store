<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Users</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Users</h1>
				<p>Users management system</p>
			</div>
		</div>
	</section>


	<!-- User-->
	<section class="container col-lg-6">
		<div class="row">
			<div class="col-lg-5 col-lg-offset-3">
				<p>
					<strong>User ID: </strong>${user.userId}
				</p>
				<p>
					<strong>Name</strong>: ${user.name}
				</p>
				<p>
					<strong>First name: </strong>${user.firstName}
				</p>
				<p>
					<strong>Last name: </strong>${user.lastName}
				</p>
				<p>
					<strong>Password</strong>: ${user.password}
				</p>
				<p>
					<strong>Birthdate</strong>:${user.birthdate}
				</p>

				<strong>Role</strong>:
				<c:forEach items="${userRole}" var="userRole">
					<h6>${userRole.name}</h6>
				</c:forEach>
				<a href="<spring:url value="/users" />" class="btn btndefault">
					<span class="glyphicon-hand-left glyphicon"></span> Back
				</a>
			</div>
		</div>
	</section>

</body>
</html>
