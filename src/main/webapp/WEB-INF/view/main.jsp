<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="model.Player, model.Enemy, model.Status, model.Recovery, model.Hp, model.MaxHp,model.Mp,model.MaxMp, model.AttackPower,model.DeffencePower"%>
<%
Player player = (Player) session.getAttribute("player");
%>
<%
Recovery enemyRecovery = new Recovery(" ",10,10);
Status enemyStatus = new Status(new Hp(10),new MaxHp(10), new Mp(0), new MaxMp(0), new AttackPower(10), new DeffencePower(10), enemyRecovery);
Enemy enemy = new Enemy("ENEMY1",1,enemyStatus);
%>
<%
Status status = (Status) session.getAttribute("status");
%>
<%
Recovery recovery = (Recovery) session.getAttribute("recovery");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta style="" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel=stylesheet href="css/main.css">
<script>
	const playerName =
<%=player.getName()%>
	;
	let playerHp =
<%=player.getStatus().getHp().getHp()%>
	;
	let playerMaxHp =
<%=player.getStatus().getMaxHp().getHp()%>
	;
	let playerMp =
<%=player.getStatus().getMp().getMp()%>
	;
	let playerMaxMp =
<%=player.getStatus().getMaxMp().getMp()%>
	;
	let playerAtk =
<%=player.getStatus().getAtk().getAtk()%>
	;
	let playerDef =
<%=player.getStatus().getDef().getDef()%>
	;
	const playerRecoveryName =
<%=player.getStatus().getRecovery().getName()%>
	;
	const playerRecovery =
<%=player.getStatus().getRecovery().getRecovery()%>
	;
	const playerRecoveryCost =
<%=player.getStatus().getRecovery().getRecoveryCost()%>
	;
	const enemyName =
<%=enemy.getName()%>
	;
	let enemyHp =
<%=enemy.getStatus().getHp().getHp()%>
	;
	let enemyMaxHp =
<%=enemy.getStatus().getMaxHp().getHp()%>
	;
	let enemyMp =
<%=enemy.getStatus().getMp().getMp()%>
	;
	let enemyMaxMp =
<%=enemy.getStatus().getMaxMp().getMp()%>
	;
	let enemyAtk =
<%=enemy.getStatus().getAtk().getAtk()%>
	;
	let enemyDef =
<%=enemy.getStatus().getDef().getDef()%>
	;
	const enemyRecoveryName =
<%=enemy.getStatus().getRecovery().getName()%>
	;
	const enemyRecovery =
<%=enemy.getStatus().getRecovery().getRecovery()%>
	;
	const enemyRecoveryCost =
<%=enemy.getStatus().getRecovery().getRecoveryCost()%>
	;
</script>

<script src="JavaScript/recovery.js"></script>
<script src="JavaScript/status.js"></script>
<script src="JavaScript/player.js"></script>
<script src="JavaScript/enemy.js"></script>
<script src="JavaScript/Hp.js"></script>
<script src="JavaScript/MaxHp.js"></script>
<script src="JavaScript/Mp.js"></script>
<script src="JavaScript/MaxMp.js"></script>
<script src="JavaScript/AttackPower.js"></script>
<script src="JavaScript/DeffencePower.js"></script>
<script src="JavaScript/main.js"></script>
<title>Main</title>
</head>
<body>
	<div id="container">
		<div id="contents">
			<left> <img src="img/bg.jpg" width="100%">
			<div>
				<p id="maintext">aaa</p>
			</div>
			</left>
			<right> <right-upper>
			<div>
				<div id="status">
					<p>${player.name}</p>
					<p>
						HP:
						<hpDisplay><%=player.getStatus().getHp().getHp()%></hpDisplay>
						/MAXHP:<%=player.getStatus().getMaxHp().getHp()%></p>
					<p>
						MP:
						<mpDisplay><%=player.getStatus().getMp().getMp()%></mpDisplay>
						/MAXMP:<%=player.getStatus().getMaxMp().getMp()%></p>
					<p>
						攻撃力:<%=player.getStatus().getAtk().getAtk()%>/守備力:<%=player.getStatus().getDef().getDef()%></p>
					<p>状態:通常</p>
					<br>
					<p><%=enemy.getName()%></p>
					<p>
						HP:
						<enemyDisplay><%=enemy.getStatus().getHp().getHp()%></enemyDisplay>
					</p>
				</div>
			</div>
			</right-upper> <right-lower>
			<div>
				<button id="btn">Attack</button>
				<br>
				<button id="btn">Recovery</button>
			</div>
			</right-lower> </right>
		</div>
	</div>
<script>
/* 		window.onload = function() {
			document.getElementById("maintext").textContent = "text"
		}; */
	</script>

</body>
</html>