<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Player, model.Enemy, model.Status, model.Recovery, model.Hp, model.MaxHp,model.Mp,model.MaxMp, model.AttackPower,model.DeffencePower"%>
<%-- <% Player player = (Player)session.getAttribute("player"); %>
<% Enemy enemy = (Enemy)session.getAttribute("enemy"); %>> --%>
<%Recovery recovery = new Recovery("bbb",10,10); %>
<%Status status = new Status(new Hp(10),new MaxHp(10),new Mp(10),new MaxMp(10), new AttackPower(10),new DeffencePower(10),recovery); %>
<%Player player = new Player("aaa", status); %>
<%Enemy enemy = new Enemy("ccc", status); %>
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
			<left> <img src="img/bg.jpg" width="100%">
			<div>
			<p id="maintext"></p>
			</div>
			 </left>
			<right> <right-upper>
			<div>
<div id="status">
	<p><%=player.getName() %></p>
	<p>HP:<%=player.getStatus().getHp().getHp() %>/MAXHP:<%=player.getStatus().getMaxHp().getHp() %></p>
	<p>MP:<%=player.getStatus().getMp().getMp() %>/MAXMP:<%=player.getStatus().getMaxMp().getMp() %></p>
	<p>攻撃力:<%=player.getStatus().getAtk().getAtk() %>/守備力:<%=player.getStatus().getDef().getDef() %></p>
	<p>状態:通常</p>
</div>
			</div>
			</right-upper> <right-lower>
			<div>
				<button id="atkexecute">たたかう</button>
				<br>
				<button id="recoveryexecute">かいふく</button>
			</div>
			</right-lower> </right>
		</div>
	</div>
	<script>
			const playerName = <%=player.getName() %>;
			let playerHp = <%=player.getStatus().getHp().getHp() %>;
			let playerMaxHp = <%=player.getStatus().getMaxHp().getHp() %>;
			let playerMp = <%=player.getStatus().getMp().getMp() %>;
			let playerMaxMp =  <%=player.getStatus().getMaxMp().getMp() %>;
			let playerAtk = <%=player.getStatus().getAtk().getAtk() %>;
			let playerDef = <%=player.getStatus().getDef().getDef() %>;
			const playerRecoveryName = <%=player.getStatus().getRecovery().getName() %>;
			const playerRecovery = <%=player.getStatus().getRecovery().getRecovery() %>;
			const playerRecoveryCost = <%=player.getStatus().getRecovery().getRecoveryCost() %>;
			const enemyName = <%=enemy.getName() %>;
			let enemyHp = <%=enemy.getStatus().getHp().getHp() %>;
			let enemyMaxHp = <%=enemy.getStatus().getMaxHp().getHp() %>;
			let enemyMp = <%=enemy.getStatus().getMp().getMp() %>;
			let enemyMaxMp =  <%=enemy.getStatus().getMaxMp().getMp() %>;
			let enemyAtk = <%=enemy.getStatus().getAtk().getAtk() %>;
			let enemyDef = <%=enemy.getStatus().getDef().getDef() %>;
			const enemyRecoveryName = <%=enemy.getStatus().getRecovery().getName() %>;
			const enemyRecovery = <%=enemy.getStatus().getRecovery().getRecovery() %>;
			const enemyRecoveryCost = <%=enemy.getStatus().getRecovery().getRecoveryCost() %>;
			

	</script>
	
<script src=javascript/recovery.js></script>
<script src=javascript/status.js></script>	
<script src=javascript/player.js></script>
<script src=javascript/enemy.js></script>
<script src=javascript/main.js></script>
</body>
</html>