<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../include/head.jsp">
	<jsp:param name="title" value="Product Catalog" />
</jsp:include>
<body>
	<!-- Navigation bar section -->
	<jsp:include page="../include/navbar.jsp"></jsp:include>

	<section id="content">
		<div class="container">
			<div class="row">
				<h4>Product Catalog</h4>
				<div class="product-search ml-auto">
					<form action="/product/search" class="product-search-bar form-inline">
						<i class="search-icon fa fa-search"></i>
						<input type="search" name="productName" class="search-input form-control mr-2" placeholder="Search product" />
						<button type="submit" class="btn btn-primary btn-search my-2 my-sm-0">Search</button>
					</form>
				</div>
			</div>
			<div class="product mt-3" align="center">
				<h5 class="text-uppercase">${productType} Products</h5>
				<div class="product-type">
					<label for="product-type">Product Type</label>
					<select name="product-type" onchange="location = value;">
						<option value="#">--</option>
						<option value="/product/type?productType=all">All</option>
						<option value="/product/type?productType=earthmoving">Earthmoving</option>
						<option value="/product/type?productType=platform">Platform</option>
						<option value="/product/type?productType=forklift">Forklift</option>
						<option value="/product/type?productType=compressor">Compressor</option>
						<option value="/product/type?productType=tower">Light Tower</option>
						<option value="/product/type?productType=generator">Generator</option>
						<option value="/product/type?productType=truck">Truck</option>
					</select>
				</div>
				<c:forEach var="product" items="${allProductsByType}">
					<form action="/product/cart">
						<div class="product-body mt-3">
							<div class="left-column mt-5">
								<img class="product-img" src="${product.image}" alt="Image Not Found" />
							</div>
							<div class="right-column">
								<div class="product-description">
									<h5 class="text-uppercase text-primary">${product.productType.name}</h5>
									<h1>${product.name}</h1>
									<p>${product.description}</p>
								</div>
								<div class="row">
									<div class="product-param col-md-5">
										<p>Total Quantity: ${product.totalQuantity}</p>
										<p>Quantity In Stock: ${product.quantityInStock}</p>
										<p>Daily Rental Rate: $${product.dailyRentalRate} per day</p>
									</div>
									<div class="btn-product-option col-md-7 justify-content-center">
										<input type="hidden" name="productId" value="${product.id}">
										<input type="number" name="quantityOrdered" min="1" value="1">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<button type="submit" class="btn btn-primary">Add to Cart</button>
									</div>
								</div>
							</div>
						</div>
					</form>
				</c:forEach>
			</div>
		</div>
	</section>

	<!-- Footer and Contact section -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>