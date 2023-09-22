<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" href="css/log.css">
<title>userRegister</title>
</head>
<body class="container">
<div>
<form action="Register" method="POST" enctype="multipart/form-data">
	UserName:<br>
	<input type="text" name="name" required>
	<br> 
	Password:<br>
	<input type="password" name="pass" required>
	<br><br>
	<label> <input type="file" name="pict">
	</label>
	<br>
	<button type="submit">confirm</button>
	</form>
</div>
</body>
</html>