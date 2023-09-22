package model;

import java.io.Serializable;

public class Player implements Serializable{
	private int id;
	private String name;
	Status status;
	
	public Player() {}
	
	public Player(String name, Status status) {
		this.name = name;
		this.status = status;
	}
	
	public Player(int id, String name, Status status) {
		this(name, status);
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public void useRecovery(Player player, Recovery recovery) {
		if(player.status.mp.getMp() > recovery.getRecoveryCost()) {
			Hp recoveredHp = new Hp(player.status.hp.getHp() + recovery.getRecovery());
			player.status.setHp(recoveredHp);
			Mp recoveredMp = new Mp(player.status.mp.getMp() - recovery.getRecoveryCost());
			player.status.setMp(recoveredMp);
		}
	}
	
	public void attack(Player player, Enemy enemy) {
		final int amount = (Integer)player.status.getAtk().atk - (Integer)enemy.status.getDef().def;
		if(amount > 0) {
			final int dmg = (Integer)enemy.status.getHp().hp - amount;
			final int actualDmg = Math.max(dmg, 0);
			Hp damagedHp = new Hp(actualDmg);
			enemy.status.setHp(damagedHp);
			System.out.printf("%sの攻撃！！%sに%dのダメージを与えた \n", player.getName(), enemy.getName(), dmg);
			enemy.isDead(enemy);
		}else {
			System.out.printf("%sの攻撃！！ダメージを与えられなかった\n", player.getName());
		}
		System.out.printf("%sのHP: %d \n", enemy.getName(), (Integer)enemy.status.hp.hp);
	}
	
	public boolean isDead(Player player) {
		boolean isCheck = false;
		if((Integer)player.status.hp.hp <= 0) {
		isCheck = true;
		}
		return isCheck;
	}
}
