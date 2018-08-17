<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Search Results</title>
<link rel="stylesheet" href="Search.css?version=0" type="text/css" >
</head>
<body>

<div id="wrapp_all">
  <div class="dropdown">  
<form action="Search" id="DropDownFilterSelect" method="get">  
    <select name="SelectFilter" class="dropdown-select">
	                       		<option value="TeacherName">Teacher Name</option>
								<option value="Institution">Institution</option>
								
							
    </select>
	 </div>
   

 <input type="text" name="searchbox" id="searchinput" placeholder="Search..." required="required">
 <input type="submit" id="searchsubmit"value="Search">
</form>
</div>




</body>
</html>