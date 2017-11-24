<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags"%>
<html lang="en" data-ng-app="freedomModules">
<head>
	<!-- meta data info for application  -->
   	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=edge">
   	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	
	<link href="resources/css/bootstrap/bootstrap.css" rel="stylesheet">
	<link href="resources/css/bootstrap/dataTables.bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/css/bootstrap/responsive.bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/css/bootstrap/bootstrap-select.min.css" rel="stylesheet">
	
	<link href="resources/css/font-awesome.css" rel="stylesheet">
	<link href="resources/css/simple-line-icons.css" rel="stylesheet">
	<link href="resources/css/master.css" rel="stylesheet">
	<link href="resources/css/datepicker.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/js/lib/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/jquery-ui.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/jquery.validate.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/additional-methods.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/jquery.slimscroll.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/dataTables.responsive.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/jquery.jeditable.js"></script>
	<script type="text/javascript" src="resources/js/lib/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="resources/js/lib/bootstrap-select.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/responsive.bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/angular.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/angular-resource.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/angular-route.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/angular-sanitize.min.js"></script>
    <script type="text/javascript" src="resources/js/lib/angular-cookies.min.js"></script>
    <script type="text/javascript" src="resources/js/lib/angular-ui.min.js"></script>
	
	<script type="text/javascript" src="resources/js/app.js"></script>
	<script type="text/javascript" src="resources/js/controllers/DatabaseConfigController.js"></script>
	<script type="text/javascript" src="resources/js/controllers/MainController.js"></script>
	<script type="text/javascript" src="resources/js/controllers/AddUserController.js"></script>
	<script type="text/javascript" src="resources/js/controllers/AppController.js"></script>
	<script type="text/javascript" src="resources/js/controllers/DatabaseUserController.js"></script>
	<script type="text/javascript" src="resources/js/controllers/EditUserController.js"></script>
	<script type="text/javascript" src="resources/js/controllers/HeaderController.js"></script>
	<script type="text/javascript" src="resources/js/controllers/LoginController.js"></script>
	<script type="text/javascript" src="resources/js/controllers/UserListController.js"></script>
	<script type="text/javascript" src="resources/js/controllers/ViewUsersController.js"></script>
	<script type="text/javascript" src="resources/js/services/User.js"></script>
	
</head>
<body data-ng-controller="MainController" class="page-header-fixed compact-menu page-horizontal-bar page-sidebar-fixed page-login">
	<div class="spinner" ng-show="isLoading">
		<div class="modal-backdrop in"></div>
		<o:spinner />
	</div> 
	<input type="hidden" id="userInfo_accountId" value="${user_accountId}">
	<div data-ng-view> </div>	  
	<div data-ng-include='"view/template/message"'></div>  
</body>
</html>
