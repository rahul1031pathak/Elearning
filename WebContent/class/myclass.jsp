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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700" rel="stylesheet">
<script src="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>
<style>
body{
background:#f4f4f4;
    }
.wrapperDiv
{
position:relative;
width:100%;
height:100%;
margin-top:20px;
}
.verticalNav
{
position:relative;
margin-top:100px;
width:220px;
float:left;
margin-right:100px;
}
.horizontalTabs
{
poaition:relative;
float:left;
width:calc(100% - 230px);
background:white;

}
ul{
list-style:none;
width:100%;
.margin:0;
padding:0;
}
.verticalNav ul li
{
margin-bottom:10px;
height:40px;
padding-left:20px;
width:100%!important;
}
.verticalNav li button
{
background:transparent;
border:none;
color: #AFAFAF;
font-family: 'Roboto Condensed', sans-serif;
font-size: 14px;
line-height:40px;

font-weight:400;
}
.verticalNav li a
{
text-decoration:none;
color:#AFAFAF;
font-family:'Roboto Condensed', sans-serif;
font-size: 14px;
line-height: 40px;
font-weight:400;
padding:10px;
}
.verticalNav li button:focus
{
border:none;
outline:none;
}
.verticalNav ul li:hover
{
background:white;
}

.verticalNav .verticalImage
{
margin-right:20px;
height:40px;
width:40px;
}
.horizontalTabs
{
width:800px;
margin-left:30px;
box-shadow: 0px 0px 1px rgba(0,0,0,0.17);
}
.horizontalTabs ul
{

list-style-type:none;
margin:0;
padding:0;
height:45px;
box-shadow: 0px 0px 1px 0px rgba(0,0,0,0.13);
display:flex;
justify-content:space-between;
flex-direction:row;
padding-left:30px;
padding-right:30px;
margin-bottom:20px;

}
.horizontalTabs ul li
{

}
.horizontalTabs ul li a
{
cursor:pointer;
text-decoration:none;
font-family:"PT sans",sans-serif;
color:#94949C;
line-height:45px;
font-size:17px;
opacity:0.7;
}
.qn
{
border-bottom:2px solid #2D7AC6;
padding:0px 50px 0px 50px;
}
.an,.vn
{
padding:0px 50px 0px 50px;
}
</style>
<script>
$(document).ready(function(){
	 $(".qn").click(function(){
	        $(this).css({"border-bottom": "2px solid #2D7AC6"});
		    $(".vn,.an").css({"border-bottom": "none"});
		    
		    
	    });	
	 $(".an").click(function(){
	        $(this).css({"border-bottom": "2px solid #2D7AC6"});
		    $(".vn,.qn").css({"border-bottom": "none"});
		   
		    
	    });	
	 $(".vn").click(function(){
	        $(this).css({"border-bottom": "2px solid #2D7AC6"});
		    $(".qn,.an").css({"border-bottom": "none"});
		   
		    
	    });	
});
</script>
</head>
<body>
<div class="wrapperDiv">
<div class="verticalNav">
<ul>
<li><button id="ask_your_question_here"><img src="class/question.gif" class="verticalImage">Ask Question</button></li>
<li><button id="Write_your_Article"><img src="images/article.gif" class="verticalImage">Write Article</button></li>
<li><button><img src="class/youtbe.gif" class="verticalImage">Youtube Tutorials</button></li>
<li><button><img src="class/uploaded.gif" class="verticalImage">Uploaded File</button></li>
<li><a href="javascript:void(0);" id="uploadFile"><img src="images/upload.gif" class="verticalImage">Upload File</a></li>
<li><a href="{{baseUrl}}#/settings"><img src="class/settings.gif" class="verticalImage">Settings</a></li>
</ul>
</div>
<div class="horizontalTabs">
<ul>
<li class="qn" ><a class="anchorTabsMyclass" href="{{baseUrl}}#/home/Questions">Questions</a></li>
<li class="an"><a class="anchorTabsMyclass" href="{{baseUrl}}#/home/Articles">Articles</a></li>
<li class="vn"><a class="anchorTabsMyclass" href="{{baseUrl}}#/home/Videos">Videos</a></li>
</ul>


<div class="content" ui-view="main" ></div>


</div>
</div>


</body>
</html>