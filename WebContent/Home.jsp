<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home | StudyfromWeb</title>
<link rel="shortcut icon" href="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/short+logo+for+browser.gif"/>
<META Http-Equiv="Cache-Control" Content="no-cache">
<META Http-Equiv="Pragma" Content="no-cache">
<META Http-Equiv="Expires" Content="0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-beta.2/angular-sanitize.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
<script src="home_js/bootstrap.min.js"></script>
<link rel="stylesheet" href="home_js/bootstrap.min.css">
<link rel="stylesheet" href="home_js/bootstrap-theme.min.css">
<link rel="stylesheet" href="js1/font-awesome.min.css" >
<link rel="stylesheet" href="js1/font-awesome.css" >
<link rel="stylesheet" href="home_css/home.css?q=91132111">
<link rel="stylesheet" href="home_css/accordion.css?q=065045">
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
	
<script>
$(document).ready(function(){

	$("#smallScreenButton").click(function(e){
        e.stopPropagation();
         var flag=$(".123").data("flag");
 if (flag==0){       
           $(".verticla-nav").fadeIn(); 
            
       $(this).data("flag",1);
       $(".123").data("flag",1)
                 
        }
       else {
    	
               $(".verticla-nav").fadeOut();
               $(".123").data("flag",0);
            
       }
    });
     
    $(document).click(function (e)
  	      // $("html").on("click", "button:not('.slideNav')",function(e)
  	  {

  	    var container = $(".verticla-nav");
  	   if(e.target.id == "MobileDevicesWrapper" || $(e.target).parents("#MobileDevicesWrapper").size() ){
  		 
  	   }
  	    //alert(e.target.id == "accordian" || $(e.target).parents("#accordian").size());
  	  //  alert($(event.target).is('#accordian'));
  	   // alert( e.target.id == "accordian" || $(e.target).parents("#accordian").size());
  	    if(e.target.id == "accordian" || $(e.target).parents("#accordian").size() ){
  	  	 
  	    }
  	    else if(e.target.id == "headerrr" || $(e.target).parents("#headerrr").size()){}
  	    else{
  	    	 container.hide();
    	        $(".123").data("flag",0);
  	    }
  	    
  	});
    
});
</script>


<script>
$("document").ready(function(){
  $('.slideToggle').hover(function() {
   $(this).children('ul').stop(true, false, true).slideToggle(200);

});
    
       $("#spinner").bind("ajaxSend", function() {
            $(this).show();
        }).bind("ajaxStop", function() {
            $(this).hide();
        }).bind("ajaxError", function() {
            $(this).hide();
        });
     
       
    
});
</script>
  <style type="text/css">
  
  .spinner {
    position: fixed;
    top: 300px;
    left: 450px;
    margin-left: -80px; /* half width of the spinner gif */
    margin-top: -50px; /* half height of the spinner gif */
    text-align:center;
    z-index:1234;
    overflow: auto;
    width: 60%; /* width of the spinner gif */
    height: 60%; /*hight of the spinner gif +2px to fix IE8 issue */
}
  </style>
  
  
</head>
<body>

<div class="containerUserHome" id="userHomeDemo" ng-app="userHomeDemo">
<div id="userHomeDemoAngular" ng-controller="userHomeDemoCtrl">


<div id="spinner" class="spinner" style="display:none;">
    <img id="img-spinner"   style="height:80px; max-width:80px;background-color:#d2d2d2;" src="images/Loader.gif" alt="Loading"/>
</div>

<div data-flag="0" class="123"></div>
	<div id="includeHeader" class="header"> 

<%@ include file="header.jsp" %>
	</div>
	
 <div class="wrapper">
	 <div class="verticla-nav" id="verticla-nav" >
	
		<div class="navigation">
		
  <ul>
   <li class="has-sub home"><a href="#Notification" id="HomePage_Home_Button"><img class="nav-img"src="home_css/image_home/home1.svg" width="20px">HOME</a></li>
   
  
   	
    <li   ng-if="is_teacher == '1' " class="has-sub membership-request"> <a href="#Membership_Request" id="Membership_Loader"><img class="nav-img" src="home_css/image_home/membership1.svg">MEMBERSHIP REQUEST</a></li>
  
    
    <li class="has-sub create-class"> <button data-toggle="modal" href="#form-content" class="create_class_button"><img class="nav-img create_class_image" src="home_css/image_home/create1.svg">CREATE CLASSROOM</button></li>
  </ul>
</div>





<div id="accordian">
	<ul>
	<li class="slideToggle">
	
	
	
			<h3 class="created-class"><span></span><img class="nav-img" src="home_css/image_home/bookmark1.svg">MY BOOKMARKS</h3>
			<ul>
	
			
				<li><a href="#Saved_Notification"  class="" id="fetchSavedNotifications" >notifications</a></li>
				<li><a href="#Saved_Questions"  class="" id="fetchSavedquestion" >questions</a></li>
		
					
    
		  </ul>
				
		</li>
		
		
		
		
	<li class="slideToggle">
	<div  ng-if="is_teacher == '1' ">
		<h3 class="created-class"><span></span><img class="nav-img" src="home_css/image_home/my-classroom1.svg">MY CLASSROOM</h3>
			 </div>
			<ul>
				
			<div ng-repeat="Classroom in createdClassroomList ">
					<li><a ng-href="class/{{Classroom.Classroom_id}}/{{getUrlfriendlyString(user.fullname)}}/{{getUrlfriendlyString(Classroom.Classroom_Name)}}"  class="ClassLink" data-id="{{Classroom.Classroom_id}}" >{{Classroom.Classroom_Name}}</a></li>
					
    </div>
		  </ul>
			
		</li>
		
		
		
		
		<li class="slideToggle">
			<h3 class="subscription"><span></span><img class="nav-img" src="home_css/image_home/subscription1.svg">SUBSCRIPTION</h3>
			<ul>
			<div ng-if="subscribedList.length == '0' ">
					
				 <li><a ng-href="#"   data-id="" >No Class</a></li>	
					
    </div>
			
					<div ng-repeat="Classroom in subscribedList">
					<li><a ng-href="class/{{Classroom.ClassId}}/{{getUrlfriendlyString(Classroom.ClassAdminName)}}/{{getUrlfriendlyString(Classroom.ClassroomName)}}"  class="SubscribedClassroom" data-id="{{Classroom.ClassId}}" >{{Classroom.ClassroomName}}</a>
					
							<button  class="DeleteSubscribedClass"  data-value="{{Classroom.ClassId}}" ><img  data-value="{{Classroom.ClassId}}" class="cross"src="images/3.png"></button>
					
					</li>
					
</div>
			</ul>
		</li>
		<!-- we will keep this LI open by default -->
		
		
		
		
		
		
		<li class="slideToggle">
			<h3 class="class-joined"><span></span><img class="nav-img" src="home_css/image_home/joined1.svg">CLASS JOINED</h3>
			<ul>
					<div ng-if="alreadyMemberList.length == '0' ">
        <li><a ng-href="#"   data-id="" >No Class</a></li>
    </div>
							<div ng-repeat="Classroom in alreadyMemberList">
	<li><a ng-href="class/{{Classroom.ClassId}}/{{getUrlfriendlyString(Classroom.ClassAdminName)}}/{{getUrlfriendlyString(Classroom.ClassroomName)}}"  class="SubscribedClassroom" data-id="{{Classroom.ClassId}}" >{{Classroom.ClassroomName}}</a>
		<button  class="LeaveThisClassroom"  data-value="{{Classroom.ClassId}}" ><img  data-value="{{Classroom.ClassId}}" class="cross"src="images/3.png"></button>
					
					</li>
					        	
					
</div>
			</ul>
		</li>
		
	</ul>
</div>
</div>

</div>


<div class="notification-area" id="singlepage" >

	<p ng-bind="message" style="background:#fff;text-align:center;font-family:Roboto,Tahoma;font-size:16px;padding:8px;margin:0;border-bottom:1px solid #eeeeee;"></p>



<div ng-view></div>
	

</div>


</div>
</div>



<script type="text/javascript">


var app = angular.module('userHomeDemo', ["ngRoute",'ngSanitize']);

  app.controller('userHomeDemoCtrl', ['$scope','$http','$rootScope',
                                function ($scope, $http,$rootScope)  {
	  $rootScope.message = 'Notifications';
 	   $scope.user = [];
 	   $scope.subscribedList = [];
 	   $scope.memberRequestList = [];
 	   $scope.createdClassroomList = [];
 	  $scope.alreadyMemberList = [];
 	 $scope.is_teacher="0";
 	   $http({
 	        method : "GET",
 	        url : "Fetch_HomePageDetails"
 	    }).then(function mySucces(response) {
 	    	 $scope.alreadyMemberList=	response.data.alreadyMember;
 	    	 $scope.user = response.data.user;
 	    	 $scope.subscribedList = response.data.subscribed;
 	    	 $scope.memberRequestList  =response.data.memberRequest;
 	    	  $scope.createdClassroomList =response.data.createdClassroomList;
 	    	
 	    	  if($scope.createdClassroomList.length>0){
 	    		 $scope.is_teacher='1';
 	    	  }
 	    	  console.log($scope.is_teacher);
 	    	  
 	    }, function myError(response) {
 	         
 	    });
 	   
 	
 	  $scope.user=[];
	  $http({
	        method : "GET",
	        url : "Fetch_User_Details",
	       
	    }).then(function mySucces(response) {
	    	 $scope.user = response.data;
	    	
	    }, function myError(response) {
	       
	    });
	 
	  
	  
	  $scope.getUrlfriendlyString= function (string) {
	  
	    var newtext= string.replace(/<\/?[^>]+(>|$)/g, "-")
        .toLowerCase()
        .replace(/[^\w ]+/g,'')
        .replace(/ +/g,'-')
        ;
	//   console.log(newtext);
	    return newtext;
	    };
	   
	  
	  
 	   
 	  $scope.loadHomePageDetails= function () {
	       // alert("hiii" );
	       $http({
 	        method : "GET",
 	        url : "Fetch_HomePageDetails"
 	    }).then(function mySucces(response) {
 	    	 $scope.alreadyMemberList=	response.data.alreadyMember;
 	    	 $scope.user = response.data.user;
 	    	 $scope.subscribedList = response.data.subscribed;
 	    	 $scope.memberRequestList  =response.data.memberRequest;
 	    	  $scope.createdClassroomList =response.data.createdClassroomList;
 	    	 if($scope.createdClassroomList.length>0){
 	    		 $scope.is_teacher='1';
 	    	  }
 	  // $('#spinner').hide(1500);
 	    }, function myError(response) {
 	         
 	    });
		  // alert("finish");
	    };
	   
 	   
    
 	}]);
  
  
  app.config(function($routeProvider) {
	    $routeProvider
	    .when("/", {
	    	 templateUrl : "Notification.jsp",
	        	controller : "PeopleCtrl" 
	    })
	    .when("/Notification", {
	    
	    	 templateUrl : "Notification.jsp",
	        	controller : "PeopleCtrl"
	    })
	    .when("/Saved_Questions", {
	        templateUrl : "SavedQuestions.jsp",
	        controller : 'questionCtrl'
	    })
	    .when("/Membership_Request", {
	        templateUrl : "Membership_Request.jsp",
	        controller : 'MembershipRequestCtrl'
	    })
	    .when("/Saved_Notification", {
	    	
	        templateUrl : "saved_Notifications.jsp",
	        controller : 'savedPeopleCtrl'
	    });
	});


	app.controller('PeopleCtrl', ['$scope','$http','$rootScope',
	                              function ($scope, $http,$rootScope)  {
		   $scope.people = [];
		   $rootScope.message = 'Notifications';
		   $scope.Classid_In_Notifications=[]; 
		   $scope.uniqueClassid_In_Notifications=[]; 
		   $http({
		        method : "GET",
		        url : "Fetch_Notification"
		    }).then(function mySucces(response) {
		    	 $scope.people = response.data.notifications;
		    	 //console.log(response.data.notifications[0]); working fine
				  $('#spinner').hide(500);
		    	  
		    	// console.log(response.data.notifications); 
		    	//iterate through object keys
		    	 response.data.notifications.forEach(function(item) {
		    	   //get the value by class_id
		    	   var val = item.class_id;
		    	   //push the class_id string in the array
		    	   $scope.Classid_In_Notifications.push(val);
		    	 });
		    	
		    	 var a= $scope.Classid_In_Notifications;
		    	 var unique = a.filter(function(itm, i, a) {
		    		    return i ==  a.indexOf(itm);
		    		});
		    	 $scope.uniqueClassid_In_Notifications=unique;
		    	// console.log( $scope.uniqueClassid_In_Notifications); 
		    	 
		    	 
	 	    	 $scope.classList= [];
	 	    	 
	 	    	$.extend(true,$scope.classList,	$scope.subscribedList);
	 	    	$.extend(true,$scope.classList,	$scope.alreadyMemberList);
	 	    	
	 	    	 
	 	    	 $.each( $scope.uniqueClassid_In_Notifications, function(i) {
	 	    	 
		   var result = $.grep($scope.classList, function(e){ return e.ClassId==  $scope.uniqueClassid_In_Notifications[i]; });
		   
		   if (result.length == 0) {
			   var result = $.grep($scope.createdClassroomList, function(e){ return e.Classroom_id==  $scope.uniqueClassid_In_Notifications[i]; });
			
			   $.each( $scope.people, function(index) {

				  if(  $scope.people[index].class_id ==$scope.uniqueClassid_In_Notifications[i]){
					  $scope.people[index].classname=result[0].Classroom_Name;
					  //.toLowerCase() .replace(/[^\w ]+/g,'') .replace(/ +/g,'-');
					  $scope.people[index].classAdmin=$scope.user.fullname
				  }
				       
				 

				});
			   
			   
			 } else if (result.length == 1) {
			   // access the foo property using result[0].foo
			   
			     $.each( $scope.people, function(index) {

				  if(  $scope.people[index].class_id ==$scope.uniqueClassid_In_Notifications[i]){
					  $scope.people[index].classname=result[0].ClassroomName;
					  $scope.people[index].classAdmin=result[0].ClassAdminName;
				  }
			     });
			     
			 } else {
			   // multiple items found
			 }
	 	    	});
	 	    	// console.log( $scope.people);
		    }, function myError(response) {
		    	 //document.location.href='index.html'
		    	console.log(response.data);
		    });
		   
		   
		   
		   $scope.loadNotification= function () {
		       // alert("hiii" );
		       $rootScope.message = 'Notifications';
		        $http({
			        method : "GET",
			        url : "Fetch_Notification"
			    }).then(function mySucces(response) {
			    	 $scope.people = response.data.notifications;
			    	 
			       //	 console.log(response.data.notifications); 
				    	//iterate through object keys
				    	 response.data.notifications.forEach(function(item) {
				    	   //get the value by class_id
				    	   var val = item.class_id;
				    	   //push the class_id string in the array
				    	   $scope.Classid_In_Notifications.push(val);
				    	 });
				    	
				    	 var a= $scope.Classid_In_Notifications;
				    	 var unique = a.filter(function(itm, i, a) {
				    		    return i ==  a.indexOf(itm);
				    		});
				    	 $scope.uniqueClassid_In_Notifications=unique;
				    	 console.log( $scope.uniqueClassid_In_Notifications); 
				    	 
				    	 
			 	    	 $scope.classList= [];
			 	    	 
			 	    	$.extend(true,$scope.classList,	$scope.subscribedList);
			 	    	$.extend(true,$scope.classList,	$scope.alreadyMemberList);
			 	    	
			 	    	 
			 	    	 $.each( $scope.uniqueClassid_In_Notifications, function(i) {
			 	    	 
				   var result = $.grep($scope.classList, function(e){ return e.ClassId==  $scope.uniqueClassid_In_Notifications[i]; });
				   
				   if (result.length == 0) {
					   var result = $.grep($scope.createdClassroomList, function(e){ return e.Classroom_id==  $scope.uniqueClassid_In_Notifications[i]; });
					
					   $.each( $scope.people, function(index) {

						  if(  $scope.people[index].class_id ==$scope.uniqueClassid_In_Notifications[i]){
							  $scope.people[index].classname=result[0].Classroom_Name;
							  //.toLowerCase() .replace(/[^\w ]+/g,'') .replace(/ +/g,'-');
							  $scope.people[index].classAdmin=$scope.user.fullname
						  }
						       
						 

						});
					   
					   
					 } else if (result.length == 1) {
					   // access the foo property using result[0].foo
					   
					     $.each( $scope.people, function(index) {

						  if(  $scope.people[index].class_id ==$scope.uniqueClassid_In_Notifications[i]){
							  $scope.people[index].classname=result[0].ClassroomName;
							  $scope.people[index].classAdmin=result[0].ClassAdminName;
						  }
					     });
					     
					 } else {
					   // multiple items found
					 }
			 	    	});
			 	    	 console.log( $scope.people);
			    	 
			    		
			    }, function myError(response) {
			       alert(errror);
			    });
			  // alert("finish");
		    };
		   
		  
		   
		   
		   
		}]);







	app.controller('questionCtrl', ['$scope','$http','$rootScope',
	                                function ($scope, $http,$rootScope)  {
	  	   $scope.questionList = [];
	  	 $rootScope.message = 'Saved Questions';
	  	  console.log($rootScope.message );
	  	   $http({
	  	        method : "GET",
	  	        url : "Fetch_Saved_questions"
	  	    }).then(function mySucces(response) {
	  	    	console.log(response.data);
	  	    	 $scope.questionList = response.data;
	  	   		
	  	    }, function myError(response) {
	  	    	alert("fail");
	  	       // $scope.myWelcome = response.statusText;
	  	    });
	  	   
	  	  
	  	   
	  	   
	  	   
	  	}]);

	
	
	
	
	
	
	
	
	 app.controller('MembershipRequestCtrl',['$scope','$http','$rootScope',
			 function($scope, $http,$rootScope) {
		 $rootScope.message = 'Requests';
		   $scope.memberRequestList = [];
		   $http({
		        method : "GET",
		        url : "Fetch_MemberShip_Request"
		    }).then(function mySucces(response) {
		    	 $scope.memberRequestList = response.data;
		    	 console.log(response.data);
		    	 $('#spinner').hide();
		    }, function myError(response) {
		    	 $('#spinner').hide();
		    });
		}]);
	
	
	
	
	



	app.controller('savedPeopleCtrl', ['$scope','$http','$rootScope',
	                                   function ($scope, $http,$rootScope)  {
		 $rootScope.message = 'Saved Notifications';
	     	   $scope.saved_notifications_list = [];
	     	   $scope.saved_items = [];
	     	  $scope.message = 'Saved Notifications';
	     	 $scope.Classid_In_Notifications=[];
	     	$scope.uniqueClassid_In_Notifications=[];
	     	   $http({
	     	        method : "GET",
	     	        url : "Fetch_Saved_Notifications"
	     	    }).then(function mySucces(response) {
	     	    	 $scope.saved_notifications_list = response.data;
	     	    	
	     	    
	     	 	//iterate through object keys
		    	 response.data.forEach(function(item) {
		    	   //get the value by class_id
		    	   var val = item.class_id;
		    	   //push the class_id string in the array
		    	   $scope.Classid_In_Notifications.push(val);
		    	   
		    	 });
		    	
		    	 var a= $scope.Classid_In_Notifications;
		    	 var unique = a.filter(function(itm, i, a) {
		    		    return i ==  a.indexOf(itm);
		    		});
		    	 $scope.uniqueClassid_In_Notifications=unique;
		    	
		    	 
		    	 
	 	    	 $scope.classList= [];
	 	    	 
	 	    	$.extend(true,$scope.classList,	 $scope.subscribedList);
	 	    	$.extend(true,$scope.classList,	$scope.alreadyMemberList);
	 	    	
	 	    	 $.each( $scope.uniqueClassid_In_Notifications, function(i) {
	 	    	 
		   var result = $.grep($scope.classList, function(e){ return e.ClassId==  $scope.uniqueClassid_In_Notifications[i]; });
		//   console.log("result"+result.length+"$scope.uniqueClassid_In_Notifications[i]"+$scope.uniqueClassid_In_Notifications[i]);
		   if (result.length == 0) {
			   var result_new = $.grep($scope.createdClassroomList, function(e){ return e.Classroom_id==  $scope.uniqueClassid_In_Notifications[i]; });
			   
			  
			   if(result_new.length >0){
				   
			   $.each(   $scope.saved_notifications_list, function(index) {
				  
				  if(   $scope.saved_notifications_list[index].class_id ==$scope.uniqueClassid_In_Notifications[i]){
					  $scope.saved_notifications_list[index].classname=result_new[0].Classroom_Name;
					  //.toLowerCase() .replace(/[^\w ]+/g,'') .replace(/ +/g,'-');
					   $scope.saved_notifications_list[index].classAdmin=$scope.user.fullname
				  }
				       
				 

				});
			   }else{
				  
				   
				  
				   var a=$scope.saved_notifications_list ;
					 
					  a= a.filter(function(el) {
						    return  el.class_id !== $scope.uniqueClassid_In_Notifications[i];
						
				 // removed saved notification in which you are not currently member
				   });
					  $scope.saved_notifications_list=a;
				   }
			   
			 } else if (result.length >= 1) {
			   // access the foo property using result[0].foo
			   
			     $.each(   $scope.saved_notifications_list, function(index) {

				  if(   $scope.saved_notifications_list[index].class_id ==$scope.uniqueClassid_In_Notifications[i]){
					  $scope.saved_notifications_list[index].classname=result[0].ClassroomName;
					  $scope.saved_notifications_list[index].classAdmin=result[0].ClassAdminName;
					 
				  }
			     });
			     
			 } else {
			   // multiple items found
			 }
	 	    	});
	 	    	
	     	    		
	     	    }, function myError(response) {
	     	        $scope.myWelcome = response.statusText;
	     	    });
	     	   
	   	   
	     	}]);
	
	 // angular.bootstrap(document.getElementById('userHomeDemo'), ['userHomeDemo']);
</script>

	<%@ include file="modal.jsp" %>
	<script type="text/javascript" src="studyfromweb_js/Studyfromweb_UserHomeDemo.js?q=555555"></script>
	<script type="text/javascript">
	//$('#includeHeader').load('header.jsp');
	</script>
</body>
</html>
