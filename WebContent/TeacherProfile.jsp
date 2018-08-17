<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vicky Kumar</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=PT+Sans|Ubuntu" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	$(".view_classroom").click(function(){
		$(".b2").fadeToggle();
	});
});
</script>
<style>
body,html{
margin:0;
padding:0;
background:#f9f9f9;
height:100%;
}
.teacher_profile_wrapper{
position:relative;
display:flex;
flex-direction:row;
width:100%;
min-height:100%;
}
.teacher_beasic_detail{
display:flex;
flex-direction:column;
margin:0px auto;
width:220px;
float:left;
background:#2874f0;
font-family:"PT sans",sans-serif;
min-height:100%;
box-shadow: 0 1px 8px 5px rgba(0,0,0,0.14);
}
.teacher_beasic_detail .view_classroom
{
background:transparent;
border:none;
font-family:"PT sans",sans-serif;
color:#fff;
letter-spacing:1px;
font-size:20px;
}
.teacher_beasic_detail .view_classroom:hover{
text-decoration:underline;
}
.teacher_beasic_detail .view_classroom:focus{
text-decoration:underline;
outline:none;
border:none;
}
.teacher_beasic_detail .teacher_name
{
font-size:30px;
text-align:center;
font-weight:900;
color:#fff;
margin:0;
padding:0;
letter-spacing:1px;
font-family:"PT sans",sans-serif;
}
.teacher_beasic_detail .img1
{
border-radius:50%;
border:3px solid #FFF;
margin:50px auto;
margin-bottom:5px;
object-fit:cover;
}
.full_detail{
position:relative;
display:flex;
float:left;
width:calc(100% - 220px);
flex-direction:column;
}
.full_detail h3
{
margin-top:50px;
font-family:"PT sans",sans-serif;
color:#848484;
padding-left:20px;
padding-right:20px;
letter-spacing:1px;
}
.full_detail .vision
{
font-family:"PT sans",sans-serif;
width:80%;
color:#848484;
padding-top:20px;
font-size:15px;
padding-left:20px;
padding-right:20px;
}
.basic_information{
padding-left:20px;
padding-right:20px;
padding-top:20px;
width:100%;
}
.basic_information .b1
{
width:50%;
float:left;
}
.basic_information .b2
{
width:50%;
margin-top:25px;
float:left;
max-height:300px;
height:100%;
overflow-x:hodden;
overflow-y:auto;
border:1px solid #848484;
padding-left:10px;
padding-right:10px;
display:none;
}
.basic_information .b2::-webkit-scrollbar-track
{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	background-color: #F5F5F5;
}

.basic_information .b2::-webkit-scrollbar
{
	width:6px;
	background-color: #eee;
}

.basic_information .b2::-webkit-scrollbar-thumb
{
	background-color: #b1b2b3;
}

.basic_information .b2 .classroom_row
{
border-bottom:1px solid #888;
}
.basic_information .b2 ul
{
list-style:none;
margin:0;
padding:0;
}
.basic_information .b2 ul li
{
font-family:"PT sans",sans-serif;
color:#848484;
font-size:14px;
padding:0;
margin:0;

}
.basic_information .b2 ul li a
{
font-family:"PT sans",sans-serif;
color:#666666;
font-weight:500;
font-size:17px;
cursor:pointer;
}
.basic_information table tr td
{
font-family:"PT sans",sans-serif;
color:#848484;
padding-top:20px;
font-size:15px;
}
.basic_information table tr td:nth-child(1)
{
width:170px;
}
.basic_information table tr td:nth-child(2)
{
width:50px;
}
.basic_information table tr td:nth-child(3)
{
width:calc(100% - 220px);
}
</style>
</head>
<body>
<div class="teacher_profile_wrapper">
<div class="teacher_beasic_detail">
<img src="images/rakul.jpg" width="140px" height="140px" class="img1" >
<p class="teacher_name">VICKY KUMAR</p>
<button class="view_classroom">Visit Classroom</button>
</div>
<div class="full_detail">
<div style="width:100%;height:30px;background:#2874f0;box-shadow: 8px 8px 8px 0px rgba(0,0,0,0.14);"></div>
<h3>My Vision</h3>
<p class="vision">Vision is the name of several fictional superheroes appearing in American
 comic books published by Marvel Comics. The first iteration was an alien created
  by Joe Simon and Jack Kirby who first appeared in Marvel Mystery Comics
   #13 (November 1940). The second
iteration is an android and a member of the Avengers who first appeared in The 
Avengers #57 (October 1968) by </p>
<div class="basic_information">
<div class="b1">
<table>
  <tr>
    <td>Institution</td>
    <td>:</td>
    <td>birla institute of technology</td>
  </tr>
  <tr>
    <td>No. of followers</td>
    <td>:</td>
    <td>200</td>
  </tr>
  <tr>
    <td>Education</td>
    <td>:</td>
    <td>Computer Science</td>
  </tr>
  <tr>
    <td>Profession</td>
    <td>:</td>
    <td>UI/UX developer</td>
  </tr>
  <tr>
    <td>No. of classroom created</td>
    <td>:</td>
    <td>27</td>
  </tr>
  <tr>
    <td>Email</td>
    <td>:</td>
    <td>vickychandi99@gmail.com</td>
  </tr>
  <tr>
    <td>Date of birth</td>
    <td>:</td>
    <td>1990</td>
  </tr>
</table>
</div>
<div class="b2">
<div class="classroom_row">
<ul>
<li><a>Mathematics</a></li>
<li>This is a short notes about this class</li>
</ul>
</div>
<div class="classroom_row">
<ul>
<li><a>Ohysics</a></li>
<li>This is a short notes about this class</li>
</ul>
</div>
<div class="classroom_row">
<ul>
<li><a>Chemistry</a></li>
<li>This is a short notes about this class</li>
</ul>
</div>
<div class="classroom_row">
<ul>
<li><a>Biology</a></li>
<li>This is a short notes about this class</li>
</ul>
</div>
<div class="classroom_row">
<ul>
<li><a>Data Structure</a></li>
<li>This is a short notes about this class</li>
</ul>
</div>
<div class="classroom_row">
<ul>
<li><a>Probability</a></li>
<li>This is a short notes about this class</li>
</ul>
</div>
<div class="classroom_row">
<ul>
<li><a>Statistics</a></li>
<li>This is a short notes about this class</li>
</ul>
</div>
<div class="classroom_row">
<ul>
<li><a>Operating System</a></li>
<li>This is a short notes about this class</li>
</ul>
</div>
<div class="classroom_row">
<ul>
<li><a>Networking</a></li>
<li>This is a short notes about this class</li>
</ul>
</div>
</div>
</div>
</div>
</div>
</body>
</html>