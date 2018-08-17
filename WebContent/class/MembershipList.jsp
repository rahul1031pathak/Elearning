<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=PT+Sans|Ubuntu" rel="stylesheet">
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
		.background:#fff;
	}
	div#membershipCtrl {
    display: flex;
    flex-direction:row;
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

..fadehover,#divID{
height:150px;
weight:180px;
overflow:hidden;
}

.profile-image{
height: 84px;
border-radius: 100px;
position: relative;
width: 48.56%;
background: transparent;
background-size: contain;
}
	*{
	margin:0;
	padding:0;
	}
	span.name,span.institute,span.date{
margin:0;
padding:0;
font-family:"PT sans",sans-serif;
text-align:center;
margin-top:15px;
color: #3C3C3C;
width: 88.44%;
margin-left: 3%;
	}
	.accept-reject{
		position:relative;
		display:flex;
		flex-direction: row;
	}
	
	.delete_this_member{
		font-family:"PT sans",sans-serif;
color:#2D7AC6;
border:none;
background:transparent;
width: 88.44%;
margin-left: 3%;
margin-top:25px;
font-weight:400;
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
		<!-- 	<span class="institute">{{member.institution}}</span>
			<span class="date">Date joined:{{member.DateTime}}</span> -->
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

//var app = angular.module('membershipApp', []);


//angular.bootstrap(document.getElementById("membershipApp"), ['membershipApp']);






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
    