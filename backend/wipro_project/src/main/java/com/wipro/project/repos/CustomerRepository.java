package com.wipro.project.repos;

import com.wipro.project.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByUserid(String userid);
}
