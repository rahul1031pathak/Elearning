<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=PT+Sans|Ubuntu" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/js1/dropify.min.css?version=121">
  <script src="${pageContext.request.contextPath}/js1/dropify.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/institution/css/create.css?version=173" type="text/css" >
<title>Create Your Institution | Studyfromweb </title>

 <script>
 $(document).ready(function() {
		var $input = $('input[type="text"],input[type="number"]');
		$input.val('');
		$input.change(function() {
			var $this = $(this);
			if ($this.val().length > 0) {
				$this.addClass('fixed');
			} else {
				$this.removeClass('fixed');
			}
		});

		

	
	});
 
 </script>
</head>
<body>
<div class="main_container">
	<div class="some_information"><p>By creating account for your institute,you can verify whether teachers are belong to your institute or not</p>
	
	<img src="${pageContext.request.contextPath}/institution/images/laptop.svg">
	</div>
	<div class="institution_form">
	
	
	<form>
		<div class="form-group">
			<input class="" type="text" name="name" required>
			<label for="name">Your Institution Name</label>
			<span class="bar"></span>
		</div>
		
   <div class="button dropdown" style="margin-top:25px;" > 
        <select id="colorselector" onchange="yesnoCheck(this);">
        <option value="red">Select your institution type</option>
        <option value="coaching">Coaching Classes</option>
        <option value="college">College</option>
        <option value="school">School</option>
        <option value="other">Other</option>
      </select>
   </div>
   
   
      <div class="button dropdown coaching" style="margin-top:10px;display:none;" id="coaching" > 
        <select id="colorselector" onchange="selectother(this);">
        <option value="red">Category</option>
        <option value="red">Engineering</option>
        <option value="yellow">Medical</option>
        <option value="blue">UPSC</option>
        <option value="blue">Humanity</option>
        <option value="blue">Bank</option>
        <option value="blue">SSC</option>
        <option value="other">Other</option>
      </select>
      </div>
      
      <div class="button dropdown school"  style="margin-top:10px;display:none;" id="school"> 
        <select id="colorselector" onchange="selectother(this);">
        <option value="red">Category</option>
        <option value="red">CBSE</option>
        <option value="yellow">ICSE</option>
        <option value="blue">State</option>
        <option value="other">Other</option>
      </select>
      </div>
      
      <div class="button dropdown college" style="margin-top:10px;display:none;" id="college"> 
        <select id="colorselector" onchange="selectother(this);">
        <option value="red">Category</option>
        <option value="red">Engineering</option>
        <option value="yellow">Medical</option>
        <option value="other">Other</option>
      </select>
      </div>
   <div class="form-group" id="other_Selected" style="display:none;">
			<input class="" type="text" name="other" required>
			<label for="for">Other</label>
			<span class="bar"></span>
   </div>
   <div class="form-group" style="margin-top:-7px;">
			<input class="" type="text" name="other" required>
			<label for="for">Address</label>
			<span class="bar"></span>
   </div>
   <div class="form-group" style="margin-top:-7px;">
			<input class="" type="text" name="other" required>
			<label for="for">City</label>
			<span class="bar"></span>
   </div>
   <div class="form-group" style="margin-top:-7px;">
			<input class="" type="number" name="other" required>
			<label for="for">Pincode</label>
			<span class="bar"></span>
   </div>
   <div class="textarea_field">
		<textarea placeholder="Please share your vision with us" maxlength="200"></textarea>
   </div>
   <div>
   <!--  <input type="file" id="input-file-now" class="dropify" data-height="300" data-allowed-file-extensions="png jpg jpeg gif" data-show-remove="true"data-show-loader="true"/> -->
   </div>
		<div class="form-submit">
			<button type="submit">Submit</button>
		</div>
	</form>
	</div>
	<div class="image_upload">
	<input type="file" id="input-file-now" class="dropify" data-height="300" data-allowed-file-extensions="png jpg jpeg gif" data-show-remove="true"data-show-loader="true"/>
	</div>
</div>
<script>
            $(document).ready(function(){
                // Basic
                $('.dropify').dropify({
                    messages: {
                        'default': 'Select a institute representative image',
                        'replace': 'Drag and drop or click to replace',
                        'remove':  'Remove',
                        'error':   'Ooops, something wrong happended.'
                    }
                });
                $('.dropify').dropify({
                    error: {
                        'fileSize': 'The file size is too big ({{ value }} max).',
                        'minWidth': 'The image width is too small ({{ value }}}px min).',
                        'maxWidth': 'The image width is too big ({{ value }}}px max).',
                        'minHeight': 'The image height is too small ({{ value }}}px min).',
                        'maxHeight': 'The image height is too big ({{ value }}px max).',
                        'imageFormat': 'The image format is not allowed ({{ value }} only).'
                    }
                });

                
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
    function yesnoCheck(event) {
    	
    	if(event.value == "coaching")
    		{
    		
    		document.getElementById("coaching").style.display = "block";
    		document.getElementById("college").style.display = "none";
            document.getElementById("school").style.display = "none";
            document.getElementById("other_Selected").style.display = "none";
    		}
    	else if(event.value == "college")
		{
		
		document.getElementById("college").style.display = "block";
		document.getElementById("school").style.display = "none";
        document.getElementById("other_Selected").style.display = "none";
        document.getElementById("coaching").style.display = "none";
		}
    	else if(event.value == "school")
		{
		
		document.getElementById("school").style.display = "block";
		 document.getElementById("coaching").style.display = "none";
         document.getElementById("college").style.display = "none";
         document.getElementById("other_Selected").style.display = "none";
		}
    	
    	else if (event.value == "other") {
            document.getElementById("other_Selected").style.display = "block";
            document.getElementById("coaching").style.display = "none";
            document.getElementById("college").style.display = "none";
            document.getElementById("school").style.display = "none";
        }
        
        else 
        {
           
            document.getElementById("coaching").style.display = "none";
            document.getElementById("college").style.display = "none";
            document.getElementById("school").style.display = "none";
            document.getElementById("other_Selected").style.display = "none";
        }
    }
    
    
    function selectother(event) {
    	
    	if (event.value == "other") {
            document.getElementById("other_Selected").style.display = "block";
            }
    	else
    		 document.getElementById("other_Selected").style.display = "none";
    		
    }
</script>
</body>
</html>