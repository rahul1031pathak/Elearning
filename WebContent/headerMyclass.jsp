<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style>
	.headerrr
{
position:fixed;
top:0;
	width:100%;
	height:70px;
    box-sizing: border-box;
	background-color:#266b91;
	
	display:flex;
	justify-content:left;
	        z-index:100;
}

.searchbarr{
    position:relative;
    display:block;
    text-align:center;
    width:60%;
    height:70px;
    background:transparent;
    
      }
      .wrapperr{
          position:relative;
          width:100%;
          display:flex;
          justify-content: center;
          
      }
      input.header-search-inputt {
    position:relative;
    padding-left:34px;
    max-width:600px;
    width: 100%;
    background: rgba(255,255,255,0.25);
    height:40px;
    font-size: 16px;
    appearance: textfield;
    font-weight: 100;
    outline: none;
    border:none!important;
    border-radius:3px;
}
      input.header-search-inputt:active,
      input.header-search-inputt:focus {
      background: rgba(255,255,255,0.25);
      color: #fff;

}
      .searchbarIcon{
          position:relative;
          margin-top:10px;
          width:20px;
          height:20px;
          margin-right:-27px;
          color:#fff;
          font-weight: 100;
          background:transparent;
      } 
      
input.header-search-inputt::-webkit-input-placeholder {
    padding-left:6px;
    color:#fff;
	font-size:16px;
	font-family:Roboto;
	
}
input.header-search-inputt:-moz-placeholder { /* Firefox 18- */
    padding-left:0px;
    color:#fff;
	font-size:16px;
	font-family:Roboto;
}
 
input.header-search-inputt::-moz-placeholder {  /* Firefox 19+ */
    padding-left:0px;
    color:#fff;
	font-size:16px;
	font-family:Roboto;
}
 
input.header-search-inputt:-ms-input-placeholder {  
    padding-left:0px;
    color:#fff;
	font-size:16px;
	font-family:Roboto;
}
.control {
  display:inline;
  color:#fff;
  position: relative;
  font-family: 'Roboto', sans-serif;
  padding-left:20px;
  margin-top:0px;
    font-weight: 500;
  cursor: pointer;
  font-size:12px;
}
.control input {
  position: absolute;
  z-index: -1;
  opacity: 0;
}
.control__indicator {
  position: absolute;
  top: 2px;
  left: 0;
  height: 12px;
  width:12px;
  background: #e6e6e6;
}
.control--radio .control__indicator {
  border-radius: 50%;
}
.control:hover input ~ .control__indicator,
.control input:focus ~ .control__indicator {
  background: #ccc;
}
.control input:checked ~ .control__indicator {
  background: #2aa1c0;
}
.control:hover input:not([disabled]):checked ~ .control__indicator,
.control input:checked:focus ~ .control__indicator {
  background: #0e647d;
}

.control__indicator:after {
  content: '';
  position: absolute;
  display: none;
}
.control input:checked ~ .control__indicator:after {
  display: block;
}

.control--radio .control__indicator:after {
  left: 3px;
  top: 3px;
  height: 6px;
  width: 6px;
  border-radius: 50%;
  background: #fff;
}




</style>
</head>
<body>

  <div class="headerrr">  
  <img src="images/logo.gif" width="178" height="70">     
        <div class="searchbarr">
    <form method="get" target="_blank"action="Search">
        <label class="control control--radio">Teacher name
      <input type="radio" name="SelectFilter" value="TeacherName" checked="checked"/>
      <div class="control__indicator"></div>
    </label>
    <label class="control control--radio">Institution
      <input type="radio"name="SelectFilter" value="Institution"/>
      <div class="control__indicator"></div>
    </label>
        <label class="control control--radio">Email
      <input type="radio"name="SelectFilter" value="Email"/>
      <div class="control__indicator"></div>
    </label>
    <div class="wrapperr">
        <img src="images/icon-search.svg" class="searchbarIcon">
    <input type="text" id="searchinput" name="searchbox" class="header-search-inputt" placeholder="Enter Keyword">
    </div>
    </form>
    </div>
    </div>
	




</body>
</html>