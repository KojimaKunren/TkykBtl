<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="model.Player, model.Enemy, model.Status, model.Recovery, model.Hp, model.MaxHp,model.Mp,model.MaxMp, model.AttackPower,model.DeffencePower"%>
<% Player player = (Player)session.getAttribute("player"); %>
<% Enemy enemy = (Enemy)session.getAttribute("enemy"); %>
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
<%=player.getStatus().getHp().getHp() %>
	;
	let playerMaxHp =
${player.status.maxhp.maxhp}
	;
	let playerMp =
${player.status.mp.mp}
	;
	let playerMaxMp =
${player.status.maxmp.maxmp}
	;
	let playerAtk =
${player.status.atk.atk}
	;
	let playerDef =
${player.status.def.def}
	;
	const playerRecoveryName =
${player.status.recovery.recoveryName}
	;
	const playerRecovery =
&{player.status.recovery.recovery}
	;
	const playerRecoveryCost =
${player.status.recovery.recoveryCost}
	;
	const enemyName =
${enemy.name}
	;
	let enemyHp =
${enemy.status.hp.hp}
	;
	let enemyMaxHp =
${enemy.status.maxhp.maxhp}
	;
	let enemyMp =
${enemy.status.mp.mp}
	;
	let enemyMaxMp =
${enemy.status.maxmp.maxmp}
	;
	let enemyAtk =
${enemy.status.atk.atk}
	;
	let enemyDef =
${enemy.status.def.def}
	;
	const enemyRecoveryName =
${enemy.status.recovery.recoveryName}
	;
	const enemyRecovery =
${enemy.status.recovery.recovery}
	;
	const enemyRecoveryCost =
${enemy.status.recovery.recoveryCost}
	;
</script>
<script src=javascript/recovery.js></script>
<script src=javascript/status.js></script>
<script src=javascript/player.js></script>
<script src=javascript/enemy.js></script>
<script src=javascript/main.js></script>
<title>Main</title>
</head>
<body onload="init()">
	<div id="container">
		<div id="contents">
			<left> <img src="img/bg.jpg" width="100%">
			<div>
			${player.status.hp}
				<p id="maintext"></p>
			</div>
			</left>
			<right> <right-upper>
			<div>
				<div id="status">
					<p><%=player.getName()%></p>
					<p>
						HP:
						<hp id="hpDisplay"></hp>
						/MAXHP:
						${player.status.maxhp.maxhp}</p>
					<p>
						MP:
						<mp id="mpDisplay"></mp>
						/MAXMP:
						${player.status.maxmp.maxmp}</p>
					<p>
						攻撃力:
						${player.status.atk.atk}
						/守備力:
						${player.status.def.def}
					</p>
					<p>状態:通常</p>
				</div>
			</div>
			</right-upper> <right-lower>
			<div>
				<button id="atkexecute" onclick="addEventListener()">たたかう</button>
				<br>
				<button id="recoveryexecute" onclick="addEventListener()">かいふく</button>
			</div>
			</right-lower> </right>
		</div>
	</div>

</body>
</html>