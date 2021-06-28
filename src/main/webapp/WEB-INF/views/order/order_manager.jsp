<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../include/head.jsp">
	<jsp:param name="title" value="Orders" />
</jsp:include>
<body>
	<!-- Navigation bar section -->
	<jsp:include page="../include/navbar.jsp"></jsp:include>

	<section id="content">
		<div class="container">
			<h4>Orders</h4>
			<div class="orders mt-3" align="center">
				<c:forEach var="order" items="${orders}">
					<div class="order-body mt-3">
						<div class="row d-flex justify-content-center">
							<h1>Order #${order.id}</h1>
						</div>
						<div class="row">
							<div class="order-param col-md-5">
								<p>Order Date: ${order.orderDate}</p>
								<p>Return Date: ${order.returnDate}</p>
							</div>
							<div class="order-param col-md-3">
								<p>Status: ${order.status}</p>
								<p>Subtotal: ${order.subtotal}</p>
							</div>
							<div class="btn-order-option col-md-4">
								<c:if test="${order.status != 'Cancelled'}">
								<a href="/order/update?id=${order.id}" class="btn btn-primary">Update</a>
								<a href="/order/cancel?id=${order.id}" class="btn btn-primary">Cancel</a>
								</c:if>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<!-- Footer and Contact section -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>