package io.github.evaldofreu.cruddemo.dao;

import io.github.evaldofreu.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    // list all employees
    public List<Employee> findAll();

    public Employee findById(int id);
    //Add or update employee
    public Employee save(Employee employee);

    public void deleteById(int id);



}
