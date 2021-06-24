<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../include/head.jsp">
	<jsp:param name="title" value="Admin Privileges" />
</jsp:include>
<body>
	<!-- Navigation bar section -->
	<jsp:include page="../include/navbar.jsp"></jsp:include>
	
	<!-- Inform admin that the product was updated -->
	<c:if test="${not empty isUpdated}">
		<script type="text/javascript">alert("Product has been ${isUpdated}.");</script>
	</c:if>

	<section id="content">
		<div class="container">
			<h4>Admin Privileges</h4>
			<div class="admin-product mt-3" align="center">
				<h5>All Products</h5>
				<c:forEach var="product" items="${allProducts}">
					<div class="product-body mt-3">
						<div class="left-column mt-5">
							<img class="product-img" src="${product.image}" alt="Image Not Found" />
						</div>
						<div class="right-column">
							<div class="product-description">
								<h5 class="text-primary">${product.productType.name}</h5>
								<h1>${product.name}</h1>
								<p>${product.description}</p>
							</div>
							<div class="row">
								<div class="product-param col-md-4">
									<p>Total Quantity: ${product.totalQuantity}</p>
									<p>Quantity In Stock: ${product.quantityInStock}</p>
									<p>Daily Rental Rate: $${product.dailyRentalRate} per day</p>
								</div>
								<div class="btn-product-option col-md-8 justify-content-center">
									<a href="/admin/product/edit?id=${product.id}" class="btn btn-primary">Edit product</a>
									<a href="/admin/product/delete?id=${product.id}" class="btn btn-primary">Delete product</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<div>
					<a href="product/new" class="btn btn-primary mt-3">Add a Product</a>
				</div>
			</div>
			<div class="admin-order mt-3" align="center">
				<h5>All Orders</h5>
				<div>TODO</div>
			</div>
		</div>
	</section>

	<!-- Footer and Contact section -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>