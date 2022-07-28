package com.wipro.project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.project.dtos.AdminLoginDTO;
import com.wipro.project.dtos.Response;
import com.wipro.project.models.Admin;
import com.wipro.project.services.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {

@Autowired AdminService adService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Admin cust) {		
		System.out.println(cust);
		adService.registerAdmin(cust);
		return Response.success(cust);
	}
	
	@GetMapping
	public List<Admin> findAllAdmins() {
		return adService.allAdmins();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findCustomerById(@PathVariable("id") int id) {
		Admin result = adService.findById(id);
		return Response.success(result);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody AdminLoginDTO dto) {
		System.out.println(dto);
		Admin user=adService.validate(dto.getName(),dto.getPass());
		if(user!=null)
			return Response.success(user);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateProfile(@RequestBody Admin cust,@PathVariable("id") int id) {
		adService.updateProfile(cust);
		return Response.status(HttpStatus.OK);
	}
}
