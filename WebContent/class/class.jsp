<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ClassRoom</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=PT+Sans|Ubuntu" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-beta.2/angular-sanitize.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.10/angular-ui-router.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router.statehelper/1.3.1/statehelper.js">  </script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router.statehelper/1.3.1/statehelper.min.js">  </script> 
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-beta.2/angular-sanitize.js"></script> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>
<base href="${pageContext.request.contextPath}/">
<style>
.header{
positon:relative;
display:flex;
height:57px;
background:#2D7AC6;
flex-direction:row;
justify-content:center;
margin:0px auto;
box-shadow: 0px 0px 3px rgba(0,0,0,0.13);
}
.header .logo
{
width: 195px;
height: 85px;
position:absolute;
left:40px;

}
.header input[type=text]
{
background: #256AAF;
border:none;
color:#fff;
width:492px;
.width:100%;
height:40px;
}
.header input[type=text]:focus
{
outline:none;
}
.searcharrowbutton{
display:flex;
flex-direction:row;
margin-top:10px;
background: #256AAF;
height:40px;
padding-left:15px;
}
.searcharrowbutton img
{
width:20px;
height:40px;
background: #256AAF;
cursor:pointer;
}
.searcharrowbutton .radiobutton
{
z-index:100;
display:none;
position:absolute;
font-family:"PT sans",sans-serif;
top:50px;
margin-left:-35px;
background:#F4F4F4;
padding:20px 50px 20px 50px;
box-shadow: 0px 1px 1px rgba(0,0,0,0.12);
font-size:16px;
color:#555;
}
.searcharrowbutton .radiobutton input[type=radio]
{
margin-bottom:8px;
margin-right:15px;
}
input[type='radio']:after {
    width: 20px;
    height: 20px;
    border-radius: 20px;
    top: -2px;
    left: -1px;
    position: relative;
    background-color:#d1d3d1;
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
.tabs
{
height:38px;
box-shadow: 0px 0px 3px rgba(0,0,0,0.13);
background-color: #FFFFFF;
color:#94949C;
padding-left:230px;
}
.tabs a
{
color:#94949C;
font-family:"PT sans",sans-serif;
padding:0px 50px 7px 50px;
font-size: 16px;
margin:25px;
line-height: 38px;
text-decoration:none;
}
.tabs a:hover
{
text-decoration:none;
}
.tabs a:active
{
text-decoration:none;
}
.tabs a:focus
{
text-decoration:none;
}
.header button
{
background:none;
border:none;
}
.header button img
{
height:38px;
width:40px;
}
</style>
<script>
$(document).ready(function(){
	$(".classes").css({"border-bottom":"2px solid #2D7AC6"});
	$(".classes").click(function(){
		$(this).css({"border-bottom":"2px solid #2D7AC6"});
		$(".followeer").css({"border-bottom":"none"});
		$(".notbod").css({"border-bottom":"none"});
	});
	
	$(".followeer").click(function(){
		$(this).css({"border-bottom":"2px solid #2D7AC6"});
		$(".classes").css({"border-bottom":"none"});
		$(".notbod").css({"border-bottom":"none"});
	});
	
	$(".notbod").click(function(){
		$(this).css({"border-bottom":"2px solid #2D7AC6"});
		$(".followeer").css({"border-bottom":"none"});
		$(".classes").css({"border-bottom":"none"});
	});
	
	$(".imgarrow").click(function(){
	    $(".radiobutton").fadeToggle(500);	
	    }); 
	
	$(document).on('click', function (e) {
        if ($(e.target).closest(".imgarrow").length === 0) {
            $(".radiobutton").fadeOut();
        }
    });
});
</script>
</head>
<body>
<div id="mainClass" ng-app="mainClass">
<div class="header">

<img src="class/logo-back.png" class="logo">
<img src="images/logoo.gif" class="logo">
<div class="searcharrowbutton">
<img src="class/down-arrow.svg" class="imgarrow">
<form>
<div class="radiobutton">
<input type="radio" name="aa">Institution<br>
<input type="radio" name="aa">Email<br>
<input type="radio" name="aa">Teacher
</div>
<input type="text">
<button type="submit"><img src="class/search.png"></button>
</form>
</div>
</div>


<div class="tabs">
<a class="anchorTabs classes" href="{{baseUrl}}#/home">Class</a>
<a class="anchorTabs followeer" href="{{baseUrl}}#/followers">Followers</a>
<a class="anchorTabs notbod" href="{{baseUrl}}#/notice">Notice Board</a>
</div>
<div ui-view="classDetails" ></div>
<div ui-view="MainClass"></div>
</div>
<script type="text/javascript">





</script>
 <%@ include file="js/NewMain.jsp" %>

</html>