package model;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String name;
	private String pass;
	private String pict;

	public User() {
	}

	public User(String name, String pass ,String pict) {
		this.name = name;
		this.pass = pass;
		this.pict = pict;
	}
	
	public User(int id, String name, String pict) {
		this.id = id;
		this.name = name;
		this.pict = pict;
	}

	public User(int id, String name, String pass, String pict) {
		this(id, name, pict);
		this.pass = pass;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPict() {
		return this.pict;
	}

	public void setPict(String pict) {
		this.pict = pict;
	}
}
