package io.github.evaldofreu.cruddemo.dao;

import io.github.evaldofreu.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements  EmployeeDAO{

    // define field for entitymanager
    private EntityManager entityManager;
    // set up contructor injection


    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        // execute query and get result list
        List<Employee> employeeList = query.getResultList();
        // return the results
        return employeeList;
    }
}
