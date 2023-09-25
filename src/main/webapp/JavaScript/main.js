const maintext = document.getElementById("maintext");
let status = document.getElementById("status");
const container = document.getElementById("container");
const context = document.getElementById("context");
const atkexecute = document.getElementById("atkexecute");
const recoveryexecute = document.getElementById("recoveryexecute");

addEventListener('click', (id) => {
	switch (id) {
		case atkexecute:
			player.attack(player, enemy);
			if (enemy.isDead(enemy)) {
				maintext.innerText = ` ${enemyName} に勝利した`;
				isEnd = true;
			}
			break;

		case recoveryexecute:
			player.useRecovery(player, player.status.recovery);
			break;
		default:
	}
});


function battle(player, enemy) {
	maintext.innerText = `Battle Start`;
	maintext.innerText = `${enemyName}が現れた!`;
	let isEnd = false;

	do {
		maintext.innerText = `行動を選択してください`;
		addEventListener();

		enemy.attack(enemy, player);
		if (player.isDead(player)) {
			isEnd = true;
			break;
		}

		hpDisplay.innertext = `${player.status.hp}`;
		mpDisplay.innerText = `${player.status.mp}`;
	} while (isEnd != true);
}

function init() {
	let playerRecovery = new Recovery(playerRecoveryName, playerRecovery, playerRecoveryCost);
	let playerStatus = new Status(playerHp, playerMaxHp, playerMp, playerMaxMp, playerAtk, playerDef, playerRecovery);
	let player = new Player(playerName, playerStatus);

	let enemyRecovery = new Recovery(enemyRecoveryName, enemyRecovery, enemyRecoveryCost);
	let enemyStatus = new Status(enemyHp, enemyMaxHp, enemyMp, enemyMaxMp, enemyAtk, enemyDef, enemyRecovery);
	let enemy = new Enemy(enemyName, enemyStatus);

	hpDisplay.innerText = `${player.status.hp}`;
	mpDisplay.innerText = `${player.status.hp}`

	battle(player, enemy);
}


