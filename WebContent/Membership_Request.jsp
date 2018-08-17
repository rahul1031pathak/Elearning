<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title></title>
<style>
.main-div{
		position:relative;
		width:100%;
		height:100%;
		display:flex;
		background:#eee;
		flex-direction:row;
		flex-wrap: wrap;
		font-family:"Roboto",sans-serif;
		padding-left:10px;
		}
	#MembershipRequestApp,#MembershipRequestCtrl{
	position:relative;
	display:flex;
	flex-wrap: wrap;
	flex-direction:row;
	}	
		
	.content{
		display:flex;
		flex-direction: column;
		background:#fff;
		width:180px;
		height:260px;
		text-align:center;
		color:black;
		margin-right:25px;
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
	 height:100%;	
     width:100%;
     overflow:hidden;
     object-fit:cover;
	 object-position: 100% 100%;
}
	p{
	margin:0;
	padding:0;
	}
	.name{
		font-size:16px;
		padding-bottom:2px;
		word-wrap: break-word;
		text-overflow: ellipsis;
	}
	.institute,.date,.classname{
		font-size:12px;
		padding-bottom:2px;
		color:#757676;
		text-overflow: ellipsis;
		word-wrap:break-word;
	}
	.accept-reject{
		position:relative;
		display:flex;
		flex-direction: row;
	}
	
	.AcceptingForMemberShipRequest,.RejectingForMemberShipRequest{
		height:25px;
		color:#fff;
		border:none;
		width:80px;
        background-color:#00b9f5;
        font-size:15px;
        display:flex;
        justify-content:center;
        margin:1px auto;
        box-shadow: 0 1px 4px rgba(0, 0, 0, .6);
		cursor:pointer;
	   }
</style>
</head>
<body>
<div class="main-div">
	<div id="MembershipRequestApp" >
<div id="MembershipRequestCtrl" >
<div ng-repeat="memberRequest in memberRequestList">
		<div class="content">
		<div class="fadehover"> 
		<div id="divID" ng-init="imgsrc=memberRequest.profile_pic" ng-mouseover="imgsrc=memberRequest.proof_pic" ng-mouseout="imgsrc=memberRequest.profile_pic">
		<img  class="profile-image" ng-src="{{imgsrc}}">
       </div>
       </div>
			<p class="name">Name:{{memberRequest.senderName}}</p>
			<p class="institute">Institute:{{memberRequest.institute}}</p>
			<p class="date">{{memberRequest.time}}</p>
			<p class="classname">For class:{{memberRequest.className}}</p>
			<div class="accept-reject">
			<button  class="AcceptingForMemberShipRequest" data-value={{memberRequest.member_req_id}}  >Accept</button>
			<button class="RejectingForMemberShipRequest" data-value={{memberRequest.member_req_id}} >Reject</button>
			</div>
			</div>
           </div>			
	</div>
	</div>
	</div>	
	
	
	<script type="text/javascript">
	

	// var app = angular.module('MembershipRequestApp', []);
	
	
	// angular.bootstrap(document.getElementById("MembershipRequestApp"), ['MembershipRequestApp']);
	</script>
	
	
	
	
			
</body>
</html>
