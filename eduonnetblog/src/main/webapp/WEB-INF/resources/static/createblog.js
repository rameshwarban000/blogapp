let localCache = {
	
	imageId : ""
}


const categoryWiseSubCategory = {
	
	"1" : [{ key : "1", value :  "Online Learning"},
		   {key : "2", value :  "Study Tips"},
		   { key :"3", value :  "Educational Technology"},
		   { key :"4", value :  "Learning Resources"},
		   { key :"5", value :  "Academic Success"},],//education
	"2" : [{ key :"6", value :  "Gadgets and Devices"},
		   { key :"7", value :  "Software Development"},
		   { key :"8", value :  "Cybersecurity"},
		   { key :"9", value :  "Artificial Intelligence"},
		   { key :"10", value :  "Emerging Technologies"},],//education
	"3" : [{ key :"11", value :  "Programming Languages"},
		   { key : "12", value :  "Web Development"},
		   { key :"13", value :  "Mobile App Development"},
		   { key :"14", value :  "Coding Challenges"},
		   { key :"15", value :  "Version Control"},],//education
	"4" : [{ key :"16", value :  "Historical Temples"},
		   { key :"17", value :  "Religious Practices"},
		   { key :"18", value :  "Temple Architecture"},
		   { key :"19", value :  "Pilgrimage Stories"},
		   { key :"20", value :  "Festivals and Celebrations"},],//education
	"5" : [{ key :"21", value :  "Travel Destinations"},
		   { key :"22", value :  "Historical Landmarks"},
		   { key :"23", value :  "Natural Wonders"},
		   { key :"24", value :  "Hidden Gems"},
		   { key :"25", value :  "Cultural Experiences"},],//education
	"6" : [{ key :"26", value :  "Recipes"},
		   { key : "27", value :  "Culinary Techniques"},
		   { key :"28", value :  "Food Reviews"},
		   { key : "29", value :  "International Cuisine"},
		   { key : "30", value :  "Healthy Eating"},],//education
	"7" : [{ key :"31", value :  "Fitness Tips"},
		   { key :"32", value :  "Mental Health"},
		   { key :"33", value :  "Nutrition"},
		   { key :"34", value :  "Holistic Health"},
		   { key : "35", value :  "Wellness Practices"},],//education
	"8" : [{ key :"36", value :  "Resume Building"},
		   { key : "37", value :  "Interview Tips"},
		   { key :"38", value :  "Career Development"},
		   { key : "39", value :  "Job Search Strategies"},
		   { key : "40", value :  "Professional Networking"},],//education
	"9" : [{ key :"41", value :  "College Life"},
		   { key :"42", value :  "Campus Events"},
		   { key : "43", value :  "Alumni Stories"},
		   { key : "44", value :  "Admission Guidance"},
		   { key : "45", value :  "Academic Programs"},]//education
}

function saveBlogOrNews() {
	// entity data
	let title = $(`#title`).val();
	let type = $(`#typeSelection`).val();
	let category = $(`#category`).val();
	let subCategory = $(`#subCategory`).val();

	// description data
	let descriptionTitle = $(`#descriptionTitle`).val();
	let descriptionText = tinymce.get("descriptionText").getContent();
	

	if (validationBlogForm(title, type, descriptionText)) {
		let descriptions = [{
			title: descriptionTitle,
			description: descriptionText,
			imageId: localCache.imageId
		}]

		let dataObject = {
			title: title,
			type: type,// news 1 // blog 2
			category: category,
			subCategory: subCategory,
			descriptions: descriptions,
		}

		saveBlogOrNewsAjax(dataObject);
	}
}
function validationBlogForm(title, type, descriptionText) {
	if (title != "" && type != "" && descriptionText != "") {
		return true;
	} else {
		return false;
	}
}
function changeSubCategory(){
	let categoryVal = $('#category').val();
	if(categoryVal != undefined && categoryVal != ""){
		$('#subCategory').empty();
		let defaultOption = $(`<option value="">Select Sub-Category</option>`);
		$('#subCategory').append(defaultOption);
		let subCatogories = categoryWiseSubCategory[categoryVal];
		if(subCatogories != undefined && subCatogories != null && subCatogories.length > 0 ){
			for(let subCategory of subCatogories){
				$('#subCategory').append($(`<option value="${subCategory.key}">${subCategory.value}</option>`));
			}
		}else{
			alter('No Sub-Catories for for selection')
		}
		
	}else{
		$('#subCategory').empty();
		let defaultOption = $(`<option value="">Select Sub-Category</option>`);
		$('#subCategory').append(defaultOption);
	}
}

function uploadImage() {
	var form = $('#uploadForm')[0];

	// Create an FormData object 
	var data = new FormData(form);
	uploadImageAjax(data);
}
/*****************************Ajaxs**********************************/
function saveBlogOrNewsAjax(dataObject) {
	$.ajax({
		type: "POST",
		url: saveBlogOrNewsURL,
		data: JSON.stringify(dataObject),
		contentType: "application/json; charset=utf-8",
		dataType: "html", // Change this to "html"
		error: function(error) {
			//showToster('error', 'Error in POST request.', error + "!.", 5, 'right');
		},
		success: function(data) {
			let rdata = JSON.parse(data);
			if (rdata.status) {
				alert("data save")
				//showToster('success', `${dataObject.type} is created Successfully.`, "Account Created Successfully.", 5, 'right');
			} else {
				alert("Fail to save data")
				//showToster('error', `${dataObject.type} saving error : ${rdata.errorMessage}`, rdata.errorMessage + "!.", 5, 'right');
			}
		}
	});
}

function uploadImageAjax(data) {
	$.ajax({
		url: uploadImageURL,
		type: 'POST',
		data: data,
		enctype: 'multipart/form-data',
		processData: false,
		contentType: false,
		success: function(data) {
			if (data.status) {
				localCache.imageId = data.data.id;
				$('#message').html('File uploaded successfully!');
				alert("Image is uploaded Successfully");
				var byteData = data.data.data;
				// Convert byte array to Blob
				var blob = new Blob([new Uint8Array(byteData)],
					{
						type: 'image/png'
					});
				// Create an image element
				var image = document.getElementById('uploadedImage');
				// Set the source of the image to the Blob URL
				image.src = URL.createObjectURL(blob);
				$('#uploadedImageContainer').show();
			} else {
				$('#message').html('Error uploading file: ' + data.errorMessage);
			}
		},
		error: function(xhr, status, error) {
			$('#message').html('Error uploading file: ' + error);
		}
	});
}