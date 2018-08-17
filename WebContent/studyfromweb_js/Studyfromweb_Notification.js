
	
	
// var app = angular.module('singlepage', ['ngSanitize']);

 //angular.bootstrap(document.getElementById("NotificationApp"), ['myApp']);
	
	
	
	
	
	
	// when user want to delete notification
    
    	 $( "body" ).delegate( ".DeleteNotification", "click", function(event) {
   
    	var NotificationId=$(event.target).attr("data-id");
    	var classId=$(event.target).attr("data-value");
    	angular.element(event.target).parent().parent().parent().remove();
   
    
    	$.ajax({
			 type: "POST",
   		 url: "Delete_Notification",
   		 dataType: "json",
   		 cache: false,
   		 data: {NotificationId:NotificationId,classId:classId},
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
    	$( "body" ).delegate( ".linkToVisit", "click", function(event) {
    		event.preventDefault();
   $('#spinner').show();
    	var ClassId=$(event.target).attr("data-id");
    	console.log(ClassId); 
    	$.ajax({
			 type: "GET",
   		 url: "Fetch_Class_Details",
   		 dataType: "json",
   		 cache: false,
   		 data: {ClassId:ClassId},
   		         success: function(data){
   		    console.log(data);
   		 var class_admin_name= data.CLASSADMINNAME
         .toLowerCase()
         .replace(/[^\w ]+/g,'')
         .replace(/ +/g,'-')
         ;
   		 var class_name= data.CLASSNAME
         .toLowerCase()
         .replace(/[^\w ]+/g,'')
         .replace(/ +/g,'-')
         ;
   		 
     		var url='class/'+ClassId+"/"+class_admin_name+"/"+class_name ;
     		
     		
     
     		var link= $("<a>").attr("href", url).attr("target", "_blank")[0];
     		  document.body.appendChild(link);
     		    link.setAttribute("type", "hidden");
     		   link.click();
     		//$(event.target).attr("href", url).attr("target", "_blank").click();
     		
     		   $('#spinner').hide();     		        
      	   	   
   		         }, // end of success function
   		 error: function(){
   		  $('#spinner').hide(); 
   			 alert("fail");
   		 }
			 
			 });
    	
	
    	return false; });
		
		
		
		
		
		
		// saving notifaction
	
    	 $( "body" ).delegate( ".bookmark", "click", function(event) {
    		 $('#spinner').show();
    	var NotificationId=$(event.target).attr("data-value");
console.log(NotificationId);
    	$.ajax({
			 type: "POST",
   		 url: "Save_Notification",
   		 dataType: "json",
   		 cache: false,
   		 data: {NotificationId:NotificationId},
   		         success: function(data){
   		       
   		     
   		        	if(data.b=="true"){
   		        		$('#spinner').hide();
   		        alert("saved");
   		        
   		        	} else{
   		        		$('#spinner').hide();
   		        	  alert("already saved");	
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
		
		
		
		
		
		
		
		
		
		
		
		