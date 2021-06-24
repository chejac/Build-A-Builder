<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="include/head.jsp">
	<jsp:param name="title" value="Rent-A-Builder" />
</jsp:include>
<body>
	<!-- Navigation bar section -->
	<jsp:include page="include/navbar.jsp"></jsp:include>

	<!-- Hero and Search bar section -->
	<section id="hero-and-search">
		<div id="hero">
			<div class="container">
				<div class="row main-hero-content">
					<div class="col-md-6">
						<h1>Rent the right equipment for the job</h1>
						<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
							Error cumque fuga modi numquam quasi! Totam temporibus neque
							facilis autem quae!</p>
					</div>
				</div>
			</div>
		</div>
		<div id="search">
			<div class="container">
				<form action="/product/search" class="search-bar form-inline my-2 my-lg-0 justify-content-center">
					<i class="search-icon fa fa-search"></i>
					<input type="search" name="productName" class="search-input form-control mr-sm-2" placeholder="Search product" />
					<button type="submit" class="btn btn-primary btn-search my-2 my-sm-0">Search</button>
				</form>
			</div>
		</div>
	</section>

	<!-- Product section -->
	<section id="product">
		<div class="container">
			<div class="row">
				<div class="col-6">
					<h4 class="mb-3">Product Type</h4>
				</div>
				<div class="col-6 text-right">
					<a class="btn btn-primary mb-3 mr-1" href="#carouselIndicator"
						role="button" data-slide="prev"> <i class="fa fa-arrow-left"></i>
					</a> <a class="btn btn-primary mb-3" href="#carouselIndicator"
						role="button" data-slide="next"> <i class="fa fa-arrow-right"></i>
					</a>
				</div>
				<div class="col-12">
					<div id="carouselIndicator" class="carousel slide"
						data-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active">
								<div class="row">
									<div class="col-md-3 mb-3">
										<div class="card">
											<div class="card-img-pos">
												<img class="card-img" src="/img/bulldozer.png"
													alt="Card image" />
											</div>
											<div class="card-body">
												<h4 class="card-title">Earthmoving</h4>
												<p class="card-text">Some quick example text to build on
													the card title and make up the bulk of the card's content.
												</p>
												<a href="/product/type?productType=earthmoving" class="btn btn-primary btn-product-detail">More
													Details</a>
											</div>
										</div>
									</div>
									<div class="col-md-3 mb-3">
										<div class="card">
											<div class="card-img-pos">
												<img class="card-img" src="/img/scissor-lift.png"
													alt="Card image" />
											</div>
											<div class="card-body">
												<h4 class="card-title">Platforms</h4>
												<p class="card-text">Some quick example text to build on
													the card title and make up the bulk of the card's content.
												</p>
												<a href="/product/type?productType=platform" class="btn btn-primary btn-product-detail">More
													Details</a>
											</div>
										</div>
									</div>
									<div class="col-md-3 mb-3">
										<div class="card">
											<div class="card-img-pos">
												<img class="card-img" src="/img/forklift.png"
													alt="Card image" />
											</div>
											<div class="card-body">
												<h4 class="card-title">Forklifts</h4>
												<p class="card-text">Some quick example text to build on
													the card title and make up the bulk of the card's content.
												</p>
												<a href="/product/type?productType=forklift" class="btn btn-primary btn-product-detail">More
													Details</a>
											</div>
										</div>
									</div>
									<div class="col-md-3 mb-3">
										<div class="card">
											<div class="card-img-pos">
												<img class="card-img" src="/img/compressor.png"
													alt="Card image" />
											</div>
											<div class="card-body">
												<h4 class="card-title">Compressors</h4>
												<p class="card-text">Some quick example text to build on
													the card title and make up the bulk of the card's content.
												</p>
												<a href="/product/type?productType=compressor" class="btn btn-primary btn-product-detail">More
													Details</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="carousel-item">
								<div class="row">
									<div class="col-md-3 mb-3">
										<div class="card">
											<div class="card-img-pos">
												<img class="card-img" src="/img/light-tower.png"
													alt="Card image" />
											</div>
											<div class="card-body">
												<h4 class="card-title">Light Towers</h4>
												<p class="card-text">Some quick example text to build on
													the card title and make up the bulk of the card's content.
												</p>
												<a href="/product/type?productType=tower" class="btn btn-primary btn-product-detail">More
													Details</a>
											</div>
										</div>
									</div>
									<div class="col-md-3 mb-3">
										<div class="card">
											<div class="card-img-pos">
												<img class="card-img" src="/img/generator.png"
													alt="Card image" />
											</div>
											<div class="card-body">
												<h4 class="card-title">Generators</h4>
												<p class="card-text">Some quick example text to build on
													the card title and make up the bulk of the card's content.
												</p>
												<a href="/product/type?productType=generator" class="btn btn-primary btn-product-detail">More
													Details</a>
											</div>
										</div>
									</div>
									<div class="col-md-3 mb-3">
										<div class="card">
											<div class="card-img-pos">
												<img class="card-img" src="/img/truck.png"
													alt="Card image" />
											</div>
											<div class="card-body">
												<h4 class="card-title">Trucks</h4>
												<p class="card-text">Some quick example text to build on
													the card title and make up the bulk of the card's content.
												</p>
												<a href="/product/type?productType=truck" class="btn btn-primary btn-product-detail">More
													Details</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-3 mt-2">
					<a href="/product/type?productType=all" class="btn btn-primary btn-all-product">Browse
						All Product</a>
				</div>
			</div>
		</div>
	</section>

	<!-- About section -->
	<section id="about">
		<div class="container">
			<h4 class="mb-3">About</h4>
			<div class="row justify-content-center text-center">
				<div class="col-md-4">
					<i class="fas fa-tools fa-3x mb-2 about-icon"></i>
					<h3>simple</h3>
					<p>Lorem ipsum, dolor sit amet consectetur adipisicing elit.
						Accusamus modi deserunt dolore dolor atque, esse minima assumenda
						neque recusandae a exercitationem nostrum sint vero dolores.</p>
				</div>
				<div class="col-md-4">
					<i class="fas fa-phone-volume fa-3x mb-2 about-icon"></i>
					<h3>accessible</h3>
					<p>Lorem ipsum, dolor sit amet consectetur adipisicing elit.
						Accusamus modi deserunt dolore dolor atque, esse minima assumenda
						neque recusandae a exercitationem nostrum sint vero dolores.</p>
				</div>
				<div class="col-md-4">
					<i class="fas fa-coins fa-3x mb-2 about-icon"></i>
					<h3>fair</h3>
					<p>Lorem ipsum, dolor sit amet consectetur adipisicing elit.
						Accusamus modi deserunt dolore dolor atque, esse minima assumenda
						neque recusandae a exercitationem nostrum sint vero dolores.</p>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-3 mt-2 mb-4">
					<a class="btn btn-primary btn-info-video text-white"
						data-toggle="modal" data-target="#video">More Info</a>
				</div>
				<div class="modal fade" id="video">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-body">
								<iframe width="560" height="315"
									src="https://www.youtube.com/embed/AhtH4ITooCc" frameborder="0"
									allowfullscreen></iframe>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Footer and Contact section -->
	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>