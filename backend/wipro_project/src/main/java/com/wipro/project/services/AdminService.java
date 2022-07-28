package com.wipro.project.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.project.models.*;
import com.wipro.project.repos.AdminRepo;

@Service
public class AdminService {

	@Autowired private AdminRepo dao;

	
	public void registerAdmin(Admin cust) {
		dao.save(cust);
	}

	
	public List<Admin> allAdmins() {
		return dao.findAll();
	}

	
	public Admin findById(int id) {
		return dao.findById(id).orElse(null);
	}

	
	public Admin validate(String name, String pwd) {
		Admin cc=dao.findByName(name);
		if(cc!=null && cc.getPass().equals(pwd)) {
			return cc;
		}
		return null;
	}
	
	
	public boolean verifyUserId(String userid) {
		return dao.findByUserid(userid)!=null;
	}

	
	public void updateProfile(Admin cust) {
		if(cust.getPass().equals("") || cust.getPass()==null) {
			cust.setPass(findById(cust.getUserId()).getPass());
		}
		dao.save(cust);	
	}
}
