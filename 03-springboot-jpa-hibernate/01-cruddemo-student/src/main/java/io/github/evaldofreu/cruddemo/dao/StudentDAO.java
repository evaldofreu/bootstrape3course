package io.github.evaldofreu.cruddemo.dao;

import io.github.evaldofreu.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);


     void update(Student student);



     void delete(Integer id);

     int deleteAll();
}
