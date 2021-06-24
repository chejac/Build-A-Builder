<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../include/head.jsp">
	<jsp:param name="title" value="Login" />
</jsp:include>
<body>
	<!-- Navigation bar section -->
	<jsp:include page="../include/navbar.jsp"></jsp:include>
	
	<!-- Inform user that they are logged out -->
	<c:if test="${not empty loggedOut}">
		<script type="text/javascript">alert("${loggedOut}");</script>
	</c:if>
	
	<section id="content">
		<div class="container d-flex justify-content-center">
			<form action="/login" method="POST" class="form-content shadow">
				<h4 class="form-heading py-2">Log in</h4>
				<div class="form-params align-items-center">
					<div class="row">
						<div class="form-param col-md-12">
							<label for="username">Username</label>
							<input type="text" name="username" 
								class="form-input" placeholder="Username" />
						</div>
					</div>
					<div class="row">
						<div class="form-param col-md-12">
							<label for="password">Password</label>
							<input type="password" name="password" 
								class="form-input" placeholder="Password" />
						</div>
					</div>
					<div class="form-param form-error">
						<span>${error}</span>
					</div>
					<div class="form-param text-center">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<button class="btn btn-primary form-button" type="submit">Log in</button>
					</div>
					<h5 class="text-center">
						<a href="/register">Create an account</a>
					</h5>
				</div>
			</form>
		</div>
	</section>

	<!-- Footer and Contact section -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>