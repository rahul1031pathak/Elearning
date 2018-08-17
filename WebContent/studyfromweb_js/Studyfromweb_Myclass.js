$(document).ready(function(){
    
	
	var app = angular.module('noticesInClass', []);
	app.controller('noticesInClassCtrl', function($scope, $http) {
		   $scope.noticeList = [];
		   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};
		   $http({
		        method : "POST",
		        url : "Fetch_Notice_Of_Class",
		        params: data
		    }).then(function mySucces(response) {
		    	 $scope.noticeList  = response.data;
		    	console.log(response.data);
		    }, function myError(response) {
		       
		    });
		});

	angular.bootstrap(document.getElementById("noticesInClass"), ['noticesInClass']);
	
	
	
	
	
	$('#spinner').show();
	 $("#dialogConfirmation").dialog({
	      autoOpen: false,
	      modal: true
	    });
	
	 
	    $( "body" ).delegate( ".deleteSubAdminButton", "click", function(event) {
	    	
	    		 var id_sub_admin=$(event.target).attr("data-value");
	var sub_admin_user_id=$(event.target).attr("data-flag");
	var class_id=angular.element(document.getElementById('classDetailsCtrl')).scope().classId;

	    		angular.element(event.target).parent().parent().parent().remove(); 

	    	$.ajax({
	    	type: "POST",
	    	url: "Delete_Sub_Admin",
	    	cache: false,
	    	data: {id_sub_admin:id_sub_admin,sub_admin_user_id:sub_admin_user_id,class_id:class_id},
	    	       success: function(data){
	    	      	 if(data.b=="true"){
	    	      		// document.location.href='myclass.jsp'
	    	      	//	angular.element(document.getElementById('subadminCtrl')).scope().subAdminListReload();
	    	      	 }
	    	      	
	    	       },
	    	error: function(){

	    	}

	    	}); 



	    	return false; });
	    
	    
	    
	    
		
		 var app = angular.module('fileUploaded', []);
		 app.controller('fileuploadedList', function($scope, $http) {
			   $scope.fileList = [];
	      	   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};

			   $http({
			        method : "GET",
			        url : "Fetch_UploadedFiles",
			        params: data
			    }).then(function mySucces(response) {
			    	 $scope.fileList = response.data;
			    	
			    }, function myError(response) {
			        $scope.myWelcome = response.statusText;
			    });
		 $scope.fileListReload=function(){
			 

			   $http({
			        method : "GET",
			        url : "Fetch_UploadedFiles",
			        params: data
			    }).then(function mySucces(response) {
			    	 $scope.fileList = response.data;
			    	 
			    }, function myError(response) {
			        $scope.myWelcome = response.statusText;
			    });
		 }
		
		
		});


		 angular.bootstrap(document.getElementById("fileUploaded"), ['fileUploaded']);






	    
	    
	    
	    $( "body" ).delegate( ".DeleteUploadedFile", "click", function(event) {
	  	  //  $('.DeleteUploadedFile').click(function(){
	  	    		var fileId=$(event.target).attr("data-value");
	  	    		angular.element(event.target).parent().parent().parent().remove();
	  				
	  	    	$.ajax({
	  				 type: "POST",
	  	   		 url: "Delete_FileUploaded",
	  	   		 dataType: "json",
	  	   		 cache: false,
	  	   		 data: {fileId:fileId,ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId},
	  	   		         success: function(data){
	  	   		     
	  	   		        	if(data.b=="true"){
	  	   		        	
	  	   		        		angular.element(document.getElementById('fileuploadedList')).scope().fileListReload();
	  	   		        	}
	  	      		        	  
	  	      		        	  
	  	      		          
	  	   		        	          
	  	   		         }, // end of success function
	  	   		 error: function(){
	  	   			 alert("fail");
	  	   		 }
	  				 
	  				 });  	
	  	    	return false; });
	    
	    
	    
	    
	    
   
	    
	    
	    
	    
	    
	    
	    
	    
	 $("#Delete_this_classroom").click(function(){
		 
		   $("#dialogConfirmation").dialog({
			  height: 200,
	            width: 300,
		      buttons : {
		        "Confirm" : function() {
		          
        	 $.ajax({
				 type: "POST",
	    		 url: "Class_Deletor",
	    		data: {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId},
	    		
	    		 cache: false,
	    		    success: function(data){
	    		       document.location.href='Home.jsp'
	    		        },//end of success function
	    		 error: function(){
	    		 alert("fail");
	    		 }
	    		          }); 
	
	      },
		        "Cancel" : function() {
					 
		          $(this).dialog("close");
		        }
		      }
		    });
		      $("#dialogConfirmation").dialog("open");
			  
		  });
	  
	  });  // end of delete classroom function


	 
	 
	 
	 
	$(document).ready(function(){
    $("#Notice_submit_button").click(function(){
    			
    	   $('#spinner').show();
    	    	var notice= $("#notice_Submitted").val();
    	    	var count = $("#notice_Submitted").val().trim().length;
    	    	
    	    	if(count<1){ alert("you have submitted blank notice");}
    	    	else{
    	    		 $.ajax({
    	    			    url : "Notice_Submitter",
    	    			    type: "GET",
    	    			    data : {
    	    			    	notice : notice,ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId
    	    			    },dataType: "json",
    	    			    success: function(data){
    	    			    	//console.log(data);
    	    			     if(data.b=="true"){
    	    			    	 $('#spinner').hide();
    	    			    	 $("#form-content").modal('hide');  
    	    			    	 $('#feednoticeform')[0].reset();
    	    			    	
    	    			    	 
    	    			     }
    	    			     else{
    	    			    	 alert("some error occured plss retry");
    	    			    	 $('#feednoticeform')[0].reset();
    	    			     }
    	    			   	
    	    			    }
    	    			    
    	    			});
    	    		
    	    		
    	    		
    	    	}
    		
  
	});
    });

	
	
	
	
	
	
	
	
	 $(document).ready(function(){
    $('#videoIdSubmit').click(function(){
    	
    	   $('#spinner').show();
    	var is_playlist= $("#PlaylistOrVideo").val();
    	var videoId= $("#VideoIdValue").val();
    	var Content_Of_Video= $("#Content_Of_Video").val();
if(is_playlist==1){
 if (videoId.length) {

            if (/https?\:\/\/www\.youtube\.com\/watch\?v=[A-Za-z0-9_\-]+((&list=[A-Za-z0-9_\-]+(&index=\d+)?)|((&index=\d+)?&list=[A-Za-z0-9_\-]+))/.test(videoId)) {
                result = videoId.split("&")[1];
                
                $.ajax({
       			 type: "POST",
          		 url: "SharedVideos",
          		 dataType: "json",
          		 cache: false,
          		 data: {is_playlist:is_playlist,videoId:result,ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId,Content_Of_Video:Content_Of_Video},
          		         success: function(data){
          		        	 $('#spinner').hide();	
          		     $(".popup").fadeOut(350);
          		   $('#mySelectParagraph').text('shared video');
       			$('#CommonArea').hide();
       			$('#include_Article').hide();
       			$('#include_youtubelist').show(); 
       		 $('#ModalYoutubeVideo').modal('hide');
       		 angular.element(document.getElementById('YoutubeListCtrl')).scope().loadYoutubeList();
       		 
       		 $('#youtubevideoform')[0].reset();
       		 
          		         }, // end of success function
          		 error: function(){
          			alert("fail");
          			 $('#spinner').hide();
          			 $('#ModalYoutubeVideo').modal('hide');
          			 $('#youtubevideoform')[0].reset();
          		 }
       			 
       			 });//end of ajax
               
            } else {
                
             //   result = "invalid input";
             alert("The youtube url is not valid.");
            
             $('#spinner').hide();
             $('#youtubevideoform')[0].reset();
            }
        } else {
            result = "";
        }
      // console.log(result);


}

else if(is_playlist==0){
var videoid = videoId.match(/(?:https?:\/{2})?(?:w{3}\.)?youtu(?:be)?\.(?:com|be)(?:\/watch\?v=|\/)([^\s&]+)/);
if(videoid != null) {
  // console.log("video id = ",videoid[1]);
   
   $.ajax({
			 type: "POST",
		 url: "SharedVideos",
		 dataType: "json",
		 cache: false,
		 data: {is_playlist:is_playlist,videoId:videoid[1],ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId,Content_Of_Video:Content_Of_Video},
		         success: function(data){
		        	 $('#spinner').hide();
		        	 $('#ModalYoutubeVideo').modal('hide');
		     $(".popup").fadeOut(350);
		     $('#mySelectParagraph').text('shared video');
				$('#CommonArea').hide();
				$('#include_Article').hide();
				$('#include_youtubelist').show();
				 angular.element(document.getElementById('YoutubeListCtrl')).scope().loadYoutubeList();
				 $('#youtubevideoform')[0].reset();
		         }, // end of success function
		 error: function(){
			 alert("fail");
			 $('#spinner').hide();
			 $('#ModalYoutubeVideo').modal('hide');
			 $('#youtubevideoform')[0].reset();
		 }
			 
			 });
   
   
} else { 
    alert("The youtube url is not valid.");
    $('#spinner').hide();
    $('#youtubevideoform')[0].reset();
}
}




     });
     });
	 
	 
	 
	 
	 
	 
	 
	 
	  $(document).ready(function(){
    $("#privacy_setting_Form_submit_button").click(function(){
    
    	   $('#spinner').show();
    	var ques = $("input[type='radio'][name='questionPermission']:checked"); //working fine
    	var viewPermission = $("input[type='radio'][name='viewingPermission']:checked");
    	
    	var ans = $("input[type='radio'][name='answerPermission']:checked"); 
    	var question  = ques.val();
    	var answer =ans.val();
    	var view=viewPermission.val();
    	
    	
    	 $.ajax({
			 type: "post",
    		 url: "Privacy_Setter_of_Class",
    		 dataType: "json",
    		 cache: false,
    		 data:{question:question,answer:answer,view:view ,ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId},
    		         success: function(data){
    		        		
    		         
    		         },//end of success function
    		 error: function(){
    		 alert("fail");
    		 }
    		          }); 
    	
    	 
    	 
    	 $('#spinner').hide();
    	 
    	
    });
    });
	
	
	
	
	  $(document).ready(function(){
    	 
	
    	 $("#ask_your_question_here").click(function(){
    		
    		// $('#question_in_text_form')[0].reset();
    		// $('#ask_question_form')[0].reset();     //edited by vicky
    		 tinyMCE.activeEditor.setContent("");
		 $('#AskQuestionModal').modal('show');
    	    });
    
    
     $("#Write_your_Article").click(function(){
    //	 $('#article_in_pic')[0].reset(); //edited by vicky

    	 $('#article_in_text')[0].reset();
    	 tinyMCE.activeEditor.setContent("");

    	 $('#article_in_text')[0].reset();

     	 $('#WriteArticleModal').modal('show');
     });
     
     
 
     
     });
	
	
	
	
$("document").ready(function(){
	//$('#manage_member_ul').load('MembershipList.jsp');
	$('#include_Article').load('Article.jsp');
	$('#include_youtubelist').load('youtubeVideoList.jsp');
	$('#Manage_Member_Ul').load('MembershipList.jsp');
	
	$('#manage_subscriber_ul').load('SubscriberList.jsp');
	$('#CommonArea').load('QuestionList.jsp',function(response, status, xhr){
		  if(status == "error") {
			    ajaxOnFailure(response);
			  } else {
			   // ajaxOnSuccess(response); 
				  angular.element(document.getElementById('questionAngular')).scope().loadQuestionList();
				  $('#CommonArea').data('flag',1);
			  } });
	
	$('#include_Article').hide();
	$('#include_youtubelist').hide();
	$('#Manage_Member_Ul').hide(); 
	$('#switch_to_followers').hide();
	
});	
	
$("document").ready(function(){
	$('.scrollRadioButton').click(function() { 
	//function myFunction() {
		var check=$(this).data("value");
		
//function myFunction() {
	//var check=$("#mySelect").val();

	//function myFunction() {
	//var check=$("#mySelect").val();
	
	if(check=="1"){
		//$('#CommonArea').load('Article.jsp');
		var flag = $('#include_Article').data('flag');
		if(flag=="0"){
		
		$('#CommonArea').hide();
		$('#include_youtubelist').hide();
		$('#include_Article').show();
		
		 angular.element(document.getElementById('articleAngular')).scope().loadArticleList();
		 $('#include_Article').data('flag',1);
		$('#mySelectParagraph').text('Article Shared');
		}
		if(flag=="1"){
			$('#CommonArea').hide();
			$('#include_youtubelist').hide();
			$('#include_Article').show();
			$('#mySelectParagraph').text('Article Shared');
		}
		
		
		
		
		
	}else if(check==0) {
		
		var flag = $('#CommonArea').data('flag');
		if(flag=="0"){
		
		
		
		$('#CommonArea').show();
		$('#include_Article').hide();
		
		$('#include_youtubelist').hide();
		//$('#CommonArea').load('QuestionList.jsp');
		 angular.element(document.getElementById('questionAngular')).scope().loadQuestionList();
		 $('#CommonArea').data('flag',1);
		$('#mySelectParagraph').text('Question Discussed In This class');
		
		
		
		}
		
		else{
			$('#mySelectParagraph').text('Question Discussed In This class');
			$('#CommonArea').show();
			$('#include_Article').hide();
			
			$('#include_youtubelist').hide();
		}
	}
	
	
	
	else {
		var flag = $('#include_youtubelist').data('flag');
		if(flag=="0"){

			$('#CommonArea').hide();
			$('#include_Article').hide();
			$('#include_youtubelist').show();
			$('#mySelectParagraph').text('shared video');
			 angular.element(document.getElementById('YoutubeListCtrl')).scope().loadYoutubeList();
			 $('#include_youtubelist').data('flag',1);
		}
		else{
			$('#mySelectParagraph').text('shared video');
			$('#CommonArea').hide();
			$('#include_Article').hide();
			$('#include_youtubelist').show();
		}
		
	}
	
});

});


	
	
	
	
	
	
	
$("document").ready(function(){
	$('.scrollRadioButton1').click(function() { 
//function goToClassContent() {
		var check=$(this).data("value");
		
		if(check=="0"){
		
			$('#manage_subscriber_ul').hide();
			$('#Manage_Member_Ul').show(); 
			 angular.element(document.getElementById('membershipCtrl')).scope().memberShipList();
			
			$('#mySelectParagraph').text('MemberList');
	
		}else if(check==1) {
		
			$('#manage_subscriber_ul').show();
			$('#Manage_Member_Ul').hide(); 
			//$('#CommonArea').load('QuestionList.jsp');
			 angular.element(document.getElementById('subscriberCtrl')).scope().subscriberList();
			
			$('#mySelectParagraph').text('subscribers');
	}
		else{
			
			 $("#switch_back_to_classContent").show();
				$('#switch_to_followers').hide();
		}
		
	
		
	});
});





$(function() {
    //----- OPEN
    $('[data-popup-open]').on('click', function(e)  {
        var targeted_popup_class = jQuery(this).attr('data-popup-open');
        $('[data-popup="' + targeted_popup_class + '"]').fadeIn(350);
 
        e.preventDefault();
    });
 
    //----- CLOSE
    $('[data-popup-close]').on('click', function(e)  {
        var targeted_popup_class = jQuery(this).attr('data-popup-close');
        $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);
 
        e.preventDefault();
    });
});




function openNav() {
		document.getElementById("fuck").style.width = "400px";
		}
function closeNav() {
		document.getElementById("fuck").style.width = "0";
	}
	
	
	
	
	  $(document).ready(function(){
		
		  $("form#transferClassform").submit(function(event){
			   $("#dialogConfirmation").dialog({
					  height: 200,
			            width: 300,
				      buttons : {
				        "Confirm" : function() {
			  
			   $('#spinner').show();
			   var formData = $(transferClassform).serializeArray();
			   formData.push({name: 'class_id', value: angular.element(document.getElementById('classDetailsCtrl')).scope().classId});
			   console.log(formData);
		    $.ajax({
		    	 url: 'Transfer_Class',
		        type: 'POST',
		        data: formData,
		      
		        success: function (data) {
		        	// location.reload(true);
		        	 $('#spinner').hide();
		        	 $('#transferClassform')[0].reset();
		        	$('.transfer_arrow').hide();
		   		$('.transfer_list').hide();
		   	 $("#dialogConfirmation").dialog("close");
		   	window.location.replace("Home.jsp");
		        },
		      
		    });
				        },
				        "Cancel" : function() {
							 
				          $(this).dialog("close");
				        }
				      }
				    });
				      $("#dialogConfirmation").dialog("open");
					  
			
		    return false;
		});
		 
		  
		  
		  
		  
		  $("form#SubAdminForm").submit(function(event){
	
				   $('#spinner').show();
				   var formData = $(SubAdminForm).serializeArray();
				   formData.push({name: 'class_id', value: angular.element(document.getElementById('classDetailsCtrl')).scope().classId});
				   console.log(formData);
	 		    $.ajax({
	 		    	 url: 'Add_SubAdmin',
	 		        type: 'POST',
	 		        data: formData,
	 		      
	 		        success: function (data) {
	 		        	// location.reload(true);
	 		        	 $('#spinner').hide();
	 		        	 $('#SubAdminForm')[0].reset();
	 		        	$('.add_manager_arrow').hide();
	 		   		$('.add_manager_list').hide();
	 		   	angular.element(document.getElementById('subadminCtrl')).scope().subAdminListReload();
	 		        },
	 		      
	 		    });

	 		    return false;
	 		});
			 
	
    	 
    	 $("form#question_in_text_form").submit(function(e){
    		   $('#spinner').show();
    		 e.preventDefault();
    		
    		 tinyMCE.triggerSave();
    		var formData = $(question_in_text_form).serializeArray();
    		
      		formData.push({name: 'ClassId', value: angular.element(document.getElementById('classDetailsCtrl')).scope().classId});
console.log(formData);



tinymce.activeEditor.uploadImages(function(success) {
	
    $.ajax({
    	 url: 'AskQuestion',
        type: 'POST',
        data: formData,
     
        success: function (data) {
        	  $('#spinner').hide();
			 $('#AskQuestionModal').modal('hide');
			 angular.element(document.getElementById('questionAngular')).scope().loadQuestionList();
        	
        },
        error: function(){
        	  $('#spinner').hide();
				 $('#AskQuestionModal').modal('hide');
    		 }
       
    });
	  });
	




    		    
    		   return false;
    		});
    	 
    	
     
    	 $("form#article_in_text").submit(function(e){
    		   $('#spinner').show();
    		 e.preventDefault();
    		// nicEditors.findEditor('ArticleTextArea').saveContent();
    		 tinyMCE.triggerSave();
      		var formData = $(article_in_text).serializeArray();
      		formData.push({name: 'ClassId', value: angular.element(document.getElementById('classDetailsCtrl')).scope().classId});
    		    $.ajax({
    		    	 url: 'WriteArticle',
    		        type: 'post',
    		        data: formData,
    		     
    		        success: function (data) {
    		            angular.element(document.getElementById('articleAngular')).scope().loadArticleList();
    		        	 $('#WriteArticleModal').modal('hide');
    		        	 $('#spinner').hide();
    		        },
    		        error: function(){
    		        	 $('#WriteArticleModal').modal('hide');
    		        	 $('#spinner').hide();
  		    		 },
    		        cache: false,
    		    });

    		    return false;
    		});
    });

	