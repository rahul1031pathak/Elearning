   
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/youtube.css?version=41555">
<title>Question List</title>
<script> 
$(document).ready(function(){
	$( "body" ).delegate( ".video_ref_body", "click", function(){
		$(this).children('.video_ref_arrow').stop(true, false, true).toggle();
		$(this).children('.video_ref_content').stop(true, false, true).slideToggle(300);
        
    });
	$("body").delegate( ".video_refer_click", "click", function(event){

		$(event.target).parent().parent().children('.video_refer_arrow').stop(true, false, true).toggle();
		$(event.target).parent().parent().children('.video_refer_content').stop(true, false, true).slideToggle(300);
		$(event.target).parent().children('.video_refer_arrow').stop(true, false, true).toggle();
		$(event.target).parent().children('.video_refer_content').stop(true, false, true).slideToggle(300);
	});
});
</script>

</head><body>

<div id="YoutubeListApp"  >
<div id="YoutubeListCtrl" ng-controller="YoutubeListCtrl" >


  <div ng-if="YoutubeList.length == '0' "   style="display:flex;flex-direction:column;justify-content:center;margin:0px auto;">

<img ng-src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/no_content/no+video.png"  height="15%" width="15%" style="margin:40px auto">
<a href="http://class25.businesscatalyst.com/classroom-assist.html" target="_blank" style="text-align:center;margin-top:30px;margin-bottom:130px;font-size:16px;font-family:"Roboto",sans-serif;">Click Here To Know More</a>
</div>

<div ng-repeat="youtube in YoutubeList"  class="youtuber">


  <div ng-if="youtube.is_playlist== '0' ">
<div class="youtubewrapper">
	<div class="videoWrapper">
   <iframe width="854" height="480" ng-src=" {{trustSrc(youtube.shared_videos_id)}}" frameborder="0" allowfullscreen></iframe>
    </div>
    </div>
    </div>


 <div ng-if="youtube.is_playlist == '1' ">
 <div class="youtubewrapper">
	<div class="videoWrapper">
   <iframe width="854" height="480" ng-src="{{trustSrcList(youtube.shared_videos_id)}}"  allowfullscreen></iframe>
    </div>
    </div>
 </div>
 <div class="youtubeInformation">
        <p class="videoInformation">{{youtube.video_content}}</p>
        <div class="youtubeButton">
        
       <div ng-if=" ISCLASSADMIN == 'true' ||ISSUBADMIN == 'true' "  > 
        <button title="Delete" title="delete this article" class="delete_article" data-value="{{youtube.id}}"><img data-value="{{youtube.id}}" src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/delete.svg"alt="Delete">Delete</button>
    </div>
     <!--    <button data-value="{{question.ques_id}}" class="save_question"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/bookmark1.svg">Bookmark</button> --> 
		<div class="video_ref_body">
	<!-- 	<button class="VideoRefrenceCheckButton" data-value="{{youtube.id}}"><img class="ArticleRefrenceCheckButton" data-value="{{youtube.id}}" src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/eye.svg">Reference</button> -->
		<div class="video_ref_arrow"></div>
		<div class="video_ref_content">
		<img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/balls.svg" class="video_ref_loader">
		<div class="video_ref_table_content">
		<table class="video_question_table">
   <tr>
    <th>Question ID</th>
    <th>Name</th>
    <th>Date</th>
  </tr>
  <tbody ng-repeat="refQues in refVideoResult.Ques_Ref_Video_list">
  <tr>
    <td>{{refQues.ques_id}}</td>
    <td>{{refQues.name}}</td>
    <td>{{refQues.dateTime}}</td>
  </tr>
  </tbody>
  
  
  </table>
  <table class="video_article_table">
   <tr>
    <th>Article ID</th>
    <th>Name</th>
    <th>Date</th>
  </tr>
  <tbody ng-repeat="refArticle in refVideoResult.Article_Ref_Video_list">
  <tr>
    <td>{{refArticle.article_id}}</td>
    <td>{{refArticle.name}}</td>
    <td>{{refArticle.dateTime}}</td>
  </tr>
  </tbody>
  
  </table>
  <table class="video_video_table">
   <tr>
    <th>Video ID</th>
    <th>Name</th>
    <th>Date</th>
  </tr>
  
  <tbody ng-repeat="refVideo in refVideoResult.Video_Ref_Video_list">
  <tr>
    <td>{{refVideo.video_id_1}}</td>
    <td>{{refVideo.name}}</td>
    <td>{{refVideo.dateTime}}</td>
  </tr>
  </tbody>

  </table>
		</div>
		</div>
		</div>
		
		<div class="video_refer_body">
	<!-- 	<button class="video_refer_click"><img ng-src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/add.svg" class="refer">Reference</button> -->
		<div class="video_refer_arrow"></div>
		<div class="video_refer_content">
		<form  ng-submit="FormSubmit($event)" onsubmit="event.returnValue = false; return false;">
		<select class="video_refer_select" name="refrenceTO">
        <option value="question">Question</option>
        <option value="article">Article</option>
        <option value="video">Video</option>
        </select>
        <input type="number" name="refToId" placeholder="Enter ID" required/><br>
        <input type="hidden" name="refFromId" value="{{youtube.id}}">
        <input type="submit"  value="Submit" class="video_refer_submit">
		</form>
		</div>
		</div>
        </div>
</div>
</div>
</div>
</div>

<script type="text/javascript">
//var app = angular.module('YoutubeListApp', []);


	
//angular.bootstrap(document.getElementById("YoutubeListApp"), ['YoutubeListApp']);



</script>



<script type="text/javascript">



$( "body" ).delegate( ".VideoRefrenceCheckButton", "click", function(event) {
	  
	    		var video_id=$(event.target).attr("data-value");
	    	 $('.video_ref_arrow').hide();
	    	 $('.video_ref_content').hide();
	    		$('.video_ref_loader').show();
	    		
	    		angular.element(document.getElementById('YoutubeListCtrl')).scope().refVideoResult=[];
	    		angular.element(document.getElementById('YoutubeListCtrl')).scope().$apply();
				console.log(video_id);
				$(this).siblings('.video_ref_arrow').stop(true, false, true).toggle();
				$(this).siblings('.video_ref_content').stop(true, false, true).slideToggle(300);
	    	$.ajax({
				 type: "GET",
	   		 url: "Fetch_Video_Ref",
	   		 dataType: "json",
	   		 cache: false,
	   		 data: {video_id:video_id,class_id:angular.element(document.getElementById('classDetailsCtrl')).scope().classId},
	   		         success: function(data){
	   		        	// console.log(data);
	   		       angular.element(document.getElementById('YoutubeListCtrl')).scope().refVideoResult=data;
	   	 angular.element(document.getElementById('YoutubeListCtrl')).scope().$apply();
	   	$('.video_ref_loader').hide();
	   		           
	   		         }, // end of success function
	   		 error: function(){
	   			 alert("fail");
	   		 }
				 
				 });  	
	    	return false; });














$( "body" ).delegate( ".delete_video", "click", function(event) {
    
	var videoId=$(event.target).attr("data-value");
	console.log(videoId);
	angular.element(event.target).parent().parent().parent().remove();
	
	 $.ajax({
		 type: "POST",
		 url: "Youtube_deleter",
		 cache: false,
		 data: {videoId:videoId},
		         success: function(msg){
		        	   
		         },
		 error: function(){
		 alert("failure");
		 }
		 
		 }); 

	
	
	return false; });
</script>


</body>
</html>