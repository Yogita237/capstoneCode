package com.wipro.project.dtos;

public class AdminLoginDTO {
	private String name;
	private String pass;
	private String role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "AdminLoginDTO [name=" + name + ", pass=" + pass + ", role=" + role + "]";
	}

	
		
}
