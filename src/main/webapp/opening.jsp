<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" href="css/opening.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js" 
integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<title>Opening</title>
</head> 
<body class="container">
	<div id="btn">
		<img class="image" src="img/1.jpg"> 
		<img class="image" src="img/2.jpg">
		<img class="image" src="img/3.jpg">
		<div style="font-size:'5px'; color:'white'; text-align:'center';">
			<h5>Click Start</h5>
		</div>
	</div>

	<script>
	const btn = document.getElementById("btn");
	btn.addEventListener("click",()=>{
			location.href='Login';
		});

</script>
</body>
</html>