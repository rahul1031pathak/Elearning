// when user want to delete notification
    
    	 $( "body" ).delegate( ".removeNotification", "click", function(event) {
   
    	var NotificationId=$(event.target).attr("data-id");
    	var flag="notification";
    	angular.element(event.target).parent().parent().remove();
   
    
    	$.ajax({
			 type: "POST",
   		 url: "Delete_Saved_Items",
   		 dataType: "json",
   		 cache: false,
   		 data: {NotificationId:NotificationId,flag:flag},
   		         success: function(data){
   		      
   		     
   		        	if(data.b=="true"){
   		        	
   		        	//angular.element(document.getElementById('notificationContainerAngular')).scope().loadNotification();    working very great
   		        	
   		        	
   		        	}
      		        	  
      		        	  
      		          
   		        	          
   		         }, // end of success function
   		 error: function(){
   			 alert("fail");
   		
   		//angular.element(document.getElementById('notificationContainerAngular')).scope().loadNotification();
   			//  alternative     var scope=angular.element(document.getElementById('notificationContainerAngular')).scope();
   			//scope.$apply(function () {
   			//    scope.loadNotification();
   			//    });
   		
   			
   		 }
			 
			 });  
    	
    	return false; });
		
		
		
		
		
		
		
		
		
		
		// when user clickon class link
     //$(document).ready(function(){
    	$( "body" ).delegate( ".savedlinkToVisit888", "click", function(event) {
			
   $('#spinner').show();
    	var ClassId=$(event.target).attr("data-id");
    	//alert(ClassId); 
    	$.ajax({
			 type: "GET",
   		 url: "Check_Class_Privacy",
   		 dataType: "json",
   		 cache: false,
   		 data: {ClassId:ClassId},
   		         success: function(data){
   		      //   alert(data.is_classAdmin); working fine
   		   
   		        	if(data.is_classAdmin=="true"){
     		        	  
     		        	  
      		        	 $.ajax({
      	   		 			 type: "POST",
      	   		     		 url: "MyclassroomFetcher",
      	   		     		 cache: false,
      	   		     		 data: {ClassId:ClassId},
      	   		     		         success: function(msg){
      	   		     		          
      	   		     		        var b= msg;
      	   		     		        
      	   		     		        if(b=="true"){  document.location.href='myclass.jsp'}
      	   		     		        
      	   		     		         },
      	   		     		 error: function(){
      	   		     		 
      	   		     		 }
      	   		 			 
      	   		 			 }); 
      		        	  
      		        	  
      		          }
      		        
   		      
   		   
   		      
   		        	else if(data.can_view=="true"){
						
      		        	 $.ajax({
      		 			 type: "POST",
      		     		 url: "MyclassroomFetcher",
      		     		 cache: false,
      		     		 data: {ClassId:ClassId},
      		     		         success: function(msg){
      		     		          
      		     		     
      		     		        if(msg.b=="true"){  document.location.href='otherclass.jsp'}
      		     		        
      		     		         },
      		     		 error: function(){
      		     		 
      		     		 }
      		 			 
      		 			 }); 
      		        	  
      		        	  
      		          }
   		        	else{alert("you donot have permission ")}
      		       
   		        
   		         }, // end of success function
   		 error: function(){
   			 alert("fail");
   		 }
			 
			 });
    	
	
    	return false; });
		
		
		
		
		
		//var app = angular.module('savedmyApp', ['ngSanitize']);

//angular.bootstrap(document.getElementById("savedNotificationApp"), ['savedmyApp']);
		