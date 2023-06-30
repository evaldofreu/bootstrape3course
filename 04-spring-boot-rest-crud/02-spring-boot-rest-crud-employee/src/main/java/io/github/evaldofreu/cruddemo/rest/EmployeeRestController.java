package io.github.evaldofreu.cruddemo.rest;

import io.github.evaldofreu.cruddemo.dao.EmployeeDAO;
import io.github.evaldofreu.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //quick and dirt: inject emplyee dao
    private EmployeeDAO employeeDAO;
    //expose "/employees" and return a list of employees
    public EmployeeRestController(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }




}
