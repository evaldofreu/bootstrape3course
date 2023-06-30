package io.github.evaldofreu.cruddemo.service;

import io.github.evaldofreu.cruddemo.dao.EmployeeDAO;
import io.github.evaldofreu.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService

        {


            private EmployeeDAO employeeDAO;

            @Autowired
            public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
                this.employeeDAO = employeeDAO;
            }

            @Transactional
            @Override
            public List<Employee> findAll() {
                return employeeDAO.findAll();
            }

            @Transactional
            @Override
            public Employee findById(int id) {
                return employeeDAO.findById(id);
            }

            @Transactional
            @Override
            public Employee save(Employee employee) {
                return employeeDAO.save(employee);
            }
            @Transactional
            @Override
            public void deleteById(int id) {
                employeeDAO.deleteById(id);
            }
        }
