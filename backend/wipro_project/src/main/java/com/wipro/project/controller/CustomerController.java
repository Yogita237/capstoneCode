package com.wipro.project.controller;

import java.util.List;
import java.util.Optional;

import com.wipro.project.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.project.dtos.LoginDTO;
import com.wipro.project.dtos.Response;
import com.wipro.project.models.Customer;
import com.wipro.project.services.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Customer cust) {
        System.out.println(cust);
        customerService.registerCustomer(cust);
        return Response.success(cust);
    }

    @GetMapping
    public List<Customer> findAllCustomers() {
        return customerService.allCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable("id") int id) {
        Customer result = customerService.findById(id);
        return Response.success(result);
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
        System.out.println(dto);
        Customer user = customerService.validate(dto.getUserid(), dto.getPwd());
        if (user != null)
            return Response.success(user);
        else
            return Response.status(HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateProfile(@RequestBody Customer cust, @PathVariable("id") int id) {
        customerService.updateProfile(cust);
        return Response.status(HttpStatus.OK);
    }


	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable int id){
		customerService.deleteUserById(id);
	}


}