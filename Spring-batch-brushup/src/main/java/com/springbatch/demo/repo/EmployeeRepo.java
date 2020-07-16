package com.springbatch.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbatch.demo.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {
}
