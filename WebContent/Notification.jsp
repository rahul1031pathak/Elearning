<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@page import="structure.classroom.Notifications "%>
     <%@page import="com.fasterxml.jackson.databind.ObjectMapper "%>
     <%@ page import="com.google.gson.*" %>
         
         
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <script src="js/jquery.cookie.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="css/home/notification.css?version=132" />

</head>
<body >
 
 <div id="NotificationApp" >
<div id="notificationContainerAngular" >
<form class="search-container" action="">
  <input class="search-box header-search" ng-model="test" id="search-box" type="search" placeholder="search your timeline">
  <label class="search-icon-container" for="search-box">
    <span class="search-icon glyphicon glyphicon-search"></span>
  </label>
  <input class="search-btn" type="submit" title="Submit" value="search">
</form>



<div ng-if="people.length == '0' " style="display:flex;flex-direction:column;justify-content:center;background:#fff;padding-bottom:22%;margin:0px auto;">

<img class="img-responsive"  ng-src="https://d1v0zurmr84n8z.cloudfront.net/images/no-notificationlong.gif" height="100%" width="100%" style="margin-top:50px">
<a href="http://class25.businesscatalyst.com/home-assist.html" target="_blank" style="text-align:center;margin-top:20px;font-size:16px;font-family:"Roboto",sans-serif;">Click me to help you</a>
</div> 

 
 <div ng-repeat="person in people  | filter : test| orderBy:'notification_id':false">
 

 <div class="wrap">
	<div class="content-area">
	<img ng-src="{{person.generator_profile_pic}}" class="profileimg" onerror="this.src = 'image/Portrait_placeholder.png';">
		<p class="qa">{{person.notification_type}} </p>
		<ul class="ndc">
			<li>Name:{{person.generated_by_name}}</li>
			<li>Date:{{person.time}}</li>
			
		</ul>	
	</div>
	<div class="NotificationContent">
	
	
	<div  ng-bind-html="person.notification_content" style="padding:10px">
           
    </div>
    
		</div>
	
		<div style="border-top:1px solid #eee;padding-top:10px;">
		<a href="class/{{person.class_id}}/{{getUrlfriendlyString(person.classAdmin)}}/{{getUrlfriendlyString(person.classname)}}"  class="ViewClass linkToVisi" target="_blank" title="view" data-id="{{person.class_id}}" ><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/view.svg" alt="view">View</a>
		<a class="DeleteNotification" data-id="{{person.notification_id}}" data-value={{person.class_id}} title="delete"><img data-id="{{person.notification_id}}" data-value={{person.class_id}} src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/delete.svg" alt="delete">Delete</a>
		<button class="bookmark" data-value={{person.notification_id}}><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/bookmark1.svg" data-value={{person.notification_id}}>Bookmark</button>
		</div>
	</div>
 
 
 
 </div>
 
	</div>
	</div> 

<script type="text/javascript" src="studyfromweb_js/Studyfromweb_Notification.js?q=5555"></script>


</body>
</html>
