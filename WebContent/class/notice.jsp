<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notice</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=PT+Sans|Ubuntu" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700" rel="stylesheet">
<script src="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>
<style>
html,body{
background:#f4f4f4;
height:100%;
}
.noticeboard{
display:flex;
background:#fff;
max-width:864px;
width:100%;
font-family:"PT sans",sans-serif;
margin:20px auto;
flex-direction:column;
height:100%;
}
.noticeboard img
{
width:45px;
height:65px;
margin:0px auto;
}
.noticeboard p
{
color: #666666;
opacity:0.6;
font-size:17px;
padding:5px 20px 20px 20px;

font-weight:100;
}
.noticeboard .marqueeDiv li
{
display:flex;
flex-direction:row;
justify-content:space-between;
border-bottom:1px solid rgba(66,66,66,.3);
margin-left:10px;
margin-right:10px;
}
.noticeboard .marqueeDiv li button
{
color: #666666;
background:transparent;
border:none;
width:20px;
opacity:.7;
.margin-right:50px;
}
.noticeboard .marqueeDiv
{
margin:0;
padding:0;
}
</style>
</head>
<body>
<div class="noticeboard">
<img src="class/loudspeaker.gif">
<marquee behavior="scroll" direction="up"height="100%"scrollamount="4" onmouseover="this.stop();"onmouseout="this.start();">
<ul class="marqueeDiv">
<li><p>Marquee Behavior : The text can scroll, slide or alternate.</p><button>X</button></li>
<li><p>Marquee Direction : Direction can be left , right and it can be up or down.</p><button>X</button></li>
<li><p>Marquee Repeat : Number of times the action can be repeated.</p><button>X</button></li>
<li><p>Marquee Speed : Delay in milliseconds and jump in pixels.</p><button>X</button></li>
</ul>
</marquee>
</div>
</body>
</html>