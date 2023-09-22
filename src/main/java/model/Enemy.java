package model;

import java.io.Serializable;

public class Enemy implements Serializable{
	private String name;
	private int id;
	Status status;
	
	public Enemy() {}
	
	public Enemy(String name, Status status) {
		this.name = name;
		this.status = status;
	}
	
	public Enemy(String name, int id,  Status status) {
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
	
	public void attack(Enemy enemy, Player player) {
		final int amount = (Integer)enemy.status.getAtk().atk - (Integer)player.status.getDef().def;
		if(amount > 0) {
			final int dmg = (Integer)player.status.getHp().hp - amount;
			Hp damagedHp = new Hp(dmg);
			player.status.setHp(damagedHp);
			System.out.printf("%sの攻撃！！%sに%dのダメージを与えた \n", enemy.getName(), player.getName(), dmg);
		}else {
			System.out.printf("%sの攻撃！！%sにダメージを与えられなかった \n", enemy.getName(), player.getName());
		}
		System.out.printf("%sのHP: %d \n",player.getName(), (Integer)player.status.hp.hp);
	}
	
	public boolean isDead(final Enemy enemy) {
		boolean isCheck = false;
		if((Integer)enemy.status.hp.hp <= 0) {
		isCheck = true;
		}
		return isCheck;
	}
}
