<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="structure.classroom.Dao_Answer"%>
    <%@page import="structure.classroom.Question"%>
        <%@page import="structure.user.UserList"%>
<!DOCTYPE html> 
<html lang="en">
<head>



<title>${requestScope.ques_content} - ${requestScope.CLASSNAME} - ${requestScope.CLASSADMINNAME} | StudyFromWeb</title>
<meta name="description" content="admin :${requestScope.CLASSADMINNAME},class :${requestScope.CLASSNAME} , details :${requestScope.DISCRIPTION}">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.0-beta.2/angular-sanitize.js"></script>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 
 <link href="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet"> 
<script src="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/GiveAnswer.css?version=173" type="text/css" >
<link rel="shortcut icon" href="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/short+logo+for+browser.gif"/>
<script src="https://cdn.ckeditor.com/4.6.2/full/ckeditor.js"></script>
 <script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>
 
 
</head>
<body>

<div id="fb-root"></div>
<script>
window.fbAsyncInit = function() {
    FB.init({
      appId      : '964796970330121',
      xfbml      : true,
      version    : 'v2.9'
    });
    FB.AppEvents.logPageView();
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));


//window.history.pushState("object or string", "${requestScope.CLASSNAME} - ${requestScope.CLASSADMINNAME} | StudyFromWeb", "class/${requestScope.ClassId}/${requestScope.CLASSADMINNAME}/${requestScope.CLASSNAME}");



</script>
<%@ include file="ClassDetailsForPage.jsp" %>
<%@ include file="loading.jsp" %>

<script type="text/javascript">





$(document).ready(function(){
	
	function isLogin() {
		var islogin='${sessionScope.ISLOGIN}';
		 if(!islogin==null&&islogin==false){
			 return false;
		 }else{
			 return true;
		 }
	}
	 $(".askquestion").hide();
	
	 $("#giveAnswer").click(function(){
		 if(isLogin()){
		 $("#ask_question_form").hide();
	    	$(".wrap").hide();
	    	$(".askquestion").show();
	    	$("#backToClassroom").hide();
		 }
		 else{
			 $('#LogInSignUp').modal('show');
		 }
	 });
	 
	 $("#giveAnswer").click(function(){
			
	    	$("#backToDiscussion").show();
	    	
	 });
	 $("#backToDiscussion").click(function(){
			
	    	$(this).hide();
	    	
	 });

	 $("#backToDiscussion").click(function(){
		
	    	$(".wrap").show();
	    	$(".askquestion").hide();
	    	$("#backToClassroom").show();
	 });
	 

});
</script>

<button id="backToDiscussion" style="background:none;border:0;display:none;"><img src="images/back.svg" class="go_back" width="20px" height="20px" ></button>
<div class="askquestion" >
<h3>Give Your Answer</h3>

<select id="mySelect" onchange="myFunction()" name="isPic">
<option value="0"><b>Written</b></option>
<option value="1">In Form of Image</option>
</select>
<form method="post" id="ask_question_form" class="ask_question_form"  enctype="multipart/form-data">
<input type="hidden" name="Ques_Id" id="answer_QuesId" ><br>
<input type="hidden" name="ClassId" id="answer_ClassId" ><br>
<input type="file" name="file-1[]" id="file-1" accept="image/*" class="inputfile inputfile-1"/>
<label for="file-1"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Choose a file&hellip;</span></label>
<input type="submit" value="Submit" >			
 </form> 
<form  id="question_in_text_form"   Class="ask_question_form"  >
<textarea name="answer" id="question"rows="13" placeholder="Write your answer here"></textarea><br>
<input type="submit" value="Submit" >	
		
</form> 
</div>


<%String name=(String)session.getAttribute("USERNAME"); %>



<div class="wrap" id="questionAnswerApp" ng-app="questionAnswer" >
<div id="questionquestionAnswerAngular" ng-controller="questionAnswerCtrl">
   
   <div class="second">
   <p class="questionHead">Question</p>
  <div class="question" >

<div class="answerCommon">
		<div class="AnswerHeaderr">
			<ul>
				<li style="font-size:12px;">Topic:{{question.topic}}</li>
				<li style="font-size:12px;">Subtopic:{{question.subtopic}}</li>
				<li style="font-size:12px;text-transform:capitalize;">Raised By:{{question.ques_raiser_name}}</li>
				<li style="font-size:12px;">Date:{{question.dateTime}}</li>
			</ul>
		</div>
		<div class="ArticleContent" style="min-height:150px;">
			<p ng-bind-html="question.qes_content" ></p>
		</div>
		<div class="ArticleButton">
		
		<div ng-if="question.qes_raiser == LoginUser  || ISCLASSADMIN == 'true' ||ISSUBADMIN == 'true' " >
		<a class="delete_question" data-value="{{question.ques_id}}" ><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/delete.svg" alt="delete">Delete</a>
		</div>
		<a ng-href="" data-value="{{question.ques_id}}" class="save_question"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/bookmark1.svg">Bookmark</a>
		<a  ng-click="fbQuestionShare(question.qes_content,question.ques_id)" ng-init=""class="shareQuestion"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/share.svg">Share</a>
		</div>
	</div>
	
	
	


</div>



<div class="answer">
<p class="answerHead">All Answers</p>
<div ng-if="answerList.length == '0' " class="no_solution">
No solution yet
</div>

<div ng-repeat="question in answerList| orderBy:'ans_id':true">





	<div class="answerCommon">
		<div class="AnswerHeaderr">
			<ul>
			<!-- 	<li style="font-size:10px;">Topic:{{question.topic}}</li>
				<li style="font-size:10px;">Subtopic:{{question.subtopic}}</li> -->
				<li style="font-size:12px;">Given By:{{question.answer_giver_name}}</li>
				<li style="font-size:12px;">Date:{{question.time}}</li>
			</ul>
		</div>
		<div class="ArticleContent" style="min-height:100px;">
			<p ng-bind-html="question.ans_content" ></p>
		</div>
		<div class="ArticleButton" ng-if="question.ans_giver == LoginUser  || ISCLASSADMIN == 'true' ||ISSUBADMIN == 'true' ">
		<a class="delete_answer" title="delete" data-value="{{question.ans_id}}" ><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/delete.svg" alt="delete">Delete</a>
		</div>
	</div>
	
	
	
	</div>
</div>
<div class="give_answer">
<button type="button" id="giveAnswer">Your Answer</button>
</div>
</div>
</div>
</div>







<script>

//function loadpeople(){
	
	
	
 var app = angular.module('questionAnswer', ['ngSanitize']);
 app.controller('questionAnswerCtrl', ['$scope','$http',
                               function ($scope, $http)  {
	   $scope.answerList = [];
	   $scope.question = [];
	   $scope.LoginUser = '${sessionScope.USERID}';
	   $scope.questionId='${requestScope.quesId}';
	   $scope.ISCLASSADMIN = '${requestScope.is_admin}';
	   $scope.ISSUBADMIN = '${requestScope.is_subAdmin}';
	   $scope.context='${pageContext.request.contextPath}';
   	   var data = {quesId: $scope.questionId};
   console.log(" $scope.ISCLASSADMIN"+ $scope.ISCLASSADMIN);
   console.log("  $scope.ISSUBADMIN"+  $scope.ISSUBADMIN+" $scope.context"+ $scope.context);
	   $http({
	        method : "POST",
	        url : "${pageContext.request.contextPath}/Fetch_AnswerListOfQuestion",
	        params: data
	    }).then(function mySucces(response) {
	    	
	    	 $scope.answerList = response.data.answerList;
	    	 $scope.question = response.data.question;
	  
	    		
	    }, function myError(response) {
	    	alert("fail");
	       // $scope.myWelcome = response.statusText;
	    });
	   
	   
	   
	   
	   
	   
	   $scope.appendHtml= function (append) {
		      console.log(append);
			   $(this).html(append);
		    };
		    
	   
	   $scope.loadQuestionAnswerList= function () {
	   
	   $http({
	        method : "POST",
	        url : "Fetch_AnswerListOfQuestion",
	        params: data
	    }).then(function mySucces(response) {
	    	
	    	 $scope.answerList = response.data.answerList;
	    	 $scope.question = response.data.question;
	  console.log(response.data); 
	    console.log(response.data.question);
	    		
	    }, function myError(response) {
	    	alert("fail");
	       // $scope.myWelcome = response.statusText;
	    });
	   
	   }
	   
	   
	   
	   
	   
	    $scope.fbQuestionShare= function (des,quesId) {
		     
		      var url='https://www.studyfromweb.com/AnswerFetcher?quesId='+quesId+'&ClassId='+angular.element(document.getElementById('classDetailsCtrl')).scope().classId;
console.log(url);
		  	
		  	var imageURL="datv3d2em9nfj.cloudfront.net/globe.png" ;
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

		    	var imageURL="https://datv3d2em9nfj.cloudfront.net/"+description;
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
		    
		    }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	}]);
 
 //angular.element(document).ready(function() {
angular.bootstrap(document.getElementById("questionAnswerApp"), ['questionAnswer']);
// angular.bootstrap(document.getElementById('questionApp'), ['question','questionAnswer']);
// });
//}
 </script>
<script>
       CKEDITOR.replace( 'question', {
	    toolbar: [			
 		{items: [ 'Bold', 'Italic', 'Underline'] },
		{ name: 'paragraph',items:['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'] },
 		{ name: 'links',items: [ 'Link'] },
		{ name: 'insert',items: [ 'Image','Table', 'HorizontalRule','SpecialChar'] }
	]
       });
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/studyfromweb_js/Studyfromweb_Answer.js?q=15555"></script>

   <%@ include file="fbShare.jsp" %>
  <script>
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
	 
  
  </script>

</body>
</html>