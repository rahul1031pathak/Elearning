<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Update Your Profile</title>
<link rel="shortcut icon" href="images/globe.png" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
           <link type="text/css" rel="stylesheet" href="UpdateProfile.css?version=08" />
        
</head>
<body>


<div class="main">
<h1>Complete Your Profile</h1>
<div class="UploadImage"><img src="${sessionScope.USER.profilepic}" id="updateImage" class="img-rounded" width="150" height="150" alt="Update profile pic"></div>
<form method="post" id="ask_question_form" Class="ask_question_form" action="UpdateProfile" enctype="multipart/form-data">
<input type="file" name="file-1[]" id="file-1" onchange="readURL(this);"  accept="image/*" class="inputfile inputfile-1"/>
<label for="file-1"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>profile pic</span></label>
<div id="pr">
 <div class="updateProof"><img src="${sessionScope.USER.proof}" id="updateProof" class="img-rounded" width="120" height="120" alt="Update proof pic"></div>
</div>
 <input type="file" name="file-2[]" id="file-2" onchange="readURL(this);"  accept="image/*" class="inputfile inputfile-2"/>
<label id="upic"for="file-2"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span id="span">Id Proof</span></label>
  
<div class="inner-addon left-addon">
      <i class="glyphicon glyphicon-user"></i>      
      <input type="text" class="form-control" name="Username"  placeholder="Username : ${sessionScope.USER.fullname}" />
</div>

<div class="inner-addon left-addon">
         <i class="glyphicon glyphicon-home"></i>  
      <input type="text" class="form-control" name="institution" placeholder="institution : ${sessionScope.USER.institution}" />
</div>
<div> Your Field of Interest  : ${sessionScope.USER.foi1}  , ${sessionScope.USER.foi2} , ${sessionScope.USER.foi3}   </div>
<div id="list1" class="dropdown-check-list1" tabindex="100">
        <span class="anchor">Field of Interest</span>
        <ul id="items1" class="items1">
            <li><input type="checkbox"  name="FOI" value="upsc"/>Upsc </li>
            <li><input type="checkbox" name="FOI" value="Engineering">Engineering</li>
            <li><input type="checkbox" name="FOI" value="Medical"/>Medical</li>
            <li><input type="checkbox" name="FOI" value="Literature"/>Literature</li>
            <li><input type="checkbox" name="FOI" value="Language"/>Language</li>
            <li><input type="checkbox" name="FOI" value="Commerce" />Commerce</li>
           
			<li><input type="checkbox" />Other</li>
        </ul>
    </div>
	<div id="list2" class="dropdown-check-list2" tabindex="100">
        <span class="anchor">Types of institution</span>
        <ul id="items2" class="items2">
        <li><input type="checkbox" name="TOI" value="Coaching Classes"/>Coaching Classes</li>
            <li><input type="checkbox" name="TOI"  value="College"/>College </li>
            <li><input type="checkbox" name="TOI"  value="School"/>School</li>
            <li><input type="checkbox" name="TOI" value="Training Center"/>Training Center</li>
             <li><input type="checkbox" name="TOI" value="Self" />Self</li>
            <li><input type="checkbox" name="TOI" value="Other"/>Other</li>
            
        </ul>
    </div>
	<input type="submit" id="flip" value="Submit">
	</form> 
</div>
</body>
<script> 
$('.items1 input[type=checkbox]').change(function(e){
   if ($('.items1 input[type=checkbox]:checked').length >3) {
        $(this).prop('checked', false)
        alert("allowed only 3");
   }
});
</script> 
<script> 
$('.items2 input[type=checkbox]').change(function(e){
   if ($('.items2 input[type=checkbox]:checked').length >3) {
        $(this).prop('checked', false)
        alert("allowed only 3");
   }
})
</script> 
<script>
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
			if( this.files && this.files.length > 1 )
				fileName = ( this.getAttribute( 'data-multiple-caption' ) || '' ).replace( '{count}', this.files.length );
			else
				fileName = e.target.value.split( '\\' ).pop();

			if( fileName )
				label.querySelector( 'span' ).innerHTML = fileName;
			else
				label.innerHTML = labelVal;
		});

		// Firefox bug fix
		input.addEventListener( 'focus', function(){ input.classList.add( 'has-focus' ); });
		input.addEventListener( 'blur', function(){ input.classList.remove( 'has-focus' ); });
	});
}( document, window, 0 ));
</script>
<script>
$("#file-1").change(function(e) {

    for (var i = 0; i < e.originalEvent.srcElement.files.length; i++) {

        var file = e.originalEvent.srcElement.files[i];

        var reader = new FileReader();
        reader.onloadend = function() {
             $('#updateImage').attr('src', reader.result);
        }
        reader.readAsDataURL(file);}
});
</script>
<script>
$("#file-2").change(function(e) {

    for (var i = 0; i < e.originalEvent.srcElement.files.length; i++) {

        var file = e.originalEvent.srcElement.files[i];

        var reader = new FileReader();
        reader.onloadend = function() {
             $('#updateProof').attr('src', reader.result);
        }
        reader.readAsDataURL(file);}
});
</script>

</body>
</html>