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
		background:#fff;
		width:180px;
		height:260px;
		text-align:center;
		color:black;
		margin-right:7px;
		margin-bottom:20px;
		overflow-y:auto;
		}
	.content::-webkit-scrollbar-track
{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	background-color: #F5F5F5;
}

.content::-webkit-scrollbar
{
	width: 6px;
	background-color: #F5F5F5;
}

.content::-webkit-scrollbar-thumb
{
	background-color: #b1b2b3;
}

	.profile-image{
	 max-height:150px;	
     height:100%;
     width:100%;
     object-fit:cover;
	 object-position: 100% 10%;
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
		font-size:16px;
		padding-bottom:2px;
		word-wrap: break-word;
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
		width:100px;
		height:25px;
		color:#fff;
		border:none;
		width:75px;
        background-color:#00b9f5;
        font-size:15px;
        display:flex;
        justify-content:center;
        margin:3px auto;
        box-shadow: 0 1px 4px rgba(0, 0, 0, .6);
		cursor:pointer;
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
			<p class="institute" style="font-size:12px">{{member.institution}}</p>
			<p class="date" style="font-size:12px">date joined:{{member.DateTime}}</p>
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

var app = angular.module('subscriberApp', []);
app.controller('subscriberCtrl',  ['$scope','$http',
                                   function ($scope, $http)  {
	   $scope.memberList = [];
	   $scope.ISCLASSADMIN = angular.element(document.getElementById('classDetailsCtrl')).scope().ISCLASSADMIN;
$scope.subscriberList= function () {
	   var classid='${param.ClassId}';  
	console.log(classid);
	   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};
	   $http({
	        method : "GET",
	        url : "Fetch_Subscriber_List",
	        params: data
	    }).then(function mySucces(response) {
	    	 $scope.memberList = response.data.userlist;
	    	
	    	 console.log(response.data.userlist);
	    }, function myError(response) {
	        $scope.myWelcome = response.statusText;
	    });
 

};





}]);

angular.bootstrap(document.getElementById("subscriberApp"), ['subscriberApp']);





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
    