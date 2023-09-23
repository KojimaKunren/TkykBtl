package model;

public class Status {
	Hp hp;
	final MaxHp MAXHP;
	Mp mp;
	final MaxMp MAXMP;
	AttackPower atk;
	DeffencePower def;
	Recovery recovery;
	
	public Status(Hp hp, MaxHp MAXHP, Mp mp, MaxMp MAXMP, AttackPower atk, DeffencePower def, Recovery recovery){
	this.hp = hp;
	this.MAXHP = MAXHP;
	this.mp = mp;
	this.MAXMP = MAXMP;
	this.atk = atk;
	this.def = def;
	this.recovery = recovery;
	}
	
	public Hp getHp() {
		return this.hp;
	}
	
	public void setHp(Hp hp) {
		this.hp = hp;
	}
	
	public MaxHp getMaxHp() {
		return this.MAXHP;
	}
	
	public Mp getMp() {
		return this.mp;
	}
	
	public void setMp(Mp mp) {
		this.mp = mp;
	}
	
	public Mp getMaxMp() {
		return this.MAXMP;
	}
	
	
	public AttackPower getAtk() {
		return this.atk;
	}
	
	public void setAtk(AttackPower atk) {
		this.atk = atk;
	}
	
	public DeffencePower getDef() {
		return this.def;
	}
	
	public void setDef(DeffencePower def) {
		this.def = def;
	}
	
	public Recovery getRecovery() {
		return this.recovery;
	}
	
	public void setRecovery(Recovery recovery) {
		this.recovery = recovery;
	}
}
