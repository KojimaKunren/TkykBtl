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
}
function useRecovery(player) {
	if (player.getStatas().mp.getMp() > playerRecoveryCost) {
			const recoveredHp = player.getStatus().hp.getHp() + playerRecovery;
		player.getStatus().hp = new Hp(recoveredHp);
			const recoveredMp = player.getStatus().mp.getMp() - playerRecoveryCost;
		player.getStatus().mp = new Mp(recoveredMp);
	}
}

function attack(player, enemy) {
	const amount = player.getStatus().atk.getAtk() - enemyDef;
	if (amount > 0) {
		const dmg = enemy.getStatus().hp.getHp() - amount;
		const damagedHp = Math.max(dmg, 0);
		enemy.getStatus().hp = new Hp(damagedHp);
		maintext.innerText=`playernmaeの攻撃！！enemyNameに dmg のダメージを与えた`;
		enemy.isDead(enemy);
	} else {
		maintext.innerText=`playerName の攻撃！！ダメージを与えられなかった`;
	}
	maintext.innerText=` enemyName のHP: enemyHp`;
}

function isDead(player) {
	let isCheck = false;
	if (player.getStatus().hp.getHp() <= 0) {
		isCheck = true;
	}
	return isCheck;
}
