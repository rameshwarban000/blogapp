<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!-- for spring language tag for use doller sign -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>About Me - Rameshwar Bansode</title>

<link rel="stylesheet"
	href="<c:url value="/resources/static/css/aboutme.css"/>">
</head>
<body>

	<!-- Your navigation bar goes here -->

	<section class="about-section">
		<div class="container">
			<h2>About Me</h2>
			<div class="profile-info">
				<img src="<c:url value="/resources/static/img/myimage.jpg"/>" alt="Rameshwar Bansode">
				<p>My name is Rameshwar Dashrath Bansode. I have completed a BCA
					from Navgan College, Parli-Vaijanath. With 2 years of experience as
					a full-stack Java web developer, I have contributed to 7 to 8
					projects during my tenure at Educloud.</p>
				<p>
					Contact me at: <br> Phone: 9561215453 <br> Email: <a
						href="mailto:rameshwarban000@gmail.com">rameshwarban000@gmail.com</a>
					<br> Address: Savta Mali Nagar, Parli-Vaijanath, District
					Beed, State Maharashtra, India.
				</p>
			</div>
			<div class="social-links">
				<a href="https://www.linkedin.com/in/rameshwar-bansode-aa6052189/" target="_blank" class="social-link">LinkedIn</a>
				<a href="https://github.com/rameshwarban000" target="_blank" class="social-link">GitHub</a>
			</div>
		</div>
	</section>

</body>
</html>
