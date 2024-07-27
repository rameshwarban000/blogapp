/**
 *@augments Rameshwar Bansode.  
 */

function getLocalChach(){
	let cache = {
		blogOrNewsList : [],
		getBlogOrNewsList : function (){
			if(cache.blogOrNewsList != undefined && cache.blogOrNewsList != null && cache.blogOrNewsList.length > 0 ){
				return cache.blogOrNewsList;
			}else{
				let blogOrNewsList = getBlogOrNewsListAjax();
				return blogOrNewsList;
			}
			
		},
		getBlogOrNewById: function(id) {
			if (cache.blogOrNewsList != undefined && cache.blogOrNewsList != null && cache.blogOrNewsList.length > 0) {
				let blogOrNews = cache.blogOrNewsList.find(obj => obj.id == id);
				return blogOrNews;
			}
		},
		removeBlogOrNewsFromListAndReturn : function (id){
			if (cache.blogOrNewsList != undefined && cache.blogOrNewsList != null && cache.blogOrNewsList.length > 0) {
				cache.blogOrNewsList = cache.blogOrNewsList.filter(obj => obj.id != id)
				return cache.blogOrNewsList;
			}
		}
		
	}
	return  cache;
}

        
function renderTable(blogsAndNews, isNew) {
		let tBody = $('#mainTableBody');
		tBody.empty();
	if (blogsAndNews != undefined && blogsAndNews != null && blogsAndNews.length > 0) {
		/*id, category , date , subCategory, title, type*/
		let count = 1;
		for (let blgorNewsObj of blogsAndNews) {
			let tr = $(`<tr id="tr_${blgorNewsObj.id}"></tr>`);
			tBody.append(tr);
			let typeName  = getType(blgorNewsObj.type);
			let subCategoryName  = getSubCategoryName(blgorNewsObj.type);
			let tds = $(`
					<td>${count}</td>
					<td>${blgorNewsObj.title}</td>
					<td>-</td>
					<td>-</td>
					<td>${converMillisecondsToDate(blgorNewsObj.date)}</td>
					<td>
						<a href="/eduonnetblog/blogDetails/${blgorNewsObj.id}"><i class="bi bi-book" title="Read "></i></a>
						<i class="bi bi-pencil-square" title="Edit"></i> 
						<i class="bi bi-trash3-fill" onclick="deleteEntry(${blgorNewsObj.id})" title="Delete"></i>
					</td>
				`);
			tr.append(tds);
			count++;
		}
		if(isNew){
			$('#mainTable').DataTable({
				// You can add DataTables configuration options here
			});
		}
	
	}else{
			$('#noRecordsFound').show();
	}
}
function getType(typeId){

}

function getSubCategoryName(subTypeId){
	
}

function deleteEntry(id){
	if(confirm("Confirm Delete?")){
		let password = prompt("Please enter Password");
		deleteBlogAjax(id, password)
	}
}

function editBlogOrNews(id){
	//open blogOrNews with description in add or edit page 
}

/*Utiliti method*/
function converMillisecondsToDate(milliseconds){
	const date = new Date(milliseconds);
	const options = {year : 'numeric', month : '2-digit', day : '2-digit' }
	const formattedDate = date.toLocaleDateString('en-GB',options);
	return formattedDate;
}


/*---------------------------------Ajax for delete blog or news-------------------------*/

function deleteBlogAjax(id, password){
	let body = {
		blogOrNewId : id,
		password : password
	}
	$.ajax({
		url: deleteBlogURL,
		
		type : 'POST',
		data: JSON.stringify(body),
		contentType: "application/json; charset=utf-8",
		dataType: "html", // Change this to "html"
		error: function(error) {
			//showToster('error', 'Error in POST request.', error + "!.", 5, 'right');
		},
		success: function(res) {
			let reposonce = JSON.parse(res);
			if(reposonce.status){
				alert("Object is deleted");
				// delete object from cache 
				let list  = cache.removeBlogOrNewsFromListAndReturn(id);
				// re-render table.
				renderTable(list, false);
			}else{
				alert(reposonce.errorMessage);
			}
		}
	})
}

function getBlogOrNewsListAjax(){
	//
}
 