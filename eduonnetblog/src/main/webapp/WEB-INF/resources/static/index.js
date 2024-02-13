/**
 * 
 */

var newsData = [
	{
		"id": 1,
		"title": "Ram Mandir News",
		"desc": "Ram mandir opening is on 22 Jan 2024",
		"img": "",
		"postType": "news",
		"category": "",
		"subCategory": "",
		"date": "",
		"expiredate": ""
	}
];

var blogs = [
	{
		"id": 1,
		"title": "Ram Mandir News",
		"desc": "Ram mandir opening is on 22 Jan 2024",
		"img": "",
		"postType": "news",
		"category": "",
		"subCategory": "",
		"date": "",
		"expiredate": ""
	}
];

let categories = [
	{
		title: "Education",
		icon: '<i class="bi bi-backpack3-fill"></i>',
		id: "1"
	},
	{
		title: "Technology",
		icon: '<i class="bi bi-motherboard"></i>',
		id: "2"
	},
	{
		title: "Programming",
		icon: '<i class="bi bi-code-slash"></i>',
		id: "3"
	},
	{
		title: "Temples",
		icon: '<i class="bi bi-house-fill"></i>',
		id: "4"
	},
	{
		title: "Places",
		icon: '<i class="bi bi-geo-alt-fill"></i>',
		id: "5"
	},
	{
		title: "Food",
		icon: '<i class="bi bi-basket2"></i>',
		id: "6"
	},
	{
		title: "Health",
		icon: '<i class="bi bi-lungs-fill"></i>',
		id: "7"
	},
	{
		title: "Job Preparation",
		icon: '<i class="bi bi-bag-fill"></i>',
		id: "8"
	},
	{
		title: "Colleges",
		icon: '<i class="bi bi-bank"></i>',
		id: "9"
	},
]

function renderNews(newsList) {
	if (newsList != undefined && newsList.length > 0) {
		for (let news of newsList) {
			let newsDiv = $('<div class="news"> </div>');
			$(".newsNews").append(newsDiv);

			let mainTitleAndDescription = $('<div class="mainTitleAndDescription" style=""></div>');
			newsDiv.append(mainTitleAndDescription);

			let newTitle = $(`<div class="newTitle"></div>`);
			mainTitleAndDescription.append(newTitle);
			let b = $(`<b>${news.title}</b>`);
			newTitle.append(b);

			let description = $(`<div class="description"></div>`);
			mainTitleAndDescription.append(description);
			let descriptionHeader = $(`<b>Description : </b>`);
			description.append(descriptionHeader);
			if (news.descriptions[0].title != undefined) {
				if (descWiseImages != undefined) {
					let descriptionObj = news.descriptions[0];

					let image = descWiseImages[descriptionObj.id];
					// Inside your renderNews function

					if (image != undefined) {
					
						let imageUrl = getImageURLUsingByteData(image.data)
						mainTitleAndDescription.css('background-image', 'url(' + imageUrl + ')');
					}
					description.append($(`<p>${news.descriptions[0].title}</p>`));
				}
				let socialDiv = $(`<div class="socialDiv"></div>`);
				newsDiv.append(socialDiv);

				let shareBtn = $(`<button class="share"></button>`);
				socialDiv.append(shareBtn);
				shareBtn.append($(`<i class="bi bi-share-fill"></i>`));
			}
		}
	}
}
// convert byte code to image 
function getImageURLUsingByteData(byteData) {
	var blob = new Blob([new Uint8Array(byteData)],
		{
			type: 'image/png'
		});
	return URL.createObjectURL(blob);
}

function renderBlogList(blogList) {
	if (blogList != undefined && blogList != null && blogList.length > 0) {
		for (let blog of blogList) {
			let blogsDiv = $('.blogsDiv');
			let blogDiv = $(`<div class="blog" id="blog_${blog.id}" onclick=""></div>`);
			blogsDiv.append(blogDiv);

			let blogImg = $(`<div class="blogImg"></div>`);
			if (blog.descriptions != undefined && blog.descriptions.length > 0) {

				let image = descWiseImages[blog.descriptions[0].id];
				if (image != undefined) {

					let imageUrl = getImageURLUsingByteData(image.data)
					blogImg.css('background-image', 'url(' + imageUrl + ')');
					blogImg.css('background-size', 'cover');
					blogImg.css('background-position', 'center');
				}
			}
			blogDiv.append(blogImg);
			let dateAndDescriDiv = $(`<div></div>`);
			blogDiv.append(dateAndDescriDiv);

			let blogDate = $(`<div class="blogDate">12/12/24</div>`);
			dateAndDescriDiv.append(blogDate);

			let blogTitle = $(`<div class="blogTitle">${blog.title}</div>`);
			dateAndDescriDiv.append(blogTitle);

			let likeUnlikeBtnDiv = $(`<div class="likeUnlikeBtnDiv">
				<i class="bi bi-hand-thumbs-up"></i>
				<i class="bi bi-hand-thumbs-down"></i>
				<i class="bi bi-chat-left"></i>
				<i class="bi bi-share"></i>
				</div>`);
			dateAndDescriDiv.append(likeUnlikeBtnDiv);
		}
	}
}


function renderCategories() {

	for (let category of categories) {
		let categoryDiv = $(`<div class="categoryDiv"></div>`);
		$(`.categoriesDiv`).append(categoryDiv);
		let categoryBtn = $(`<button id="categoryBtn_${category.id}" class="categoryBtn">${category.icon} ${category.title}</button>`);
		categoryDiv.append(categoryBtn);
	}
}