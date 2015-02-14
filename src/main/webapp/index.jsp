<html ng-app="FINKI_CISCO">

<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js"></script>
<script src="http://code.angularjs.org/1.2.1/angular-route.min.js"></script>
<script src="script.js"></script>
<script src="controllers/userController.js"></script>
</head>

<body>
	<div ng-view></div>
	<h1>KUR</h1>
	<div>
		<form ng-controller="userController" ng-submit="login()">

			<label>Email</label> <input type="text" id="email" name="email"
				ng-model="user.email" placeholder="ur email here"> <label>Password</label>
			<input type="text" id="pwd" name="pwd" ng-model="user.pwd"
				placeholder="ur own pwd here">

			<button class="btn btn-primary">Login</button>

		</form>
	</div>

</body>

</html>