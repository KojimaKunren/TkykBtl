const maintext = document.getElementById("maintext");

class Enemy {
	constructor(name, status) {
		this.name = name;
		this.status = status;
	}
	
	 attack(enemy, player) {
	const amount = enemy.status.atk - player.status.def;
	if (amount > 0) {
		const dmg = player.status.hp - amount;
		const actualDmg = Math.max(dmg, 0);
		player.status.hp = actualDmg;
		maintext.innerText=`${enemyName}の攻撃！！${playerName}に${dmg}のダメージを与えた`;
		player.isDead(player);
	} else {
		maintext.innerText=`${enemyName}の攻撃！！ダメージを与えられなかった`;
	}
	maintext.innerText=`${playerName}のHP: ${player.status.hp}`;
}

	 isDead(enemy) {
		let isCheck = false;
		if (enemy.status.hp <= 0) {
		isCheck = true;
	}
}