<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

<title></title>
<style>
	
	.main-div{
		position:relative;
		max-width:100%;
		max-height:100%;
		display:flex;
		flex-direction: row;
		flex-wrap: wrap;
		font-family:Roboto,Tahoma;
		margin-left:7px;
	}
	.content{
		display:flex;
		flex-direction: column;
		background:#fff!important;
		width:173px;
		height:208px;
		text-align:center;
		color:black;
	    padding-top: 20px;
        padding-bottom: 13px;
		overflow-y:none;
		margin-right:10px;
		box-shadow: 0px 0px 2px rgba(0,0,0,0.17);
		}

	.profile-image{
	 height: 84px;
border-radius: 100px;
position: relative;
width: 48.56%;
background: transparent;
background-size: contain;
}
	.profile-image-hover{
	 display:none;
		z-index:10;
	 max-height:150px;	
     height:100%;
     width:100%;
     object-fit:cover;
	 object-position: 100% 10%;
		
	}
	
	p{
	margin:0;
	}
	.name{
		margin:0;
padding:0;
font-family:"PT sans",sans-serif;
text-align:center;
margin-top:15px;
color: #3C3C3C;
width: 88.44%;
margin-left: 3%;
	}
	.institute,.date{
		font-size:12px;
		padding-bottom:2px;
		color:#757676;
		word-wrap:break-word;
	}
	.accept-reject{
		position:relative;
		display:flex;
		flex-direction: row;
	}
	
	.accept,.reject,.delete_this_subscriber{
		font-family:"PT sans",sans-serif;
color:#2D7AC6;
border:none;
background:transparent;
width: 88.44%;
margin-left: 3%;
margin-top:25px;
font-weight:400;
	}

	
	

	@media screen and (max-width: 480px) {
     .main-div{
       margin-left:20px;
    }
}
</style>


</head>

<body>
<div id="subscriberApp" ng-app="subscriberApp">
		<div id="subscriberCtrl" ng-controller="subscriberCtrl">
		 
		 
		
	<div class="main-div">
	 <div class="main-div" ng-repeat="member in memberList">
		<div class="content">
	<div class="fadeover">
		<div id="divID"  ng-init="imgsrc=member.profilepic" ng-mouseover="imgsrc=member.proof" ng-mouseout="imgsrc=member.profilepic"> 
<img  class="profile-image" ng-src="{{imgsrc}}">        </div>
</div>
			<p class="name" style="font-size:12px">{{member.fullname}}</p>
		<!--  	<p class="institute" style="font-size:12px">{{member.institution}}</p>
			<p class="date" style="font-size:12px">date joined:{{member.DateTime}}</p> -->
			 <div ng-if="ISCLASSADMIN == 'true' ">
			<div class="accept-reject">
			<button class="delete_this_subscriber" data-value={{member.userId}}>remove</button>
			</div>
			</div>
				</div>
			</div>
		
			
		
	</div>			
		</div></div></div>	
		
		<script>

//var app = angular.module('subscriberApp', []);


//angular.bootstrap(document.getElementById("subscriberApp"), ['subscriberApp']);





$( "body" ).delegate( ".delete_this_subscriber", "click", function(event) {
//  $('.DeleteUploadedFile').click(function(){
		var userId=$(event.target).attr("data-value");
		angular.element(event.target).parent().parent().parent().parent().remove();
		console.log(userId);
	$.ajax({
		 type: "POST",
	 url: "Delete_Subscription",
	 dataType: "json",
	 cache: false,
	 data: {userId:userId,ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId},
	         success: function(data){
	     
	        	if(data.b=="true"){
	        		 angular.element(document.getElementById('subscriberCtrl')).scope().subscriberList();
	        	}
		        	  
		        	  
		          
	        	          
	         }, // end of success function
	 error: function(){
		 alert("fail");
	 }
		 
		 });  	
	return false; });


</script>	
</body>
</html>
    