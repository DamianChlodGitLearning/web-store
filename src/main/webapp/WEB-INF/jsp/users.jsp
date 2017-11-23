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

<%-- 	<section class="container">
		<form:form modelAttribute="newUser" class="form-horizontal">
			<fieldset>
				<legend>Add new user</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="password">Password</label>
					<div class="col-lg-10">
						<form:input id="password" path="password" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="firstName">First
						Name</label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="lastName">Last
						Name</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="birthdate">Birthdate</label>
					<div class="col-lg-10">
						<form:input id="birthdate" path="birthdate" type="date"
							class="form:input-large" />
					</div>
				</div>

				<div class="col-lg-offset-2">
					<form:select path="usersGroupList" items="${usersGroups}"
						itemLabel="name" itemValue="usersGroupId" multiple="true" />
				</div>
				<br>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Dodaj użytkownika" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
	<section>
		<div class="container">
			<a href="<spring:url value="/" />" class="btn btndefault"> <span
				class="glyphicon-hand-left glyphicon"></span> Back to main page
			</a>
		</div>
		<div class="container">
			<a href="<spring:url value="/usersGroups" />" class="btn btndefault"> <span
				class="glyphicon-hand-left glyphicon"></span> Go to groups management
			</a>
		</div>
	</section> --%>
	<!-- Users List -->

	<div class="container">
		<h2>User Table</h2>
		<p>basic information about users</p>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Birthdate</th>
					<th>Edit</th>
					<th>Delete</th>
					<th>Details</th>

				</tr>
			</thead>
			<c:forEach items="${users}" var="user">
				<tbody>
					<tr>
						<td>${user.userId}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.birthdate}</td>
						<td><a href="<c:url value='/users/edit/${user.userId}' />">edit</a></td>
						<td><a href="<c:url value='/users/delete/${user.userId}' />">delete</a></td>
						<td><a href="<c:url value='/users/details/${user.userId}' />">details</a></td>
					</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>
