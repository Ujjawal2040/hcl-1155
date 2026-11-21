
package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createNewEmployee(Employee newEmp) {
        employeeRepository.save(newEmp);
        return "Employee is added successfully";
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long empid) {
        return employeeRepository.findById(empid).orElse(null);
    }
}
