$("document").ready(function(){
$('.dropdown').hover(function() {
	$(this).children('ul').stop(true, false, true).slideToggle(300);
});
});