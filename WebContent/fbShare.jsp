<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>



<script type="text/javascript">
$(document).ready(function(){
$('#share_button').click(function(e){
e.preventDefault();

var url='https://www.studyfromweb.com/class?id='+ ${requestScope.ClassId};

var description1='Subject : ${requestScope.CLASSNAME}  ,'+'  Details  : '+'${requestScope.DISCRIPTION}     ,'+'  followers:${requestScope.ADMINFOLLOWERS}';
//var imageURL='${requestScope.ADMINIDIMAGE}';
var imageURL="d1v0zurmr84n8z.cloudfront.net/globe.png"
var description2='email :${requestScope.ADMINEMAIL}     , '+'            institution:${requestScope.ADMININSTITUTION}  , '+'  followers:${requestScope.ADMINFOLLOWERS}'
var description="Hello friends this is my classroom on www.studyfromweb.com , Join this classroom to enhance and share your knowledge .. ..  "+description1;
var caption="click here to visit this classroom"
FB.ui(
{
method: 'feed',
name: 'Welcome  to  www.studyfromweb.com',
link: url,
picture: imageURL,
caption: caption,
description: description,

});
});









function fbQuestionShare(description,quesId){

	var url='https://www.studyfromweb.com/AnswerFetcher?quesId='+quesId+'&ClassId=${requestScope.ClassId}';

	
	var imageURL="d1v0zurmr84n8z.cloudfront.net/globe.png"
	var description=description;
	var caption="click here to visit this classroom"
	FB.ui(
	{
	method: 'feed',
	name: 'Welcome  to  www.studyfromweb.com',
	link: url,
	picture: imageURL,
	caption: caption,
	description: description,

	});
}



function fbQuestionShareImage(description){

	var url='https://www.studyfromweb.com/AnswerFetcher?quesId=${requestScope.quesId}&ClassId=${requestScope.ClassId}';

	
	var imageURL=description;
	var description='';
	var caption="click here to visit this classroom"
	FB.ui(
	{
	method: 'feed',
	name: 'Welcome  to  www.studyfromweb.com',
	link: url,
	picture: imageURL,
	caption: caption,
	description: description,

	});
}




});
</script>

</body>
</html>