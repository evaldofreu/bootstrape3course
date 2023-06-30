package io.github.evaldofreu.cruddemo.rest;

import io.github.evaldofreu.cruddemo.entity.Employee;
import io.github.evaldofreu.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService service;
    //expose "/employees" and return a list of employees


    @Autowired
    public EmployeeRestController(EmployeeService service) {
            this.service = service;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return service.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){

        Employee employee = service.findById(id);
        if (employee == null){
            throw new RuntimeException("Employee is not found - "+id);
        }
        return employee;
    }


    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee savedEmployee = service.save(employee);
        return savedEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee savedEmployee = service.save(employee);
        return savedEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee employee = service.findById(id);
        if (employee == null){
            throw new RuntimeException("Employee is not found - "+id);
        }

        service.deleteById(id);
    }




}
