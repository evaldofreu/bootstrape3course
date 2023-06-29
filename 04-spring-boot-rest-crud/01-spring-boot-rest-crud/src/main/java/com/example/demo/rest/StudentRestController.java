package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // define endpoint for "/students"b- return a lista of students
    private List<Student> students;

    // define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData(){
        students = new ArrayList<Student>();
        students.add(new Student("Pormina","Patel"));
        students.add(new Student("Mario","Rossi"));
        students.add(new Student("Mary","Smith"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if (studentId<0 || students.size()<=studentId) {
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return students.get(studentId);

    }




}
