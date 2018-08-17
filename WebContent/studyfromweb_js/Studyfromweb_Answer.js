 $(document).ready(function(){
    	
	 
	 $("form#ask_question_form").submit(function(){
	
		   $('#spinner').show();
		   $('#answer_ClassId').val(angular.element(document.getElementById('classDetailsCtrl')).scope().classId);
		   $('#answer_QuesId').val(angular.element(document.getElementById('questionquestionAnswerAngular')).scope().questionId);
		   
		    var formData = new FormData($(this)[0]);
		   
		    $.ajax({
		    	 url: 'Submit_Answer',
		        type: 'POST',
		        data: formData,
		     
		        success: function (data) {
				// $('#AskQuestionModal').modal('hide');
		           angular.element(document.getElementById('questionquestionAnswerAngular')).scope().loadQuestionAnswerList();
		           $('#spinner').hide();
		           $(".wrap").show();
			    	$(".askquestion").hide();
		        },
		        cache: false,
		        contentType: false,
		        processData: false
		    });
		
		
		    return false;
		});
	 
	 
	 $("form#question_in_text_form").submit(function(e){
		
		   $('#spinner').show();
		 e.preventDefault();
		 for ( instance in CKEDITOR.instances ) {
	            CKEDITOR.instances[instance].updateElement();
	        }
		var formData = $(question_in_text_form).serializeArray();
  		formData.push({name: 'ClassId', value: angular.element(document.getElementById('classDetailsCtrl')).scope().classId});
  		formData.push({name: 'Ques_Id', value: angular.element(document.getElementById('questionquestionAnswerAngular')).scope().questionId});
console.log(formData);
		    $.ajax({
		    	 url: 'Submit_Answer',
		        type: 'GET',
		        data: formData,
		     
		        success: function (data) {
					 $('#AskQuestionModal').modal('hide');
					  $('#spinner').hide();
		          angular.element(document.getElementById('questionquestionAnswerAngular')).scope().loadQuestionAnswerList();
		          $(".wrap").show();
			    	$(".askquestion").hide();
		        },
		       
		    });
		
		 
		   return false;
		});
	 
	
	 
    });
	
	
	
	
	// answer delete option clicked by admin
     $( "body" ).delegate( ".delete_answer", "click", function(event) {
    	 var answerId=$(event.target).attr("data-value");
    	 angular.element(event.target).parent().parent().remove();
    	 var quesId=angular.element(document.getElementById('questionAnswerCtrl')).scope().questionId;
    	
    	
    	 $.ajax({
			 type: "POST",
    		 url: "Answer_deleter",
    		 cache: false,
    		 data: {anserId:answerId,quesId:quesId},
    		         success: function(msg){
    		        	 document.getElementById(index).remove(); 
    		         },
    		 error: function(){
    		 
    		 }
			 
			 }); 
    
    	
    	
    	return false; });
   
     
	 
	 	      $( "body" ).delegate( ".delete_question", "click", function(event) {
    	//var qesId=question.getQues_id;
	 	    	 var quesId=$(event.target).attr("data-value");
	 	    	// alert(quesId);
	 	    	angular.element(event.target).parent().parent().remove(); 
    
    	 $.ajax({
			 type: "POST",
    		 url: "Question_Deleter",
    		 cache: false,
    		 data: {quesId:quesId},
    		         success: function(data){
    		        	 if(data.b=="true"){
    		        		// document.location.href='myclass.jsp'
    		        		// alert("done");
    		        	 }
    		        	
    		         },
    		 error: function(){
    		 
    		 }
			 
			 }); 
    
    	
    	
    	return false; });
		
		
		
		
		function myFunction() {
	var check=$( "#mySelect" ).val();
	
	if(check=="1"){
		$("#question_in_text_form").hide();	
		$('#question').val('');
		$("#ask_question_form").show();	
	}else {
		$("#ask_question_form").hide();
		$('#uploadQuestion').val('');
		$("#question_in_text_form").show();
	}
	
}






function changeImage() {
    var image = document.getElementById('myImage');
    if (image.src.match("1.png")) {
        image.src = "images/2.png";
    } else {
        image.src = "images/1.png";
    }
}

'use strict';

;( function ( document, window, index )
{
	var inputs = document.querySelectorAll( '.inputfile' );
	Array.prototype.forEach.call( inputs, function( input )
	{
		var label	 = input.nextElementSibling,
			labelVal = label.innerHTML;

		input.addEventListener( 'change', function( e )
		{
			var fileName = '';
			var ValidImageTypes = ["image/gif", "image/jpeg", "image/png"];
			var filetype=this.files[0].type;
			if ($.inArray(filetype, ValidImageTypes) < 0) {
			     // invalid file type code goes here.
		alert("You can not upload this file");
			}
			else{
				//alert("valid");
				
				
				

				if( this.files && this.files.length > 1 )
							fileName = ( this.getAttribute( 'data-multiple-caption' ) || '' ).replace( '{count}', this.files.length );
						else
							fileName = e.target.value.split( '\\' ).pop();

						if( fileName ){
							
							label.querySelector( 'span' ).innerHTML = fileName;
						}
							
						else
							label.innerHTML = labelVal;
		
			}
		});

		// Firefox bug fix
		input.addEventListener( 'focus', function(){ input.classList.add( 'has-focus' ); });
		input.addEventListener( 'blur', function(){ input.classList.remove( 'has-focus' ); });
	});
}( document, window, 0 ));







  

