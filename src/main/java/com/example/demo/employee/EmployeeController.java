package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepo rep;

	@RequestMapping("/allEmployees")
	public Iterable<Employee> getAllEmployees() {
		return rep.findAll();

	}
	@RequestMapping("/find-employee/{employeeNumber}")
	public Employee viewEmployee(@PathVariable("employeeNumber") int employeeNumber, Model model) {
	Employee e = rep.findById(employeeNumber).get();
	return e;
	}
	@PostMapping("/add-employee")
	public String addEmployee(@RequestBody Employee c) {
		rep.save(c);
		return "Success";
	}
}
