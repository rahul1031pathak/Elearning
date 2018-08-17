<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<title>Write Your Article Here</title>
<link rel="shortcut icon" href="images/globe.png" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>

<meta http-equiv="Cache-control" content="no-cache">

<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<link href="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" href="upload.css" type="text/css" > 
<script src="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>
<script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>

<script type="text/javascript">
    // function on clicking usericon
     $(document).ready(function(){
    	 $("#article_in_pic").hide();
    	 
    	 
    	 $("form#article_in_pi").submit(function(){

    		    var formData = new FormData($(this)[0]);
    		    formData .append("flag","1")
    		    $.ajax({
    		    	 url: 'WriteArticle_Ajax',
    		        type: 'POST',
    		        data: formData,
    		        async: false,
    		        success: function (data) {
    		            alert(data.b)
    		        },
    		        cache: false,
    		        contentType: false,
    		        processData: false
    		    });

    		    return false;
    		});
    
     });
    </script>
   
    	
   
</head>
<body>
<div class="container-fluid">


<div class="askquestion">
<h1>Write Your Article Here</h1>
<select id="mySelect" onchange="myFunction()" name="isPic">
   <option value="0">Written</option>
   <option value="1">in form of image</option>
 </select>


 <form method="post"    id="article_in_pic" Class="ask_question_form" action="WriteArticle" enctype="multipart/form-data">
<input type="text" name="topic" id="topic" placeholder="Topic"><br>
<input type="text" name="subtopic" id="subtopic" placeholder="Sub Topic"><br>
<input type="file" name="file-1[]" id="file-1" accept="image/*" class="inputfile inputfile-1"/>
<label for="file-1"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Choose a file&hellip;</span></label>
<input type="submit" value="Submit" >		
 
</form> 


<form method="get"  id="article_in_text"   Class="ask_question_form" action="WriteArticle" >

 <input type="text" name="topic"  placeholder="Topic" ><br>
<input type="text" name="subtopic" placeholder="Sub Topic"><br>
<textarea name="article" id="question"rows="13" placeholder="Write your question here"></textarea><br>
<input type="submit" value="Submit" >	
 
</form> 

</div>
</div>



<script>
function myFunction() {
	var check=$( "#mySelect" ).val();
	
	if(check=="1"){
		$("#article_in_text").hide();	
		$('#article').val('');
		$("#article_in_pic").show();	
	}else {
		$("#article_in_pic").hide();
		$('#uploadArticle').val('');
		$("#article_in_text").show();
	}
	
}
</script>
<script>
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
			var ValidImageTypes = ["image/gif", "image/jpeg", "image/png"];
			var filetype=this.files[0].type;
			if ($.inArray(filetype, ValidImageTypes) < 0) {
			     // invalid file type code goes here.
				alert("You can not upload this file");
			}
			else{
				//alert("valid");
				
				
				

				if( this.files && this.files.length > 1 )
							fileName = ( this.getAttribute( 'data-multiple-caption' ) || '' ).replace( '{count}', this.files.length );
						else
							fileName = e.target.value.split( '\\' ).pop();

						if( fileName ){
							
							label.querySelector( 'span' ).innerHTML = fileName;
						}
							
						else
							label.innerHTML = labelVal;
		
			}
		});

		// Firefox bug fix
		input.addEventListener( 'focus', function(){ input.classList.add( 'has-focus' ); });
		input.addEventListener( 'blur', function(){ input.classList.remove( 'has-focus' ); });
	});
}( document, window, 0 ));</script>

</body>
</html>