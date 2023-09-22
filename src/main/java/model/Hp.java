package model;

public class Hp {
	private static final int MIN = 0;
	final int hp;
	
	public Hp(final int hp){
		if(hp < MIN) {
			throw new IllegalArgumentException();
		}
		
		this.hp =hp;
	}
	
	public int getHp() {
		return this.hp;
	}
}
