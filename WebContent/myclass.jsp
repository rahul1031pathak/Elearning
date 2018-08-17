<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="in.Elearning.java.Notice_In_Class"%>
  <%@ page import="com.google.gson.*" %>
<!DOCTYPE html>
<html>
<head>

<title> ${requestScope.CLASSADMINNAME} - ${requestScope.CLASSNAME} | StudyFromWeb</title>
<meta name="description" content="admin :${requestScope.CLASSADMINNAME},class :${requestScope.CLASSNAME} , details :${requestScope.DISCRIPTION}">
<meta name="keywords" content="study from web,${requestScope.CLASSADMINNAME} ${requestScope.CLASSNAME} studyfromweb" />
<link rel="shortcut icon" href="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/short+logo+for+browser.gif"/>
<base href="${pageContext.request.contextPath}/">
 
  
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>


	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
 <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-beta.2/angular-sanitize.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=PT+Sans|Ubuntu" rel="stylesheet">

<script src="js/jquery.cookie.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="js1/font-awesome.min.css" >
    <link rel="stylesheet" href="js1/font-awesome.css" >
<link type="text/css" rel="stylesheet" href="css/otherclass.css?version=7011212">
<link type="text/css" rel="stylesheet" href="css/tablayout.css?version=412525">
<script type="text/javascript" src="studyfromweb_js/myclassAbove.js?q=55111521355"></script>
<style>
td{border:none!important;}
tr{padding-left:0;}
.privacy_wrapper{
position:relative;
display:flex;
flex-direction:row;
width:100%
}
.privacy_description
{
position:relative;
display:flex;
flex-direction:column;
float:left;
width:250px;
justify-content:space-between;
background:#2874f0;
padding-bottom:20px;
}
.privacy_description p
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
.privacy_description img
{
  width:100px;
  height:100px;
  justify-content:center;
  margin:0px auto;
  
 
}
.privacy_form_wrapper{
			display:flex;
			justify-content: center;
			flex-direction: column;
			font-family:Roboto,sans-serif;
			width:calc(100% - 250px);
			padding-left:10px;
			padding-right:10px;
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
        #privacySettingForm{
        margin-top:70px;
        }
        #privacySettingForm label{
         padding-left:10px;
         font-family:"Roboto",sans-serif;
         font-weight:100;
         color:#333;
        }
        #p1{
        padding-left:10px;
        font-family:"Roboto",sans-serif;
        font-weight:100;
        color:#333;
        font-size:16px;
        }
@media screen and (max-width:550px)
{
.privacy_description{display:none;}
.privacy_form_wrapper{width:100%;}


}
</style>
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
<div data-flag="0" class="123"></div>
<%@ include file="loading.jsp" %>

<div id="dialogConfirmation" title="Confirmation Required">
  Are you sure about this?
</div>



<!-- model content for privacy setting-->
  <div class="modal fade" id="privacy" role="dialog">

   <div class="modal-dialog" id="mdialog" >
   <div class="modal-content">
		<div class="modal-body" style="padding:0;">
		<div class="privacy_wrapper">
		<div class="privacy_description">
		<p>You can change your privacy setting anytime.This will help you to restrict students to use some specific feature of your class</p>
  <img src="images/user.svg">
		</div>
		<div class="privacy_form_wrapper">
		<img src="images/letter-x.svg" class="close" data-dismiss="modal" width="12px" height="12px">
<form  id="privacySettingForm">
<p id="p1">Who can ask question in your class</p>
<table><tr><td><input id="Anyone_can_ask" name="questionPermission" type="radio" value="1">
<label for="Anyone_can_ask" class="css-label radGroup2">Subscribers</label></td><td>
<input id="MemberOfClass_can_ask" name="questionPermission" type="radio" value="0">
<label for="MemberOfClass_can_ask" class="css-label radGroup2">Members of class</label></td></tr></table><br>
<p id="p1">Who can write article your class</p>
<table><tr><td><input id="Anyone_can_view" name="viewingPermission" type="radio" value="1" >
<label for="Anyone_can_view" class="css-label radGroup2"> Subscribers</label></td><td>
<input id="MemberOfClass_can_view" name="viewingPermission" type="radio" value="0">
<label for="MemberOfClass_can_view" class="css-label radGroup2">Members of class</label></td></tr></table><br>
<p id="p1">Who can give answer in your class</p>
<table><tr><td><input id="Anyone_can_give" name="answerPermission" type="radio" value="1">
<label  for="Anyone_can_give" class="css-label radGroup2">Subscribers</label></td><td>
<input id="MemberOfClass_can_give" name="answerPermission" type="radio" value="0">
<label for="MemberOfClass_can_give" class="css-label radGroup2"> Members of class</label></td></tr></table><br>
    <button type="submit"  id="privacy_setting_Form_submit_button" data-dismiss="modal" class="submit">Submit</button> 
</form>
</div>
 </div>
 </div>

</div>
</div>
</div>
 
  <!-- Modal -->




  <!-- model content for notice feeding--> 
   <div class="modal fade" id="form-content" role="dialog">
  <div class="modal-dialog"  >
    <div class="modal-content feed_notice">
         
 
 <div class="modal-body" style="padding:0;">
 
 <div class="feed_notice_wrapper">
 <div class="feed_description">
 <p>You can drop your notice here so that members of this class will know about your future routine and plan.</p>
  <img src="images/megaphone.svg">
 </div>
 <div class="feed_form">
 <img src="images/letter-x.svg" class="close" data-dismiss="modal" width="12px" height="12px">
 <form class="contact"  id="feednoticeform">
 <textarea class="input-xlarge" id="notice_Submitted" rows="10" name="notice" placeholder="This notice will display in this classroom"></textarea>
<button type="submit"  id="Notice_submit_button">Submit</button>
</form>
</div>
 </div>
 </div>
 </div>
 </div>
 </div>
         <!-- Modal  notice feed-->
         
         
         
         
         
           <!-- Modal video sharing--> 
  <div id="ModalYoutubeVideo"  class="modal fade">
   <div class="modal-dialog" id="mdialog"  role="dialog">
   <div class="modal-content share_video_in_class">
        
		<div class="modal-body">
		
          <!--  <h2 class="modal-title">Your Video Details</h2>-->
          <div class="youtube_wrapper">
          <div class="youtube_description"><p>Please share relevant video related to this class so that other student could get it easily</p>
          <img src="images/youtube.svg">
          </div>
   
   <div class="youtube_form_wrapper" >
   <img src="images/letter-x.svg" class="close" data-dismiss="modal" width="12px" height="12px">
   <form action="#"  id="youtubevideoform"class="VideoShare">
    
	  <select id="PlaylistOrVideo">
	  <option value="0" selected>Video</option>
	    <option value="1">Playlist</option>
	 </select>
		<input type="text" name="" id="VideoIdValue" placeholder="Enter video or playlist url" required/>
		<input type="text" name="" id="Content_Of_Video" placeholder="Write about this video"> 
 
 </form>
 <button id="videoIdSubmit">Submit</button>
	</div> 		 
	</div>

 </div>
</div>
</div>
</div>
         
         
         
         
         


	<div id="headerapp" ng-app="headerapp">
<div id="headerappCtrl" ng-controller="headerappCtrl">
<div class="header">
 <%@ include file="header.jsp" %>

	</div>
	</div>
	</div>
	
	

<div class="centeerr">
		<ul class="dropDownMenu">
			
			<li><button id="ask_your_question_here">Ask Question</button></li>
			<li><button id="Write_your_Article">Write Article</button></li>
			<li><button id="uploadFile" data-toggle="modal" data-target="#uploadModal">Upload File</button></li>
			<li class="uploaded"><button id="uploaded">Uploaded File</button>
			
			<ul>
		<div id="fileUploaded" ng-app="fileUploaded">
<div id="fileuploadedList" ng-controller="fileuploadedList">

    <div ng-repeat="file in fileList">
   
           <li>   <div class="one_half last" data-id="{{$index}}"><a ng-href="https://d1v0zurmr84n8z.cloudfront.net/{{file.fileUploadedPath}}" target="_blank" class="FileDownloadingLink" data-id="{{file.fileUploadedId}}">{{file.fileUploadedName}}</a>
   <a ng-href="javascript:void(0);"   class="DeleteUploadedFile" data-value="{{file.fileUploadedId}}" ><span class="glyphicon glyphicon-trash cross DeleteUploadedFile" data-value="{{file.fileUploadedId}}"  ></span></a></div></li>
    </div>

			</div>
</div>
			</ul>
			
			
			</li>
			<li><button data-toggle="modal" data-target="#form-content" >Feed Notice</button></li>
			<li><button id="privacySettingButton"  data-toggle="modal" data-target="#privacy" >Privacy Setting</button></li>
			<li><button id="sharedYoutubeVideos"  data-toggle="modal" data-target="#ModalYoutubeVideo"> Youtube Tutorial </button></li>
            <li><button id="Delete_this_classroom">Delete Class</button></li>
			<li><button id="share_button">Share</button></li>
			
			<li id="manage"><button  id="manage1">Followers</button></li>
			<li class="transfer"><button id="transfer_button">Transfer Class</button>
			
			<div class="transfer_arrow"></div>
			<div   class="transfer_list">
			<form id="transferClassform">
			<input type="email"  name="newAdminEmail" placeholder="Email" required/>
			<input type="submit" id="newAdminSubmit" value="transfer" />
			</form>
			
			</div>
			</li>
			
			<li id="AddManagerModal"><button  id="add_manager">+Admin</button>
			<div class="add_manager_arrow"></div>
			<div   class="add_manager_list">
			<form id="SubAdminForm">
			<input type="email"  name="subAdminEmail" placeholder="Email" required/>
			<input type="submit" id="SubAdminSubmit" value="Add" />
			</form>
			
			</div>
			</li>
		
			
			
			
			<li  id="manager"><button >SubAdmins</button>
			
				
			<div class="manager_arrow"></div>
				
			<div   class="manager_list">
			<div id="subadminApp" ng-app="subadminApp">
            <div id="subadminCtrl" ng-controller="subadminCtrl">
		
		 <div ng-if="subAdmin_List.length == '0' " >
			<div class="manager_content">
			<div class="name_email">
			<p>No Subadmins</p>
			
			</div>
			</div>
		</div>
			<div ng-repeat="subadmin in subAdmin_List">
			<div class="manager_content">
			<div class="name_email">
			<p>{{subadmin.sub_admin_name}}</p>
			<p>{{subadmin.sub_admin_email}}</p>
			</div>
			
			<div ng-if="ISCLASSADMIN  == 'true' " >
			
			<button class="deleteSubAdminButton" data-value="{{subadmin.id_sub_admin}}" data-flag="{{subadmin.sub_admin_user_id}}"><img class="deleteSubAdminButton" data-value="{{subadmin.id_sub_admin}}" data-flag="{{subadmin.sub_admin_user_id}}"src="images/delete.svg" alt="delete"width="16px" height="16px"></button>
			
			</div>
			</div>
		    </div>
			
			</div>
			</div>
	        </div>
			</li> 
			
	
			
			
		</ul>
	</div>



<div class="main-wrapper">
	
	
	<div class="working-area">
 <div  id="switch_back_to_classContent">
	<div class="selectoption">
      <button class="scrollRadioButton selected"  data-value="0" >Question</button>
      <button class="scrollRadioButton" data-value="1" >Article</button>
      <button class="scrollRadioButton" data-value="2"  >Video</button>
    </div>
        <div class="selecteddivContent" id="CommonArea" data-flag="0"></div>
        <div class="selecteddivContent" id="include_Article" data-flag="0"></div>
        <div class="selecteddivContent" id="include_youtubelist" data-flag="0"></div>
    </div>    
        
        <div id="switch_to_followers">
        
        	<div class="selectoption">
      <button class="scrollRadioButton1" data-value="0" >Members</button>
      <button class="scrollRadioButton1" data-value="1" >Subscriber</button>
      <button class="scrollRadioButton1" data-value="2" >back</button>
    </div>
        <div class="selecteddivContent" id="Manage_Member_Ul" data-flag="0"></div>
        <div class="selecteddivContent" id="manage_subscriber_ul" data-flag="0"></div>
	
	
 </div>
 
 
 
 
  
</div>
		
	
	<div class="notification-area" id="fuck">
	<div id="noticesInClass" ng-app="noticesInClass">
<div ng-controller="noticesInClassCtrl">
	
	
		 <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
		<div class="notification1">
		<p class="p1">Notice</p>
		
         <div class="notificaton">
         <marquee behavior="scroll" direction="up"height="190px"scrollamount="4" onmouseover="this.stop();"onmouseout="this.start();">
         
       <div ng-if="noticeList.length=='0'">
        <span>&#x261B;</span>&nbsp; <p>No Updates</p>
         </div>
       <div ng-repeat="notice in noticeList">
		<span>&#x261B;</span>&nbsp;<p>{{notice.notice}},Date:{{notice.time}}</p>
		</div>
		</marquee>
    	</div>
    	
    	</div>
    	
   </div>
    </div>
    		
    	
			<ul class="classroom-detail">
				<p class="p2">Classroom Detail</p>
				<li>Class: <span style="color:#82132b;"> ${requestScope.CLASSNAME}</span></li>
				<li>Admin:<span style="color:#82132b;">  ${requestScope.CLASSADMINNAME}</span></li>
				<li>Number of members: <span style="color:#82132b;"> ${requestScope.number_of_members}</span></li>
				<li>Number of subscriber: <span style="color:#82132b;"> ${requestScope.number_of_subscribers}</span></li>
				<li>Classroom description:  <span style="color:#82132b;">${requestScope.DISCRIPTION}</span></li>
			</ul>
</div>
</div>

<%@ include file="AskQuestion1.jsp" %>


<div id="classDetailsApp" ng-app="classDetailsApp">
<div id="classDetailsCtrl" ng-controller="classDetailsCtrl">

</div>
</div>
<script>




</script>
<script type="text/javascript">


var app = angular.module('headerapp', []);

  app.controller('headerappCtrl', ['$scope','$http','$rootScope',
                                function ($scope, $http,$rootScope)  {
	  
	  
	  $scope.user=[];
	  $http({
	        method : "GET",
	        url : "Fetch_User_Details",
	       
	    }).then(function mySucces(response) {
	    	 $scope.user = response.data;
	    	console.log( $scope.user);
	    }, function myError(response) {
	       
	    });
	  
     }]);



	var app = angular.module('classDetailsApp', []);
	app.controller('classDetailsCtrl', function($scope, $http) {
		  $scope.classId = '${requestScope.ClassId}';
		   $scope.ISCLASSADMIN = '${requestScope.ISCLASSADMIN}';
		   $scope.ISSUBADMIN = '${requestScope.is_subAdmin}';
		   $scope.DISCRIPTION= '${requestScope.DISCRIPTION}';
		   $scope.CLASSNAME= '${requestScope.CLASSNAME}';
		   $scope.CLASSADMINNAME= '${requestScope.CLASSADMINNAME}';
		   $scope.contextPath='${pageContext.request.contextPath}/';
		   $scope.can_answer= '${requestScope.can_answer}';
		   $scope.can_question= '${requestScope.can_question}';
		   $scope.is_memberShipReqsent= '${requestScope.is_memberShipReqsent}';
		   $scope.can_view= '${requestScope.can_view}';
		   $scope.is_classMember= '${requestScope.is_classMember}';
		   $scope.is_subscriber= '${requestScope.is_subscriber}';
		console.log("$scope.contextPath"+$scope.contextPath);
		});

	angular.bootstrap(document.getElementById("classDetailsApp"), ['classDetailsApp']);



	
	
	
	

	var app = angular.module('subadminApp', []);
	app.controller('subadminCtrl', function($scope, $http) {
		 var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};
		$scope.subAdmin_List=[];
		 $scope.ISCLASSADMIN = '${requestScope.ISCLASSADMIN}';
		 $scope.ISSUBADMIN = '${requestScope.is_subAdmin}';
		 if(!$scope.ISCLASSADMIN && $scope.ISSUBADMIN ){
			 $("#AddManagerModal").hide();
		}
		$http({
	        method : "GET",
	        url : "Fetch_Sub_Admin",
	        params: data
	    }).then(function mySucces(response) {
	    	$scope.subAdmin_List = response.data;
	    	console.log( $scope.subAdmin_List);
	    }, function myError(response) {
	       
	    });
		
		
		 $scope.subAdminListReload=function(){
			 
			 $http({
			        method : "GET",
			        url : "Fetch_Sub_Admin",
			        params: data
			    }).then(function mySucces(response) {
			    	$scope.subAdmin_List = response.data;
			    	console.log( $scope.subAdmin_List);
			    }, function myError(response) {
			       
			    });
			 
		 }
		
		
		
		});

	angular.bootstrap(document.getElementById("subadminApp"), ['subadminApp']);
    </script>
 
    <%@ include file="fbShare.jsp" %>
    <script type="text/javascript" src="studyfromweb_js/Studyfromweb_Myclass.js?q=155555"></script>
</body>
</html>