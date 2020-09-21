package com.shreeApp.fleetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreeApp.fleetapp.models.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public Employee findByUsername(String username);
}
