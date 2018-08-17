$("document").ready(function () {

$(".alert").hide();

$(".signup_submit").click(function(event){

var data=$(".password").val();

var len=data.length;

if(len<1)

{

$(".password").next().show(function(){
	$(".password").next().delay(5000).fadeOut("slow");
});

}

else

{

$(".password").next().hide();

}

if($(".password").val() !=$(".confirm").val())

{

$(".confirm").next().show(function(){
	$(".confirm").next().delay(5000).fadeOut("slow");
});

}

else

{

$(".confirm").next().hide();

}

event.preventDefault();

});

});