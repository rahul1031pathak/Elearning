<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="structure.user.UserSearch"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


 <style>
.box{
    position:relative;
	min-width:550px;
    display:block;
	background-color:#e8e9ea; 
    width: 60%;
	color:#024388;
    height: 500px;
	margin:60px auto;
    box-shadow: 0 1px 4px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);  
}
.userdetail{
    position:relative;
	display:block;
	float:top;
	width:100%;
    height: 130px;
    background: red; /* For browsers that do not support gradients */        
    background: -webkit-linear-gradient(90deg, red, yellow); /* For Safari 5.1 to 6.0 */
    background: -o-linear-gradient(90deg, red, yellow); /* For Opera 11.1 to 12.0 */
    background: -moz-linear-gradient(90deg, red, yellow); /* For Firefox 3.6 to 15 */
    background: linear-gradient(90deg, #0665cb, #03356d); /* Standard syntax (must be last) */
           }
#profilephoto{
    position:relative;
    float:left;
	margin-left:45px;
	margin-top:40px;
             }	
.circle{
    position:relative;
    float:left;
    width:160px;
	height:160px;
	margin-left:-150px;
	margin-top:25px;
       }	
#uname{
       margin-left:20px;
	   margin-top: 70px;
	   font-size:45px;
	   color:white;
	   }
.college{width:100%;height:90px;float:top;}
.email{width:100%;height:60px;float:top;}
.follower{width:100%;height:60px;float:top;}	
.proof{width:100%;height:160px;float:top;} 
#institution{width:44px;margin-top:-20px;margin-left:10px;}
#instname{font-size:20px;margin-top:50px;margin-left:10px;}
#mail{width:38px;margin-left:200px;}
#mai{font-size:20px;margin-left:10px;}
#follow{width:44px;margin-left:200px;} 
#follo{font-size:20px;margin-left:10px;}
#id{width:44px;margin-left:200px;margin-top:-160px;}
#frame{margin-left:-190px;margin-top:-40px;}
#proofleimage{margin-left:30px;margin-top:-40px;}
#batch{margin-left:-60px;margin-top:40px;}
@media screen and (max-width: 920px) {
 .box{width:100%;margin-left:4px;margin-right:4px;}  
}



</style>
</head>
<body>




<div id="ViewProfileOfRquesteeApp" ng-app="ViewProfileOfRquesteeApp">
<div id="ViewProfileOfRquesteeCtrl" ng-controller="ViewProfileOfRquesteeCtrl">
<div class="box">
<div class="userdetail">
<img src="{{requestee.proof}}" class="img-circle" id="profilephoto"width="135px" height="135px" />
<img src="images/circle.png" class="circle"  >
<label id="uname">{{requestee.fullname}}</label>
</div>
<div class="college">
<img src="images/institution.png"  id="institution"/>
<label id="instname">{{requestee.institution}}</label>
</div> 
<div class="email">
<img src="images/mail.png"  id="mail">
<label id="mai">{{requestee.email}}</label>
</div>
<div class="follower">
<img src="images/follow.png"  id="follow">
<label id="follo">{{requestee.numberOfFollowers}}</label>
</div>
<div class="proof">
<img src="images/id.png"  id="id">
<img src="{{requestee.profilePic}}" id="proofleimage" width="150px" height="150px">
<img src="images/frame.png"  id="frame"width="220px" height="220px">
<img src="images/BATCH.png"  id="batch" width="44px"height="70px"/>

</div>
</div>


</div>
</div>





 <script type="text/javascript">
//function loadpeople(){
	
	
	
 var app = angular.module('ViewProfileOfRquesteeApp', []);
 app.controller('ViewProfileOfRquesteeCtrl', ['$scope','$http',
                               function ($scope, $http)  {
	 $scope.requestee=[];
	
	   $scope.loadProfileOfRequestee= function (senderid) {
	      
	        $http({
		        method : "GET",
		        url : "Fetch_User_Details",
		        params: {senderid:senderid}
		    }).then(function mySucces(response) {
		    	 $scope.requestee = response.data;
		    	// alert("success");
		    	 //console.log(response.data.notifications[0]); working fine
		    	//console.log(response.data);
		    	$("#viewProfileModal").modal('show');
		    	//console.log(angular.element(document.getElementById('ViewProfileOfRquesteeCtrl')).scope().requestee.fullname); 
		    		
		    }, function myError(response) {
		       alert(errror);
		    });
		  // alert("finish");
	    };
	   
	  
	   
	   
	   
	}]);
 angular.bootstrap(document.getElementById("ViewProfileOfRquesteeApp"), ['ViewProfileOfRquesteeApp']);
	
//}
 </script>














</body>
</html>