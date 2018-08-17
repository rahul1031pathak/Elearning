


$("document").ready(function(){
	
	$('#include_Article').load('Article.jsp');
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
	$('#include_youtubelist').load('youtubeVideoList.jsp');
	$('#include_Article').hide();
	$('#include_youtubelist').hide();
	$('#switch_to_followers').hide();
	
	
});	



	
$("document").ready(function(){
$('.scrollRadioButton').click(function() { 
//function myFunction() {
	var check=$(this).data("value");
	
	
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
			//$('#mySelectParagraph').text('shared video');
			 angular.element(document.getElementById('YoutubeListCtrl')).scope().loadYoutubeList();
			 $('#include_youtubelist').data('flag',1);
		}
		else{
		//	$('#mySelectParagraph').text('shared video');
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
	 $("#delete_this_member").hide();
	 $("#delete_this_subscriber").hide();
	

	if(check=="0"){
		
		
//		$('#CommonArea').hide();
//		$('#include_youtubelist').hide();
//		$('#include_Article').hide();
		$('#manage_subscriber_ul').hide();
		$('#Manage_Member_Ul').show(); 
		 angular.element(document.getElementById('membershipCtrl')).scope().memberShipList();
		
//		$('#mySelectParagraph').text('MemberList');
		
		
		
		
		
		
		
	}else if(check==1) {
	
		
	//	$('#CommonArea').hide();
//		$('#include_youtubelist').hide();
	//	$('#include_Article').hide();
		$('#manage_subscriber_ul').show();
		$('#Manage_Member_Ul').hide(); 
		//$('#CommonArea').load('QuestionList.jsp');
		 angular.element(document.getElementById('subscriberCtrl')).scope().subscriberList();
		
		$('#mySelectParagraph').text('subscriber');
		
	
	}
	else{
		 $("#switch_back_to_classContent").show();
			$('#switch_to_followers').hide();
		//myFunction(); 
	}
	

	
});
});







$(document).ready(function(){
	
 $("#logoToHome").click(function(){
    	document.location.href='Home.jsp';
    });
    
     });




 




function openNav() {
		document.getElementById("fuck").style.width = "400px";
	}

	function closeNav() {
		document.getElementById("fuck").style.width = "0";
	}





	
	
	
	
	
	
	
	  $(document).ready(function(){

	
   
    	 
    	 $("form#question_in_text_form").submit(function(e){
    		 e.preventDefault();
    		 if(isLogin()){
    		// nicEditors.findEditor('question').saveContent();
    			 tinyMCE.triggerSave();
    		var formData = $(question_in_text_form).serializeArray();
      		formData.push({name: 'ClassId', value: angular.element(document.getElementById('classDetailsCtrl')).scope().classId});
      		 console.log(formData);
    		    $.ajax({
    		    	 url: 'AskQuestion',
    		        type: 'post',
    		        data: formData,
    		     
    		        success: function (data) {
    		          
    		        	 $('#AskQuestionModal').modal('hide');
						 	angular.element(document.getElementById('questionAngular')).scope().loadQuestionList();
						 	 $('#spinner').hide();
    		        },
					error: function(){
   			 alert("Some thing went wrong");
			  $('#AskQuestionModal').modal('hide');
			  $('#spinner').hide();
   		 },
    		        cache: false,
    		    });
    		 }
    		 else{
				 $('#LogInSignUp').modal('show');
			 }
    		    return false;
    		});
    	 
    	
	 
    	 $("form#article_in_text").submit(function(e){
    		
    		 e.preventDefault();
    		 if(isLogin()){
    		// nicEditors.findEditor('ArticleTextArea').saveContent();
    			 tinyMCE.triggerSave();
      		var formData = $(article_in_text).serializeArray();
      		formData.push({name: 'ClassId', value: angular.element(document.getElementById('classDetailsCtrl')).scope().classId});

    		    $.ajax({
    		    	 url: 'WriteArticle',
    		        type: 'post',
    		        data: formData,
    		     
    		        success: function (data) {
    		        	
    		        	 $('#WriteArticleModal').modal('hide');
						 angular.element(document.getElementById('articleAngular')).scope().loadArticleList();
						 $('#spinner').hide();
    		        },
					error: function(){
   			 alert("Some thing went wrong");
			 $('#WriteArticleModal').modal('hide');
			 $('#spinner').hide();
   		 },
    		        cache: false,
    		    });
    	 }
    	 else{
			 $('#LogInSignUp').modal('show');
		 }
    		    return false;
    		});
    });

	
	

 