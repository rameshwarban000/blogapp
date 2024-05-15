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
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />

<!-- page css  -->

<link rel="stylesheet"
	href="<c:url value="/resources/static/indexPage.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/static/css/blogDetails.css"/>">
<script
	src="<c:url value="/resources/static/js/blogDetails.js"/>"></script>
	
	<script type="text/javascript"
	src="<c:url value="/resources/static/initTextEditor.js"/>"></script>

<title>Blog Details</title>

<script type="text/javascript">

var entity = eval(${entity});
var descriptions = eval(${descriptions});
var images = eval(${images});

var recBlogList = eval(${recBlogList});
var recDescList = eval(${recDescList});
var recImgList = eval(${recImgList});

$(document).ready(function(){
	
	// render blog details
	renderBlogDetails(entity, descriptions, images);
	renderRecomendedBlogList(recBlogList, recDescList, recImgList);
	
	
	  $(document).click(function(event) {
		    // Check if the clicked element is not the button or the div
		    if (!$(event.target).closest('#feedbackandReport, .feedbackAndReportDiv').length) {
		      // Hide the div if it's not the button or the div
		      $(".feedbackAndReportDiv").hide();
		    }
		  });
});
</script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary fixed-top blogTopNavbar" >
  <div class="container-fluid">
    <a class="navbar-brand" href="#">M-Work Blog</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        
		<div class="nav-link">
			<button class="menuBtn" onclick=""><i class="bi bi-backpack2-fill"></i> Education</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick=""><i class="bi bi-motherboard-fill"></i> Technology</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick=""><i class="bi bi-code-slash"></i> Programming</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick=""> <i class="bi bi-bank"></i> Temples</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick=""><i class="bi bi-geo-alt-fill"></i> Places</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick=""><i class="bi bi-egg-fried"></i> Food</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick=""><i class="bi bi-lungs-fill"></i> Health</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick=""><i class="bi bi-briefcase-fill"></i> Job Preparation</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick=""><i class="bi bi-bank2"></i> Colleges</button>
		</div>
      </div>
    </div>
  </div>
</nav>

	<div class="descritpionDetialsMainDiv">

		<div class="blogButtonsDiv">
			<!-- Dicriptions buttons  -->

			<div class="blogBtnDiv">
				<button class="btn btnBlog">
					<i class="bi bi-hand-thumbs-up"></i>
				</button><!-- like -->
			</div>
			<div class="blogBtnDiv">
				<button class="btn btnBlog">
					<i class="bi bi-hand-thumbs-down"></i>
				</button><!-- dislike -->
			</div>
			<div class="blogBtnDiv">
				<button class="btn btnBlog" id="shareblogBtn">
					<i class="bi bi-share"></i>
				</button><!-- share  -->
			</div>
			<div class="blogBtnDiv">
				<button class="btn btnBlog">
					<i class="bi bi-chat-square-text"></i>
				</button><!-- comment -->
			</div>
			<div class="blogBtnDiv">
				<button class="btn btnBlog" onclick="listenBlog()">
					<i class="bi bi-earbuds"></i>
				</button><!-- audioble icon  -->
			</div>
			<div class="blogBtnDiv">
				<button class="btn btnBlog" id="feedbackandReport" onclick="showReportAndFeedBack()">
					<i class="bi bi-list"></i>
				</button><!-- Menu btn  -->
			</div>
		</div>

		<div class="blogDetailsDiv">
			<div class="blogDetails">

				<div class="blogDetailsHeader">
					<label id="blogTitle" title="Blog main title">--</label>
					<label>
					 <i class="bi bi-calendar-month-fill"></i><span id="blogDate" title="last updated date">--</span>
					</label>
				</div>

				<div class="descriptions">
					
				</div>
			</div>
		</div>
		<!-- Blog details div end  -->
	</div>
	<h5 style="margin: 10px 50px;">More Topics</h5>
	<div class="topics">

	</div>

	<div class="feedbackAndReportDiv" style="display: none">
		<div><button class="btn " id="reportBtn" onclick="showReport()"><i class="bi bi-flag"></i> Report</button></div>
		<div><button class="btn " id="feedbackBtn"  onclick="showFeedback()"><i class="bi bi-wechat"></i> Feedback</button></div>
	</div>
	<!-- *************************************************  Feed back And report start ******************************************************-->
	<div id="reportDiv" class="feedbackandreportUIDiv" id="reportDiv" style="display: none">
		<div class="feedbackandreportUIDivInnerDiv">
			<div class="headerOfFeedBackAndReportDiv">
				<h5>Report this blog</h5>
			</div>
			<div class="textDivOfFeedbackAndReportDiv">
				<textarea id="feedBackTextArea" rows="" cols=""></textarea>
			</div>
			<div class="feedbackandreportbtndiv">
				<button class="btn btn-success">Report Now</button>
				<button class="btn btn-danger" onclick="clearReport()">Cancle</button>
			</div>
		
		</div>
	</div>
	<div id="feedbackDiv" class="feedbackandreportUIDiv" id="feedbackDiv" style="display: none">
			<div class="feedbackandreportUIDivInnerDiv">
			<div class="headerOfFeedBackAndReportDiv">
				<h5>Feedback this blog</h5>
			</div>
			<div class="textDivOfFeedbackAndReportDiv">
				<textarea id="feedBackTextArea" rows="" cols=""></textarea>
			</div>
			<div class="feedbackandreportbtndiv">
				<button class="btn btn-success">Feedback Now</button>
				<button class="btn btn-danger" onclick="clearFeedBack()">Cancle</button>
			</div>
		
		</div>
	</div>
	<!-- *************************************************  Feed back And report End ******************************************************-->

	<div id="shareModal" class="modal" style="display: none;">
		<div class="modal-content">
			<span class="close" style="text-align: right;">&times;</span>
			<p>Share this blog with blow</p>
			<div style="text-align: center;">

				<button class="btn btnBlog" id="facebookButton">
					<i class="bi bi-facebook"></i>
				</button>
				<button class="btn btnBlog" id="twitterButton">
					<i class="bi bi-twitter"></i>
				</button>
				<button class="btn btnBlog" id="whatsappButton">
					<i class="bi bi-whatsapp"></i>
				</button>
				<button class="btn btnBlog" id="instagramButton">
					<i class="bi bi-instagram"></i>
				</button>
				<button class="btn btnBlog" id="copyLinkButton">
					<i class="bi bi-copy"></i>
				</button>
			</div>
		</div>
	</div>
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
</body>
</html>