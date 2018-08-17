<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Followers</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=PT+Sans|Ubuntu" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700" rel="stylesheet">
<script src="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>
<style>
body{
background:#f4f4f4;
    }
.selectoneOption
{
list-style:none;
margin:0;
padding:0;
margin-top:20px;
text-align:center;
}
.selectoneOption li
{
display:inline;
text-align:center;
width:150px;
padding:0px 100px 7px 100px;
.margin-right:150px;
}
.selectoneOption li a
{
text-align:center;
font-family:"PT sans",sans-serif;
color: #666666;
font-size:16px;
font-weight:100;
opacity:0.7;
text-decoration:none;

cursor:pointer;
}
.memberselect{
border-bottom:2px solid #2D7AC6;
}
.member
{
display:flex;
flex-direction:row;
margin-top:40px;
justify-content:center;
flex-wrap:wrap;
flex:4;
margin-left:150px;
margin-right:150px;
}
.singlemember{
display:flex;
flex-direction:column;
width:173px;
height:208px;
box-shadow: 0px 0px 2px rgba(0,0,0,0.17);
border-color: #787878;
background-color: #FFFFFF;
padding-top: 20px;
padding-bottom: 13px;
margin-right:30px;
margin-bottom:30px;
}
.singlemember img
{
height: 84px;
border-radius: 100px;
position: relative;
width: 48.56%;
margin-left: 25.44%;
background: transparent;
background-size: contain;
}
.singlemember p
{
margin:0;
padding:0;
font-family:"PT sans",sans-serif;
text-align:center;
margin-top:15px;
color: #3C3C3C;
width: 88.44%;
margin-left: 3%;
}
.singlemember button
{
font-family:"PT sans",sans-serif;
color:#2D7AC6;
border:none;
background:transparent;
width: 88.44%;
margin-left: 3%;
margin-top:25px;
font-weight:400;
}



.follower
{
display:flex;
flex-direction:row;
margin-top:40px;
justify-content:center;
flex-wrap:wrap;
flex:4;
margin-left:150px;
margin-right:150px;
display:none;
}
.singlefollower{
display:flex;
flex-direction:column;
width:173px;
height:208px;
box-shadow: 0px 0px 2px rgba(0,0,0,0.17);
border-color: #787878;
background-color: #FFFFFF;
padding-top: 20px;
padding-bottom: 13px;
margin-right:30px;
margin-bottom:30px;
}
.singlefollower img
{
height: 84px;
border-radius: 100px;
position: relative;
width: 48.56%;
margin-left: 25.44%;
background: transparent;
background-size: contain;
}
.singlefollower p
{
margin:0;
padding:0;
font-family:"PT sans",sans-serif;
text-align:center;
margin-top:15px;
color: #3C3C3C;
width: 88.44%;
margin-left: 3%;
}
.singlefollower button
{
font-family:"PT sans",sans-serif;
color:#2D7AC6;
border:none;
background:transparent;
width: 88.44%;
margin-left: 3%;
margin-top:25px;
font-weight:400;
}
</style>
<script>
$(document).ready(function(){
	 $(".followerselect").click(function(){
	        $(this).css({"border-bottom": "2px solid #2D7AC6"});
		    $(".memberselect").css({"border-bottom": "none"});
		    $(".member").css({"display": "none"});
		    $(".follower").css({"display": "flex"});
		    
	    });	
	 $(".memberselect").click(function(){
	        $(this).css({"border-bottom": "2px solid #2D7AC6"});
		    $(".followerselect").css({"border-bottom": "none"});
		    $(".follower").css({"display": "none"});
		    $(".member").css({"display": "flex"});
		    
	    });	
});
</script>
</head>
<body>
<ul class="selectoneOption">
<li class="memberselect"><a href="{{baseUrl}}#/followers/members">Members</a></li>
<li class="followerselect"><a href="{{baseUrl}}#/followers/subscribers">Followers</a></li>
</ul>
<div class="member" ui-view="followers">

</div>
</body>
</html>