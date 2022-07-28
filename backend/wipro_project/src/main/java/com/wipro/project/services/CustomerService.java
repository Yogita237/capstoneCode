package com.wipro.project.services;

import java.util.List;
import java.util.Optional;

import com.wipro.project.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.project.models.Customer;
import com.wipro.project.repos.CustomerRepository;

@Service
public class CustomerService {
	@Autowired private CustomerRepository dao;

	
	public void registerCustomer(Customer cust) {
		dao.save(cust);
	}

	
	public List<Customer> allCustomers() {
		return dao.findAll();
	}

	
	public Customer findById(int id) {
		return dao.findById(id).orElse(null);
	}

	
	public Customer validate(String userid, String pwd) {
		Customer cc=dao.findByUserid(userid);
		if(cc!=null && cc.getPwd().equals(pwd)) {
			return cc;
		}
		return null;
	}
	
	
	public boolean verifyUserId(String userid) {
		return dao.findByUserid(userid)!=null;
	}

	
	public void updateProfile(Customer cust) {
		if(cust.getPwd().equals("") || cust.getPwd()==null) {
			cust.setPwd(findById(cust.getId()).getPwd());
		}
		dao.save(cust);	
	}

	public Customer read(Integer id) {
		Optional<Customer> temp = dao.findById(id);
		Customer b=null;
		if(temp.isPresent())
		{
			b=temp.get();
		}
		return b;
	}
	public Customer delete(Integer id) {
		Customer b=read(id);
		if(b!=null)
		{
			dao.delete(b);
		}
		return b;
	}

	public void deleteUserById(int id) {

		dao.deleteById(id);
	}
}
