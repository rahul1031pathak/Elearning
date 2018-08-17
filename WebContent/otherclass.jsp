<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="in.Elearning.java.Notice_In_Class"%>
  <%@ page import="com.google.gson.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
 
 <title> ${requestScope.CLASSADMINNAME} - ${requestScope.CLASSNAME} | StudyFromWeb</title>
<meta name="description" content="admin :${requestScope.CLASSADMINNAME},class :${requestScope.CLASSNAME} , details :${requestScope.DISCRIPTION}">
<meta name="keywords" content="study from web,${requestScope.CLASSADMINNAME} ${requestScope.CLASSNAME} studyfromweb" />

<link rel="shortcut icon" href="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/short+logo+for+browser.gif"/>
<base href="${pageContext.request.contextPath}/">
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="js/jquery.cookie.js"></script>

<link type="text/css" rel="stylesheet" href="otherclass1.css?version=081">
 <script type="text/javascript" src="studyfromweb_js/Studyfromweb_Otherclass.js?q=5555"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-beta.2/angular-sanitize.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>
  <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="js1/font-awesome.min.css" >
   <link rel="stylesheet" href="js1/font-awesome.css" >
   <link type="text/css" rel="stylesheet" href="css/tablayout.css?version=4255511555">

	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="js1/bootstrap-theme.min.css">


<script type="text/javascript">

$(document).ready(function(){
	 //$("#manage_Member").hide();
	
	
	 $("#manage").click(function(){
		// $('#CommonArea').hide();
			 $("#switch_back_to_classContent").hide();
		$('#switch_to_followers').show();
		$('#Manage_Member_Ul').show();
			//$('#include_youtubelist').hide();
		
		//	$('#include_Article').hide(); 
			
		 //$("#manage_Member").show();
		 //$("#mySelect").hide();
		 //$('#mySelectParagraph').text('MemberList');
		 angular.element(document.getElementById('membershipCtrl')).scope().memberShipList();
	    });
	 
	 
	  //  $(".slideNav").click(function(){
	   //     $(".center").slideToggle();
	  //  });
});
</script>

<script>
$(document).ready(function(){
	$("#other_manager").hover(function(){
		$(this).children('.other_manager_arrow').stop(true, false, true).toggle();
		$(this).children('.other_manager_list').slideToggle();
	});
});
</script>
<script>
$("document").ready(function(){
	  $('.uploaded').hover(function() {
	  	$(this).children('ul').stop(true, false, true).slideToggle(300);
	  });
	  	$(window).scroll(function () {
	       
	      if ($(window).scrollTop() > 80) {
	        $('.notification-area').addClass('navbar-fixed');
	      }
	      if ($(window).scrollTop() < 80) {
	        $('.notification-area').removeClass('navbar-fixed');
	      }
	    });
	  });

</script>
<script>
$(document).ready(function(){
    $(".rightNav").click(function(){
        $(".center").slideToggle();
    });
});
</script>


<script>
$(document).ready(function(){
	
	
    
    $("#smallScreenButton").click(function(e){
        e.stopPropagation();
        var flag=$(".123").data("flag");
    
        if (flag==0){
       
           $(".centeerr").fadeIn(); 
            
       $(this).data("flag",1);
       $(".123").data("flag",1)
          
            
        }
       else {
    	
               $(".centeerr").fadeOut();
               $(".123").data("flag",0);
            
       }
    });
    
    
    
    
    $(document).click(function (e)
    	      // $("html").on("click", "button:not('.slideNav')",function(e)
    	  {

    	    var container = $(".centeerr");
    	  var container1 = $(".slideNav");
    	  if(!$(event.target).is('.verticla-nav'))
    	  {
    		  container.hide();
   	        $(".123").data("flag",0);
   	       
    	  }
    	    
    	});
    
});
</script>

<script type="text/javascript">



function isLogin() {
	var islogin='${sessionScope.ISLOGIN}';
	 if(!islogin==null&&islogin==false){
		 return false;
	 }else{
		 return true;
	 }
}




$(document).ready(function(){
    $("#SendMembershipRequest").click(function(){
    	var islogin='${sessionScope.ISLOGIN}';
    	console.log(islogin);
    if(islogin){
   	 var can_view='${requestScope.can_view}';
   	 console.log(can_view); 
   	 var ClassId= angular.element(document.getElementById('classDetailsCtrl')).scope().classId;
   	 var CLASSADMINID= angular.element(document.getElementById('classDetailsCtrl')).scope().CLASSADMINID;
   	 var CLASSNAME= angular.element(document.getElementById('classDetailsCtrl')).scope().CLASSNAME;
   	 //console.log(ClassId); 
if(can_view){
   	 $.ajax({
			 type: "post",
   		 url: "MembershipRequest",
   		 dataType: "json",
   		 cache: false,
   		 data:{ClassId:ClassId,CLASSADMINID:CLASSADMINID,CLASSNAME:CLASSNAME},
   		         success: function(data){
   		        	 
   		        	 $("#membership_req_sent_after_sent").show();
   		    		 $("#MemberShipDiv").hide();

   		         },//end of success function
   		 error: function(){
   		 alert("fail");
   		 }
   		          }); 
}//end of if
else{
	
}
}
   	 else{
   		$('#LogInSignUp').modal('show');
		 }  	
   });
   
    });






  $(document).ready(function(){
    $("#subscribeButton").click(function(){
   	 if(<%=  session.getAttribute("ISLOGIN")%>){
   	 var can_view='${requestScope.can_view}';
	 var ClassId= angular.element(document.getElementById('classDetailsCtrl')).scope().classId;
if(can_view){
   	 $.ajax({
			 type: "POST",
   		 url: "Subriber",
   		 dataType: "json",
   		 cache: false,
   		 data:{ClassId:ClassId},
   		         success: function(data){
   		        	 
   		        	 $("#ButtonafterSubscribtion").show();
   		        	 $("#SubscriptionDiv").hide();
   		         
   		         },//end of success function
   		 error: function(){
   		 alert("fail");
   		 }
   		          }); 
}//end of if
else{
	
}
   	 } 	
   	 else{
   		$('#LogInSignUp').modal('show');
		 }
   });
   
    });





 




$(document).ready(function(){
	 
	
	 $("#ButtonafterSubscribtion").hide();
	 $("#membership_req_sent_after_sent").hide();
	
	 var is_classMember='${requestScope.is_classMember}';
	 var can_question='${requestScope.can_question}'; //working fine
	 var is_memberShipReqsent='${requestScope.is_memberShipReqsent}' ; 
	//alert( is_classMember); working fine
	 if(is_memberShipReqsent==true){
		// $("#SubscriptionDiv").hide();
		 
		 $("#MemberShipDiv").hide();
		 $("#membership_req_sent_after_sent").show();
	 }
	 
	 
	 else	 if(is_classMember==true){
		// alert("rahul");
		 $("#SubscriptionDiv").hide();
		 $("#membership_req_sent_after_sent").hide();
		
	 }else{
		 $("#MemberShipDiv").show();
		 $("#subscribedButton").hide();
		 
		 
	 }
	 
	 
$("#ask_your_question_here").click(function(){
	// $('#question_in_text_form')[0].reset();
	// $('#ask_question_form')[0].reset();
	tinyMCE.activeEditor.setContent("");
	tinyMCE.triggerSave();
	 if(<%=  session.getAttribute("ISLOGIN")%>){
	 if( can_question){
	 
		
		 $('#AskQuestionModal').modal('show');
   	
	 }
	 
	 else  if(is_classMember){
		 $('#AskQuestionModal').modal('show');
	 }
	 
	 else {alert("you have no permission only member is allowed");
	 
	 }
	 
	 }else{
		 $('#LogInSignUp').modal('show');
	 }
   });	 

$("#Write_your_Article").click(function(){
	 $('#article_in_pic')[0].reset();
	 $('#article_in_text')[0].reset();
	 tinyMCE.activeEditor.setContent("");
	 if(<%=  session.getAttribute("ISLOGIN")%>){
	 if( can_question){
	 
		
		 $('#WriteArticleModal').modal('show');
   	}
	 
	 else  if(is_classMember){
		 $('#WriteArticleModal').modal('show');
	 }
	 
	 else {alert("you have no permission only member is allowed");
	 
	 }
	 }
	 else{
		 $('#LogInSignUp').modal('show');
	 }
   });	 


	 
});
</script>
<script>
$("document").ready(function(){
	  $('.uploaded').hover(function() {
	  	$(this).children('ul').stop(true, false, true).slideToggle(300);
	  });
	  	$(window).scroll(function () {
	        //if you hard code, then use console
	        //.log to determine when you want the 
	        //nav bar to stick.  
	        //console.log($(window).scrollTop())
	      if ($(window).scrollTop() > 80) {
	        $('.notification-area').addClass('navbar-fixed');
	      }
	      if ($(window).scrollTop() < 80) {
	        $('.notification-area').removeClass('navbar-fixed');
	      }
	    });
	  });

</script>

 <style>
 .other_manager_list{
	 position:absolute;
	 display:none;
	 width:250px;
	 margin-left:-100px;
	 background:#fff;
	 padding:5px;
	 z-index:101;
	 box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
	 }
	
.other_manager_arrow{
  display:none;
  position:absolute;
  margin-left:40px;
  margin-top:-10px;
  width: 0; 
  height: 0; 
  z-index:101;
  border-left:10px solid transparent;
  border-right: 10px solid transparent;
  border-bottom: 10px solid #fff;
  }
  .other_name_email{
  z-index:101;
  text-align:left;
  border-bottom:1px solid #eee;
  padding-bottom:3px;
  }
  .other_name_email p:first-child
  {
  margin:0;
  padding:0;
  font-size:15px;
  color:#333;
  font-weight:500;
  font-family:"Roboto",sans-serif;
  }
  .other_name_email p:last-child
  {
margin:0;
padding:0;
font-size:12px;
color:#aaa8a8;
font-family:"Roboto",sans-serif;
  }
  
</style>


</head>
<body>
<div data-flag="0" class="123"></div>
<%@ include file="fbShare.jsp" %>

<%@ include file="loading.jsp" %>
<% String  is_subscriber=request.getParameter("is_subscriber"); %>



	<div id="headerapp" ng-app="headerapp">
<div id="headerappCtrl" ng-controller="headerappCtrl">
<div class="header">
 <%@ include file="header.jsp" %>

	</div>
	</div>
	</div>

<div class="center">
		<ul class="dropDownMenu">
		<li><button id="ButtonafterSubscribtion" >Subscribed</button></li>
		
        <li><button id="membership_req_sent_after_sent" >request sent</button></li>
        
       <li><div id="MemberShipDiv"> 
       
       <c:choose>
       
 <c:when test="${requestScope.is_classMember}">
               	<button  id="alreadyMember" >Member</button>
                  


    </c:when>
    <c:when test="${requestScope.is_memberShipReqsent}">
    <button  id="membership_req_sent" >Request sent</button>
                


    </c:when>
    
    <c:otherwise>
    <button  id="SendMembershipRequest"  >Send Request</button>
              


    </c:otherwise>
   

       </c:choose>
   </div></li>    
       
       
      <li> <div id="SubscriptionDiv">
         <c:choose>
        <c:when test="${requestScope.is_subscriber}">
         <button id="subscribedButton"  >Subscribed</button>
                 

 </c:when>
 <c:otherwise>
 <button id="subscribeButton"   >Subscribe</button>
             

 </c:otherwise>
   </c:choose>
     </div> </li> 
       
			<li><button id="ask_your_question_here">Ask Question</button></li>
			<li><button id="Write_your_Article">Write Article</button></li>
			
			<li class="uploaded"><button id="uploaded">Uploaded File</button>
				
			<ul>
	
	<div id="fileUploaded" ng-app="fileUploaded">
<div id="fileuploadedList" ng-controller="fileuploadedList">

    <div ng-repeat="file in fileList">
   
           <li>   <div class="one_half last"><a ng-href="https://d1v0zurmr84n8z.cloudfront.net/{{file.fileUploadedPath}}"  target="_blank" class="FileDownloadingLink" data-id="{{file.fileUploadedId}}">{{file.fileUploadedName}}</a></div></li>
    </div>
</div>
</div>
	
			</ul>
			</li>
		<li><button id="share_button">Share</button></li>
		<li><button  id="manage">followers</button></li>
			<li  id="other_manager">
			<button>SubAdmin</button>
			<div class="other_manager_arrow"></div>
			<div   class="other_manager_list">
			
			<div id="subadminApp" ng-app="subadminApp">
            <div id="subadminCtrl" ng-controller="subadminCtrl">
            
			 <div ng-if="subAdmin_List.length == '0' " >
		<div class="other_name_email">
			
			<p>No Subadmins</p>
			
			
			</div>
		</div>
			
			<div ng-repeat="subadmin in subAdmin_List">
			<div class="other_name_email">
			<p>{{subadmin.sub_admin_name}}</p>
			<p>{{subadmin.sub_admin_email}}</p>
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
      <button class="scrollRadioButton"  data-value="0" >Question</button>
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
         <marquee behavior="scroll" direction="up" scrollamount="4" height="190px" onmouseover="this.stop();"onmouseout="this.start();">
         
       <div ng-if="noticeList.length=='0'">
         <span>&#x261B;</span>&nbsp;<p>No Updates</p>
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
				<li>Class:  ${requestScope.CLASSNAME}</li>
				<li>Admin:  ${requestScope.CLASSADMINNAME}</li>
				<li>Number of members:  ${requestScope.number_of_members}</li>
				<li>Number of subscriber:  ${requestScope.number_of_subscribers}</li>
				<li>Classroom Discription:  ${requestScope.DISCRIPTION}</li>
			</ul>
	   
</div>

</div>



<div id="classDetailsApp" ng-app="classDetailsApp">
<div id="classDetailsCtrl" ng-controller="classDetailsCtrl">

</div>
</div>
<script>

var app = angular.module('classDetailsApp', []);
app.controller('classDetailsCtrl', function($scope, $http) {
	  $scope.classId = '${requestScope.ClassId}';
	   $scope.ISCLASSADMIN = '${requestScope.ISCLASSADMIN}';
	   $scope.ISSUBADMIN = '${requestScope.is_subAdmin}';
	   $scope.DISCRIPTION= '${requestScope.DISCRIPTION}';
	   $scope.can_answer= '${requestScope.can_answer}';
	   $scope.can_question= '${requestScope.can_question}';
	   $scope.is_memberShipReqsent= '${requestScope.is_memberShipReqsent}';
	   $scope.can_view= '${requestScope.can_view}';
	   $scope.is_classMember= '${requestScope.is_classMember}';
	   $scope.is_subscriber= '${requestScope.is_subscriber}';
	   $scope.CLASSNAME= '${requestScope.CLASSNAME}';
	   $scope.CLASSADMINNAME= '${requestScope.CLASSADMINNAME}';
	  
	});

angular.bootstrap(document.getElementById("classDetailsApp"), ['classDetailsApp']);

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



var app = angular.module('noticesInClass', []);
app.controller('noticesInClassCtrl', function($scope, $http) {
	   $scope.noticeList = [];
	   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};

	   $http({
	        method : "POST",
	        url : "Fetch_Notice_Of_Class",
	        params: data
	    }).then(function mySucces(response) {
	    	 $scope.noticeList  = response.data;
	    	
	    }, function myError(response) {
	       
	    });
	});

angular.bootstrap(document.getElementById("noticesInClass"), ['noticesInClass']);



var app = angular.module('fileUploaded', []);
app.controller('fileuploadedList', function($scope, $http) {
	   $scope.fileList = [];
  	   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};

	   $http({
	        method : "GET",
	        url : "Fetch_UploadedFiles",
	        params: data
	    }).then(function mySucces(response) {
	    	 $scope.fileList = response.data;
	    
	    }, function myError(response) {
	    	
	    });
	});


angular.bootstrap(document.getElementById("fileUploaded"), ['fileUploaded']);




var app = angular.module('subadminApp', []);
app.controller('subadminCtrl', function($scope, $http) {
	 var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};
	$scope.subAdmin_List=[];
	 $scope.ISCLASSADMIN = '${requestScope.is_classAdmin}';
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
<%@ include file="AskQuestion1.jsp" %>
<%@ include file="logSignup.jsp" %>
</body>
</html>