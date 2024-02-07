<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!-- for spring language tag for use doller sign -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<!-- page css -->

<link rel="stylesheet"
	href="<c:url value="/resources/static/indexPage.css"/>">
<script type="text/javascript"
	src="<c:url value="/resources/static/index.js"/>"></script>


<script type="text/javascript">
	/* var aboutmePageURL = '<c:url value="/aboutme"/>'; */
	
	$(document).ready(function(){
		renderNews();
		renderCategories();
	})
</script>
<title>Blogs Page</title>


<!-- google add link  -->
<script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-7846227789325433"
     crossorigin="anonymous"></script>
<body>
	<div class="">
		<div class="mainNavBar">
			<h4 style="position:absolute; left: 30px;">Welcome to M-Work Blog</h4>
		</div>
		<div style="text-align: center; margin-top: 10px;">
			
		</div>
		<!--  -->
				<h4 style="text-align: center">Tranding News</h4>
		<div class="newsAndAdd">
		<!-- Affilate Marketing -->
			<div class="newAdd">add</div>

			<div class="newsNews">
			</div>
			<!-- Affilate Marketing -->
			<div class="newAdd">add</div>
		</div>
		<!-- main blog UI -->
	<!-- 	<div class="allAddDiv">
	
		</div> -->
		<!-- Main Blogs UI  -->
		<div class="blogPanelAndAdd">
			<div class="leftSideNav" style="padding:10px;">
				<label style="padding: 5px 5px;"> <i class="bi bi-bookmark-fill"></i> Categories</label>
				<div style="overflow: auto;" class="categoriesDiv">
					
				</div>

			</div>
			<div class="blogsDiv">
				<div class="blog">
					<div class="blogImg">image</div>
					<div>
						<div class="blogDate">01-02-24</div>
						<div class="blogTitle">Pushpa 2 Kanatra Most avaited film</div>
						<div class="likeUnlikeBtnDiv">
							<i class="bi bi-hand-thumbs-up"></i>
							<i class="bi bi-hand-thumbs-down"></i>
							<i class="bi bi-chat-left"></i>
							<i class="bi bi-share"></i>
						</div>
					</div>

				</div>
				<div class="blog">
					<div class="blogImg">image</div>
					<div>
						<div class="blogDate">01-02-24</div>
						<div class="blogTitle">Pushpa 2 Kanatra Most avaited film</div>
						<div class="likeUnlikeBtnDiv">
							<i class="bi bi-hand-thumbs-up"></i>
							<i class="bi bi-hand-thumbs-down"></i>
							<i class="bi bi-chat-left"></i>
							<i class="bi bi-share"></i>
						</div>
					</div>

				</div>
				<div class="blog">
					<div class="blogImg">image</div>
					<div>
						<div class="blogDate">01-02-24</div>
						<div class="blogTitle">Pushpa 2 Kanatra Most avaited film</div>
						<div class="likeUnlikeBtnDiv">
							<i class="bi bi-hand-thumbs-up"></i>
							<i class="bi bi-hand-thumbs-down"></i>
							<i class="bi bi-chat-left"></i>
							<i class="bi bi-share"></i>
						</div>
					</div>

				</div>
				<div class="blog">
					<div class="blogImg">image</div>
					<div>
						<div class="blogDate">01-02-24</div>
						<div class="blogTitle">Pushpa 2 Kanatra Most avaited film</div>
						<div class="likeUnlikeBtnDiv">
							<i class="bi bi-hand-thumbs-up"></i>
							<i class="bi bi-hand-thumbs-down"></i>
							<i class="bi bi-chat-left"></i>
							<i class="bi bi-share"></i>
						</div>
					</div>

				</div>
				<div class="blog">
					<div class="blogImg">image</div>
					<div>
						<div class="blogDate">01-02-24</div>
						<div class="blogTitle">Pushpa 2 Kanatra Most avaited film</div>
						<div class="likeUnlikeBtnDiv">
							<i class="bi bi-hand-thumbs-up"></i>
							<i class="bi bi-hand-thumbs-down"></i>
							<i class="bi bi-chat-left"></i>
							<i class="bi bi-share"></i>
						</div>
					</div>

				</div>
				<div class="blog">
					<div class="blogImg">image</div>
					<div>
						<div class="blogDate">01-02-24</div>
						<div class="blogTitle">Pushpa 2 Kanatra Most avaited film</div>
						<div class="likeUnlikeBtnDiv">
							<i class="bi bi-hand-thumbs-up"></i>
							<i class="bi bi-hand-thumbs-down"></i>
							<i class="bi bi-chat-left"></i>
							<i class="bi bi-share"></i>
						</div>
					</div>

				</div>
				<div class="blog">
					<div class="blogImg">image</div>
					<div>
						<div class="blogDate">01-02-24</div>
						<div class="blogTitle">Pushpa 2 Kanatra Most avaited film</div>
						<div class="likeUnlikeBtnDiv">
							<i class="bi bi-hand-thumbs-up"></i>
							<i class="bi bi-hand-thumbs-down"></i>
							<i class="bi bi-chat-left"></i>
							<i class="bi bi-share"></i>
						</div>
					</div>

				</div>
				<div class="blog">
					<div class="blogImg">image</div>
					<div>
						<div class="blogDate">01-02-24</div>
						<div class="blogTitle">Pushpa 2 Kanatra Most avaited film</div>
						<div class="likeUnlikeBtnDiv">
							<i class="bi bi-hand-thumbs-up"></i>
							<i class="bi bi-hand-thumbs-down"></i>
							<i class="bi bi-chat-left"></i>
							<i class="bi bi-share"></i>
						</div>
					</div>

				</div>
				<div class="blog">
					<div class="blogImg">image</div>
					<div>
						<div class="blogDate">01-02-24</div>
						<div class="blogTitle">Pushpa 2 Kanatra Most avaited film</div>
						<div class="likeUnlikeBtnDiv">
							<i class="bi bi-hand-thumbs-up"></i>
							<i class="bi bi-hand-thumbs-down"></i>
							<i class="bi bi-chat-left"></i>
							<i class="bi bi-share"></i>
						</div>
					</div>

				</div>
				<div class="blog">
					<div class="blogImg">image</div>
					<div>
						<div class="blogDate">01-02-24</div>
						<div class="blogTitle">Pushpa 2 Kanatra Most avaited film</div>
						<div class="likeUnlikeBtnDiv">
							<i class="bi bi-hand-thumbs-up"></i>
							<i class="bi bi-hand-thumbs-down"></i>
							<i class="bi bi-chat-left"></i>
							<i class="bi bi-share"></i>
						</div>
					</div>

				</div>
				<div class="blog">
					<div class="blogImg">image</div>
					<div>
						<div class="blogDate">01-02-24</div>
						<div class="blogTitle">Pushpa 2 Kanatra Most avaited film</div>
						<div class="likeUnlikeBtnDiv">
							<i class="bi bi-hand-thumbs-up"></i>
							<i class="bi bi-hand-thumbs-down"></i>
							<i class="bi bi-chat-left"></i>
							<i class="bi bi-share"></i>
						</div>
					</div>

				</div>
			
			</div>
			<div class="blogDiv" style="display: none;">Blogs</div>
			<div class="blogSideAdd">Adds</div>
		</div>

		<!-- Related Topics  -->
		<div style="margin-top: 5px; margin-left: 5px;">
			<p>Related Topics</p>
		</div>
		<div class="topicDiv">
			<div class="topic">Daily Inspiration</div>
			<div class="topic">Productivity Hacks</div>
			<div class="topic">Recipe of the Day</div>
			<div class="topic">Wellness Tips</div>
		</div>
		<div class="footerAdd">Footer Add</div>


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
				<div class="copyright">&copy; 2024 Your Blog. All rights
					reserved.</div>
			</div>
		</footer>
	</div>
</body>
</html>
