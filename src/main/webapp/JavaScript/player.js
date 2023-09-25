
const maintext = document.getElementById("maintext");

class Player {
	constructor(name, status) {
		this.name = name;
		this.status = status;
	}

	get getName() {
		return this.name;
	}

	get getStatus() {
		return this.status;
	}

	 useRecovery(player) {
	if (player.status.hp> playerRecoveryCost()) {
			const recoveredHp = player.status.hp + player.status.recovery.recovery;
		player.status.hp = recoveredHp;
			const recoveredMp = player.status.mp - player.status.recovery.recoveryCost;
		player.status.mp =recoveredMp;
	}
}

	 attack(player, enemy) {
	const amount = player.status.atk - enemy.status.def;
	if (amount > 0) {
		const dmg = enemy.status.def - amount;
		const actualDmg = Math.max(dmg, 0);
		enemy.status.hp = actualDmg; 
		maintext.innerText=`${playerName}の攻撃！！${enemyName}に${dmg}のダメージを与えた`;
		enemy.isDead(enemy);
	} else {
		maintext.innerText=`${playerName}の攻撃！！ダメージを与えられなかった`;
	}
	maintext.innerText=`${enemyName}のHP: ${enemy.status.hp}`;
}

	isDead(player) {
	let isCheck = false;
	if (player.status.hp <= 0) {
		isCheck = true;
	}
	return isCheck;
}
}
