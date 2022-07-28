package com.wipro.project.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String name;
	private String pass;
	public Admin(int userid, String name, String pass) {
		super();
		this.userid = userid;
		this.name = name;
		this.pass = pass;
	}
	
	public Admin() {}
	public int getUserId() {
		return userid;
	}
	public void setUserId(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Admin [id=" + userid + ", name=" + name + ", pass=" + pass + "]";
	}

	
	
	
}
