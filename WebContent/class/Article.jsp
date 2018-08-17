<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/article.css?version=41455">
<title></title>
 
<script> 
$(document).ready(function(){
	$( "body" ).delegate( ".article_ref_body", "click", function(){
		$(this).children('.article_ref_arrow').stop(true, false, true).toggle();
		$(this).children('.article_ref_content').stop(true, false, true).slideToggle(300);
        
    });
	$("body").delegate( ".article_refer_click", "click", function(event){

		$(event.target).parent().parent().children('.article_refer_arrow').stop(true, false, true).toggle();
		$(event.target).parent().parent().children('.article_refer_content').stop(true, false, true).slideToggle(300);
		$(event.target).parent().children('.article_refer_arrow').stop(true, false, true).toggle();
		$(event.target).parent().children('.article_refer_content').stop(true, false, true).slideToggle(300);
	});
});
</script>
 <style>
    
 
 </style>
</head>
<body>

<!-- BackToTop Button -->
<a href="javascript:void(0);" id="scroll" title="Scroll to Top" style="display: none;">Top<span></span></a>

<div class="wrap" id="articleApp" >
<div id="articleAngular" ng-controller="articleCtrl">


<div class="searchbartext">
    <div class="wrapboth">


<input type="text" ng-model="test" class="header-search-input" placeholder="SEARCH THIS CLASSROOM">
<img src="images/search.svg" class="searchIcon">
</div>
    </div>
   <div ng-if="articleList.length == '0' "   style="display:flex;flex-direction:column;justify-content:center;margin:0px auto;">

<img ng-src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/no_content/no+article.png"  height="15%" width="15%" style="margin:40px auto">
<a href="http://class25.businesscatalyst.com/classroom-assist.html" target="_blank" style="text-align:center;margin-top:30px;margin-bottom:130px;font-size:16px;font-family:"Roboto",sans-serif;">Click Here To Know More</a>
</div>  

<div class="article" id="" ng-repeat="article in articleList | filter : test |orderBy:'article_id':true">
<div class="article_detail">
<p>Topic:{{article.topic}}</p>
<p>Subtopic : {{article.subtopic}}</p>
<p>Written by :{{article.article_writer_name}}</p>
<p>Date:{{article.dateTime}}</p>
</div>

<div class="articleTextContent"  ng-bind-html="article.article_content"> 
</div>				

<div class="articleFooter">


<div ng-if="article.article_writer == LoginUser  || ISCLASSADMIN == 'true' ||ISSUBADMIN == 'true' "  >
<a title="Delete" title="delete this article" class="delete_article" data-id="{{article.article_id}}"><img data-id="{{article.article_id}}" src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/delete.svg"alt="Delete">Delete</a>
</div>
	<!--  	<button data-value="{{question.ques_id}}" class="save_question"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/bookmark1.svg">Bookmark</button>
		<a  ng-click="fbQuestionShare(question.qes_content,question.ques_id)" ng-init=""class="shareQuestion"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/share.svg">Share</a>-->
		<div class="article_ref_body">
	<!-- 	<button class="ArticleRefrenceCheckButton" data-value="{{article.article_id}}"><img class="ArticleRefrenceCheckButton" data-value="{{article.article_id}}" src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/eye.svg">Reference</button> --> 
		<div class="article_ref_arrow"></div>
		<div class="article_ref_content">
		<img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/balls.svg" class="article_ref_loader">
		<div class="article_ref_table_content">
		<table class="article_question_table">
   <tr>
    <th>Question ID</th>
    <th>Name</th>
    <th>Date</th>
  </tr>
  <tbody ng-repeat="refQues in refArticleResult.Ques_Ref_Article_list">
  <tr>
    <td>{{refQues.ques_id}}</td>
    <td>{{refQues.name}}</td>
    <td>{{refQues.dateTime}}</td>
  </tr>
  </tbody>
  
  </table>
  
  
  <table class="article_article_table">
   <tr>
    <th>Article ID</th>
    <th>Name</th>
    <th>Date</th>
  </tr>
   <tbody ng-repeat="refarticle in refArticleResult.Article_Ref_Article_list">
  <tr>
    <td>{{refarticle.article_id_2}}</td>
    <td>{{refarticle.name}}</td>
    <td>{{refarticle.dateTime}}</td>
  </tr>
   </tbody>
 
  </table>
  
  
  
  <table class="article_video_table">
   <tr>
    <th>Video ID</th>
    <th>Name</th>
    <th>Date</th>
  </tr>
    <tbody ng-repeat="refvideo in refArticleResult.Article_Ref_Video_list">
  <tr>
    <td>{{refvideo.Video_id}}</td>
    <td>{{refvideo.name}}</td>
    <td>{{refvideo.dateTime}}</td>
  </tr>
 </tbody>
  </table>
		</div>
		</div>
		</div>
		
		<div class="article_refer_body">
	<!-- 	<button class="article_refer_click"><img ng-src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/add.svg" class="refer">Reference</button> --> 
		<div class="article_refer_arrow"></div>
		<div class="article_refer_content">
		<form  ng-submit="FormSubmit($event)" onsubmit="event.returnValue = false; return false;">
		<select class="article_refer_select" name="refrenceTO">
        <option value="question">Question</option>
        <option value="article">Article</option>
        <option value="video">Video</option>
        </select>
        <input type="number" name="refToId"  placeholder="Enter ID" required /><br>
          <input type="hidden" name="refFromId" value="{{article.article_id}}">
        <input type="submit"  value="Submit" class="article_refer_submit">
		</form>
		</div>
		</div>
		</div>
</div>
</div>

 
 </div>


 
 <script type="text/javascript">
//function loadpeople(){
	
	
	
// var app = angular.module('article', ['ngSanitize']);
 
 
 //angular.bootstrap(document.getElementById("articleApp"), ['article']);
//}
 </script>
 
 <script type="text/javascript">
 
 $( "body" ).delegate(".delete_article","click", function(event) {
		
	   	angular.element(event.target).parent().parent().parent().parent().parent().remove();
	   	var articleId=$(event.target).attr("data-id");
	   //	alert(articleId);
	   	$.ajax({
				 type: "POST",
	  		 url: "Delete_Article",
	  		 dataType: "json",
	  		 cache: false,
	  		 data: {articleId:articleId},
	  		         success: function(data){
	  		     
	  		        	if(data.b=="true"){
	  		        	
	  		        	}
	      
	  		        	          
	  		         }, // end of success function
	  		 error: function(){
	  			 alert("fail");
	  		 }
				 
				 });  	
	   	return false; });
 
 
 
 
 
 
 
 
 


 
 $( "body" ).delegate( ".ArticleRefrenceCheckButton", "click", function(event) {
	  
	    		var article_id=$(event.target).attr("data-value");
	    	 $('.article_ref_arrow').hide();
	    	 $('.article_ref_content').hide();
	    		$('.article_ref_loader').show();
	    		
	    		angular.element(document.getElementById('articleAngular')).scope().refArticleResult=[];
	    		angular.element(document.getElementById('articleAngular')).scope().$apply();
				console.log(article_id);
				$(this).siblings('.article_ref_arrow').stop(true, false, true).toggle();
				$(this).siblings('.article_ref_content').stop(true, false, true).slideToggle(300);
	    	$.ajax({
				 type: "GET",
	   		 url: "Fetc_Article_Ref",
	   		 dataType: "json",
	   		 cache: false,
	   		 data: {article_id:article_id,class_id:angular.element(document.getElementById('classDetailsCtrl')).scope().classId},
	   		         success: function(data){
	   		       angular.element(document.getElementById('articleAngular')).scope().refArticleResult=data;
	   	 angular.element(document.getElementById('articleAngular')).scope().$apply();
	   	$('.article_ref_loader').hide();
	   		           
	   		         }, // end of success function
	   		 error: function(){
	   			 alert("fail");
	   		 }
				 
				 });  	
	    	return false; });
 
 
 
 
 </script>
</body>
</html>