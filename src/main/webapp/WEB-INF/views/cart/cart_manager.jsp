<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<jsp:include page="../include/head.jsp">
	<jsp:param name="title" value="Cart" />
</jsp:include>
<body>
	<!-- Navigation bar section -->
	<jsp:include page="../include/navbar.jsp"></jsp:include>

	<section id="content">
		<div class="container">
			<h4>Cart</h4>
			<div class="cart mt-3" align="center">
				<form action="/cart/order">
					<c:forEach var="cartDetail" items="${allCartDetails}">
						<div class="cart-body mt-3">
							<div class="row d-flex justify-content-center">
								<h1>${cartDetail.product.name}</h1>
							</div>
							<div class="row">
								<div class="left-column ml-5">
									<img class="cart-img" src="${cartDetail.product.image}" alt="Image Not Found" />
								</div>
								<div class="right-column ml-5">
									<div class="row">
										<div class="cart-param col-md-4">
											<p class="m-0">Daily Rental Rate: <fmt:formatNumber value="${cartDetail.product.dailyRentalRate}" type="currency"/> per day</p>
										</div>
										<div class="btn-cart-option col-md-8 align-self-center">
											<input type="number" id="${cartDetail.id}" value="${cartDetail.quantityOrdered}"/>
											<a onclick="getInputValue(${cartDetail.id})" class="btn btn-primary text-white">Update</a>
											<a href="/cart/delete?id=${cartDetail.id}" class="btn btn-primary">Delete</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<h1 id="empty-cart-header"></h1>
					<div class="btn-cart-submit col-md-8 justify-content-center">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<button type="submit" id="btn-submit-order" class="btn btn-primary">Submit Order</button>
					</div>
					<!-- Disable submit button when cart is empty -->
					<c:if test="${empty allCartDetails}">
						<script type="text/javascript">
							document.getElementById('empty-cart-header').innerHTML = "Cart is Empty";
							document.getElementById('btn-submit-order').disabled = true;
						</script>
					</c:if>
				</form>
				<form id="inputValueForm" action="/cart/update">
					<input type="hidden" id="inputValue" name="inputValue"/>
					<input type="hidden" id="cartDetailId" name="cartDetailId"/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
			</div>
		</div>
	</section>

	<!-- Footer and Contact section -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>