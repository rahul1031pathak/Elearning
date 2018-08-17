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
<link type="text/css" rel="stylesheet" href="..\\notification.css?version=125" />
  
    <title></title>

</head>
<body >
 
 <div id="NotificationApp" ng-app="myApp">
<div id="notificationContainerAngular" ng-controller="PeopleCtrl">




 <div ng-repeat="person in people">
 
 
 <div class="wrap">
	<div class="content-area">
	<img ng-src="{{person.generator_profile_pic}}" class="profileimg" onerror="this.src = 'image/Portrait_placeholder.png';">
		<p class="qa">{{person.notification_type}} </p>
		<a href="#"><img src="images/bookmark.png" class="bookmark" data-value={{person.notification_id}}></a>
		<ul class="ndc">
			<li>Name:{{person.generated_by_name}}</li>
			<li>Date:{{person.time}}</li>
			
		</ul>	
	</div>
	<div class="NotificationContent">
	 <div ng-if="person.is_pic == '1' ">
	<img class="img-responsive"   ng-src="https://datv3d2em9nfj.cloudfront.net/{{person.notification_content }}">
	</div>
	
	<div ng-if="person.is_pic == '0' ">
            {{person.notification_content }} 
    </div>
    
		</div>
		<div>
		<a href="#" class="ViewClass linkToVisit" data-id="{{person.class_id}}" >View this class</a>
			<button class="DeleteNotification" data-id="{{person.notification_id}}" data-value={{person.class_id}}>Delete</button>
		
		</div>
	</div>
 
 
 
 </div>
 
	</div>
	</div> 

<script type="text/javascript" src="studyfromweb_js/Studyfromweb_Notification.js?q=1555"></script>


</body>
</html>
