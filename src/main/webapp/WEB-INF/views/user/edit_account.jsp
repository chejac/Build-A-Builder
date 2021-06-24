<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<jsp:include page="../include/head.jsp">
	<jsp:param name="title" value="Account Profile" />
</jsp:include>
<body>
	<!-- Navigation bar section -->
	<jsp:include page="../include/navbar.jsp"></jsp:include>
	
	<!-- Inform user that they updated their account profile -->
	<c:if test="${not empty isUpdated}">
		<script type="text/javascript">alert("Account profile has been updated.");</script>
	</c:if>
	
	<section id="content">
		<div class="container d-flex justify-content-center">
			<form:form action="update" method="POSt" modelAttribute="userForm" class="form-content shadow">
				<h4 class="form-heading py-2">Edit your account</h4>
				<div class="form-params align-items-center">
					<form:hidden path="id"/>
					<div class="row">
						<div class="form-param col-md-6">
							<form:label path="username">Username</form:label>
							<form:input type="text" path="username" cssClass="form-input"
								placeholder="Username" autofocus="true"></form:input>
							<form:errors path="username" cssClass="form-error"></form:errors>
						</div>
						<div class="form-param col-md-6">
							<form:label path="email">Email</form:label>
							<form:input type="email" path="email" cssClass="form-input" 
								placeholder="Email"></form:input>
							<form:errors path="email" cssClass="form-error"></form:errors>
						</div>
					</div>
					<div class="row">
						<div class="form-param col-md-6">
							<form:label path="companyName">Company Name</form:label>
							<form:input type="text" path="companyName" cssClass="form-input"
								placeholder="Company Name"></form:input>
						</div>
						<div class="form-param col-md-6">
							<form:label path="phone">Phone Number</form:label>
							<form:input type="text" path="phone" cssClass="form-input" 
								placeholder="Phone Number"></form:input>
							<form:errors path="phone" cssClass="form-error"></form:errors>
						</div>
					</div>
					<div class="row">
						<div class="form-param col-md-6">
							<form:label path="firstName">First Name</form:label>
							<form:input type="text" path="firstName" cssClass="form-input"
								placeholder="First Name"></form:input>
							<form:errors path="firstName" cssClass="form-error"></form:errors>
						</div>
						<div class="form-param col-md-6">
							<form:label path="lastName">Last Name</form:label>
							<form:input type="text" path="lastName"
								cssClass="form-input" placeholder="Last Name"></form:input>
							<form:errors path="lastName" cssClass="form-error"></form:errors>
						</div>
					</div>
					<div class="row">
						<div class="form-param col-md-6">
							<form:label path="personalInfo.addressLine1">Address Line 1</form:label>
							<form:input type="text" path="personalInfo.addressLine1" cssClass="form-input"
								placeholder="Address Line 1"></form:input>
							<form:errors path="personalInfo.addressLine1" cssClass="form-error"></form:errors>
						</div>
						<div class="form-param col-md-6">
							<form:label path="personalInfo.addressLine2">Address Line 2</form:label>
							<form:input type="text" path="personalInfo.addressLine2" cssClass="form-input"
								placeholder="Address Line 2"></form:input>
						</div>
					</div>
					<div class="row">
						<div class="form-param col-md-4">
							<form:label path="personalInfo.city">City</form:label>
							<form:input type="text" path="personalInfo.city" cssClass="form-input"
								placeholder="City"></form:input>
							<form:errors path="personalInfo.city" cssClass="form-error"></form:errors>
						</div>
						<div class="form-param col-md-2">
							<form:label path="personalInfo.state">State</form:label>
							<form:select path="personalInfo.state" items="${states}" 
								cssClass="form-input"></form:select>
						</div>
						<div class="form-param col-md-6">
							<form:label path="personalInfo.postalCode">Postal Code</form:label>
							<form:input type="text" path="personalInfo.postalCode" cssClass="form-input"
								placeholder="Postal Code"></form:input>
							<form:errors path="personalInfo.postalCode" cssClass="form-error"></form:errors>
						</div>
					</div>
					<div class="row">
						<div class="form-param col-md-6">
							<form:label path="password">Password</form:label>
							<form:password path="password" cssClass="form-input"
								placeholder="Password"></form:password>
							<form:errors path="password" cssClass="form-error"></form:errors>
						</div>
						<div class="form-param col-md-6">
							<form:label path="confirmPassword">Confirm your Password</form:label>
							<form:password path="confirmPassword" cssClass="form-input"
								placeholder="Confirm your password"></form:password>
							<form:errors path="confirmPassword" cssClass="form-error"></form:errors>
						</div>
					</div>
					<div class="form-param text-center">
						<button class="btn btn-primary form-button" type="submit">Update</button>
					</div>
				</div>
			</form:form>
		</div>
	</section>

	<!-- Footer and Contact section -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>