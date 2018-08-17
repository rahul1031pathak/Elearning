var app = angular.module('YoutubeListApp', []);
app.controller('YoutubeListCtrl', ['$scope','$http','$sce',
                              function ($scope, $http,$sce)  {
	   $scope.YoutubeList = [];
	   $scope.trustSrc = function(src) {
		   src="https://www.youtube.com/embed/"+src;
	        return $sce.trustAsResourceUrl(src);
	        }
	   $scope.trustSrcList = function(src) {
		   src="https://www.youtube.com/embed/?"+src;
	        return $sce.trustAsResourceUrl(src);
	        }
	   
	   
	   $http({
	        method : "POST",
	        url : "Fetch_YoutubeVideoList"
	    }).then(function mySucces(response) {
	    	 $scope.YoutubeList = response.data;
	    	 
	    	 console.log( $scope.YoutubeList); 
	    		
	    }, function myError(response) {
	    	
	    });
	   

	   
	}]);

	
angular.bootstrap(document.getElementById("YoutubeListApp"), ['YoutubeListApp']);


///////////

//delete shared video
 
     
    