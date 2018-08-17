   
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html >
<head>

<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Question List</title>

<style>
	.answerCommon{
		position:relative;
		width:100%;
		height:auto;
		background:#fff;
		margin-bottom:7px;
	
	}
	.AnswerHeaderr{
		width:100%;
		border-bottom:1px solid #f1f1f1;
		margin-bottom:10px;
	            }
	.AnswerHeaderr ul{
		display:flex;
		width:100%;
		font-size:10px;
		list-style:none;
		padding:0;
		margin:0;
	}
	.AnswerHeaderr ul li{
		display:flex;
		color:#393636;
		font-size:10px;
		padding:4px 0px 4px 0px;
		justify-content:center;
		font-family:Roboto,Tahoma;
		width:100%;
	}
	.ArticleContent{
		padding-bottom:5px;
		width:100%;
		min-height:150px;
		text-align:left;
		padding:10px;
		font-family:Roboto,Tahoma;
		color:#393636;
		
	}
	.ArticleButton{
		width:100%;
		position:relative;
		display:flex;
		justify-content:center;
		
		padding-bottom:10px;
		padding-top:10px;
		color:#737579;
		text-align:center;
		
	}
	.ArticleButton a{
		text-decoration:none;
		font-family:Roboto,Tahoma;
		margin-right:15px;
		cursor:pointer;
		color:#737579;
	}
	.ArticleButton img{
	width:20px;
	height:20px;
	margin-right:5px;
	}
	.ArticleContent img{
		width:80%;
		margin:0px auto;
		height:auto;
	}
</style>
</head><body>

<div  class="Question"  >

<div id="questionAngular" >

<div ng-repeat="question in questionList">

<div ng-if="question.is_pic == '0' ">

	<div class="answerCommon">
		<div class="AnswerHeaderr">
			<ul>
				<li style="font-size:10px;">Topic:{{question.topic}}</li>
				<li style="font-size:10px;">Subtopic:{{question.subtopic}}</li>
				<li style="font-size:10px;">Name:{{question.ques_raiser_name}}</li>
				<li style="font-size:10px;">Date:{{question.dateTime}}</li>
			</ul>
		</div>
		<div class="ArticleContent">
			<p ng-bind-html="question.qes_content" ></p>
		</div>
		<div class="ArticleButton">
		<a ng-href="{{getUrlfriendlyString(question.qes_content)}}"  target="_blank"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/view.png">View</a>
	<!--  	<div ng-if="question.qes_raiser == LoginUser"  >-->
		<a class="delete_question" data-value="{{question.ques_id}}" ><img data-value="{{question.ques_id}}" src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/delete+normal.png">Delete</a>
	
		
<a  ng-click="fbQuestionShare(question.qes_content,question.ques_id)" ng-init=""class="shareQuestion"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/share+normal.png">Share</a>
		</div>
	</div>
	
	</div>
	
	
	<div ng-if="question.is_pic == '1' ">
	<div class="answerCommon">
		<div class="AnswerHeaderr">
			<ul>
				<li style="font-size:10px;">Topic:{{question.topic}}</li>
				<li style="font-size:10px;">Subtopic:{{question.subtopic}}</li>
				<li style="font-size:10px;">Name:{{question.ques_raiser_name}}</li>
				<li style="font-size:10px;">Date:{{question.dateTime}}</li>
			</ul>
		</div>
		<div class="ArticleContent">
			<img ng-src="https://d1v0zurmr84n8z.cloudfront.net/{{question.qes_content }}" class="img-responsive">
		</div>
		<div class="ArticleButton">
		<a ng-href="{{getUrlfriendlyString(question.qes_content)}}"  target="_blank"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/view.png">View</a>
		<!--  <div ng-if="question.qes_raiser == LoginUser ">-->
		<a class="delete_question" data-value="{{question.ques_id}}"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/delete+normal.png">Delete</a>
		
		
<a  ng-click="fbQuestionShareImage(question.qes_content,question.ques_id)" ng-init=""class="shareQuestion"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/share+normal.png">Share</a>
		
		</div>
	</div>	
	
	</div>
	
	
	</div>
	
	
</div>
</div>	
	
	
	
	



 
 <script type="text/javascript">
//function loadpeople(){
	
	

 
// angular.bootstrap(document.getElementById("questionApp"), ['question']);
//}
 </script>


<script type="text/javascript">
    // question delete option clicked by admin
    $( "body" ).delegate( ".delete_question", "click", function(event) {
   // $('.questionFetchingLink').click(function(){
    	//var qes_id=this.id;
    	var qes_id=$(event.target).attr("data-value");
    	angular.element(event.target).parent().parent().parent().remove();
    	 $.ajax({
			 type: "POST",
    		 url: "Delete_Saved_Items",
    		 dataType: "json",
    		 cache: false,
    		 data: {ques_Id:qes_id,flag:"question"},
    		         success: function(data){
    		        	console.log(data);
    		        	
    		         
    		         },
    		 error: function(){
    		  alert("fail");
    		 }
			 
			 }); 
    
    	
    	
    	return false; });
    
</script>





</body>
</html>