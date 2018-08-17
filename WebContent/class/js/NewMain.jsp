<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>



var app = angular.module('mainClass', ['ui.router', 'ui.router.stateHelper','ngSanitize']);

angular.module('mainClass').run(['$rootScope', function($rootScope){
    $rootScope.baseUrl= window.location.href.split('#')[0];
    var baseUrl=window.location.href.split('#')[0];
    
   $rootScope.ISCLASSADMIN = '${requestScope.ISCLASSADMIN}';
   
    
}])



    
app.config(function(stateHelperProvider,$urlRouterProvider){
	
	$urlRouterProvider.when('/home','/home/Questions');
	$urlRouterProvider.when('/followers','/followers/members');
	$urlRouterProvider.when('','/home/Questions');
	$urlRouterProvider.otherwise('/home/Questions');
	  stateHelperProvider.state({
		    name: 'home',
	    url: '{path:/home|}',  //{path:/home|}
	 // abstract:true,
	   
	    views: {
            'MainClass': {
            	//controller : 'questionCtrl',
            	 templateUrl: 'class/myclass.jsp',
             	  
            },
            'classDetails': {
            	 templateUrl: 'class/ClassDetailsForPage.jsp',
             	 // controller : 'classDetailsCtrl',
            }
        },  
	    
	    children: [
	      {
	        name: 'Questions',
	        url: '/Questions',
	     
	      
	            	    views: {
	                        'main': {
	                        	//controller : 'questionCtrl',
	                        	 templateUrl: 'class/QuestionList.jsp',
	                         	  
	                        }
	                    },   
	
	      },
	       {
		        name: 'Articles',
		        url: '/Articles',
		        views: {
                    'main': {
                    	//controller : 'questionCtrl',
                    	templateUrl: 'class/Article.jsp',
                     	            }
                },   

		        },
		      {
			        name: 'Videos',
			        url: '/Videos',
			        views: {
	                    'main': {
	                    	//controller : 'questionCtrl',
	                    	  templateUrl: 'class/youtubeVideoList.jsp',
	                     	  
	                    }
	                },   

			      }
			 
	    ]
	  
	  } )
	  
	    .state({
          name: 'followers',
          url: '/followers',
          
          views: {
              'MainClass': {
              	//controller : 'questionCtrl',
            	  templateUrl: 'class/followers.jsp'
               	  
              },
              'classDetails': {
              	 templateUrl: 'class/ClassDetailsForPage.jsp',
               	 // controller : 'classDetailsCtrl',
              }
          },
          
          children: [
           	      {
           	        name: 'members',
           	        url: '/members',
           	     
           	      
           	            	    views: {
           	                        'followers': {
           	                        	//controller : 'questionCtrl',
           	                        	 templateUrl: 'class/MembershipList.jsp',
           	                         	  
           	                        }
           	                    },   
           	
           	      },
           	       {
           		        name: 'subscribers',
           		        url: '/subscribers',
           		        views: {
                               'followers': {
                               	//controller : 'questionCtrl',
                               	templateUrl: 'class/SubscriberList.jsp',
                                	            }
                           },   

           		        }
           		     
           	    ] 
          
         
      })
      
          .state({
          name: 'notice',
          url: '/notice', views: {
              'MainClass': {
                	//controller : 'questionCtrl',
            	  templateUrl: 'class/notice.jsp',
                 	  
                },
                'classDetails': {
                	 templateUrl: 'class/ClassDetailsForPage.jsp',
                 	 // controller : 'classDetailsCtrl',
                }
            },  
            
         
      })
        .state({
        	  name: 'settings',
		       url: '/settings',
          views: {
              'MainClass': {
                	//controller : 'questionCtrl',
            	  templateUrl: 'class/setting.jsp',
                 	  
                },
                'classDetails': {
                	 templateUrl: 'class/ClassDetailsForPage.jsp',
                 	 // controller : 'classDetailsCtrl',
                }
            },  
            
         
      })
  
	     
	 
	});


// class details
app.controller('classDetailsCtrl', function($scope, $http) {
	//console.log("hello");
	   $scope.classId = '${requestScope.ClassId}';
	   $scope.CLASSNAME = '${requestScope.CLASSNAME}';
	   $scope.CLASSADMINNAME = '${requestScope.CLASSADMINNAME}';
	   $scope.CLASSADMINID= '${requestScope.CLASSADMINID}';
	   $scope.ISCLASSADMIN = '${requestScope.ISCLASSADMIN}';
	});
	
//////	
	
	// question List //
	app.controller('questionCtrl', ['$scope','$http',
                               function ($scope, $http)  {
	
	   $scope.questionList = [];
	   $scope.LoginUser = '${sessionScope.USERID}';
	 
	   $scope.ISCLASSADMIN = '${requestScope.ISCLASSADMIN}';
		 $scope.ISSUBADMIN = '${requestScope.is_subAdmin}';
		  $scope.CLASSNAME=  angular.element(document.getElementById('classDetailsCtrl')).scope().CLASSNAME;
		   $scope.CLASSADMINNAME= angular.element(document.getElementById('classDetailsCtrl')).scope().CLASSADMINNAME;
		  
		 // console.log(" $scope.CLASSNAME"+ $scope.CLASSNAME +$scope.LoginUser);
		 //  console.log(" $scope.CLASSADMINNAME"+ $scope.CLASSADMINNAME);
	   $scope.ClassId =	 angular.element(document.getElementById('classDetailsCtrl')).scope().classId;
	   $scope.rahul='';
	   $scope.refQuestResult=[];
	   $scope.loadQuestionList= function () {
	      
	       	   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};

	       $http({
	        method : "GET",
	        url : "Fetch_QuestionList",
	        params: data
	    }).then(function mySucces(response) {
	    	
	    	 $scope.questionList = response.data;
	   		
	   		$('#spinner').hide();
	    }, function myError(response) {
	    	alert("fail");
	      
	    });
		  // alert("finish");
	    };
	   
	    
	    angular.element(document.getElementById('questionAngular')).scope().loadQuestionList(); // for loading first time
	    
	    
		  $scope.getUrlfriendlyString= function (string) {
			  
			    var newtext= string.replace(/<\/?[^>]+(>|$)/g, "-")
		        .toLowerCase()
		        .replace(/[^\w ]+/g,'')
		        .replace(/ +/g,'-')
		        ;
			//   console.log(newtext);
			    return newtext;
			    };

	    $scope.FormSubmit=function(obj){
	    	   $('#spinner').show();
			
			var formdata= $(obj.target).serializeArray();
		  var userName=angular.element(document.getElementById('headerappCtrl')).scope().user.fullname;
				  
	formdata.push({name: 'class_id', value: angular.element(document.getElementById('classDetailsCtrl')).scope().classId});
			 formdata.push({name: 'refrenceFrom', value:'question'});
			 formdata.push({name: 'userName', value:userName});
		   $http({
				        method : "post",
				        url : "Refrence_Adder",
				       data: $.param(formdata),
				     // params:{ refrenceTO:'question'},
				      //   cache: false,
				    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
				    }).then(function mySucces(response) {
				    	  $('#spinner').hide();
				    	  $(obj.target).parent().hide();
				    	
				    }, function myError(response) {
				    	  $('#spinner').hide();
				    	
				    });
				   
	 		    return false;
	    };
	    
	    
	    
	    $scope.UpdateQuesRef=function(data){
	    	$scope.refQuestResult=data;
	    	console.log($scope.refQuestResult);
	    	console.log($scope.refQuestResult.Ques_Ref_Ques_list);
	    };
	    
		   $scope.appendHtml= function (append) {
		      console.log(append);
			   $(this).html(append);
		    };
	   
		    $scope.fbQuestionShare= function (des,quesId) {
			     
			      var url='https://www.studyfromweb.com/AnswerFetcher?quesId='+quesId+'&ClassId='+angular.element(document.getElementById('classDetailsCtrl')).scope().classId;
console.log(url);
			  	
			  	var imageURL="d1v0zurmr84n8z.cloudfront.net/globe.png" ;
			  		var strippedText = $("<div/>").html(des).text();
			  	var description="Question content : "+strippedText;
			  	
			 
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
			    };
	   
	   
			    
			    
			    
			    
			    $scope.fbQuestionShareImage= function (description,quesId) {
				      var url='https://www.studyfromweb.com/AnswerFetcher?quesId='+quesId+'&ClassId='+angular.element(document.getElementById('classDetailsCtrl')).scope().classId;

			    	var imageURL="https://d1v0zurmr84n8z.cloudfront.net/"+description;
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
			    
			    };
			    
			    
	   
	}]);


////////// article	
	
	app.controller('articleCtrl', ['$scope','$http',
                               function ($scope, $http)  {
	   $scope.articleList = [];
	   $scope.refArticleResult=[];
	   $scope.LoginUser = '${sessionScope.USERID}';
	   $scope.ISCLASSADMIN = '${requestScope.ISCLASSADMIN}';
		 $scope.ISSUBADMIN = '${requestScope.is_subAdmin}';
	/*   $http({
	        method : "POST",
	        url : "Fetch_ArticleList"
	    }).then(function mySucces(response) {
	    	//alert("success");
	    	 $scope.articleList = response.data;
	    	
	    	 console.log(response.data); 
	    
	    		
	    }, function myError(response) {
	    	alert("fail");
	       // $scope.myWelcome = response.statusText;
	    });  */
	  
	   $scope.loadArticleList= function () {
	       	   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};
	       $http({
	        method : "GET",
	        url : "Fetch_ArticleList",
	        params: data
	    }).then(function mySucces(response) {
	    	//alert("success");
	    	 $scope.articleList = response.data;
	    	
	    	 console.log(response.data); 
	    
	    		
	    }, function myError(response) {
	    	alert("fail");
	       // $scope.myWelcome = response.statusText;
	    });
		  // alert("finish");
	    };
	    
	    
	    angular.element(document.getElementById('articleAngular')).scope().loadArticleList();// for first time load
	    
	    $scope.FormSubmit=function(obj){
	    	   $('#spinner').show();
			
			var formdata= $(obj.target).serializeArray();
		  var userName=angular.element(document.getElementById('headerappCtrl')).scope().user.fullname;
				  
	formdata.push({name: 'class_id', value: angular.element(document.getElementById('classDetailsCtrl')).scope().classId});
			 formdata.push({name: 'refrenceFrom', value:'article'});
			 formdata.push({name: 'userName', value:userName});
		   $http({
				        method : "post",
				        url : "Refrence_Adder",
				       data: $.param(formdata),
				     // params:{ refrenceTO:'question'},
				      //   cache: false,
				    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
				    }).then(function mySucces(response) {
				    	  $('#spinner').hide();
				    	  $(obj.target).parent().hide();
				    	
				    }, function myError(response) {
				    	  $('#spinner').hide();
				    	
				    });
				   
	 		    return false;
	    };
	    
	   
	}]);
	
	
	
	///////// shared videos
	
	app.controller('YoutubeListCtrl', ['$scope','$http','$sce',
                              function ($scope, $http,$sce)  {
	   $scope.YoutubeList = [];
	   $scope.refVideoResult= [];
	   $scope.trustSrc = function(src) {
		   
		  
		  
		  var videoid = src.match(/(?:https?:\/{2})?(?:w{3}\.)?youtu(?:be)?\.(?:com|be)(?:\/watch\?v=|\/)([^\s&]+)/);
		  if(videoid==null){
			  src="https://www.youtube.com/embed/"+src;  
		  }else{
			  src="https://www.youtube.com/embed/"+videoid[1]; 
		  }
		  
		   
		   console.log(src);
	        return $sce.trustAsResourceUrl(src);
	        }
	   $scope.trustSrcList = function(src) {
		   src="https://www.youtube.com/embed/?"+src;
	        return $sce.trustAsResourceUrl(src);
	        }
	   
	   
	   
	   
		
	   $scope.FormSubmit=function(obj){
	   	   $('#spinner').show();
	   	
	   	var formdata= $(obj.target).serializeArray();
	   var userName=angular.element(document.getElementById('headerappCtrl')).scope().user.fullname;
	   		  
	   formdata.push({name: 'class_id', value: angular.element(document.getElementById('classDetailsCtrl')).scope().classId});
	   	 formdata.push({name: 'refrenceFrom', value:'video'});
	   	 formdata.push({name: 'userName', value:userName});
	   $http({
	   		        method : "post",
	   		        url : "Refrence_Adder",
	   		       data: $.param(formdata),
	   		     // params:{ refrenceTO:'question'},
	   		      //   cache: false,
	   		    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	   		    }).then(function mySucces(response) {
	   		    	  $('#spinner').hide();
	   		    	  $(obj.target).parent().hide();
	   		    	
	   		    }, function myError(response) {
	   		    	  $('#spinner').hide();
	   		    	
	   		    });
	   		   
	   	    return false;
	   };
	   	
	   
	   
	   
	   
	   
	   
	   $scope.loadYoutubeList= function () {
       	   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};

	  $http({
	        method : "GET",
	        url : "Fetch_YoutubeVideoList",
	        params: data
	    }).then(function mySucces(response) {
	    	 $scope.YoutubeList = response.data;
	    	 console.log(response.data);
	    	 
	    		
	    }, function myError(response) {
	    	
	    }); 
	   
	   };
	   angular.element(document.getElementById('YoutubeListCtrl')).scope().loadYoutubeList();
	}]);
	
	
	
	
///membership list

app.controller('membershipCtrl',  ['$scope','$http',
                                   function ($scope, $http)  {
	   $scope.memberList = [];
	//   $scope.ISCLASSADMIN = angular.element(document.getElementById('classDetailsCtrl')).scope().ISCLASSADMIN;
	   
$scope.memberShipList= function () {
	   
	   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};
	   $http({
	        method : "GET",
	        url : "Fetch_MembershipList",
	        params: data
	    }).then(function mySucces(response) {
	    	 $scope.memberList = response.data.userlist;
	    	
	    	 console.log(response.data.userlist);
	    }, function myError(response) {
	        $scope.myWelcome = response.statusText;
	    });
 

};


angular.element(document.getElementById('membershipCtrl')).scope().memberShipList();

  
}]);


// subscriber list
app.controller('subscriberCtrl',  ['$scope','$http',
                                   function ($scope, $http)  {
	   $scope.memberList = [];
	   $scope.ISCLASSADMIN = angular.element(document.getElementById('classDetailsCtrl')).scope().ISCLASSADMIN;
$scope.subscriberList= function () {
	   var classid='${param.ClassId}';  
	console.log(classid);
	   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};
	   $http({
	        method : "GET",
	        url : "Fetch_Subscriber_List",
	        params: data
	    }).then(function mySucces(response) {
	    	 $scope.memberList = response.data.userlist;
	    	
	    	 console.log(response.data.userlist);
	    }, function myError(response) {
	        $scope.myWelcome = response.statusText;
	    });
 

};


angular.element(document.getElementById('subscriberCtrl')).scope().subscriberList();

}]);
	
	
	
	
	
	
</script>
</body>
</html>