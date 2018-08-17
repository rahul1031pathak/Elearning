<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <style type="text/css">
  
  .spinner {
    position: fixed;
    top: 300px;
    left: 450px;
    margin-left: -80px; /* half width of the spinner gif */
    margin-top: -50px; /* half height of the spinner gif */
    text-align:center;
    z-index:1234;
    overflow: auto;
    width: 60%; /* width of the spinner gif */
    height: 60%; /*hight of the spinner gif +2px to fix IE8 issue */
}
  </style>
  
</head>
<body>
<script>
$("document").ready(function(){
      $("#spinner").bind("ajaxSend", function() {
            $(this).show();
        }).bind("ajaxStop", function() {
            $(this).hide();
        }).bind("ajaxError", function() {
            $(this).hide();
        });
     
       
    
});
</script>
<div id="spinner" class="spinner" style="display:none;">
    <img id="img-spinner"   style="height:80px; max-width:80px;background-color:#d2d2d2;" src="images/Loader.gif" alt="Loading"/>
</div>
</body>
</html>