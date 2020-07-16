package com.springbatch.demo.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springbatch.demo.model.Employee;
import com.springbatch.demo.repo.EmployeeRepo;

import java.util.List;

@Component
public class EmployeeDBWriter implements ItemWriter<Employee> {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public void write(List<? extends Employee> employees) throws Exception {
		employeeRepo.saveAll(employees);
		System.out.println("inside writer " + employees);
	}
}
