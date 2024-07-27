<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!-- for spring language tag for use doller sign -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<c:url value='/resources/static/img/homePageImg/logo.png'/>" type="image/x-icon">

<!-- bootstrap css and js  -->
<link rel="stylesheet"
	href="<c:url value="/resources/static/bootstrap-5.3.2-dist/css/bootstrap.min.css"/>">
<script type="text/javascript"
	src="<c:url value="/resources/static/bootstrap-5.3.2-dist/js/bootstrap.min.js"/>"></script>

<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<!-- bootstrap and google icons links  -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<!-- page css -->
<link rel="stylesheet" href="<c:url value="/resources/static/homepage.css" />" />

<script type="text/javascript">

</script>
<title>Dashboard</title>

<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary hederNavBar">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">M-Work Blog</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarText"
				aria-controls="navbarText" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#"> <i class="bi bi-person-circle"></i> About Us</a></li>
					<li class="nav-item"><a class="nav-link active" href="#"><i class="bi bi-telephone-plus-fill"></i> Contact
							Us</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="mainIntroDiv">
		<div class="textOfIntro" style="width: 50%;">
			<h2 class="headTitle">Read the Quality Content</h2>
			<p>We give you the best content for consume and learn.</p>
		</div>
		<div style="width: 50%;">
			<img src="<c:url value="/resources/static/img/homePageImg/blogIllustrator.jpg" />"  width="100%" height="auto">
		</div>
	</div>
	<div style="text-align: center; padding-top: 50px;">

		<h2 style="font-size: medium;">Best Content for your favorite
			Content</h2>
		<div style="display: flex; justify-content: center; gap: 10px;">
			<div class="contentInfoDiv">
				<div class="contentInfoInnerDiv">
					<span class="contentInfoTitle">Based On Research</span><br> <span>All
						content wrote on research.</span>
				</div>
				<div>
					<img class="infoImg" src="<c:url value="/resources/static/img/homePageImg/reserch.jpg" />" alt="..." width="100%">
				</div>
			</div>
			<div class="contentInfoDiv">
				<div class="contentInfoInnerDiv">
					<span class="contentInfoTitle">Best Quality</span><br> <span>Best
						Quality Images for better Understanding</span>
				</div>
				<div>
					<img class="infoImg" src="<c:url value="/resources/static/img/homePageImg/quility.jpg"/>" alt="..." width="100%"
						height="auto">
				</div>
			</div>
			<div class="contentInfoDiv">
				<div class="contentInfoInnerDiv">
					<span class="contentInfoTitle">Reach UI/UX</span><br> <span>Best
						UI for only reading not any confusion</span>
				</div>
				<div>
					<img class="infoImg" src="<c:url value="/resources/static/img/homePageImg/uiux.jpg"/>" alt="..." width="100%">
				</div>
			</div>

		</div>
	</div>
	<div class="container infodivsMain">
		<div class="infodivs">
			<!-- Education -->
			<div>
				<h4>
					<a href="/eduonnetblog/categoryWiseBlogs/1"><i class="bi bi-award-fill"></i> Education</a>
				</h4>
				<p>Unlocking the Power of Education: Explore Insights, Tips, and
					Resources for Lifelong Learning</p>
			</div>
			<div class="infodivsInnderDivImg">
				<img src="<c:url value="/resources/static/img/homePageImg/education illustrator.jpg"/>" alt="myImg" width="100%">
			</div>
		</div>

		<div class="infodivs">
			<!-- Programming -->
			<div class="infodivsInnderDivImg">
				<img src="<c:url value="/resources/static/img/homePageImg/programming.jpg"/>" alt="myImg" width="100%">
			</div>
			<div>
				<h4>
					<h4>
						<a href="/eduonnetblog/categoryWiseBlogs/2"><i class="bi bi-code-slash"></i> Programming </a>
					</h4>
					<p>Decoding the World of Programming: Your Gateway to Expertise
						and Innovation</p>
				</h4>
			</div>
		</div>

		<div class="infodivs">
			<!-- Technology -->
			<div>
				<h4>
					<a href="/eduonnetblog/categoryWiseBlogs/3"><i class="bi bi-cpu-fill"></i> Technology </a>
				</h4>
				<p>Embrace Tomorrow's Teach Today: Stay Ahead with Insights into
					the Future of Technology</p>
			</div>
			<div class="infodivsInnderDivImg">
				<img src="<c:url value="/resources/static/img/homePageImg/tech.jpg"/>" alt="myImg" width="100%">
			</div>
		</div>

		<div class="infodivs">
			<!-- Temples / Places -->
			<div class="infodivsInnderDivImg">
				<img src="<c:url value="/resources/static/img/homePageImg/temple.jpg"/>" alt="myImg" width="100%">
			</div>
			<div>
				<h4>
					<h4>
						<a href="/eduonnetblog/categoryWiseBlogs/4"><i class="bi bi-geo-alt-fill"></i> Temples & Places </a>
					</h4>
					<p>Journey Through Temples of Knowledge: Exploring Timeless
						Wisdom and Tradition</p>
				</h4>
			</div>
		</div>
		<div class="infodivs">
			<!-- Food  -->
			<div>
				<h4>
					<a href="/eduonnetblog/categoryWiseBlogs/5"><i class="bi bi-egg-fried"></i> Food </a>
				</h4>
				<p>Feast Your Eyes and Appetite: Savour the Stories, Recipes,
					and Culinary Adventures Advice: "Explore new tastes, but always
					remember to cook with love and savor every bite."</p>
			</div>
			<div class="infodivsInnderDivImg">
				<img src="<c:url value="/resources/static/img/homePageImg/food.jpg"/>" alt="myImg" width="100%">
			</div>
		</div>

		<div class="infodivs">
			<!-- Health  -->
			<div class="infodivsInnderDivImg">
				<img src="<c:url value="/resources/static/img/homePageImg/health.jpg"/>" alt="myImg" width="100%">
			</div>
			<div>
				<h4>
					<h4>
						<a href="/eduonnetblog/categoryWiseBlogs/6"><i class="bi bi-lungs-fill"></i> Health </a>
					</h4>
					<p>Empowering Health: Your Guide to Wellness, Fitness, and
						Holistic Living" Advice: "Make informed choices, prioritize
						preventive care, and remember, health is a journey, not a
						destination.</p>
				</h4>
			</div>
		</div>
		<div class="infodivs">
			<!-- Food  -->
			<div>
				<h4>
					<a href="/eduonnetblog/categoryWiseBlogs/7"><i class="bi bi-briefcase-fill"></i> Job </a>
				</h4>
				<p>Empowering Your Career Journey: Discover Opportunities,
					Insights, and Success Stories" Advice: "Stay persistent, keep
					learning, and remember, the right opportunity is just around the
					corner.</p>
			</div>
			<div class="infodivsInnderDivImg">
				<img src="<c:url value="/resources/static/img/homePageImg/jobs.jpg"/>" alt="myImg" width="100%">
			</div>
		</div>
	</div>

<!-- 	<div class="mostReadedBolgListMainDiv" style="margin-top: 20px;">
		<div style="text-align: center;">
			<h3>Most Readed Blogs</h3>
		</div>
		<div class="mostReadedBlogList container" style="padding-top: 10px;">
			<div class="mostRededBlogDiv">
				<div style="text-align: center;">
				</div>
				<div>
					<h1></h1>
				</div>
			</div>
			<div class="mostRededBlogDiv">Blog Two</div>
			<div class="mostRededBlogDiv">Blog Three</div>
			<div class="mostRededBlogDiv">Blog Four</div>
		</div>
	</div> -->


	<footer
		style="background-color: black; color: white; text-align: center;">
		<div>
			<div>
				<img src="<c:url value="/resources/static/img/homePageImg/logo.png"/>" alt="M work Logo" width="20%" style="border-radius: 50%;">
				<h4>M-Work</h4>
				<p>We are provide the best content for reading.</p>

			</div>
			<div>
				<h4>Our Service</h4>
				<a href="#">Blogging</a><br> <a href="#">M-Work Jobs</a>
			</div>
			<div>
				<h4>Contact Info</h4>
				<p>You can connect us on rameshwarban000@gmail.com</p>
				<p></p>
			</div>
		</div>
		<div>
			<div>
				<p>
					&copy; <span id="currentYear"></span> M-Work. All Rights Reserved.
					| <a href="<c:url value="/privacyPolicy"/>">Privacy Policy</a> | <a
						href="<c:url value="/termAndPolicy"/>">Terms of Use</a>
				</p>
			</div>
			<script>
				document.getElementById("currentYear").textContent = new Date()
						.getFullYear();
			</script>
		</div>
	</footer>
</body>
</html>
