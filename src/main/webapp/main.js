function battle(player, enemy, select) {
		innerText=`Buttle Start`;
		innerText=`enemy.getName()が現れた! \n`;
		let isEnd = false;

		do {
			innerText=`行動を選択してください`;
			switch (select) {
			case 1:
				player.attack(player, enemy);
				if (enemy.isDead(enemy)) {
					innerText=`%sに勝利した \n", enemy.getName()`;
					isEnd = true;
					break;
				}
				break;
			case 2:
				player.useRecovery(player, player.status.recovery);
				break;
			default:
			}
			
			enemy.attack(enemy, player);
			if (player.isDead(player)) {
				isEnd = true;
				break;
			}
		} while (isEnd != true);
	}