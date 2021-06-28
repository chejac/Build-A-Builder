<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<jsp:include page="../include/head.jsp">
	<jsp:param name="title" value="Edit Order" />
</jsp:include>
<body>
	<!-- Navigation bar section -->
	<jsp:include page="../include/navbar.jsp"></jsp:include>

	<section id="content">
		<div class="container d-flex justify-content-center">
			<form:form method="POST" modelAttribute="orderForm" class="form-content shadow">
				<h4 class="form-heading py-2">Edit Order</h4>
				<div class="form-params align-items-center">
					<div class="row">
						<div class="form-param col-md-7">
							<form:label path="orderDate">Order Date</form:label>
							<br/><fmt:formatDate pattern="MM-dd-yyyy" value="${orderForm.orderDate}"/>
							<form:hidden path="orderDate"/>
						</div>
					</div>
					<div class="row">
						<div class="form-param col-md-7">
							<form:label path="returnDate">Return Date</form:label>
							<form:input type="date" path="returnDate" cssClass="form-input"></form:input>
							<form:errors path="returnDate" cssClass="form-error"></form:errors>
						</div>
					</div>
					<div class="form-param text-center">
						<button class="btn btn-primary form-button" type="submit">Complete Order</button>
					</div>
				</div>
			</form:form>
		</div>
	</section>

	<!-- Footer and Contact section -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>