<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Setting</title>
<link href="https://fonts.googleapis.com/css?family=PT+Sans|Ubuntu" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700" rel="stylesheet">
<script src="https://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>
<style>
.settingSelect
{
margin:0px auto;
width:700px;
height:350px;
box-shadow: 0px 0px 2px rgba(0,0,0,0.17);
}
.settingSelect ul.setingSwitch
{
display:flex;
flex-direction:row;
margin:0;
padding:0;
justify-content:space-between;
list-style:none;
background:#f4f4f4;
height:50px;
}
.settingSelect .setingSwitch img
{
width:40px;
height:50px;
margin-right:10px;
}
.settingSelect .setingSwitch a
{
text-decoration:none;
font-family:"PT sans",sans-serif;
color: #3C3C3C;
font-size:15px;
cursor:pointer;
.margin-left:10px;
margin-right:10px;
}


.privacySetting
{
width:100%;
margin-top:10px;
display:flex;
flex-direction:column;
justify-content:center;
}
.privacySetting p
{
text-align:center;
font-family:"PT sans",sans-serif;
font-size:20px;
}




.privacy_form_wrapper{
			display:flex;
			justify-content: center;
			flex-direction:column;
			font-family:"PT sans",sans-serif;
			width:100%;
			margin:opx auto;
			padding-left:10px;
			padding-right:10px;
			}
			.submit{
			width:100px;
			margin:10px auto;
			color:#fff;
	        cursor: pointer;
	        font-family: 'PT sans', sans-serif;
	        border:none;
	        display:flex;
	        justify-content:center;
            background-color:#339cf5;
            font-size:16px;
            font-weight:100;
            padding:8px 5px 8px 5px;
			box-shadow: 0 1px 4px rgba(0, 0, 0, .6);
		}
		#privacySettingForm{margin:30px auto;}
	
		.submit:hover{background-color:#2f87d1;color:#fff;}
        .submit:active,.submit:focus{background-color:#2f87d1;color:#fff;}
        
        #privacySettingForm label{
         padding-left:10px;
         font-family:"PT sans",sans-serif;
         font-weight:100;
         color:#333;
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
.subAdmin
{

width:100%;
display:flex;
justify-content:center;
flex-direction:column;
display:none;
}
.subAdmin p:first-child
{
font-family: 'PT sans', sans-serif;
text-align:center;
font-size:20px;
margin-top:20px;
}
.subAdmin p:nth-child(2)
{
font-family: 'PT sans', sans-serif;
text-align:center;
font-size:16px;
margin-top:40px;
}
.subAdmin form
{
display:flex;
justify-content:center;
margin-top:40px;
}
.subAdmin input[type=text]
{
margin-right:20px;
border:1px solid #D7244C;
border-radius:2px;
font-family: 'PT sans', sans-serif;
height:35px;
width:300px;
text-align:center;
}
::-webkit-input-placeholder { /* Chrome/Opera/Safari */
  color: #D7244C;
  font-family: 'PT sans', sans-serif;
  font-weight:500;
  font-size:16px;
}
::-moz-placeholder { /* Firefox 19+ */
  color: #D7244C;
  font-family: 'PT sans', sans-serif;
}
:-ms-input-placeholder { /* IE 10+ */
  color: #D7244C;
  font-family: 'PT sans', sans-serif;
}
:-moz-placeholder { /* Firefox 18- */
  color: #D7244C;
  font-family: 'PT sans', sans-serif;
}
.button-one {
font-family: 'PT sans', sans-serif;
text-align: center;
  cursor: pointer;
  padding:5px 20px 5px 20px;
  outline: none;
  background-color: #27ae60;
  border: none;
  color:white;
  border-radius:5px;
  box-shadow: 0 3px #95a5a6;
}

.button-one:hover{
  background-color: #2ecc71;
}

.button-one:active {
  background-color: #2ecc71;
  box-shadow: 0 0px #95a5a6;
  transform: translateY(3px);
}
.transferClass
{
width:100%;
display:flex;
justify-content:center;
flex-direction:column;
display:none;
}
.transferClass p:first-child
{
font-family: 'PT sans', sans-serif;
text-align:center;
font-size:20px;
margin-top:20px;
}
.transferClass p:nth-child(2)
{
font-family: 'PT sans', sans-serif;
text-align:center;
font-size:16px;
margin-top:40px;
}
.transferClass form
{
display:flex;
justify-content:center;
margin-top:40px;
}
.transferClass input[type=text]
{
margin-right:20px;
border:1px solid #D7244C;
border-radius:2px;
font-family: 'PT sans', sans-serif;
height:35px;
width:300px;
text-align:center;
}
.deleteClass
{
width:100%;
display:flex;
justify-content:center;
flex-direction:column;
display:none;
}
.deleteClass p:first-child
{
font-family: 'PT sans', sans-serif;
text-align:center;
font-size:20px;
margin-top:20px;
}
.deleteClass form
{
display:flex;
justify-content:center;
margin-top:40px;
}
.deleteClass form input[type=submit]
{
padding-left:40px;
padding-right:40px;
margin-top:40px;
}
</style>
<script>
$(document).ready(function(){
	$(".ps").css({"background":"#ffffff"});
	$(".ps").click(function(){
		$(this).css({"background":"#ffffff"});
		$(".privacySetting").css({"display": "flex"});
		$(".subAdmin,.transferClass,.deleteClass").css({"display": "none"});
		$(".sa,.ts,.dc").css({"background":"#f4f4f4"});
	});
	$(".sa").click(function(){
		$(this).css({"background":"#ffffff"});
		$(".subAdmin").css({"display": "flex"});
		$(".privacySetting,.transferClass,.deleteClass").css({"display": "none"});
		$(".ps,.ts,.dc").css({"background":"#f4f4f4"});
	});
	$(".ts").click(function(){
		$(this).css({"background":"#ffffff"});
		$(".transferClass").css({"display": "flex"});
		$(".privacySetting,.subAdmin,.deleteClass").css({"display": "none"});
		$(".sa,.ps,.dc").css({"background":"#f4f4f4"});
	});
	$(".dc").click(function(){
		$(this).css({"background":"#ffffff"});
		$(".deleteClass").css({"display": "flex"});
		$(".privacySetting,.subAdmin,.transferClass").css({"display": "none"});
		$(".sa,.ts,.ps").css({"background":"#f4f4f4"});
	});
	
});
</script>
</head>
<body>
<div class="settingSelect">
<ul class="setingSwitch">
<li class="ps"><a><img src="class/privacy.gif">Privacy Settings</a></li>
<li class="sa"><a><img src="class/admin.gif">Sub Admin</a></li>
<li class="ts"><a><img src="class/transfer.gif">Transfer Class</a></li>
<l class="dc"><a><img src="class/delete.gif">Delete</a></li>
</ul>
<div class="privacySetting" >
<p>Privacy Setting</p>
<div class="privacy_form_wrapper">
<form id="privacySettingForm">

<table><tr><td width="50%">Who can ask question in your class</td>
<td width="25%"><input id="Anyone_can_ask" name="questionPermission" type="radio" value="1">
<label for="Anyone_can_ask" class="css-label radGroup2">Subscribers</label></td><td width="25%">
<input id="MemberOfClass_can_ask" name="questionPermission" type="radio" value="0">
<label for="MemberOfClass_can_ask" class="css-label radGroup2">Members of class</label></td></tr></table><br>

<table><tr>
<td width="50%">Who can write article your class</td>
<td width="25%"><input id="Anyone_can_view" name="viewingPermission" type="radio" value="1" >
<label for="Anyone_can_view" class="css-label radGroup2"> Subscribers</label></td><td width="25%">
<input id="MemberOfClass_can_view" name="viewingPermission" type="radio" value="0">
<label for="MemberOfClass_can_view" class="css-label radGroup2">Members of class</label></td></tr></table><br>

<table><tr>
<td width="50%">Who can give answer in your class</td>
<td width="25%"><input id="Anyone_can_give" name="answerPermission" type="radio" value="1">
<label  for="Anyone_can_give" class="css-label radGroup2">Subscribers</label></td><td width="25%">
<input id="MemberOfClass_can_give" name="answerPermission" type="radio" value="0">
<label for="MemberOfClass_can_give" class="css-label radGroup2"> Members of class</label></td></tr></table><br>
<button type="submit"  id="privacy_setting_Form_submit_button" data-dismiss="modal" class="submit">Submit</button>
</form>
</div>
</div>



<div class="subAdmin">
<p>Sub Admin</p>
<p>Enter the email account connected with us to add as Sub Admins.</p>
<form>
<input type="text" placeholder="Email">
<input type="submit" class="button-one" value="DONE">
</form>
</div>


<div class="transferClass">
<p>Transfer Class</p>
<p>Enter the email account connected with us to add as Sub Admins.</p>
<form>
<input type="text" placeholder="Email">
<input type="submit" class="button-one" value="DONE">
</form>
</div>


<div class="deleteClass">
<p>Delete Class</p>
<form>
<input type="submit" class="button-one" value="Delete Class">
</form>
</div>

</div>

</body>
</html>