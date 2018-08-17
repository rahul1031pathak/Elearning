<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> update your info</title>
<script src="js1/jquery-2.2.4.min.js" type="text/javascript"></script>
<script src="js1/bootstrap.min.js"></script>
<link rel="shortcut icon" href="https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/short+logo+for+browser.gif"/>
<link rel="stylesheet" href="js1/bootstrap.min.css">
<link rel="stylesheet" href="js1/bootstrap-theme.min.css">
    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-beta.2/angular-sanitize.js"></script>
<link rel="stylesheet" href="css/chosen.css">
    <link rel="stylesheet" href="css/dropify.min.css">
    <script src="js/dropify.min.js"></script>
    <link rel="stylesheet" href="css/dropify.min1.css">
    <script src="js/dropify.min1.js"></script>
    <link rel="stylesheet" href="css/update.css">
<script>
   $(document).ready(function(){
		 $('[data-type="input-label"]').each(function(){
				var parent = $(this).parent();
				var labelName = $(this).attr("placeholder");
				var id = $(this).attr("id");

				var newInput = "<div class='input-label'>";
				newInput += $(this)[0].outerHTML;
				newInput += "<label for='" + id + "'>" + labelName + "</label>";
				newInput += "</div>";

				$(newInput).insertBefore(this).find("input").blur(function(){
					if($(this).val().length > 0){
						$(this).next().addClass("active");
					}else{
						$(this).next().removeClass("active");
					}
				});

				$(this).remove();

			});
	});
</script>
    <script>
  jQuery(document).ready(function($) {

  //Count nr. of square classes
  var countSquare = $('.square').length;

  //For each Square found add BG image
  for (i = 0; i < countSquare; i++) {
    var firstImage = $('.square').eq([i]);
    var secondImage = $('.square2').eq([i]);

    var getImage = firstImage.attr('data-image');
    var getImage2 = secondImage.attr('data-image');

    firstImage.css('background-image', 'url(' + getImage + ')');
    secondImage.css('background-image', 'url(' + getImage2 + ')');
  }

});
</script>
</head>

<body>
<div id="UpdateProfileApp" ng-app="UpdateProfileApp">
<div id="UpdateProfileCtrl" ng-controller="UpdateProfileCtrl">
    <div class="UpdateProfile">
      <div class="profileANDRproof">
          <h3>update your profile</h3>
        <!--  <div class="square-flip">
		<img class='square' data-image="image/Disha.jpg" >
		<img class='square2' data-image="image/disha-patani-3a.jpg">
	</div>-->
        </div>
        <div class="updateFormArea">
            <form enctype="multipart/form-data" id="ask_question_form">
          
<input type="text" data-type="input-label"  name="name"  data-name="" placeholder=""  id="name" ></input>
<input type="text" data-type="input-label" name="institution"  data-name=" " placeholder="" id="institution"></input>
<input type="text" data-type="input-label" name="current_city" data-name="CURRENT CITY" placeholder=""  id="current_city"></input>
<input type="text" data-type="input-label" name="phone"data-name="PHONE NUMBER"  placeholder="" id="phone_number"></input>

<select data-placeholder="FIELD OF INTEREST" name="FOI" class="chosen-select" multiple style="width:100%" tabindex="4">
                <option value="upsc">UPSC</option>
                <option value="engineering">Engineering</option>
                <option value="medical">Medical</option>
                <option value="literature">literature</option>
                <option value="language">Language</option>
                <option value="commerce">commerce</option>
                <option value="other">Other</option>
</select><br>
<select data-placeholder="TYPE OF INSTITUTION" name="TOI" class="chosen-select" multiple style="width:100%" tabindex="4">
                <option value="Coaching Classes">Coaching Classes</option>
                <option value="College">College</option>
                <option value="School">School</option>
                <option value="Training Center">Training Center</option>
                <option value="Self">Self</option>
                <option value="other">Other</option>
</select><br>
    <textarea type="text"placeholder="{{write_about}}" name="write_about"  class="WAYourself" maxlength="200" id="write_about"></textarea>    
    <input type="file" name="file-1[]" id="input-file-now"class="dropify" placeholder="hello" data-height="75" data-allowed-file-extensions="png jpg jpeg gif"/>
    <input type="file" name="file-2[]" id="input-file-now"class="dropify1 proofImage" data-height="75" data-allowed-file-extensions="png jpg jpeg gif"/>
    <input type="submit" value="SUBMIT" class="updateProfileSubmitButton">
    
            </form>
      </div>
    </div>
    
        </div>
    </div>
<script src="js/chosen.jquery.js" type="text/javascript"></script>
  <%@ include file="loading.jsp" %>
	
  <script type="text/javascript">
    var config = {
      '.chosen-select'           : {max_selected_options: 3},
      '.chosen-select-deselect'  : {allow_single_deselect:true},
      '.chosen-select-no-single' : {disable_search_threshold:10},
      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
      '.chosen-select-width'     : {width:"100%"}
    }
    for (var selector in config) {
      $(selector).chosen(config[selector]);
    }
	 
  </script>
<script>
            $(document).ready(function(){
                // Basic
                $('.dropify').dropify();

                
                // Used events
                var drEvent = $('#input-file-events').dropify();

                drEvent.on('dropify.beforeClear', function(event, element){
                    return confirm("Do you really want to delete \"" + element.file.name + "\" ?");
                });

                drEvent.on('dropify.afterClear', function(event, element){
                    alert('File deleted');
                });

                drEvent.on('dropify.errors', function(event, element){
                    console.log('Has Errors');
                });

                var drDestroy = $('#input-file-to-destroy').dropify();
                drDestroy = drDestroy.data('dropify')
                $('#toggleDropify').on('click', function(e){
                    e.preventDefault();
                    if (drDestroy.isDropified()) {
                        drDestroy.destroy();
                    } else {
                        drDestroy.init();
                    }
                })
            });
        </script>
<script>
            $(document).ready(function(){
                // Basic
                $('.proofImage').dropify1();

                
                // Used events
                var drEvent = $('#input-file-events').dropify1();

                drEvent.on('dropify1.beforeClear', function(event, element){
                    return confirm("Do you really want to delete \"" + element.file.name + "\" ?");
                });

                drEvent.on('dropify1.afterClear', function(event, element){
                    alert('File deleted');
                });

                drEvent.on('dropify1.errors', function(event, element){
                    console.log('Has Errors');
                });

                var drDestroy = $('#input-file-to-destroy').dropify();
                drDestroy = drDestroy.data('dropify1')
                $('#toggleDropify').on('click', function(e){
                    e.preventDefault();
                    if (drDestroy.isDropified()) {
                        drDestroy.destroy();
                    } else {
                        drDestroy.init();
                    }
                })
            });
        </script>
        
        
        
        
        
        <script type="text/javascript">
var app = angular.module('UpdateProfileApp', []);
app.controller('UpdateProfileCtrl', ['$scope','$http','$sce',
                              function ($scope, $http,$sce)  {
	   $scope.email="";
	   $scope.name="";
	   $scope.institution="";
	   $scope.city="";
	   $scope.write_about="";
	   $scope.phone="";
	  // $scope.loadYoutubeList= function () {
       	//   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};

	  $http({
	        method : "GET",
	        url : "Fetch_update_profile",
	        //params: data
	    }).then(function mySucces(response) {
	    	 console.log(response.data);
	    	  $scope.name=response.data.fullname;
	    	  $scope.institution=response.data.institution;
	    	  $("#write_about").attr("placeholder", "ABOUT YOURSELF   "+response.data.write_about).val("").focus().blur();
	    	  $("#name").attr("placeholder","NAME     "+ response.data.fullname).val("").focus().blur();
	    	  $("#institution").attr("placeholder","INSTITUTION    "+ response.data.institution).val("").focus().blur();
	    	  $("#current_city").attr("placeholder","CITY    "+ response.data.city).val("").focus().blur();
	    	  $("#phone_number").attr("placeholder","PHONE     "+ response.data.phone).val("").focus().blur();
	    	 // angular.element(document.getElementById('UpdateProfileCtrl')).scope(). show();
	    	//  $("#name").attr("data-name","$scope.name");
	    	 // console.log(	  $("#name").data("name"));
	    	// show();
	    }, function myError(response) {
	    	
	    }); 
	   
	//   };
	   
	
	
	
	
	
	
	
	
	
	 $scope.show= function () {
       	//   var data = {ClassId:angular.element(document.getElementById('classDetailsCtrl')).scope().classId};
 $('#spinner').show();
		  $http({
		        method : "GET",
		        url : "Fetch_update_profile",
		        //params: data
		    }).then(function mySucces(response) {
		    	 console.log(response.data);
		    	  $scope.name=response.data.fullname;
		    	  $scope.institution=response.data.institution;
		    	  $("#write_about").attr("placeholder", "write_about   "+response.data.write_about).val("").focus().blur();
		    	  $("#name").attr("placeholder","NAME     "+ response.data.fullname).val("").focus().blur();
		    	  $("#institution").attr("placeholder","INSTITUTION    "+ response.data.institution).val("").focus().blur();
		    	  $("#current_city").attr("placeholder","CITY    "+ response.data.city).val("").focus().blur();
		    	  $("#phone_number").attr("placeholder","PHONE     "+ response.data.phone).val("").focus().blur();
		    	  $('#spinner').hide();
		    	 // angular.element(document.getElementById('UpdateProfileCtrl')).scope(). show();
		    	//  $("#name").attr("data-name","$scope.name");
		    	 // console.log(	  $("#name").data("name"));
		    	// show();
		    }, function myError(response) {
		    	 $('#spinner').hide();
		    }); 
	   
	  };
	
	
	
	
	
	
	}]);

	
//angular.bootstrap(document.getElementById("YoutubeListApp"), ['YoutubeListApp']);



</script>
        
        
    <script type="text/javascript">
    
    
    
	 
	 $("form#ask_question_form").submit(function(event){
		 event.preventDefault();
		   $('#spinner').show();
		 //  $('#ques_ClassId').val(angular.element(document.getElementById('classDetailsCtrl')).scope().classId);
	// console.log($('#ques_ClassId').val());
	   var formData = new FormData($(this)[0]);
	  // formData.append("ClassId",angular.element(document.getElementById('classDetailsCtrl')).scope().classId);
 console.log( formData );
	    $.ajax({
	    	 url: 'UpdateProfile',
	        type: 'POST',
	        data: formData,
	     
	        success: function (data) {
	        	 $('#spinner').hide();
	        	angular.element(document.getElementById('UpdateProfileCtrl')).scope(). show();
	        },
	       cache: false,
	        contentType: false,
	        processData: false, 
	    });

	    return false;
	});
    
    
    
    
    
    </script>    
        
        
        
        
        
        
        
        
        
        
        
        
        
</body>
</html>
    