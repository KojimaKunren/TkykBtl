<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=divece-widht, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" type="text/css" href="css/log.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<title>Register Done</title>
</head>
<body>
	<div id="move">
		<h1>Register Done</h1>
		<p style="font-size:10px;, text-align:center;"> 自動で遷移します</p>
	</div>

<script>
$('#move').load(function(){
	setTimeout(function(){
	window.location.href='/main.jsp';
		}, 1000);
});
</script>
</body>
</html>