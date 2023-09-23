<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" type="text/css" href="css/log.css">
<title>Login</title>
</head>
<body class="container">
	<div>
		<h1>TKYKBTL</h1>
	</div>
	<div>
		<h1>Login</h1>
		<form action="Login" method="POST">
			UserName:<br>
			<input type="text" name="name" required><br> 
			Password:<br>
			<input type="password" name="pass" required><br><br>
			<button type=submit>ログイン</button>
		</form>
			<p>ユーザー未登録の方</p>
			<a href="Register">ユーザー登録</a>
	</div>
</body>
</html>