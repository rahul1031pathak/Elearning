   

//$("#u3094-13").click(function(){
	function LOGIN() {
	var username = $("#widgetu3088_input").val();
//alert(username );
		 var password =  $("#widgetu3084_input").val();
		
		 // set cookies to expire in 14 days
		 $.cookie('loginemail', username, { expires: 1 });
		 $.cookie('loginpassword', password, { expires: 1 });
		 $.cookie('remember', true, { expires: 1 });
		
		 // reset cookies
		// $.cookie('loginemail', null);
		// $.cookie('loginpassword', null);
		// $.cookie('remember', null);
	
	var loginemail= $("#widgetu3088_input").val();
	var loginpassword= $("#widgetu3084_input").val();
	
	
	if(loginemail==null ||loginemail==""){
		//$("#widgetu3088_input").val("");
		//$("#widgetu3088_input").val(" email required");
		}
else if(loginpassword==null ||loginpassword==""){ //$("#widgetu3084_input").val("");

}
	else{
		
		 $('#spinner').show();
		$.ajax({
			 type: "POST",
   		 url: "LoginValidator",
   		 cache: false,
   		 data: {loginemail:loginemail,loginpassword:loginpassword},
   		         success: function(data){
				
   		        
   		        	 if(data.b=="false"){
   		        		
   		        		 $('#spinner').hide();
   		        		 alert("email or password incorrect");
   		        		 }
   		        	 if(data.b=="true"){
   		        		
   		        		// document.location.href="Home.jsp"
   		        		 $('#LogInSignUp').modal('hide');
   		        		location.reload(true);
						 $('#spinner').hide();
						}
   		        	 else if(data.b=="verify"){
   		        		//$("#widgetu3088_input").val("");
   		        		 $('#spinner').hide();
   		        		alert("please verify your email by clicking verification link sent by us to your email");
   		       
   		        	 }	}
   		         
		
		});
		}
	
//}); 
	}




// registration start





	// Calling Login Form
	//$("#u3051-13").click(function(){
	function SIGNUP() {	
		
		var email= $("#widgetu3052_input").val();
		var fullname= $("#widgetu3047_input").val();
		var password= $("#widgetu3056_input").val();
		var dummyPassword=  $("#widgetu3042_input").val();
		
		if ($.trim( fullname).length == 0) {
			alert("enter name");
		}

		else{	var sEmail = email;
		
		
	        if ($.trim(sEmail).length == 0) {
	        	//$("#widgetu3047_input").val();
	       alert("enter valid email");
	        }
	        else
	        	if(!validateEmail(sEmail)){
	        		alert("invalid email");
	        	}
	        	
	        	else {
	        	
	        	if(password!=dummyPassword){
	        	//	$("#widgetu3047_input").val('');
	        		alert('password is not same');
	        	
	        	}
	        	
	        	else{
	        		
	        		 $('#spinner').show();
	        	
	        	 $.ajax({
	   			  
	    			 type: "POST",
	        		 url: "Registeration",
	        		 cache: false,
	        		 data: {fullname:fullname,email:email,password:password},
	        		         success: function(msg){
	        		          
	        		        var b= msg;
	        		 //  	 var url=window.location.pathname ;
					//	 console.log(url);
					
							 $('#spinner').hide();
	        		        if(b=="true"){  alert("verification link has been sent please verify ");  		 $('#LogInSignUp').modal('hide');}
	        		        else {alert(" this email has already been registered  please try with other email") ;}
	        		         },
	        		 error: function(){
	        			 $('#spinner').hide();
	        		 alert("fail");
	        		 }
	    			 
	    			 }); 
	      
	        	}
	        }
	        }
		
	//});
	}

// registration end


// email verification start

function validateEmail(sEmail) {
    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if (filter.test(sEmail)) {
        return true;
    }
    else {
        return false;
    }
}
// email verification end


	
    	 