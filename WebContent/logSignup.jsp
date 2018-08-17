<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
   <link rel="stylesheet" href="js1/font-awesome.min.css" >
  <link rel="stylesheet" href="js1/font-awesome.css" >
  <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
  <style>
	 
	  
	  
	  body,html{
		-webkit-font-smoothing: antialiased;
		margin:0;
		padding:0;
	    }
	.LogSign{
			-webkit-border-radius: 0px;
            -moz-border-radius: 0px;
            border-radius: 0px; 
		    background:#f3f3f3;
		    position:relative;
		    max-width:500px;
		    width:100%;
		    box-shadow: 0px 1px 4px rgba(0,0,0,0.24);
		
		   
		}  
	  
	  .LogSign .modal-body .close{
			position:absolute;
			top:0px;
			right:0px;
			opacity:1;
		   -webkit-transition:ease 0.25s all;
            transition:ease 0.25s all;
           -webkit-transform:translate(50%, -50%);
            transform:translate(50%, -50%);
            line-height:100%;
		}
	  .LogSign .modal-body .close:hover
	  {
		  -webkit-transform:translate(50%, -50%) rotate(180deg);
          transform:translate(50%, -50%) rotate(180deg);
	  }
	  .LogSign .modal-body .heading{
		  line-height: 36px;
          color: #47ADDD;
          text-align: center;
		  letter-spacing:1px;
          position: relative;
          font-size: 30px;
          font-weight:1;
          font-family:Vedrana;
	  }
	  .LogSign .modal-body .or{
		  line-height: 36px;
          color:#70777a;
          text-align: center;
          position: relative;
          font-size:15px;
          font-weight:100;
		  margin:0px;
          font-family:Vedrana;
	  }
	  .LogSign .modal-body .fbLogin{
		  background:#3b5998;
		  border:none;
		  color:white;
		  font-family:Roboto,Tahoma;
		  padding:5px 15px 5px 15px;
		  font-size:20px;
		  position:relative;
		  display:flex;
		  justify-content: center;
		  margin:25px auto;
		  width:300px;
		  text-align:center;
		  
	  }
	  .LogSign .modal-body .fbLogin .fa-facebook{
		  padding-right:5px;
		  padding-top:7px;
	  }
	 .input_input::-webkit-input-placeholder{
 font-family: 'roboto', sans-serif;
 -webkit-transition: all 0.3s ease-in-out;
 transition: all 0.3s ease-in-out;
}




.input_input {
  margin:15px auto;
  width:80%;
  display: block;
  border: none;
  padding:10px 0;
	position:relative;
   border-bottom: solid 1px #47ADDD;
  -webkit-transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);
  transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);
  background: -webkit-linear-gradient(top, rgba(255, 255, 255, 0) 96%, #47ADDD 4%);
  background: linear-gradient(to bottom, rgba(255, 255, 255, 0) 96%, #47ADDD 4%);
  background-position: -400px 0;
  .background-size: 200px 100%;
  background-repeat: no-repeat;
  color: #409eca;
}
.input_input:focus, .input_input:valid {
 box-shadow: none;
 outline: none;
 background-position: 0 0;
}
.input_input:focus::-webkit-input-placeholder, .input_input:valid::-webkit-input-placeholder {
 color: #409eca;
 font-size: 11px;
 -webkit-transform: translateY(-20px);
 transform: translateY(-20px);
 visibility: visible !important;
}

.MiddleLogin {
  border: none;
  background:#47ADDD;
  cursor: pointer;
  position:relative;
  display:block;
  font-family:Roboto,Tahoma;
  border-radius: 3px;
	font-size:20px;
  padding: 6px;
  width:150px;
  color: white;
  margin:45px auto;
  box-shadow: 0 3px 6px 0 rgba(0, 0, 0, 0.2);
}

 .MiddleLogin:hover {
  -webkit-transform: translateY(-3px);
  -ms-transform: translateY(-3px);
  transform: translateY(-3px);
  box-shadow: 0 6px 6px 0 rgba(0, 0, 0, 0.2);
}
	  .fgpassword{
		  margin:0;
		  margin-top:-35px;
		  text-align:center;
		  font-family:Roboto,Tahoma;
		  font-size:14px;
		  padding:0;
		  color:#47ADDD;
	  }
	  .cAccount{
		  font-family:Roboto,Tahoma;
		  position:relative;
		  margin:10px auto;
		  text-align:center;
	  }
	  .SignupArea{
		  display:none;
	  }
	  .pAccount,.plogin{
		  background:transparent;
		  margin:0;
		  border:none;
		  color:#47ADDD;
	  }
	  
	</style>	  
</head>
<body>
<script>
  
  
  
  
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
     // document.getElementById('status').innerHTML = 'Please log ' +'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      //document.getElementById('status').innerHTML = 'Please log ' + 'into Facebook.';
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
	    FB.init({
	      appId      : '210064789371937',
	      xfbml      : true,
	      version    : 'v2.6'
	    });
	    
	
	  };

	  (function(d, s, id){
	     var js, fjs = d.getElementsByTagName(s)[0];
	     if (d.getElementById(id)) {return;}
	     js = d.createElement(s); js.id = id;
	     js.src = "//connect.facebook.net/en_US/sdk.js";
	     fjs.parentNode.insertBefore(js, fjs);
	   }(document, 'script', 'facebook-jssdk'));
  
  
  function loginUser() {
		$(document).ready(function(){
			FB.login(function(response) {
			    if (response.authResponse) {
			     console.log('Welcome!  Fetching your information.... ');
			     FB.api('/me', function(response) {
			       console.log('Good to see you, ' + response.name + '.');
			       testAPI();
			     });
			    } else {
			     console.log('User cancelled login or did not fully authorize.');
			    }
			}); 
		});
	}

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me?fields=name,email,id', function(response) {
     // console.log('Successful login for: ' + response.name);
     // document.getElementById('status').innerHTML ='Thanks for logging in, ' + response.email + '!';
     
      var facebookId=response.id;
      var name=response.name;
      var email=response.email;
     // alert(facebookId);
      $.ajax({
			 
			 type: "GET",
 		 url: "Facebook",
 		 cache: false,
 		 data: {facebookId:facebookId},
 		 
 		         success: function(data){
 		        	//alert(data.UserId);
 		     if(!data.UserId==""||!data.UserId==null) {
 		   
 		    	 $.ajax({
 		   			  
	    			 type: "POST",
	        		 url: "Facebook",
	        		 cache: false,
	        		 data: {UserId:data.UserId},
	        		         success: function(msg){
	        		        	 $('#LogInSignUp').modal('hide');
	        		        	 location.reload(true);
	        		    //    var b= msg;
	        		    //    var url=window.location.pathname ;
	    					
	   					
	        		         },
	        		 error: function(){
	        		 alert("fail");
	        		 }
	    			 
	    			 }); 
 		    	  } 
 		     
 		     else if(data.UserId==""||data.UserId==null){
 		    	 
 		    	// alert(data.UserId);
 		    	 
 		    	 $.ajax({
		   			  
	    			 type: "POST",
	        		 url: "Facebook_Registration",
	        		 cache: false,
	        		 data: {name:name,email:email,facebookId:facebookId},
	        		         success: function(msg){
	        		        	 $('#mdialog').modal('hide');
	        		        	 location.reload(true);
	        					  },
	        		 error: function(){
	        		 alert("fail");
	        		 }
	    			 
	    			 }); 
 
 		    	 
 		     }
 		     
 		     

 		      
 		         },
 		 error: function(){
 		 alert("fail");
 		 }
			 
			 }); 
      
      

      
    });
  }
</script>










  <!-- model content for privacy setting-->
<div id="LogInSignUp"  class="modal fade">
   <div class="modal-dialog" id="mdialog"  role="dialog">
   <div class="modal-content LogSign">
        
		<div class="modal-body">
		<image src="images/cancel.svg" class="close" data-dismiss="modal" width="20px" height="20px">
		<div class="LoginArea">
			<p class="heading">LOGIN</p>
			<button class="fbLogin" onClick="loginUser()"><i class="fa fa-facebook fa-lg" aria-hidden="true"></i><p>Login with Facebook</p></button>
		    <p class="or">OR</p>
  <form action="#">
  <input class="input_input" placeholder="Username" type="text" id="widgetu3088_input" required>
  <input class="input_input" placeholder="Password" type="password" id="widgetu3084_input" required>
 
			</form>
			 <button onClick="LOGIN()"class="MiddleLogin" id="loginbutton">Login</button>
			<p class="fgpassword">Foget Password ?</p>
			<p class="cAccount">Don't have an account ?<button class="pAccount">Create account</button></p>
			</div>
 <div class="SignupArea">
		 <p class="heading">CREATE ACCOUNT</p>
	 <button class="fbLogin" onClick="loginUser()"><i class="fa fa-facebook fa-lg" aria-hidden="true"></i><p>Sign up with Facebook</p></button>
		    <p class="or">OR</p>
  <form>
  <input class="input_input" placeholder="Name" type="text" id="widgetu3052_input"required>
  <input class="input_input" placeholder="Email" type="email" id="widgetu3047_input"required>
  <input  class="input_input" placeholder="Password" type="password" id="widgetu3056_input"required>
  <input class="input_input" placeholder="Confirm Password" type="password" id="widgetu3042_input" required>
  <button  class="MiddleLogin" onClick="SIGNUP()">Signup</button>
			</form>
			<p class="cAccount">Already have an account ?<button class="plogin">Login</button></p>
</div>
	

 </div>
</div>
</div>
</div>
<script>
$(document).ready(function(){	
$(".pAccount").click(function() {
$(".LoginArea").slideUp("slow", function() {
$(".SignupArea").slideDown("slow");
});
});
// On Click SignIn It Will Hide Registration Form and Display Login Form
$(".plogin").click(function() {
$(".SignupArea").slideUp("slow", function() {
$(".LoginArea").slideDown("slow");
});
});
});
</script>
<script type="text/javascript" src="studyfromweb_js/Studyfromweb_Index.js?id=155"></script>
</body>
</html>
</html>
