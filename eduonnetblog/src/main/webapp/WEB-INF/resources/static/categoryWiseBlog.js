

function renderNews(newsList, descWiseImages) {
	// corasole
	if (newsList != undefined && newsList.length > 0) {
		let counter = 0;
		let slidCount = 1;
		for (let news of newsList) {
			let corasolBtn = $(` <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="${counter}" aria-label="Slide ${slidCount}"></button>`);
			if (slidCount == 1) {
				corasolBtn.addClass('active');
			}
			$(`.carousel-indicators`).append(corasolBtn);

			let carouselItem = $(`<div class="carousel-item ${slidCount == 1 ? 'active' : ''}" data-bs-interval="6000"></div>`)
			$(`.carousel-inner`).append(carouselItem);

			let imageSrc = "";

			if (news.descriptions[0].title != undefined) {
				if (descWiseImages != undefined) {
					let descriptionObj = news.descriptions[0];

					let image = descWiseImages[descriptionObj.id];
					// Inside your renderNews function

					if (image != undefined) {
						imageSrc = getImageURLUsingByteData(image.data)
					}
				}
			}
			if (imageSrc == "") {
				let carouseImg = $(` <img scr='<c:url value="/resources/static/img/RamMandir.jpeg"/>'  class="d-block w-100" alt="No Image Found">`)
				carouselItem.append(carouseImg);
			} else {
				let carouseImg = $(` <img  class="d-block w-100" alt="No Image Found">`)
				carouseImg.attr("src", imageSrc);
				carouselItem.append(carouseImg);
			}

			let carouselCaption = $(`<div class="carousel-caption d-none d-md-block"></div>`);
			carouselItem.append(carouselCaption);

			let title = $(`<h5>${news.title}</h5>`);
			carouselCaption.append(title);
			let descriptionTitle = $(`<p>${news.descriptions[0].title}</p>`);
			carouselCaption.append(descriptionTitle);
			counter++;
			slidCount++;
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

function renderBlogList(blogList, descWiseImages) {
	if (blogList != undefined && blogList != null && blogList.length > 0) {
		for (let blog of blogList) {
			let blogsMainDiv = $('#blogsMainDiv');
			// card
			let cardBlogDiv = $(`<div class="card" id="blog_${blog.id}" style="width: 18rem;" ></div>`);
			blogsMainDiv.append(cardBlogDiv);

			let imageSrc = "";

			if (blog.descriptions[0].title != undefined) {
				if (descWiseImages != undefined) {
					let descriptionObj = blog.descriptions[0];

					let image = descWiseImages[descriptionObj.id];
					// Inside your renderNews function

					if (image != undefined) {
						imageSrc = getImageURLUsingByteData(image.data)
					}
				}
			}

			//Image
			let cardImage = $(`<img  class="card-img-top blogImage" alt="..." >`);
			cardImage.attr('src', imageSrc);
			cardBlogDiv.append(cardImage);

			// Card body
			let cardBody = $(`<div class="card-body"></div>`);
			cardBlogDiv.append(cardBody);

			// card body date 
			const formattedDate = formatDateFromMilliseconds(blog.date);
			let bodyDate = $(`<span title="Date"><i class="bi bi-calendar"></i> : ${formattedDate}</span>`);
			cardBody.append(bodyDate);


			//card body title 
			let bodyTitle = $(`<a href="/eduonnetblog/blogDetails/${blog.id}" class="blogDetailLink"><h5 class="card-title" title="Title">${blog.title}</h5></a>`);
			cardBody.append(bodyTitle);


			// card body context 
			let bodyContext = $(`<div class="blogContext">
					<p class="card-text" title="context">${blog.descriptions[0].title}</p>
				</div>`)
			cardBody.append(bodyContext);



			let socialBtnDiv = $(`<div class="socialBtnDiv">
					<div class="blogBtnDiv" title="share">
						<button class="btn btnBlog">
							<i class="bi bi-share"></i>
						</button>
					</div>
				</div>`);
				/*<div class="blogBtnDiv" title="like">
						<button class="btn btnBlog">
							<i class="bi bi-hand-thumbs-up"></i>
						</button>
					</div>*/
						/*<div class="blogBtnDiv" title="unlike">
						<button class="btn btnBlog">
							<i class="bi bi-hand-thumbs-down"></i>
						</button>
					</div>*/
			cardBody.append(socialBtnDiv);
		}
	}
}


function formatDateFromMilliseconds(milliseconds) {
	// Create a new Date object from milliseconds
	const date = new Date(milliseconds);

	// Define months array for formatting
	const months = [
		"Jan", "Feb", "Mar", "Apr", "May", "Jun",
		"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
	];

	// Get day, month, and year from the date object
	const day = String(date.getDate()).padStart(2, '0');
	const month = months[date.getMonth()];
	const year = date.getFullYear();

	// Return formatted date string
	return `${day} ${month} ${year}`;
}

function renderNewInCard(newsList, descWiseImages) {
	if (newsList != undefined && newsList.length > 0) {
		
		for(let news of newsList){
			
			let newsDiv  = $(`<div class="col"></div>`);
			$('.newsMainDiv').append(newsDiv);
			
			let newsCardDiv = $(`<div class="card"></div>`);
			newsDiv.append(newsCardDiv);
			
			
			let imageSrc = "";

			if (news.descriptions[0].title != undefined) {
				if (descWiseImages != undefined) {
					let descriptionObj = news.descriptions[0];

					let image = descWiseImages[descriptionObj.id];
					// Inside your renderNews function

					if (image != undefined) {
						imageSrc = getImageURLUsingByteData(image.data)
					}
				}
			}
			
			let newsImage = $(`<img  class="card-img-top" alt="...">`);
				newsImage.attr('src' ,imageSrc );
			newsCardDiv.append(newsImage);
			
			let newsCardBody  = $(`<div class="card-body"></div>`);
			newsCardDiv.append(newsCardBody);
			
			let newsTitle  = $(`<h5 class="card-title">${news.title}</h5>`);
			newsCardBody.append(newsTitle);
			
			let newsDescTitle = $(`<p>${news.descriptions[0].title}</p>`);
			newsCardBody.append(newsDescTitle);
		}
	}
}


