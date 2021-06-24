<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<jsp:include page="../include/head.jsp">
	<jsp:param name="title" value="Edit Product" />
</jsp:include>
<body>
	<!-- Navigation bar section -->
	<jsp:include page="../include/navbar.jsp"></jsp:include>
	
	<section id="content">
		<div class="container d-flex justify-content-center">
			<form:form action="/admin/product/update" method="POSt" modelAttribute="productForm" class="form-content shadow">
				<h4 class="form-heading py-2">Edit your product</h4>
				<div class="form-params align-items-center">
					<form:hidden path="id"/>
					<div class="row">
						<div class="form-param col-md-6">
							<form:label path="name">Name</form:label>
							<form:input type="text" path="name" cssClass="form-input"
								placeholder="Name" autofocus="true"></form:input>
							<form:errors path="name" cssClass="form-error"></form:errors>
						</div>
						<div class="form-param col-md-6">
							<form:label path="image">Image URL</form:label>
							<form:input type="text" path="image" cssClass="form-input" 
								placeholder="Image URL"></form:input>
							<form:errors path="image" cssClass="form-error"></form:errors>
						</div>
					</div>
					<div class="row">
						<div class="form-param col-md-6">
							<form:label path="description">Description</form:label>
							<form:input type="text" path="description" cssClass="form-input"
								value="${lorem}"></form:input>
							<form:errors path="description" cssClass="form-error"></form:errors>
						</div>
						<div class="form-param col-md-3">
							<form:label path="totalQuantity">Total Quantity</form:label>
							<form:input type="number" path="totalQuantity" cssClass="form-input"></form:input>
							<form:errors path="totalQuantity" cssClass="form-error"></form:errors>
						</div>
						<div class="form-param col-md-3">
							<form:label path="dailyRentalRate">Daily Rental Rate</form:label>
							<form:input type="number" path="dailyRentalRate" cssClass="form-input" step="any"></form:input>
							<form:errors path="dailyRentalRate" cssClass="form-error"></form:errors>
						</div>
					</div>
					<div class="row">
						<div class="form-param col-md-3">
							<form:label path="productType.name">ProductType</form:label>
							<form:select path="productType.name" items="${allProductTypes}" 
								cssClass="form-input"></form:select>
							<form:errors path="productType.name" cssClass="form-error"></form:errors>
						</div>
					</div>
					<div class="form-param text-center">
						<button class="btn btn-primary form-button" type="submit">Edit</button>
					</div>
				</div>
			</form:form>
		</div>
	</section>

	<!-- Footer and Contact section -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>