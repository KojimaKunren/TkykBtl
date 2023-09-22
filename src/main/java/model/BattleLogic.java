package model;

public class BattleLogic {

	public void battle(Player player, Enemy enemy, int select) {
		System.out.println("Buttle Start");
		System.out.printf("%sが現れた! \n", enemy.getName());
		boolean isEnd = false;

		do {
			System.out.printf("行動を洗濯してください");
			switch (select) {
			case 1:
				player.attack(player, enemy);
				if (enemy.isDead(enemy)) {
					System.out.printf("%sに勝利した \n", enemy.getName());
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
}
