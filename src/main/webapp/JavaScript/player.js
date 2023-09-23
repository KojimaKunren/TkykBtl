
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
function useRecovery(player, recovery) {
	if (playerMp > recovery.getRecoveryCost()) {
			Hp recoveredHp = new Hp(player.status.hp.getHp() + recovery.getRecovery());
		player.status.setHp(recoveredHp);
			Mp recoveredMp = new Mp(player.status.mp.getMp() - recovery.getRecoveryCost());
		player.status.setMp(recoveredMp);
	}
}

function attack(player, enemy) {
	const amount = (Integer)player.status.getAtk().atk - (Integer)enemy.status.getDef().def;
	if (amount > 0) {
		const dmg = (Integer)enemy.status.getHp().hp - amount;
		const actualDmg = Math.max(dmg, 0);
			Hp damagedHp = new Hp(actualDmg);
		enemy.status.setHp(damagedHp);
		System.out.printf("%sの攻撃！！%sに%dのダメージを与えた \n", player.getName(), enemy.getName(), dmg);
		enemy.isDead(enemy);
	} else {
		System.out.printf("%sの攻撃！！ダメージを与えられなかった\n", player.getName());
	}
	System.out.printf("%sのHP: %d \n", enemy.getName(), (Integer)enemy.status.hp.hp);
}

function isDead(player) {
	let isCheck = false;
	if ((Integer)player.status.hp.hp <= 0) {
		isCheck = true;
	}
	return isCheck;
}
}