<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>



<style>
* {
   -webkit-box-sizing: border-box;
   -ms-box-sizing: border-box;
   -moz-box-sizing: border-box;
  }
.wrap{
	border:1px;
    position:relative;
	height: 100%;
	
	background-color:#F4F4F4;
	width:100%;
	
	overflow:auto;
    }
.wrap:after {
    content: "";
    clear: both;
    display:block;
            }
.second{
	width:100%;
	float:left;
	padding:15px;

	min-height:100px;
	height:auto;
	border-left:1px;
	border-right:1px;
	background-color:#F4F4F4;
	 box-shadow: 0 8px 40px rgba(0,0,0,0.12), 0 8px 40px rgba(0,0,0,0.24);
      }		
#qn	{
	background-color:#a5d5f6;
	width:100%;
	height:auto;
	
	overflow:auto;
	font-size:16px;
    }
#ans{
	
	overflow:auto;
	width:100%;
	height:auto;
	
	font-size:16px;
    }	
	p{
   margin: 0 !important;
     }	
	 a:link {
    text-decoration: none;
}

a:visited {
    text-decoration: none;
}

a:hover {
    text-decoration:none;
}

a:active {
    text-decoration:none;
         }
		 @media only screen and (max-width: 600px) {
    .second {
         width:100%;
		 padding:3px;
    }
	 .first {
         width:0%;
    }
	 .third {
         width:0%;
    }
}
hr {
    display: block;
    height: 1px;
    border: 0;
    border-top: 1px solid #ccc;
    margin: 1em 0;
    padding: 0; 
}
</style>
 
</head>
<body>

<!-- BackToTop Button -->
<a href="javascript:void(0);" id="scroll" title="Scroll to Top" style="display: none;">Top<span></span></a>

<div class="wrap" id="articleApp" ng-app="article" >
<div id="questionAngular" ng-controller="articleCtrl">




<div class="article" id="" ng-repeat="article in articleList">

<b>TOPIC: {{article.topic}}
<br>Subtopic : {{article.subtopic}}
</b>
<p id="ans">
<div ng-if="article.is_pic == '0' ">
<br> 
content:  {{article.article_content}}

<a ng-href="#"   class="delete_saved_article"  ><img class="cross" data-id="{{article.article_id}}" src="images/3.png" ></a>
	</div>				

<div ng-if="article.is_pic == '1' ">
<br> <img ng-src="https://datv3d2em9nfj.cloudfront.net/{{article.article_content}}"  >
<a ng-href="#"   class="delete_saved_article"  ><img class="cross" data-id="{{article.article_id}}" src="images/3.png" ></a>
</div>




 </p>
<p><b>Written by :</b>{{article.article_writer_name}}</p>
<p><b>On:</b>{{article.dateTime}}</p>
<hr>
</div>

 
 </div>
</div>


  <script type="text/javascript">
    // when user want to leave subscribed classroom  
    // $(document).ready(function(){
   // $('.delete_article').click(function(){
    	
    // });
    </script> 



 
 <script type="text/javascript">
//function loadpeople(){
	
	
	
 var app = angular.module('article', []);
 app.controller('articleCtrl', ['$scope','$http',
                               function ($scope, $http)  {
	   $scope.articleList = [];
	  
	   $http({
	        method : "POST",
	        url : "Fetch_Saved_Articles"
	    }).then(function mySucces(response) {
	    	
	    	 $scope.articleList = response.data;
	    		
	    }, function myError(response) {
	    	alert("fail");
	       // $scope.myWelcome = response.statusText;
	    });
	   
	  
	   
	   
	   
	}]);
 
 //angular.bootstrap(document.getElementById("articleApp"), ['article']);
//}
 </script>
<script>

$( "body" ).delegate( ".delete_saved_article", "click", function() {
	var articleId=$(event.target).attr("data-id");
	
	angular.element(event.target).parent().parent().remove();

	alert(articleId);
	$.ajax({
		 type: "POST",
		 url: "Delete_Saved_Items",
		 dataType: "json",
		 cache: false,
		 data: {articleId:articleId,flag:"article"},
		         success: function(data){
		    
		     
		        	if(data.b=="true"){
		        	
		     
		        	}
  		        	  
  		        	  
  		          
		        	          
		         }, // end of success function
		 error: function(){
			 alert("fail");
		
	
		
			
		 }
		 
		 });  
	
	return false; });
	
	
	





</script>
</body>
</html>