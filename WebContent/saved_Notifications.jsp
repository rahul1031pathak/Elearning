<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@page import="structure.classroom.Notifications "%>
     <%@page import="com.fasterxml.jackson.databind.ObjectMapper "%>
     <%@ page import="com.google.gson.*" %>
         
         
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <link type="text/css" rel="stylesheet" href="css/home/notification.css?version=918555" />
  <style>
  
  .removeNotification{
  text-decoration:none;
  color:#737579;
  }
  .savedlinkToVisit
  {
  text-decoration:none;
  color:#737579;
  padding-right:15px;
  }
  .savedlinkToVisit img,.removeNotification img{
  height:20px;
  width:20px;
 
  }
  
  </style>

</head>
<body >
 
 <div id="savedNotificationApp" >
<div id="savednotificationContainerAngular" >




 <div ng-repeat="person in saved_notifications_list">
 
 
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
	 <div ng-if="person.is_pic == '1' ">
	<img class="img-responsive"   ng-src="https://d1v0zurmr84n8z.cloudfront.net/{{person.notification_content }}">
	</div>
	
	<div ng-if="person.is_pic == '0' " ng-bind-html="person.notification_content " style="padding:10px">
           
    </div>
    
		</div>
		<div>
		<a href="class/{{person.class_id}}/{{getUrlfriendlyString(person.classAdmin)}}/{{getUrlfriendlyString(person.classname)}}" class="savedlinkToVisit" data-id="{{person.class_id}}" target="_blank"><img src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/view.png">View</a>
			<a class="removeNotification" data-id="{{person.notification_id}}" data-value="{{person.class_id}}"><img data-id="{{person.notification_id}}" data-value={{person.class_id}} src="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/delete+normal.png">Remove
		</a>
		</div>
	</div>
 
 
 
 </div>
 
	</div>
	</div> 


<script type="text/javascript" >


</script>
<script type="text/javascript" src="studyfromweb_js/savedNotifications.js?q=150"></script>

</body>
</html>
