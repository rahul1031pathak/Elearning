<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>


<link rel="stylesheet" href="js1/bootstrap.min.css">
<link rel="stylesheet" href="js1/bootstrap-theme.min.css">
<link rel="stylesheet" href="js1/font-awesome.min.css" >
<link rel="stylesheet" href="js1/font-awesome.css" >
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<style>
body,html{ 
	margin:0;
	padding:0;
	height:100%;
    background:#eee;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
     }
.headerrr
{
    position:fixed;
    top:0;
	width:100%;
	height:70px;
    box-sizing: border-box;
	background-color:#266b91;
	display:-webkit-box;
	display:-ms-flexbox;
	display:flex;
    justify-content:space-between;
	        z-index:100;
}
.headerNAV{
    text-decoration:none;
    margin:0;
    padding:0;
    white-space: nowrap;
}
.headerNAV li{
    position:relative;
    display:inline;
    height:100%;
    padding-right:10px;
    white-space: nowrap;
}

.headerNAV  li .profile
{
	color:#fff;
	font-family:"Roboto", sans-serif;
	font-size:14px;
	margin-left:15px;
	line-height:70px;
}
.headerNAV  li .logout
{
	color:#fff;
	padding-top:18px;
	font-family:"Roboto", sans-serif;
	font-size:14px;
	cursor:pointer;
	margin-left:15px;
	line-height:70px;
	padding-right:20px;
}
.headerNAV  li .follower
{
	color:#fff;
	padding-top:18px;
	font-family:Roboto,Tahoma;
	font-size:14px;
    line-height:70px;
}
.follower_counter{
    position: absolute;
    margin-top:15px;
    background:#ec1f1f;
    color:#fff;
    margin-left:3px;
    line-height:18px;
    right:5px;
    .border: 2px solid #fff;
    font-size:8px;
    border-radius: 50%;
    width:18px;
    height:18px;
    text-align:center;
}

     
  input.header-search-inputt {
    position:relative;
    padding-left:0px;
    max-width:600px;
    width: 100%;
    background: rgba(255,255,255,0.25);
    height:40px;
    font-size: 16px;
    appearance: textfield;
    font-weight: 100;
    outline: none;
    border:none;
    border-top-right-radius:3px;
    border-bottom-right-radius:3px;
}
      input.header-search-inputt:active,
      input.header-search-inputt:focus {
      background: rgba(255,255,255,0.25);
      color: #fff;

}
      .searchbarIcon{
          position:relative;
          margin-top:10px;
          width:20px;
          height:20px;
          right:30px;
          color:#fff;
          font-weight: 100;
          background:transparent;
      } 
      .searchbarDownarrow{
          position:relative;
          margin-top:10px;
          cursor:pointer;
          border:none;
          border-top-left-radius:3px;
          border-bottom-left-radius:3px;
          background: rgba(255,255,255,0.25);
          color:#fff;
          height:40px;
          width:40px;
          margin-top:0px;
          font-weight: 100;
      
      }
      .searchbarDownarrow:focus
      {
      outline:none;
      }
      
input.header-search-inputt::-webkit-input-placeholder {
    padding-left:6px;
    color:#fff;
	font-size:16px;
	font-family:Roboto;
	
}
input.header-search-inputt:-moz-placeholder { /* Firefox 18- */
    padding-left:0px;
    color:#fff;
	font-size:16px;
	font-family:Roboto;
}
 
input.header-search-inputt::-moz-placeholder {  /* Firefox 19+ */
    padding-left:0px;
    color:#fff;
	font-size:16px;
	font-family:Roboto;
}
 
input.header-search-inputt:-ms-input-placeholder {  
    padding-left:0px;
    color:#fff;
	font-size:16px;
	font-family:Roboto;
}
.control {
  display:inline;
  color:#fff;
  position: relative;
  font-family: 'Roboto', sans-serif;
  padding-left:20px;
  margin-top:0px;
    font-weight: 500;
  cursor: pointer;
  font-size:12px;
}
.control input {
  position: absolute;
  z-index: -1;
  opacity: 0;
}
.control__indicator {
  position: absolute;
  top: 2px;
  left: 0;
  height: 12px;
  width:12px;
  background: #e6e6e6;
}
.control--radio .control__indicator {
  border-radius: 50%;
}
.control:hover input ~ .control__indicator,
.control input:focus ~ .control__indicator {
  background: #ccc;
}
.control input:checked ~ .control__indicator {
  background: #2aa1c0;
}
.control:hover input:not([disabled]):checked ~ .control__indicator,
.control input:checked:focus ~ .control__indicator {
  background: #0e647d;
}

.control__indicator:after {
  content: '';
  position: absolute;
  display: none;
}
.control input:checked ~ .control__indicator:after {
  display: block;
}

.control--radio .control__indicator:after {
  left: 3px;
  top: 3px;
  height: 6px;
  width: 6px;
  border-radius: 50%;
  background: #fff;
}
.MobileDevices{
	display:-webkit-box;
	display:-ms-flexbox;
	display:flex;
	 -webkit-box-pack: justify;
	     -ms-flex-pack: justify;
	         justify-content: space-between;
}
.MobileDevices a{
	background:transparent;
	color:#f5f9fb;
	border:none;
	padding:0;
	margin:0;
	cursor:pointer;
	margin-top:10px;
	}
.MobileDevices a:focus{
	border:none;outline:none;
}
.MobileDevices a:first-child{
	margin-left:5px;
}
.MobileDevices a:last-child{
	margin-right:10px;
}
.badge{
	border:2px solid #fff;
	border-radius:50%;
	background:#134b61;
	margin-top:-15px;
	margin-left:-10px;
	color:#fff;
}
.MobileDevicesWrapper{
background-color:#266b91;
height:60px;
width:100%;
color:#fff;
display:none;
}
.SmallScreenForm{
	position:absolute;
	width:100%;
	display:none;
	 background-color:#266b91;
	z-index:2001;
	padding:15px;
	text-align:center;
	top:40px;
	
	margin:0px auto;
}
.SmallScreenForm form{
	width:100%;
	text-align:center;
	margin:0px auto;
	padding:0;
}
.user_basic_detail{

position:absolute;
right:50px;
padding:10px;
z-index:90001;
width:200px;
height:60px;
background:#fff;
.box-shadow: 0em 0.1em 0.1em 0em #ccc;
box-shadow: 0 10px 6px -6px #ccc;
display:none;
}
.user_basic_detail p:first-child
{
margin:0;
padding:0;
color:#000;
font-size:16px;
font-weight:500;
font-family:"Roboto",sans-serif;
}
.user_basic_detail p:last-child
{
margin:0;
padding:0;
font-size:14px;
color:#aaa8a8;
font-family:"Roboto",sans-serif;
}
.headerNAV  li .logout:hover .user_basic_detail{
display:block!important;
}
.arrow-up {
  display:none;
  position:absolute;
  margin-left:60px;
  margin-top:-9px;
  width: 0; 
  height: 0; 
  border-left:10px solid transparent;
  border-right: 10px solid transparent;
  border-bottom: 10px solid white;
}
@media screen and (max-width:769px)
{
	.headerrr{display:none!important;}
	.MobileDevicesWrapper{display:block!important;height:45px;position:fixed;z-index:1001}
	.searchbarr{
	display:flex;
	justify-content:center;
	margin:0px auto;
	}
	.searchbarDownarrow{display:none!important;width:0;height:0;}
	.searchbarDownarrow img{display:none!important;}
	.searchbarIcon{display:none;}
	input.header-search-inputt{border-top-left-radius:3px;border-bottom-left-radius:3px;}
}

@media screen and (max-width:400px)
{
.searchbarr{margin-bottom:20px}
}
.searchbarr{
    position:relative;
    display:block;
    float:left;
    text-align:center;
    width:60%;
    height:70px;
    background:transparent;
    }
 .wrapperr{
          position:relative;
          width:100%;
          display:flex;
          margin-top:18px;
          justify-content:flex-start;
          z-index:102;
          
      }
.showRadioButtton{
display:none;
position:absolute;
width:170px;
margin-top:40px;
z-index:105;
}
ul.radio_button{

   display:block;
   list-style-type: none;
   margin: 0;
   padding:15px;
   background:#fff;
   box-shadow: 0 10px 6px -6px #ccc;
  
}
ul.radio_button li{
display:block;
z-index:101;
text-align:left;
}
ul.radio_button li label
{
padding-left:10px;
font-family:"Roboto",sans-serif;
font-weight:100;
font-size:16px;
}
input[type='radio']:after {
    width: 20px;
    height: 20px;
    border-radius: 20px;
    top: -2px;
    left: -1px;
    position: relative;
    background-color: #d1d3d1;
    content: '';
    display: inline-block;
    visibility: visible;
    border: 2px solid white;
}

input[type='radio']:checked:after {
    width: 20px;
    height: 20px;
    border-radius: 20px;
    top: -2px;
    left: -1px;
    position: relative;
    background-color: #ffa500;
    content: '';
    display: inline-block;
    visibility: visible;
    border: 2px solid white;
}
</style>
	
	<script>
$(document).ready(function(){
   
    
    
    
    $("#smallScreenButton").click(function(e){
        e.stopPropagation();
        var flag=$(this).data("flag");
     
        if (flag==0){
       
           $(".center").show(); 
            
       $(this).data("flag",1);
           
            
        }
       else {
    	
               $(".center").hide();
               $(this).data("flag",0);
            
       }
    });
    
    
    
    
    $(document).click(function (event)
    	      // $("html").on("click", "button:not('.slideNav')",function(e)
    	  {

    	    var container = $(".center");
    	  var container1 = $(".slideNav");
    	  if(!$(event.target).is('.center'))
    	  {
    		  container.hide();
   	        $(".slideNav").data("flag",0);
    	  }
    	    
    	});
    
});
    

$(document).ready(function(){
    $(".profile").hover(function(){
    	 $(".arrow-up").fadeToggle();
        $(".user_basic_detail").slideToggle();
    });
});


</script>
		<script>
$(document).ready(function(){
	
	  $("#logo").click(function(){
	    	document.location.href='Home.jsp'
	    });
	
    $(".openSmallScreenForm").click(function(){
        $(".SmallScreenForm").slideToggle("slow");
    });
    
    $(".searchbarDownarrow").click(function(){
    $(".showRadioButtton").fadeToggle(500);	
    });
    
    $(document).on('click', function (e) {
        if ($(e.target).closest(".searchbarDownarrow").length === 0) {
            $(".showRadioButtton").fadeOut();
        }
    });
});
	</script>
</head>
<body>
<script>
window.fbAsyncInit = function() {
    FB.init({
      appId      : '964796970330121',
      xfbml      : true,
      version    : 'v2.9'
    });
    FB.AppEvents.logPageView();
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>
<div id="headerrr" class="headerrr">
    <img src="images/logo.gif" id="logo"width="178" height="70">
    <div class="searchbarr">
    <form method="get" target="_blank"action="Search">
     <div class="showRadioButtton">
    <ul class="radio_button">
    <li><input type="radio" name="SelectFilter" value="TeacherName" checked="checked"><label>Teacher Name</label></li>
    <li><input type="radio" name="SelectFilter" value="Institution"><label>Institution</label></li>
    <li><input type="radio" name="SelectFilter" value="Email"><label>Email</label></li>
    </ul>
    </div>
    <div class="wrapperr">
       <div class="searchbarDownarrow"> <img src="images/down-arrow.svg" width="20px" height="20px" style="margin-top:10px;"></div>
       <input type="text" id="searchinput" name="searchbox" class="header-search-inputt" placeholder="Enter Keyword">
       <img src="images/icon-search.svg" class="searchbarIcon">
   
    </div>
    </form>
    </div>
        <ul class="headerNAV">    
		<li ><a href="javascript:void(0);" class="follower" title="Followers"><img src="images/group.svg" width="25px" height="25px" style="padding-bottom:0px;"><span class="follower_counter">{{user.numberOfFollowers}}</span></a></li>
         <li ><a href="UpdateProfile.jsp"target="_blank" class="profile"><img ng-src="{{user.profilePic}}" style="border-radius:50%;" width="33px" height="33px"></a></li>
         <div class="arrow-up"></div>
         <div class="user_basic_detail">
          <p>Welcome {{user.fullname}}</p>
          <p>{{user.email}}</p>
         </div>
         <li ><a  class="logout"id="UserLogout" title="Logout"><img src="images/logout.svg" width="25px"height="25px"></a></li>
      </ul>
	<!--<span onclick="openNav()"><i class="fa fa-bars fa-lg" aria-hidden="true"></i></span>-->
	</div>
	<div class="MobileDevicesWrapper" id="MobileDevicesWrapper">
	<div class="MobileDevices">
        <a class="slideNav" id="smallScreenButton" data-flag="0"><i class="fa fa-bars fa-lg" aria-hidden="true"></i></a>
        <a class="openSmallScreenForm" title="search"><i class="fa fa-search fa-lg"></i></a>
       <div class="SmallScreenForm">
       <div class="searchbarr">
    <form method="get" target="_blank"action="Search">
        <label class="control control--radio">Teacher name
      <input type="radio" name="SelectFilter" value="TeacherName" checked="checked"/>
      <div class="control__indicator"></div>
    </label>
    <label class="control control--radio">Institution
      <input type="radio"name="SelectFilter" value="Institution"/>
      <div class="control__indicator"></div>
    </label>
        <label class="control control--radio">Email
      <input type="radio"name="SelectFilter" value="Email"/>
      <div class="control__indicator"></div>
    </label>
    <div class="wrapperr">
        <img src="images/icon-search.svg" class="searchbarIcon">
    <input type="text" id="searchinput" name="searchbox" class="header-search-inputt" placeholder="Enter Keyword">
    </div>
    </form>
    </div>
		 </div>
        <a title="profile" href="UpdateProfile.jsp"  target="_blank"><i class="fa fa-user-circle fa-lg"></i></a>
        <a title="follower"><i class="fa fa-users fa-lg" aria-hidden="true" ></i><span class="badge">${sessionScope.USER.numberOfFollowers}</span></a>
		<a title="logout" class="logout" id="UserLogout1"><i class="fa fa-power-off fa-lg" aria-hidden="true"></i></a>
      
    </div>
    </div>
 <script>
    // logout 
    $(document).ready(function(){
    	
    	
    
    	 $("#UserLogout1,#UserLogout").click(function(){
    	    	var facebookid='${sessionScope.FACEBOOKUSERID}';
    	    	
    	    	
    	    	if(facebookid=='false'||facebookid==''){
    	    		
    	    		
    	    	 $.ajax({
    	    			 type: "GET",
    	        		 url: "Logout",
    	        		 dataType: "json",
    	        		 cache: false,
    	        		
    	        	    success: function(data){
    	        		        	 
    	        		        	// if(data.b=="true"){
    	        		        		 
    	        		        		// $.cookie('loginemail', "");
    	        		        		 $.cookie('loginpassword', "");
    	        		        		// $.cookie('remember', "");
    	        		        	 document.location.href='index.html';
    	        		        	// }
    	        		        	 
    	        		         },
    	        		 error: function(){
    	        			 document.location.href='index.html';
    	        		 }
    	        		          }); 

    	    	}
    	    	else if(facebookid=='true'){
    	    		
    	    		
    	    
    	    		//FB.getLoginStatus(function(response) { when fb login through fblogin button
    	    			FB.login(function(response) {
    	    	
    	    	        if (response && response.status === 'connected') {
    	    	            FB.logout(function(response) {
    	    	                
        	    	            $.ajax({
          	    	    			 type: "GET",
          	    	        		 url: "Logout",
          	    	        		 dataType: "json",
          	    	        		 cache: false,
          	    	        		
          	    	        	    success: function(data){
          	    	        	  	 
          	    	        		        	 if(data.b=="true"){
          	    	        		        		 
          	    	        		        		 $.cookie('loginemail', "");
          	    	        		        		//$.cookie('loginpassword', "");
          	    	        		        		// $.cookie('remember', "");
          	    	        		        		 document.location.href='index.html'
          	    	        		        	 }
          	    	        		        	 
          	    	        		         },
          	    	        		 error: function(){
          	    	        		
          	    	        		 }
          	    	        		          });        
        	    	            
    	    	            });
    	    	            
    	    	            
    	    	 
    	    	            
    	    	            
    	    	            
    	    	     
    	    	        }
    	    	    });
    	    	}
    	    	
    	    });
    		
    	    		
    	    		
    	    		
    	    		
	    		
    });
    	 
    </script>
    <script type="text/javascript" src="studyfromweb_js/tracking.js?id=1555555222222222222222222222"></script>				
</body>
</html>