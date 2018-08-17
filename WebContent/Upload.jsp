<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>


<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<link href="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet"> 
<script src="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="upload.css" type="text/css" >

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="shortcut icon" href="images/book.gif" />
<script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>

</head>
<body>
<div class="container-fluid">


<div class="askquestion">
        <h1>WELCOME</h1>
        <form method="post"  enctype="multipart/form-data" id="uploadInClass">
        <input type="hidden" name="ClassId" id="file_ClassId" placeholder="Topic"><br>
          <input type="text" name="topic" id="topic" placeholder="Topic"><br>
<input type="text" name="subtopic" id="subtopic" placeholder="Sub Topic"><br>
<input type="file" name="file-1[]" id="file-1" accept=".xlsx,.xls,image/*,.doc, .docx.,.ppt, .pptx,.txt,.pdf" class="inputfile inputfile-1"/>
<label for="file-1"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Choose a file&hellip;</span></label>
<input type="submit" value="Submit" >		
 
        </form>
  

</div>
</div>

<script>


$("form#uploadInClass").submit(function(){
	 //  $('#spinner').show();
	   $('#file_ClassId').val(angular.element(document.getElementById('classDetailsCtrl')).scope().classId);
  var formData = new FormData($(this)[0]);

  $.ajax({
  	 url: 'uploadServlet',
      type: 'POST',
      data: formData,
   
      success: function (data) {
      	// $('#WriteArticleModal').modal('hide');
      	// angular.element(document.getElementById('articleAngular')).scope().loadArticleList();
      	// $('#spinner').hide();
      },
      cache: false,
      contentType: false,
      processData: false
  });

  return false;
});












'use strict';

;( function ( document, window, index )
{
	var inputs = document.querySelectorAll( '.inputfile' );
	Array.prototype.forEach.call( inputs, function( input )
	{
		var label	 = input.nextElementSibling,
			labelVal = label.innerHTML;

		input.addEventListener( 'change', function( e )
		{
			var fileName = '';
			if( this.files && this.files.length > 1 )
				fileName = ( this.getAttribute( 'data-multiple-caption' ) || '' ).replace( '{count}', this.files.length );
			else
				fileName = e.target.value.split( '\\' ).pop();

			if( fileName )
				label.querySelector( 'span' ).innerHTML = fileName;
			else
				label.innerHTML = labelVal;
		});

		// Firefox bug fix
		input.addEventListener( 'focus', function(){ input.classList.add( 'has-focus' ); });
		input.addEventListener( 'blur', function(){ input.classList.remove( 'has-focus' ); });
	});
}( document, window, 0 ));</script>
</body>
</html>