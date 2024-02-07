/**
 * 
 */

function showReportAndFeedBack() {
	$('.feedbackAndReportDiv').toggle();
}


function clearReport() {
	$('#reportDiv').hide();
}
function showReport() {
	$('#reportDiv').show();
}

function clearFeedBack() {
	$('#feedbackDiv').hide();

}
function showFeedback() {
	$('#feedbackDiv').show();
}


document.addEventListener('DOMContentLoaded', function() {
  // Select the share button
  var shareButton = document.getElementById('shareblogBtn');

  // Select the modal
  var shareModal = document.getElementById('shareModal');

  // Select the close button inside the modal
  var closeButton = document.querySelector('.close');

  // Add a click event listener to the share button
  shareButton.addEventListener('click', function() {
    // Show the modal
    shareModal.style.display = 'block';
  });

  // Add a click event listener to the close button
  closeButton.addEventListener('click', function() {
    // Hide the modal
    shareModal.style.display = 'none';
  });

  // Add a click event listener to the Facebook share button
  document.getElementById('facebookButton').addEventListener('click', function() {
    // Replace 'your-blog-url' with the actual URL of your blog post
    var blogUrl = encodeURIComponent('your-blog-url');
    var facebookShareUrl = 'https://www.facebook.com/sharer/sharer.php?u=' + blogUrl;
    window.open(facebookShareUrl, 'Facebook Share', 'width=600,height=400');
  });

  // Add a click event listener to the Twitter share button
  document.getElementById('twitterButton').addEventListener('click', function() {
    // Replace 'your-blog-url' with the actual URL of your blog post
    var blogUrl = encodeURIComponent('your-blog-url');
    var twitterShareUrl = 'https://twitter.com/intent/tweet?url=' + blogUrl;
    window.open(twitterShareUrl, 'Twitter Share', 'width=600,height=400');
  });
  
   // Add a click event listener to the WhatsApp share button
  document.getElementById('whatsappButton').addEventListener('click', function() {
    // Replace 'your-blog-url' with the actual URL of your blog post
    var blogUrl = encodeURIComponent('your-blog-url');
    var whatsappShareUrl = 'https://wa.me/?text=' + blogUrl;
    window.open(whatsappShareUrl, 'WhatsApp Share', 'width=600,height=400');
  });

  // Add a click event listener to the Instagram share button
  document.getElementById('instagramButton').addEventListener('click', function() {
    // Replace 'your-blog-url' with the actual URL of your blog post
    var blogUrl = encodeURIComponent('your-blog-url');
    var instagramShareUrl = 'https://www.instagram.com/share?url=' + blogUrl;
    window.open(instagramShareUrl, 'Instagram Share', 'width=600,height=400');
  });
  
   // Add a click event listener to the Copy Link button
  document.getElementById('copyLinkButton').addEventListener('click', function() {
    // Replace 'your-blog-url' with the actual URL of your blog post
    var blogUrl = 'your-blog-url';
    
    // Create a temporary text area element
    var textArea = document.createElement('textarea');
    
    // Set the value of the text area to the blog URL
    textArea.value = blogUrl;

    // Append the text area to the document
    document.body.appendChild(textArea);

    // Select the text inside the text area
    textArea.select();

    // Execute the copy command
    document.execCommand('copy');

    // Remove the text area from the document
    document.body.removeChild(textArea);

    // Optionally, provide feedback to the user
    alert('Blog link copied to clipboard!');
  });
  
});

function listenBlog(){
	
	 var blogDivs = $('.descriptionDetails');
	
	
	 blogDivs.each(function(index, blogDiv) {
      // Get the text content of the div
      var blogText = $(blogDiv).text();

      // Create a new SpeechSynthesisUtterance object
      var speech = new SpeechSynthesisUtterance();

      // Set the text content to be spoken
      speech.text = blogText;

      // Use a timeout to read each blog with a delay
      setTimeout(function() {
        // Speak the text
        window.speechSynthesis.speak(speech);
      }, index * 2000); // Adjust the delay (in milliseconds) between readings
    });
}
