<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <style>
	
	.modal-content{
			-webkit-border-radius: 0px;
            -moz-border-radius: 0px;
            border-radius: 0px; 
			box-shadow:none;
		    background:#eee; 
		    max-width:500px;
		    width:100%;
		
		   
		}  
	  .modal-content .modal-body h2{
			color:white;
			background:#266b91;
			text-align:center;
			margin-top:-15px;
		    font-weight: 100;
		    font-size:20px;
		    font-family:"Roboto",sans-serif;
			margin-left:-15px;
			margin-right:-15px;
			padding:5px 0px 8px 0px;
		}
	  .modal-content .modal-body .close{
			position:absolute;
			top:0px;
			right:0px;
			opacity:1;
		   -webkit-transition:ease 0.25s all;
            transition:ease 0.25s all;
           -webkit-transform:translate(50%, -50%);
            transform:translate(50%, -50%);
            line-height:100%;
		}
	  .modal-content .modal-body .close:hover
	  {
		  -webkit-transform:translate(50%, -50%) rotate(180deg);
          transform:translate(50%, -50%) rotate(180deg);
	  }
	 
	  .form-wrapper{
		  display:flex;
		  flex-direction: column;
		  justify-content: center;
		  margin:1px auto;
		  padding-left:20px;
		padding-right:20px;
		  
	  }
	  .form-wrapper p
	  {
		  padding:0;
		  margin:0;
		  font-family:Roboto,Tahoma;
		  font-size:16px;
		  padding:8px 0px 5px 0px;
	  }
	  .classroombutton{
			width:100px;
			margin:10px auto;
			color:#fff;
	        cursor: pointer;
	        font-family:"Roboto",sans-serif;
	        border:none;
            background-color:#339cf5;
            font-size:18px;
            padding:5px 5px 3px 5px;
			box-shadow: 0 1px 4px rgba(0, 0, 0, .6);
		}
		.classroombutton:hover{background-color:#2f87d1;color:#fff;}
        .classroombutton:active,.classroombutton:focus{background-color:#2f87d1;color:#fff;}
	  #aboutclassroom,#Classname
	  {
		  height:35px;
		  padding-left:5px;
		  font-family:Roboto,Tahoma;
		  font-size:16px;
		  border:none;
	  }
	  #aboutclassroom{height:100px;}
	  #Classname:focus, #aboutclassroom:focus{
	      transition:all 0.2s;  
		  border:1px solid #00b9f5;
		  outline:#00b9f5!important;
	  }
	</style>	  
</head>
<body>

<div id="form-content"  class="modal fade">
   <div class="modal-dialog" id="mdialog"  role="dialog">
   <div class="modal-content">
        
		<div class="modal-body">
		<img src="images/cancel.svg" class="close" data-dismiss="modal" width="20px" height="20px">
          <h2 class="modal-title">CREATE CLASSROOM</h2>
   <form  class="contact" id="createclassroomform">
    <div class="form-wrapper" >
		<p>Class Subject</p>
		<input type="text" name="ClassName" id="Classname" placeholder="Enter ClassName" required/>
		<p>Objective of this class</p>
		 <textarea  id="aboutclassroom" placeholder="write some discription about this class" name="sug" required> 
		 </textarea>

   <button class="btn classroombutton" id="submit">Submit</button>
			  </div>
	</form>

 </div>
</div>
</div>
</div>  
</body>
</html>