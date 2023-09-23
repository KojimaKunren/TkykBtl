<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Player, model.Enemy, model.Status, model.Recovery, model.Hp, model.MaxHp,model.Mp,model.MaxMp, model.AttackPower,model.DeffencePower"%>
<%-- <% Player player = (Player)session.getAttribute("player"); %>
<% Enemy enemy = (Enemy)session.getAttribute("enemy"); %>> --%>
<%Recovery recovery = new Recovery("bbb",10,10); %>>
<%Status status = new Status(new Hp(10),new MaxHp(10),new Mp(10),new MaxMp(10), new AttackPower(10),new DeffencePower(10),recovery); %>>
<%Player player = new Player("aaa", status); %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta style="" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel=stylesheet href="css/main.css">
<title>Main</title>
</head>
<body>
	<div id="container">
		<div id="contents">
			<left> <img src="img/bg.jpg" width="100%"> </left>
			<right> <right-upper>
			<div>
<div>
	<p><%=player.getName() %></p>
	<p>HP:<%=player.getStatus().getHp().getHp() %>/MAXHP:<%=player.getStatus().getMaxHp().getHp() %></p>
	<p>MP:<%=player.getStatus().getMp().getMp() %>/MAXMP:<%=player.getStatus().getMaxMp().getMp() %></p>
	<p>攻撃力:<%=player.getStatus().getAtk().getAtk() %>/守備力:<%=player.getStatus().getDef().getDef() %></p>
	<p>状態:通常</p>
</div>
			</div>
			</right-upper> <right-lower>
			<div>
				<button name="atk">たたかう</button>
				<br>
				<button name="recovery">かいふく</button>
			</div>
			</right-lower> </right>
		</div>
	</div>
<script src=javascript/main.js></script>
</body>
</html>