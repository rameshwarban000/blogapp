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

<!-- TinyMCE Editor -->
<script src="https://cdn.tiny.cloud/1/exotqesjsfazah6z08ks7m1ichy4m1hxhavgec0i479ddtdb/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>



<!-- bootstrap and google icons links  -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />

<!-- page css -->
<script type="text/javascript"
	src="<c:url value="/resources/static/createblog.js"/>"></script>

<style type="text/css">
#uploadedImageContainer img {
	width: 200px;
}

.afterSavingDataDiv{
	position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #80808042;
    z-index: 100;
}
.messageBlog{
	width: 50%;
    height: 50%;
    background-color: white;
    padding: 2%;
    border-radius: 6px;
    box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    text-align: center;
}
.formImg{
	margin-bottom: 10px;
}
</style>

<script type="text/javascript">
	var saveBlogOrNewsURL = '<c:url value="/saveblogornews"/>';
	var uploadImageURL = '<c:url value="/uploadimage"/>';

	$(document).ready(function() {
		
		 initTinyTextEditor('floatingTextarea')
	});
</script>

<title>Create Blog</title>
</head>
<body>

	<div class="card">
		<div class="card-header">
			<h4>M-Work Blog</h4>
			<p>Add Blog or news</p>
		</div>
		<div class="container" style="margin-top: 10px;">
			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="title"
					placeholder="Title" required> <label for="title">Title</label>
			</div>
			<!-- Title  -->
			<div>
				<select class="form-select" id="typeSelection">
					<option value="">Selete Type</option>
					<option value="1">Blog</option>
					<option value="2">News</option>
				</select>
				<!-- Type Selection -->
			</div>
			<div class="descriptions">
				<div class="description" style="margin-top: 10px;">
					<div class="categoryDiv">
						<select class="form-select" onchange="changeSubCategory()"
							id="category">
							<option selected value="">Select Category</option>
							<option value="1">Education</option>
							<option value="2">Technology</option>
							<option value="3">Programming</option>
							<option value="4">Temples</option>
							<option value="5">Places</option>
							<option value="6">Food</option>
							<option value="7">Health</option>
							<option value="8">Job Preparation</option>
							<option value="9">Colleges</option>
						</select>
					</div>

					<div class="subCategorySelectionDiv" style="margin: 10px 0px;">
						<select class="form-select" id="subCategory">
							<option value="">Select Sub-Category</Option>
						</select>
					</div>

					<div class="descriptionList">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="descriptionTitle"
								placeholder="Description Title" required> <label
								for="descriptionTitle">Description Title</label>
						</div>
						<div class="form-floating">
							<div class="form-control" placeholder="Description Details"
								id="floatingTextarea"></div>
						</div>

						<div style="margin-top: 10px;">
							<form id="uploadForm" class="formImg" enctype="multipart/form-data">
								<input class="form-control form-control-lg" name="file"
									id="file" type="file" accept="image/*" required>
							</form>
							<button class="btn btn-info" style="margin-top: 10px;" onclick="uploadImage('uploadForm' , 'message', 'uploadedImageContainer', 'uploadedImage')">
									<i class="bi bi-cloud-upload-fill"></i> Upload Image
								</button>
							<div id="message"></div>
							<div id="uploadedImageContainer"
								style="display: none; text-align: center;">
								<img id="uploadedImage" alt="Uploaded Image">
							</div>
						</div>
					</div>

					<!-- file Selection  -->

				</div>
				<!--Description  -->
			</div>
			<!-- Descriptions -->

			<div style="margin: 10px 5px; text-align: right;">
				<button type="button" class="btn btn-success"
					onclick="saveBlogOrNews();">
					<i class="bi bi-check2"></i> Save
				</button>

				<button type="reset" class="btn btn-danger">
					<i class="bi bi-x"></i> Clear form
				</button>

				<button type="button" class="btn btn-light" onclick="addExtraDescrFields()">
					<i class="bi bi-plus-lg"></i> Add Extra Description
				</button>
			</div>
			<!-- Add Description Buttons -->


		</div>
	</div>
	
	<div class="afterSavingDataDiv"  style="display: none;"><!--   -->
		<div class="messageBlog">
			<h1 style="color: green;"> Blog is created successfully.</h1>
			<a id="blogLink">Visit your Blog Or News</a><br>
			<a href="/eduonnetblog/createblog">Create New blog</a>
		</div>
	
	</div>

</body>
</html>