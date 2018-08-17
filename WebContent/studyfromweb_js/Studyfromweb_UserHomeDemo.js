  




////////////


  $( "body" ).delegate( ".viewProfileOfRequestee", "click", function(event) {
 	
    var senderid=$(event.target).attr("data-id");
  // alert(senderid);
  if(senderid!=null){
 $('#viewProfileModalBody').load('ViewProfile.jsp',"",function(){
	 angular.element(document.getElementById('ViewProfileOfRquesteeCtrl')).scope().loadProfileOfRequestee(senderid);
		
 });
  }else{
	  
  alert("wait");
  }
// 
    	// document.location.href='ViewProfile.jsp'
    //	angular.element(document.getElementById('ViewProfileOfRquesteeCtrl')).scope().loadProfileOfRequestee();
    
    	 
    	return false; });
	

	  $("#search").click(function(){
    	//var userid=${sessionScope.USERID} 
    	var TeacherName= $("#TeacherNameForSearch").val();
    	if(TeacherName==null ||TeacherName==""){ alert("plss enter Teacher Name");}
    	else{
    	
    		 $.ajax({
    			 type: "GET",
        		 url: "Search_Teacher_Classroom_By_Teacher_Name",
        		 cache: false,
        		 data:{ TeacherName :TeacherName },
        		         success: function(data){
        		        
        						

        		        
        		        	 
        		        	 document.location.href='ClassRoomListOfGivenTeacherName.jsp'
        		         
        		         },//end of success function
        		 error: function(){
        		 alert("fail");
        		 }
        		          }); 

    	
    	}
    });
	// search end
	
	
	
	//  accept membership request
	
	 $( "body" ).delegate( ".AcceptingForMemberShipRequest", "click", function(event) {
  //  $(".AcceptingForMemberShipRequest").click(function(){
    var membershipReqId=$(event.target).attr("data-value");
    	angular.element(event.target).parent().parent().remove();
    
    	var flag=1;
    		 $.ajax({
    			 type: "GET",
        		 url: "Response_to_request",
        		// dataType: "json",
        		// context: this,
        		// cache: false,
        		
        		 data:{ membershipReqId :membershipReqId, flag:flag},
        		         success: function(data){
        		        	// document.location.href='UserHome.jsp'

        		         },//end of success function
        		 error: function(data){
        			
        		 alert("fail");
        		 }
        		          }); 

    	
    	
    });
	
	//
	
	
 // reject memberRequest
  $( "body" ).delegate( ".RejectingForMemberShipRequest", "click", function(event) {
    
    	var membershipReqId=$(event.target).attr("data-value");
    	angular.element(event.target).parent().parent().remove();
    	//alert(membershipReqId); 
    	
    	var flag=0;
    		 $.ajax({
    			 type: "GET",
        		 url: "Response_to_request",
        		 dataType: "json",
        		 cache: false,
        		
        		 data:{ membershipReqId :membershipReqId, flag:flag },
        		         success: function(data){
        		        	// console.log(data);
        		        
        		        	//alert("success");
        		         },//end of success function
        		 error: function(){
        		 alert("fail");
        		 }
        		          }); 

    	
    	
    }); 
	
	// reject memberRequest end
	
	
	
	// create classroom
	  $("#submit").click(function(){
    	  $('#spinner').show();
    	var classname= $("#Classname").val();
    	var aboutclassroom=$("#aboutclassroom").val().trim();
    	if(classname==null ||classname==""||$("#aboutclassroom").val().trim().length<=0){ alert("all fields are mandatory"); $('#spinner').hide(); }
    	else{
    	
    		 $.ajax({
    			 type: "post",
        		 url: "Create_ClassRoom",
        		 dataType: "json",
        		 cache: false,
        		 data:{ ClassName:classname,about_classroom:aboutclassroom},
        		         success: function(data){
        		        	console.log(data);
        		        	 if(data.b=="true"){  
        		        		
        		        		 $("#form-content").modal('hide');        		        		
        		        		 angular.element(document.getElementById('userHomeDemoAngular')).scope().loadHomePageDetails();
        		        		 $('#spinner').hide();
        		        		
        		        		 $('# createclassroomform')[0].reset();
        		        	 }//end of if
        		        	 
        		        	 else{alert("you have already created classroom with this name     please try with some other name ") 
        		        		 $('#spinner').hide();
 $("#form-content").modal('hide'); 
 $('# createclassroomform')[0].reset();
        		        		  
        		        	 }
        		         
        		         },//end of success function
        		 error: function(){
        		 alert("fail");  $("#form-content").modal('hide');  $('#spinner').hide(); $('# createclassroomform')[0].reset();
        		 }
        		          }); 

    	
    	}
		return false;
    });
	
	// create classroom end
	
	
	
	
	
	
	


    // when user want to leave subscribed classroom  
    $( "body" ).delegate( ".DeleteSubscribedClass", "click", function(event) {
		
angular.element(event.target).parent().parent().remove();
 $('#spinner').show();
    	var ClassId=$(event.target).attr("data-value");;
  
    	$.ajax({
			 type: "POST",
   		 url: "Delete_Subscription",
   		 dataType: "json",
   		 cache: false,
   		 data: {ClassId:ClassId},
   		         success: function(data){
   		      //   alert(data.is_classAdmin); working fine
   		      console.log(data);
   		        	if(data.b=="true"){
   		        		$('#spinner').hide();
   		        		//alert(index);
   		        		//document.location.href='UserHome.jsp'
   		        	}
      		        	  
      		        	  
      		          
   		        	          
   		         }, // end of success function
   		 error: function(){
   			$('#spinner').hide();
   			 alert("Some thing went wrong");
   		 }
			 
			 });  	
    	
    });
       		        


    // when user want to leave subscribed classroom  
        $( "body" ).delegate( ".LeaveThisClassroom", "click", function(event) {
			
angular.element(event.target).parent().parent().remove();
 $('#spinner').show();
    	var ClassId=$(event.target).attr("data-value");;
    // alert(ClassId);
    	
    	$.ajax({
			 type: "POST",
   		 url: "Delete_Membership",
   		 dataType: "json",
   		 cache: false,
   		 data: {ClassId:ClassId},
   		         success: function(data){
   		      //   alert(data.is_classAdmin); working fine
   		        	 $('#spinner').hide();
   		        	if(data.b=="true"){
   		        	 $('#spinner').hide();
   		        		 //alert(data.id);
   		        		//var id="liLeaveThisClassroom"+data.id;
    		        	// document.getElementById(id).remove();
   		        		//document.location.href='UserHome.jsp'
   		        	}
      		        	  
      		        	  
      		          
   		        	          
   		         }, // end of success function
   		 error: function(){
   			 $('#spinner').hide();
   			 alert("fail");
   		 }
			 
			 });  	
    
    });  	
    
		
	