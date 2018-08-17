<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="classDetailsApp" ng-app="classDetailsApp">
<div id="classDetailsCtrl" ng-controller="classDetailsCtrl">

</div>
</div>
<script>

var app = angular.module('classDetailsApp', []);
app.controller('classDetailsCtrl', function($scope, $http) {
	   $scope.classId = '${requestScope.ClassId}';
	   $scope.CLASSNAME = '${requestScope.CLASSNAME}';
	   $scope.CLASSADMINNAME = '${requestScope.CLASSADMINNAME}';
	   $scope.CLASSADMINID= '${requestScope.CLASSADMINID}';
	
	});

//angular.bootstrap(document.getElementById("classDetailsApp"), ['classDetailsApp']);

</script>
</body>
</html>