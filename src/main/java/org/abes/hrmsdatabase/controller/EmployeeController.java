
package org.abes.hrmsdatabase.controller;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/v1/user")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String msg() {
        return "<h2>Welcome to Springboot App development</h2>";
    }

    @PostMapping("/addemp")
    public String addnewEmployee(@RequestBody Employee emp) {
        System.out.println(emp.getEmail());
        return employeeService.createNewEmployee(emp);
    }

    @GetMapping("/findbyid/{empid}")
    public Employee getEmpById(@PathVariable long empid) {
        System.out.println("Employee id: " + empid);
        return employeeService.getEmployeeById(empid);
    }

    // New API: return all employees
    @GetMapping("/getEmp")
    public List<Employee> getEmp() {
        return employeeService.getAllEmployees();
    }
}
