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

<link rel="icon" href="<c:url value='/resources/static/img/homePageImg/logo.png'/>" type="image/x-icon">

<!-- bootstrap css and js  -->
<link rel="stylesheet"
	href="<c:url value="/resources/static/bootstrap-5.3.2-dist/css/bootstrap.min.css"/>">
<script type="text/javascript"
	src="<c:url value="/resources/static/bootstrap-5.3.2-dist/js/bootstrap.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/static/js/manageBlogs.js"/>"></script>
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
<link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>


<!-- bootstrap and google icons links  -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	
<!-- page Css -->
<link rel="stylesheet"
	href="<c:url value="/resources/static/css/manageBlock.css"/>">
	
<!-- page css -->
<title>Manage blogs and news</title>

<script type="text/javascript">
let deleteBlogURL = '<c:url value="/deleteBlogOrNews"/>'
let blogsAndNews = ${blogsAndNews}

let cache = getLocalChach();
cache.blogOrNewsList = blogsAndNews;

$(document).ready(function (){
	renderTable(blogsAndNews, true);
});


</script>
</head>
<body>

	<div id="navBarDiv">
		<h4>M-Work Blog</h4>
		<span>ManageBlogs</span> 
		<div>
		<a href="<c:url value="/createblog"/>">
			<button class="btn btn-info">
				<i class="bi bi-plus-circle-dotted"></i> Create New Blog Or News
			</button>
		</a>
		<a href="<c:url value="/" />">
			<button class="btn btn-success">
				<i class="bi bi-house"></i> Home Page
			</button>
		</a>
		
		</div>
	</div>
	<div class="container" id="tableDiv">
		<table class="table" id="mainTable">
			<thead>
				<tr>
					<td>No.</td>
					<td>Title</td>
					<td>Type</td>
					<td>Sub Category</td>
					<td>Created Data</td>
					<td>Action</td>
				</tr>
			</thead>
				<tbody id="mainTableBody"></tbody>

		</table>
	</div>
	
	<div style="display: none;" id="noRecordsFound"> 
		<h4>No records founds!</h4>
	</div>
</body>
</html>