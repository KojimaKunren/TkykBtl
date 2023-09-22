package model;

public class DeffencePower {
	private static final int MIN = 0;
	final int def;
	
	public DeffencePower(final int def){
		if(def < MIN) {
			throw new IllegalArgumentException();
		}
		
		this.def = def;
	}
	
	public int getDef() {
		return this.def;
	}
}
