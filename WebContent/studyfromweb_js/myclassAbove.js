$(document).ready(function(){
	

	$("#manager").hover(function(){
		$(this).children('.manager_arrow').stop(true, false, true).toggle();
		$(this).children('.manager_list').slideToggle();
	});
	$("#add_manager").click(function(){
		$('.add_manager_arrow').toggle();
		$('.add_manager_list').slideToggle();
	});
	
	$("#transfer_button").click(function(){
		$('.transfer_arrow').toggle();
		$('.transfer_list').slideToggle();
	});
	
	
	
});

$("document").ready(function(){
	$('.uploaded').hover(function() {
		$(this).children('ul').stop(true, false, true).slideToggle(300);
	});
		$(window).scroll(function () {
	      //if you hard code, then use console
	      //.log to determine when you want the 
	      //nav bar to stick.  
	    //  console.log($(window).scrollTop())
	    if ($(window).scrollTop() >120) {
	      $('.notification-area').addClass('navbar-fixed');
	    }
	    if ($(window).scrollTop() <120) {
	      $('.notification-area').removeClass('navbar-fixed');
	    }
	  });
	});










$(document).ready(function(){
  $("#smallScreenButton").click(function(e){
        e.stopPropagation();
        var flag=$(".123").data("flag");
    
        if (flag==0){
       
           $(".centeerr").fadeIn(); 
            
       $(this).data("flag",1);
       $(".123").data("flag",1)
          
            
        }
       else {
    	
               $(".centeerr").fadeOut();
               $(".123").data("flag",0);
            
       }
    });
    
    
    
    
    $(document).click(function (e)
    	      // $("html").on("click", "button:not('.slideNav')",function(e)
    	  {

    	    var container = $(".centeerr");
    	  var container1 = $(".slideNav");
    	  if(!$(event.target).is('.verticla-nav'))
    	  {
    		  container.hide();
   	        $(".123").data("flag",0);
   	       
    	  }
    	    
    	});
    
});
    
$(document).ready(function(){
	$("#manage").click(function(){
		
		 $("#switch_back_to_classContent").hide();
			$('#switch_to_followers').show();
			$('#Manage_Member_Ul').show(); 
		 angular.element(document.getElementById('membershipCtrl')).scope().memberShipList();
	   });
	
    $(".rightNav").click(function(){
        $(".centeerr").slideToggle("slow");
    });
});