const maintext = document.getElementById("maintext");
let status = document.getElementById("status");
const container = document.getElementById("container");
const context = document.getElementById("context");
const atkexecute = document.getElementById("atkexecute");
const recoveryexecute = document.getElementById("recoveryexecute");

function battle(status) {
		maintext.innerText=`Buttle Start`;
		maintext.innerText=`enemy.getName()が現れた!`;
		let isEnd = false;

		do {
			maintext.innerText=`行動を選択してください`;
			switch (select) {
			case 1:
				player.attack(player, enemy);
				if (enemy.isDead(enemy)) {
					maintext.innerText=`%sに勝利した \n", enemy.getName()`;
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

function init(){
	let player = new Player(playerName,playerHp,playerMaxHp,playerMp,playerMaxMp,playerAtk,playerDef)
	}

	
