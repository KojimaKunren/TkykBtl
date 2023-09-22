package model;

public class Recovery {
	static final int MIN = 0;
	final String name;
	final int recovery;
	final int recoveryCost;

	public Recovery(final String name, final int recovery, final int recoveryCost) {
		if (recovery < MIN || recoveryCost < MIN) {
			throw new IllegalArgumentException();
		}
		
		this.name= name;
		this.recovery = recovery;
		this.recoveryCost = recoveryCost;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getRecovery() {
		return this.recovery;
	}
	
	public int getRecoveryCost() {
		return this.recoveryCost;
	}
}
