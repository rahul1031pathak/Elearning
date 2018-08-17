    
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="css/questionList.css?version=131">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script> 
$(document).ready(function(){
	
	$("body").delegate( ".refer_click", "click", function(event){

		$(event.target).parent().parent().children('.refer_arrow').stop(true, false, true).toggle();
		$(event.target).parent().parent().children('.refer_content').stop(true, false, true).slideToggle(300);
		$(event.target).parent().children('.refer_arrow').stop(true, false, true).toggle();
		$(event.target).parent().children('.refer_content').stop(true, false, true).slideToggle(300);
	});
});
</script>
<style>
	
</style>
</head>

<body>


<div  class="Question" id="questionApp" ng-app="question" >

<div id="questionAngular" ng-controller="questionCtrl">

<div class="wrapboth">

<input type="text" ng-model="test" class="header-search-input" placeholder="SEARCH THIS CLASSROOM">
<img src="images/search.svg" class="searchIcon" width="15px" height="15px">
</div>
 
    
  <div ng-if="questionList.length == '0' "   style="display:flex;flex-direction:column;justify-content:center;margin:0px auto;">

<img ng-src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/no_content/no+questions.png"  height="15%" width="15%" style="margin:40px auto">
<a href="http://class25.businesscatalyst.com/classroom-assist.html" target="_blank" style="text-align:center;margin-top:30px;margin-bottom:130px;font-size:16px;font-family:"Roboto",sans-serif;">Click Here To Know More</a>
</div>  


<div ng-repeat="question in questionList | filter : test" class="problem_creater">

<div class="answerCommon">
		<div class="AnswerHeaderr">
			<ul>
				<li style="font-size:10px;">Topic:{{question.topic}}</li>
				<li style="font-size:10px;">Subtopic:{{question.subtopic}}</li>
				<li style="font-size:10px;">Name:{{question.ques_raiser_name}}</li>
				<li style="font-size:10px;">Date:{{question.dateTime}}</li>
				<li style="font-size:10px;">ID:{{question.ques_id}}</li>
			</ul>
		</div>
		<div class="ArticleContent">
			<p ng-bind-html="question.qes_content" ></p>
		</div>
		
	</div>
	

	
	<div class="ArticleButton">
	
		<a ng-href="question/{{question.ques_id}}/{{getUrlfriendlyString(question.qes_content)}}"  target="_blank"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/view.svg" alt="view">View </a>
		<div ng-if="question.qes_raiser == LoginUser  || ISCLASSADMIN == 'true' ||ISSUBADMIN == 'true' "  >
		<button class="delete_question" data-value="{{question.ques_id}}" ><img data-value="{{question.ques_id}}" src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/delete.svg" alt="delete">Delete</button>
		</div>
		<button data-value="{{question.ques_id}}" class="save_question"><img data-value="{{question.ques_id}}" src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/bookmark1.svg">Bookmark</button>
		<a  ng-click="fbQuestionShare(question.qes_content,question.ques_id)" ng-init=""class="shareQuestion"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/share.svg">Share</a>
		<div class="ref_body" data-value="{{question.ques_id}}">
	<!-- 	<button class="RefrenceCheckButton" data-value="{{question.ques_id}}"><img  class="RefrenceCheckButton" data-value="{{question.ques_id}}" src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/eye.svg">Reference </button>   --> 
		<div class="ref_arrow"></div>
		<div class="ref_content">
 	<img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/balls.svg" class="ref_loader">   
		<div class="ref_table_content" >
			
		<table class="question_table">
		<tr></tr>
	<thead></thead>
		  <tr>
    <th>Question ID</th>
    <th>Name</th>
    <th>Date</th>
  </tr>
		 <tbody ng-repeat="refQues in refQuestResult.Ques_Ref_Ques_list">
	
 
   
   <tr>
    <th>{{refQues.ques_id_2}}</th>
    <th>{{refQues.name}}</th>
    <th>{{refQues.dateTime}}</th>
  </tr   >
  </tbody>
  
  </table>

  
  <table class="article_table">
   <tr>
    <th>Article ID {{rahul}}</th>
    <th>Name</th>
    <th>Date</th>
  </tr>
  <tbody ng-repeat="refarticle in refQuestResult.Ques_Ref_Article_list">
  <tr>
    <td>{{refarticle.article_id}}</td>
    <td>{{refarticle.name}}</td>
    <td>{{refarticle.dateTime}}</td>
  </tr>
</tbody>
  </table>
  
  
  <table class="video_table">
   <tr>
    <th>Video ID</th>
    <th>Name</th>
    <th>Date</th>
  </tr>
   <tbody ng-repeat="refvideo in refQuestResult.Ques_Ref_Video_list">
  <tr>
    <td>{{refvideo.video_id}}</td>
    <td>{{refvideo.name}}</td>
    <td>{{refvideo.dateTime}}</td>
  </tr>
  </tbody>
  </table>
		</div>
		</div>
		</div>
		
		<div class="refer_body">
	<!-- 	<button class="refer_click"><img ng-src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/add.svg" class="refer">Reference</button> -->
		<div class="refer_arrow"></div>
		<div class="refer_content">
		<form class="addRefrenceForm" ng-submit="FormSubmit($event)" onsubmit="event.returnValue = false; return false;" >
		<select class="refer_select" name="refrenceTO">
        <option value="question" >Question</option>
        <option value="article">Article</option>
        <option value="video">Video</option>
        </select>
        <input  type="number" min="0" step="1" name="refToId" placeholder="Enter ID" required /><br>
        <input type="hidden" name="refFromId" value="{{question.ques_id}}">
        <input type="submit"  value="Submit" class="refer_submit">
		</form>
		</div>
		</div>
	</div>
	</div>
	
	
</div>
</div>	
	
	
	
	
	
	
	
 
 <script type="text/javascript">
//function loadpeople(){
	
	
	
 var app = angular.module('question', ['ngSanitize']);
 app.controller('questionCtrl', ['$scope','$http',
                               function ($scope, $http)  {
	   $scope.questionList = [];
	   $scope.LoginUser = '${sessionScope.USERID}';
	   $scope.ISCLASSADMIN = '${requestScope.ISCLASSADMIN}';
		 $scope.ISSUBADMIN = '${requestScope.is_subAdmin}';
		  $scope.CLASSNAME=  angular.element(document.getElementById('classDetailsCtrl')).scope().CLASSNAME;
		   $scope.CLASSADMINNAME= angular.element(document.getElementById('classDetailsCtrl')).scope().CLASSADMINNAME;
		  
		   console.log(" $scope.CLASSNAME"+ $scope.CLASSNAME +$scope.LoginUser);
		   console.log(" $scope.CLASSADMINNAME"+ $scope.CLASSADMINNAME);
	   $scope.ClassId =	 angular.element(document.getElementById('classDetailsCtrl')).scope().classId;
	   $scope.rahul='';
	   $scope.refQuestResult=[];
	   $scope.loadQuestionList= function () {
	       // alert("hiii" );
	       	   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};

	       $http({
	        method : "GET",
	        url : "Fetch_QuestionList",
	        params: data
	    }).then(function mySucces(response) {
	    	
	    	 $scope.questionList = response.data;
	   		
	   		$('#spinner').hide();
	    }, function myError(response) {
	    	alert("fail");
	      
	    });
		  // alert("finish");
	    };
	   
	    
	    
		  $scope.getUrlfriendlyString= function (string) {
			  
			    var newtext= string.replace(/<\/?[^>]+(>|$)/g, "-")
		        .toLowerCase()
		        .replace(/[^\w ]+/g,'')
		        .replace(/ +/g,'-')
		        ;
			//   console.log(newtext);
			    return newtext;
			    };

	    $scope.FormSubmit=function(obj){
	    	   $('#spinner').show();
			
			var formdata= $(obj.target).serializeArray();
		  var userName=angular.element(document.getElementById('headerappCtrl')).scope().user.fullname;
				  
	formdata.push({name: 'class_id', value: angular.element(document.getElementById('classDetailsCtrl')).scope().classId});
			 formdata.push({name: 'refrenceFrom', value:'question'});
			 formdata.push({name: 'userName', value:userName});
		   $http({
				        method : "post",
				        url : "Refrence_Adder",
				       data: $.param(formdata),
				     // params:{ refrenceTO:'question'},
				      //   cache: false,
				    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
				    }).then(function mySucces(response) {
				    	  $('#spinner').hide();
				    	  $(obj.target).parent().hide();
				    	
				    }, function myError(response) {
				    	  $('#spinner').hide();
				    	
				    });
				   
	 		    return false;
	    };
	    
	    
	    
	    $scope.UpdateQuesRef=function(data){
	    	$scope.refQuestResult=data;
	    	console.log($scope.refQuestResult);
	    	console.log($scope.refQuestResult.Ques_Ref_Ques_list);
	    };
	    
		   $scope.appendHtml= function (append) {
		      console.log(append);
			   $(this).html(append);
		    };
	   
		    $scope.fbQuestionShare= function (des,quesId) {
			     
			      var url='https://www.studyfromweb.com/AnswerFetcher?quesId='+quesId+'&ClassId='+angular.element(document.getElementById('classDetailsCtrl')).scope().classId;
console.log(url);
			  	
			  	var imageURL="d1v0zurmr84n8z.cloudfront.net/globe.png" ;
			  		var strippedText = $("<div/>").html(des).text();
			  	var description="Question content : "+strippedText;
			  	
			 
			  	var caption="click here to visit this classroom"
			  	FB.ui(
			  	{
			  	method: 'feed',
			  	name: 'Welcome  to  www.studyfromweb.com',
			  	link: url,
			  	picture: imageURL,
			  	caption: caption,
			  	description: description,

			  	});
			    };
	   
	   
			    
			    
			    
			    
			    $scope.fbQuestionShareImage= function (description,quesId) {
				      var url='https://www.studyfromweb.com/AnswerFetcher?quesId='+quesId+'&ClassId='+angular.element(document.getElementById('classDetailsCtrl')).scope().classId;

			    	var imageURL="https://d1v0zurmr84n8z.cloudfront.net/"+description;
			    	var description='';
			    	var caption="click here to visit this classroom"
			    	FB.ui(
			    	{
			    	method: 'feed',
			    	name: 'Welcome  to  www.studyfromweb.com',
			    	link: url,
			    	picture: imageURL,
			    	caption: caption,
			    	description: description,

			    	});
			    
			    };
			    
			    
			
			    
	   
	}]);
 
 angular.bootstrap(document.getElementById("questionApp"), ['question']);
//}
 </script>


<script type="text/javascript">
    // question delete option clicked by admin
    $( "body" ).delegate( ".questionFetchingLink", "click", function() {
   // $('.questionFetchingLink').click(function(){
    	//var qes_id=this.id;
    	var qes_id=$(event.target).attr("data-id");

    	 $.ajax({
			 type: "GET",
    		 url: "AnswerFetcher",
    		 dataType: "json",
    		 cache: false,
    		 data: {qes_id:qes_id},
    		         success: function(data){
    		        	//console.log(data);
    		        	 if(data.is_admin=="true"){
    		        		// document.location.href='answer.jsp' 
    		        		// window.open("answer.jsp", '_blank');
    		        		 $('#details').load('answer.jsp');
    		        	 }else if (data.is_admin=="false"){
    		        		 document.location.href='answerNotAdmin.jsp'
    		        		 //window.open("answerNotAdmin.jsp", '_blank');
    		        	 }
    		         
    		         },
    		 error: function(){
    		  alert("fail");
    		 }
			 
			 }); 
    
    	
    	
    	return false; });
    
</script>

<script type="text/javascript">

 $( "body" ).delegate( ".delete_question", "click", function(event) {
//var qesId=question.getQues_id;
	 var quesId=$(event.target).attr("data-value");

	angular.element(event.target).parent().parent().parent().remove(); 

$.ajax({
type: "POST",
url: "Question_Deleter",
cache: false,
data: {quesId:quesId},
       success: function(data){
      	 if(data.b=="true"){
      		// document.location.href='myclass.jsp'
      		
      	 }
      	
       },
error: function(){

}

}); 



return false; });
 
 
 $( "body" ).delegate( ".save_question", "click", function(event) {
	//var qesId=question.getQues_id;
		 var quesId=$(event.target).attr("data-value");
		 console.log(quesId);
	$.ajax({
	type: "POST",
	url: "Save_Question",
	cache: false,
	data: {quesId:quesId},
	       success: function(data){
	      	 if(data.b=="true"){
	      		// document.location.href='myclass.jsp'
	      		 alert("done");
	      	 }
	      	
	       },
	error: function(){

	}

	}); 



	return false; });
 
 
 
 
 
 
 
 
 
 
 
 

 
 $( "body" ).delegate( ".RefrenceCheckButton", "click", function(event) {
	  
	    		var ques_id=$(event.target).attr("data-value");
	    	 	$('.ref_arrow').hide();
	    	 	$('.ref_content').hide();
	    		$('.ref_loader').show();
	    		angular.element(document.getElementById('questionAngular')).scope().refQuestResult=[];
	    		angular.element(document.getElementById('questionAngular')).scope().$apply();
				console.log(ques_id);
				$(this).siblings('.ref_arrow').stop(true, false, true).toggle();
				$(this).siblings('.ref_content').stop(true, false, true).slideToggle(300);
	    	$.ajax({
				 type: "GET",
	   		 url: "Fetch_Question_Ref",
	   		 dataType: "json",
	   		 cache: false,
	   		 data: {ques_id:ques_id,class_id:angular.element(document.getElementById('classDetailsCtrl')).scope().classId},
	   		         success: function(data){
	   		        	 console.log(data);
	   		         
	   		       angular.element(document.getElementById('questionAngular')).scope().refQuestResult=data;
	   	 angular.element(document.getElementById('questionAngular')).scope().$apply();
	   	$('.ref_loader').hide();
	   		           
	   		         }, // end of success function
	   		 error: function(){
	   			 alert("fail");
	   		 }
				 
				 });  	
	    	return false; });
 
 
 
 </script>			
</body>
</html>
