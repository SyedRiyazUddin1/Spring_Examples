package com.springbatch.demo.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.springbatch.demo.dto.EmployeeDTO;
import com.springbatch.demo.model.Employee;

/**
 * In this class, we are reading the data from a file and converting it into
 * EmployeeDTO object
 */
@Component
public class EmployeeProcessor implements ItemProcessor<EmployeeDTO, Employee> {

	@Override
	public Employee process(EmployeeDTO employeeDTO) throws Exception {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDTO.getEmployeeId());
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setAge(employeeDTO.getAge());
		System.out.println("inside processor " + employee.toString());
		return employee; //this employee will the input to writer now
	}
}
