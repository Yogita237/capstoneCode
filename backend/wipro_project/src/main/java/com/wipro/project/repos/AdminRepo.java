package com.wipro.project.repos;

import com.wipro.project.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminRepo  extends JpaRepository<Admin, Integer> {
	Admin findByUserid(String userid);
	Admin findByName(String name);
}
