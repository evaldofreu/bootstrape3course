package io.github.evaldofreu.cruddemo.dao;

import io.github.evaldofreu.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();


}
