$("document").ready(function(){
$('.uploaded').hover(function() {
	$(this).children('ul').stop(true, false, true).slideToggle(300);
});
	$(window).scroll(function () {
      //if you hard code, then use console
      //.log to determine when you want the 
      //nav bar to stick.  
      console.log($(window).scrollTop())
    if ($(window).scrollTop() > 70) {
      $('.center').addClass('navbar-fixed');
    }
    if ($(window).scrollTop() < 70) {
      $('.center').removeClass('navbar-fixed');
    }
  });
});