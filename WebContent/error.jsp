<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Something went wrong</title>
<style>
#error{
position:relative;
    float:left;
	hight: 150px;
    width: 196.721px;
	margin-left:40.8%;
	margin-top: 3%;
	}
#sorry{
      position:relative;
      color:#000000;
	  font-size:30px;
	  font-family:Comic sans MS;
	  margin-left:-137px;
	  top:195px;
      }	
#message{
      position:relative;
      color:#000000;
	  font-size:30px;
	  font-family:Comic sans MS;
	  margin-left:-400px;
	  top:230px;
      }	
</style>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">


<img src="images/error.gif" id="error"  alt="animation">
<label id="sorry">Sorry !</label>
<label id="message">The page you were looking for cannot be found.</label>
</body>
</html>