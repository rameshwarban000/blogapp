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
<nav class="navbar navbar-expand-lg bg-body-tertiary fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">M-Work Blog</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <!-- <a class="nav-link active" aria-current="page" href="#">Home</a>
        <a class="nav-link" href="#">Features</a>
        <a class="nav-link" href="#">Pricing</a>
        <a class="nav-link disabled" aria-disabled="true">Disabled</a> -->
        
		<div class="nav-link">
			<button class="menuBtn" onclick="">Education</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick="">Technology</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick="">Programming</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick="">Temples</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick="">Places</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick="">Food</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick="">Health</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick="">Job Preparation</button>
		</div>
		<div class="nav-link">
			<button class="menuBtn" onclick="">Colleges</button>
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
					<h2 id="blogTitle">--</h2>
					<p id="blogDate">--</p>
				</div>

				<div class="descriptions">
					<!-- <h4 class="detailsTitle">Chhatrapati Shivaji Shahaji Bhosle</h4> -->
					<%-- <img alt="Blog Image"
						src="<c:url value="/resources/static/img/chatrapati shivaji maharaj.jpg"/>"
						width="100%"
						style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 2px 6px 2px;">
					<div class="descriptionDetails">

						<p>
							<span style="color: skyblue; font-size: 40px; margin-left: 30px;">C</span>
							hhatrapati Shivaji Maharaj was an Indian ruler and a member of
							the Bhonsle Maratha clan. He was born on 19 February 1630 at
							Shivneri Fort, near the city of Junnar, which is now in Pune
							district1. Shivaji carved out his own independent kingdom from
							the declining Adilshahi Sultanate of Bijapur that formed the
							genesis of the Maratha Empire1. He established a competent and
							progressive civil administration with well-structured
							administrative institutions. He revived ancient Hindu political
							traditions, court conventions and promoted the use of the Marathi
							and Sanskrit languages, replacing Persian at court and in
							administration1. Praised for his chivalrous treatment of women,
							Shivaji employed people of all castes and religions, including
							Muslims and Europeans, in his administration and armed forces1.
							Shivaji legacy was to vary by observer and time, but nearly two
							centuries after his death he began to take on increased
							importance with the emergence of the Indian independence
							movement, as many Indian nationalists elevated him as a
							proto-nationalist and hero of the Hindus.
						</p>
					</div> --%>
				</div>
			</div>
		</div>
		<!-- Blog details div end  -->
	</div>
	<h5 style="margin: 10px 50px;">More Topics</h5>
	<div class="topics">
		<div class="card" style="width: 18rem;">
			<img src="..." class="card-img-top" alt="...">
			<div class="card-body">
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
			</div>
		</div>
		<div class="card" style="width: 18rem;">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
</div>
<div class="card" style="width: 18rem;">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
</div>
<div class="card" style="width: 18rem;">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
</div>
<div class="card" style="width: 18rem;">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
</div>

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