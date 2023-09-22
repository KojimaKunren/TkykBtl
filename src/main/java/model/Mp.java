package model;

public class Mp {
	static final int MIN =0;
	final int mp;
	
	public Mp(final int mp){
		if(mp < 0) {
			throw new IllegalArgumentException();
		}
		
		this.mp = mp;
	}
	
	public int getMp() {
		return this.mp;
	}
}
