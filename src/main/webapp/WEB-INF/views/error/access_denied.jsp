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
	
	<section id="content" class="d-flex justify-content-center">
		<div class="container">
			<div align="center">
				<img class="error-img" src="/img/access-denied.png" alt="Image Not Found" />
				<h2>Sorry, you do not have permission to view this page.</h2>
				<p>Click <a href="/">here</a> to go back to the Home page.</p>
			</div>
		</div>
	</section>
	
	<!-- Footer and Contact section -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>