<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Produkty</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Produkty</h1>
				<p>Dodaj produkty</p>
			</div>
			<a href="<c:url value="/j_spring_security_logout" />"
				class="btn btn-danger btn-mini pull-right"> Wyloguj </a>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newProduct" class="form-horizontal"
			enctype="multipart/form-data">
			<fieldset>
				<legend>Dodaj nowy produkt</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">Nazwa</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitPrice">Cena</label>
					<div class="col-lg-10">
						<form:input id="unitPrice" path="unitPrice" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Opis</label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows="2" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Liczba
						dostępnych sztuk</label>
					<div class="col-lg-10">
						<form:input id="unitsInStock" path="unitsInStock" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Kategoria</label>
					<form:select path="category.categoryId" items="${categorySet}"
						itemLabel="name" itemValue="categoryId" />
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Producent</label>
					<form:select path="manufacturer.manufacturerId"
						items="${manufacturerSet}" itemLabel="name"
						itemValue="manufacturerId" />
				</div>

				<%-- 				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">Liczba
						zamawianych sztuk</label>
					<div class="col-lg-10">
						<form:input id="unitsInOrder" path="unitsInOrder" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="condition">Wycofany</label>
					<div class="col-lg-10">
						<form:radiobutton path="discontinued" value="1" />
						Tak
						<form:radiobutton path="discontinued" value="0" />
						Nie
					</div>
				</div> --%>
				<div class="form-group">
					<label class="control-label col-lg-2" for="condition">Stan</label>
					<div class="col-lg-10">
						<form:radiobutton path="condition" value="New" />
						Nowy
						<form:radiobutton path="condition" value="Old" />
						Używany
						<form:radiobutton path="condition" value="Refurbished" />
						Odnowiony
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="productImage"> <spring:message
							code="addProduct.form.productImage.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="productImage" path="productImage" type="file"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Dodaj" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>
