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

	.memberlist{
		position:relative;
		max-width:100%;
		max-height:100%;
		display:flex;
		flex-direction: row;
		flex-wrap: wrap;
		font-family:Roboto,Tahoma;
		margin-left:7px;
		background:#fff;
	}
	div#membershipCtrl {
    display: flex;
    flex-direction:row;
                }
	.content{
		display:flex;
		flex-direction: column;
		background:#fff!important;
		width:180px;
		height:260px;
		text-align:center;
		color:black;
		margin-right:7px;
		margin-bottom:20px;
		overflow-y:auto;
		box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
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
.fadehover,#divID{
height:150px;
weight:180px;
overflow:hidden;
}

	.profile-image{
	 height:150px;	
	 overflow:hidden;
     width:100%;
     object-fit:cover;
	 object-position: 100% 100%;
}
	*{
	margin:0;
	padding:0;
	}
	span.name,span.institute,span.date{
	font-family:"Roboto",sans-serif;
	font-size:12px;
	line-height:1.2;
	}
	.accept-reject{
		position:relative;
		display:flex;
		flex-direction: row;
	}
	
	.delete_this_member{
		height:25px;
		color:#fff;
		border:none;
		width:75px;
        background-color:#00b9f5;
        font-size:15px;
        display:flex;
        font-family:"Roboto",sans-serif;
        justify-content:center;
        margin:3px auto;
        box-shadow: 0 1px 4px rgba(0, 0, 0, .6);
		cursor:pointer;
	}
	#MembershipApp,#MembershipCtrl{
	position:relative;
	display:flex;
	flex-wrap: wrap;
	flex-direction:row;
	}	
</style>


</head>

<body>

		 <div class="memberlist">
		 <div id="membershipApp" ng-app="membershipApp">
         <div id="membershipCtrl" ng-controller="membershipCtrl">
	     <div ng-repeat="member in memberList">
		<div class="content">
	    <div class="fadeover">
		
		<div id="divID"  ng-init="imgsrc=member.profilepic" ng-mouseover="imgsrc=member.proof" ng-mouseout="imgsrc=member.profilepic"> 
        <img  class="profile-image" ng-src="{{imgsrc}}">   
    
        </div>
       </div>
			<span class="name">{{member.fullname}}</span>
			<span class="institute">{{member.institution}}</span>
			<span class="date">Date joined:{{member.DateTime}}</span>
			 <div ng-if="ISCLASSADMIN == 'true' ">
			<div class="accept-reject">
			<button class="delete_this_member" data-value={{member.userId}}>Remove</button>
			</div>
			</div>
			</div>
			</div>
		    </div>			
		    </div>
		    </div>
		    	
		
		<script>

var app = angular.module('membershipApp', []);
app.controller('membershipCtrl',  ['$scope','$http',
                                   function ($scope, $http)  {
	   $scope.memberList = [];
	   $scope.ISCLASSADMIN = angular.element(document.getElementById('classDetailsCtrl')).scope().ISCLASSADMIN;
	   
$scope.memberShipList= function () {
	   
	   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};
	   $http({
	        method : "GET",
	        url : "Fetch_MembershipList",
	        params: data
	    }).then(function mySucces(response) {
	    	 $scope.memberList = response.data.userlist;
	    	
	    	 console.log(response.data.userlist);
	    }, function myError(response) {
	        $scope.myWelcome = response.statusText;
	    });
 

};




  
}]);

angular.bootstrap(document.getElementById("membershipApp"), ['membershipApp']);






$( "body" ).delegate( ".delete_this_member", "click", function(event) {
//  $('.DeleteUploadedFile').click(function(){
		var userId=$(event.target).attr("data-value");
		angular.element(event.target).parent().parent().parent().parent().remove();
		console.log(userId);
	$.ajax({
		 type: "POST",
	 url: "Delete_Membership",
	 dataType: "json",
	 cache: false,
	 data: {userId:userId,ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId},
	         success: function(data){
	     
	        	if(data.b=="true"){
	        		 angular.element(document.getElementById('membershipCtrl')).scope().memberShipList();
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
    