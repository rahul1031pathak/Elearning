<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
            <%@page import="structure.classroom.FinalClassList"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="eng">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Studyfromweb.com">
    <title>Search Result</title>
    <link rel="shortcut icon" href="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/short+logo+for+browser.gif"/>
   
 <script src="js1/jquery-2.2.4.min.js" type="text/javascript"></script>
    <script src="js1/bootstrap.min.js"></script>
    <link rel="stylesheet" href="js1/bootstrap.min.css">
    <link rel="stylesheet" href="js1/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="css/educator.css?version=1365">
   
  </head>
<body>
    <div class="header">
 <%@ include file="headerMyclass.jsp" %>

	</div>
    <div class="main_nav">
<%FinalClassList list=(FinalClassList)request.getAttribute("list"); %>
        		       
<%
    for ( int i = 0; i <  list.classdetailsWithTeacherId.size(); i++ ) {
    	
        %>
        <ul class="flex-box1" >
           <li>
			   <a href=""><img id="profile_pic" src="<%=list.userlistSearch.get(i).getProfilePic() %>"></a></li>
              <li class="dropdown">
              <button class="follow_button">Classroom List</button>
                  <ul class="dropdown-content">

                    <%
    for ( int j = 0; j < list.classdetailsWithTeacherId.get(i).classdetails.size(); j++ ) {
        %>
         
				  <li><a href="ClassRoom?ClassId=<%=list.classdetailsWithTeacherId.get(i).classdetails.get(j).getClass_id()%>" target="_blank"class="" id="<%=list.classdetailsWithTeacherId.get(i).classdetails.get(j).getClass_id()%>"><%=list.classdetailsWithTeacherId.get(i).classdetails.get(j).getClass_name()%></a></li>
			<% } %>	  
				  </ul>
            </li>
        
            <li><%=list.userlistSearch.get(i).getFullname() %></li>
            <li class="ins-field">
				<section class="institution">Institution&#10132;<P><%=list.userlistSearch.get(i).getInstitution()%></P></section>
            </li>
             <li>
				 <section class="interest">Field of <br>Interest&nbsp;&nbsp;&nbsp;&#10132;
             <ul>
				<li><%=list.userlistSearch.get(i).getFoi1() %> </li>
               <li> <%=list.userlistSearch.get(i).getFoi2() %> </li>
              <li> <%=list.userlistSearch.get(i).getFoi3() %> </li>
            </ul>
            </section>
             </li>
              <li>
				  <section class="follower">Followers&#10132;<%=list.userlistSearch.get(i).getNumberOfFollowers() %></section>
            </li> 
        </ul>
<% }%>
    </div> 
	  


    

     <script type="text/javascript">
    // when user clickon class link
     $(document).ready(function(){
    $('.link_of_Class_list_of_given_teacher').click(function(){
    	var ClassId=this.id;
    	
    	$.ajax({
			 type: "POST",
   		 url: "Check_Class_Privacy",
   		 dataType: "json",
   		 cache: false,
   		 data: {ClassId:ClassId},
   		         success: function(data){
   		      //   alert(data.is_classAdmin); working fine
   		      
   		        	if(data.is_classAdmin=="true"){
     		        	  
     		        	  
      		        	 $.ajax({
      	   		 			 type: "POST",
      	   		     		 url: "MyclassroomFetcher",
      	   		     		 cache: false,
      	   		     		 data: {ClassId:ClassId},
      	   		     		         success: function(msg){
      	   		     		          
      	   		     		       
      	   		     		        
      	   		     		        if(msg.b=="true"){  document.location.href='myclass.jsp'}
      	   		     		        
      	   		     		         },
      	   		     		 error: function(){
      	   		     		 
      	   		     		 }
      	   		 			 
      	   		 			 }); 
      		        	  
      		        	  
      		          }
      		        
   		      
   		      
   		      
   		        	else if(data.can_view=="true"){
      		        	 $.ajax({
      		 			 type: "POST",
      		     		 url: "MyclassroomFetcher",
      		     		 cache: false,
      		     		 data: {ClassId:ClassId},
      		     		         success: function(msg){
      		     		          
      		     		     
      		     		        if(msg.b=="true"){  document.location.href='otherclass.jsp'}
      		     		        
      		     		         },
      		     		 error: function(){
      		     		 
      		     		 }
      		 			 
      		 			 }); 
      		        	  
      		        	  
      		          }
   		        	else{alert("you donot have permission ")}
      		       
   		        
   		         }, // end of success function
   		 error: function(){
   			 alert("fail");
   		 }
			 
			 });
    	
	
    	return false; });
     });
    </script>     		        
<Script>
$("document").ready(function(){
	$('.dropdown').hover(function() {
		$(this).children('ul').stop(true, false, true).toggle(300);
	});
	});
</Script>
</body>
</html>