package model;

public class AttackPower{
	static final int MIN = 0;
	final int atk;
	
	public AttackPower(final int atk){
		if(atk < MIN) {
			throw new IllegalArgumentException();
		}
		
		this.atk = atk;
	}
	
	public int getAtk() {
		return this.atk;
	}
}
