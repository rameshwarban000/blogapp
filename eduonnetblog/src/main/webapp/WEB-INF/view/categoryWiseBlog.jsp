<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!-- for spring language tag for use doller sign -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

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

<!-- Page CSS -->
<link rel="stylesheet" href="<c:url value="/resources/static/categoryWiseBlog.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/static/indexPage.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/static/css/blogDetails.css"/>">

<script type="text/javascript" src="<c:url value="/resources/static/categoryWiseBlog.js"/>"></script>

<script type="text/javascript">

$(document).ready(function(){
	const myCarouselElement = document.querySelector('#carouselExampleCaptions');
	var newsList = eval(${newsList});
	var blogList = eval(${blogList});
	var descWiseImages = eval(${descWiseImages});
	
	renderNews(newsList, descWiseImages);
	renderBlogList(blogList , descWiseImages);
	renderNewInCard(newsList, descWiseImages);
	const carousel = new bootstrap.Carousel(myCarouselElement, {
	  interval: 2000,
	  touch: false
	});
});

</script>
<title>Welcome to M-Work Blog</title>
</head>
<body>

<!-- Menu bar   -->
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">M-Work Blog</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
	        <a href="<c:url value="/homePage/1"/>">
	        	<button class="btn"> Home</button>
	        </a>
        </li>
        <li class="nav-item">
          <a href="<c:url value="/homePage/1"/>">
        	<button class="btn" > Education</button>
         </a>
        </li>
        <li class="nav-item">
          <a href="<c:url value="/homePage/2"/>">
        	<button class="btn" > Technology </button>
         </a>
        </li>
        <li class="nav-item">
          <a href="<c:url value="/homePage/3"/>">
        	<button class="btn" > Programming</button>
         </a>
        </li>
        <li class="nav-item">
          <a href="<c:url value="/homePage/4"/>">
        	<button class="btn" > Temples</button>
         </a>
        </li>
        <li class="nav-item">
          <a href="<c:url value="/homePage/5"/>">
        	<button class="btn" > Places</button>
         </a>
        </li>
        <li class="nav-item">
          <a href="<c:url value="/homePage/6"/>">
        	<button class="btn" > Food </button>
         </a>
        </li>
        <li class="nav-item">
         <a href="<c:url value="/homePage/7"/>">
        	<button class="btn" > Health</button>
         </a>
        </li>
        <li class="nav-item">
         <a href="<c:url value="/homePage/8"/>">
        	<button class="btn" > Job</button>
         </a>
        </li>
        <li class="nav-item">
         <a href="<c:url value="/homePage/9"/>">
        	<button class="btn" > Colleges</button>
         </a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

<!-- Some News  -->
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
  
  </div>
  <div class="carousel-inner container" >
    
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<!-- add div  -->
	<div></div>
<!--  -->
	<div  id="blogsMainDiv">
		
	</div>

		<!--  -->
	<div class="container">
		<div class="row row-cols-1 row-cols-md-2 g-4 newsMainDiv" style="margin: 10px;">
			
		</div>
	</div>
	<!--  -->
	
	<!--***********************************************  -->
	<footer class="site-footer">
		<div class="container">
			<div class="footer-content">
				<div class="footer-links">
					<a href="#">Home</a> <a href="<c:url value="/aboutme"/>">About</a>
					<a href="#">Contact</a> <a href="#">Products</a>
				</div>
				<div class="like-buttons">
					<button class="like-button">Like</button>
					<button class="like-button">Love</button>
				</div>
			</div>
			<div class="copyright">&copy; 2024 Your Blog. All rightsre
				served.</div>
		</div>
	</footer>
</body>
</html>