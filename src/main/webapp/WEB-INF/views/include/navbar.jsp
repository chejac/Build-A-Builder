<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header id="navigation">
	<nav class="navbar navbar-expand-lg navbar-light fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/"><img
				src="/img/logo.png" alt="Rent-A-Builder" width="70%"
				height="70%" /></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav">
					<sec:authorize access="hasAuthority('ADMIN')">
						<li class="nav-item"><a class="nav-link" href="/admin/">admin</a>
						</li>
					</sec:authorize>
					<li class="nav-item"><a class="nav-link" href="/#product">product</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/manage/">manage</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/#about">about</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/#contact">contact</a>
					</li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<sec:authorize access="isAuthenticated()">
						<li class="nav-item"><a class="nav-link" href="/account/"><sec:authentication property="name"/></a>
						</li>
						<li class="nav-item pointer">
							<form id="logoutForm" method="POST" action="/logout">
								<sec:csrfInput />
							</form>
							<a class="nav-link" onclick="document.forms['logoutForm'].submit()">logout</a>
						</li>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
						<li class="nav-item"><a class="nav-link" href="/register">register</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="/login">login</a>
						</li>
					</sec:authorize>
					<li class="nav-item"><a class="nav-link" href="/cart/"><i
							class="fas fa-shopping-cart"></i> </a></li>
				</ul>
			</div>
		</div>
	</nav>
</header>