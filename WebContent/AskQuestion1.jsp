<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

   <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
   <script type="text/javascript">
    // function on clicking usericon
     $(document).ready(function(){
    	 $("#ask_question_form").hide();
    	 $("#article_in_pic").hide();
    	
    	  
     });
    </script>
<script src="tinymce/js/tinymce/tinymce.min.js"></script>
<script src="tinymce/js/tinymce/jquery.tinymce.min.js"></script>

 <script>
 $(document).ready(function(){
  tinymce.init({
    selector: '#question',
    	menubar: false,
    	plugins: 'image code link',
    	paste_data_images: true,
    	height:200,
    	toolbar: [
    	          'bold italic link image code alignleft aligncenter alignright undo redo'
    	        ],
    	          

  });
 });
  </script>
   
   <script>
 $(document).ready(function(){
  tinymce.init({
    selector: '#ArticleTextArea',
    	menubar: false,
    	plugins: 'image code link',
    	paste_data_images: true,
    	height:200,
    	toolbar: [
    	          'bold italic link image code alignleft aligncenter alignright undo redo'
    	        ],
    	          

  });
 });
  </script>
   
   <script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>
    <style>
    .hidden{display:none;}
		.question-form-wrapper{
			display:flex;
			justify-content: center;
			flex-direction: column;
			font-family:Roboto,Tahoma;
			}
			*:focus{border:none;outline:none;}
		.ask_question_form{
			display:flex;
			flex-direction: column;
		}
		.topic{
			height:32px;
			border:none;
			font-size:16px;
			padding-left:5px;
			font-weight:100;
			color:#333;
			margin-top:10px;
			margin-bottom:10px;
			font-family:"Roboto",sans-serif;
	        border-bottom:1px solid #ebebeb;
		}
		.topic:focus{
		border-bottom:1px solid #ebebeb;
		}
		#subtopic{
			height:32px;
			border:none;
			font-size:16px;
			padding-left:5px;
			font-weight:100;
			color:#333;
			margin-top:0px;
			font-family:"Roboto",sans-serif;
	        .background-color:#ebebeb;
	        border-bottom:1px solid #ebebeb;
		}
		#subtopic:focus{
		border-bottom:1px solid #ebebeb;
		}
		.submit{
			width:100px;
			margin:10px auto;
			color:#fff;
	        cursor: pointer;
	        font-family: 'Roboto', sans-serif;
	        border:none;
	        display:flex;
	        justify-content:center;
            background-color:#339cf5;
            font-size:16px;
            font-weight:100;
            padding:8px 5px 8px 5px;
			box-shadow: 0 1px 4px rgba(0, 0, 0, .6);
		}
		.submit:hover{background-color:#2f87d1;color:#fff;}
        .submit:active,.submit:focus{background-color:#2f87d1;color:#fff;}
		.modal-content .modal-body .close{
			position:absolute;
			top:13px;
			right:15px;
			opacity:1;
            line-height:100%;
		}
		 .modal-content .modal-body .close:hover
	  {
		 
	  }
		.modal-content .modal-body h1{
			color:white;
			.background:#eee;
			color: #333;
			text-align:center;
			font-size:30px;
			font-family:"Roboto",sans-serif;
			letter-spacing:1px;
			margin-top:-15px;
			margin-left:-15px;
			margin-right:-15px;
			font-weight:100;
			padding:10px;
		}
	.inputfile {
    width: 0.1px;
    height: 0.1px;
    opacity: 0;
    overflow: hidden;
    position: absolute;
   border:none;
    z-index: -1;
}

.inputfile + label {
    max-width: 100%;
    text-overflow: ellipsis;
    white-space: nowrap;
	text-align:center;
    cursor: pointer;
    display: inline-block;
    overflow: hidden;
     margin-bottom:10px;
    padding: 0.925rem 1.25rem;
    border:none;
    
}
.inputfile + label img 
{
margin-top:-3px;
}

.no-js .inputfile + label {
    display: none;
}
.inputfile-1 + label {
    color: #333;
	 background-color:#ececec;
	border:1px solid #fff;
	height:38px;
	font-family:Roboto,Tahoma;
	font-size:15px;
	margin-top:10px;
	font-weight:100;
	}

.inputfile-1:focus + label,
.inputfile-1.has-focus + label,
.inputfile-1 + label:hover {
    background-color:#e1e1e1;
}
		
		
#topic{
			height:35px;
			border:none;
			font-size:16px;
			margin-bottom:10px;
			padding-left:5px;
			font-weight:100;
			color:#333;
			font-family:"Roboto",sans-serif;
	        .background-color:#ebebeb;
	        border-bottom:1px solid #ebebeb;
			}
.modal-content{
border-radius:0px;
}	
.upload_wrapper{
position:relative;
display:flex;
flex-direction:row;
width:100%
}
.upload_description
{
position:relative;
display:flex;
flex-direction:column;
float:left;
width:250px;
background:#2874f0;
}
.upload_description p
{
margin:0;
padding:10px;
color:#fff;
font-size:20px;
padding-top:20px auto;
font-family:"PT Sans",sans-serif;
font-weight:100;
text-align:justify;
text-align:center;
overflow:hidden;
}
.upload_description img
{
  width:100px;
  height:100px;
  margin:120px auto;
 
}
.upload-form-wrapper{
			display:flex;
			justify-content: center;
			flex-direction: column;
			font-family:Roboto,sans-serif;
			width:calc(100% - 250px);
			padding-left:10px;
			padding-right:10px;
			}
@media screen and (max-width:550px)
{
.upload_description{display:none;}
.upload-form-wrapper{width:100%;}


}
	
	</style>
</head>
<body>


 

  

  <!-- Modal -->
  <div class="modal fade" id="AskQuestionModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        
        <div class="modal-body">
       <img src="images/letter-x.svg" class="close" data-dismiss="modal" width="12px" height="12px">
         
         
   <h1>Ask Question</h1>
<div class="question-form-wrapper">
	
<form  action="#" id="question_in_text_form"   Class="ask_question_form" enctype="multipart/form-data">
  <input type="text" name="topic"class="topic"  placeholder="Topic" required >
<textarea class="write-question" id="question" name="question"  placeholder="write your question here"></textarea>
 <input name="image" type="file" id="upload" class="hidden" onchange="">
 <input type="submit" value="Submit" class="submit">
</form>
</div>
</div>
      
    
</div>
      
</div>
</div>
	  
	 
	  
	  
	  
	  
	  
	    

  <!-- Modal -->
  <div class="modal fade" id="WriteArticleModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        
        <div class="modal-body">
       <img src="images/letter-x.svg" class="close" data-dismiss="modal" width="12px" height="12px">
         
         
     <h1>Write Your Article</h1>



<form method="get"  id="article_in_text"   Class="ask_question_form" enctype="multipart/form-data"  >

 <input type="text" name="topic"  class="topic" placeholder="Topic" >
	
<textarea name="article" class="write-question" id="ArticleTextArea" rows="13" placeholder="Write your article here"></textarea>

 <input type="submit" value="Submit" class="submit">
 
</form> 
</div>
</div>
      
    
      </div>
      
    </div>
  </div>
	  
	  <!--  modal -->
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  	  
	    

  <!-- Modal -->
  <div class="modal fade" id="uploadModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        
        <div class="modal-body"style="padding:0">
       
      <div class="upload_wrapper">
      <div class="upload_description">
      <p>Upload File<br>This will help other member access useful files easily</p>
  <img src="images/database.svg">
      </div>
<div class="upload-form-wrapper">
<img src="images/letter-x.svg" class="close" data-dismiss="modal" width="12px" height="12px">
<form method="post"   id="uploadInClass" Class="ask_question_form"  enctype="multipart/form-data">
 <input type="hidden" name="ClassId" id="file_ClassId" ><br>
<input type="text" name="topic" id="topic" placeholder="Topic"><br>
<input type="text" name="subtopic" id="subtopic" placeholder="Write about file"><br>
<input type="file" name="file-1[]" id="file-3" "accept=".xlsx,.xls,image/*,.doc, .docx.,.ppt, .pptx,.txt,.pdf" class="inputfile inputfile-1"/>
<label for="file-3"><span>Choose a file</span></label>
<input type="submit" value="Submit" class="submit" >	
</form> 
 
</div>
</div>
   </div>   
    
      </div>
      
    </div>
  </div>
	  
	  <!--  modal -->
	  
	  
	  
	  
	  
	  
  
	  
<script>
function myFunctionQuestion() {
	var check=$( "#mySelectQuestion" ).val();
	
	if(check=="1"){
		$("#question_in_text_form").hide();	
		$('#question').val('');
		$("#ask_question_form").show();	
	}else {
		$("#ask_question_form").hide();
		$('#uploadQuestion').val('');
		$("#question_in_text_form").show();
	}
	
}


function myFunctionArticle() {
	var check=$( "#mySelectArticle" ).val();
	
	
	
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






$("form#uploadInClass").submit(function(event){
	  event.preventDefault();
	 
	  $('#spinner').show();
		   $('#file_ClassId').val(angular.element(document.getElementById('classDetailsCtrl')).scope().classId);
		   
	  var formData = new FormData($(this)[0]);

	  $.ajax({
	  	 url: 'uploadServlet',
	      type: 'POST',
	      data: formData,
	   
	      success: function (data) {
	    	 console.log(data);
	       $('#uploadModal').modal('hide');
	   	angular.element(document.getElementById('fileuploadedList')).scope().fileListReload();
	      $('#spinner').hide();
	      },
	      cache: false,
	      contentType: false,
	      processData: false
	  });
	 
	 
	  return false;
	});





</script>
<script src="js/custom-file-input.js"></script>

</body>
</html>

