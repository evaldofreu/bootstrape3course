package io.github.evaldofreu.cruddemo;

import io.github.evaldofreu.cruddemo.dao.StudentDAO;
import io.github.evaldofreu.cruddemo.dao.StudentDAOImpl;
import io.github.evaldofreu.cruddemo.entity.Student;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//removeStudent(studentDAO);
			//removeAllStudents(studentDAO);



		};
	}

	private void removeAllStudents(StudentDAO studentDAO) {
		studentDAO.deleteAll();

	}

	private void removeStudent(StudentDAO studentDAO) {
		studentDAO.delete(3);
	}


	private void updateStudent(StudentDAO studentDAO) {
		 List<Student> students = studentDAO.findByLastName("Lucsa");
		Student student = null;
		 if (!students.isEmpty()) {
			 student = students.get(0);
		 }
		 if (student!=null) {
			 student.setLastName("Lucas");
			 studentDAO.update(student);
			 System.out.println("Student updated " + student);
		 } else {
			 System.out.println("Student not found!");
		 }

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Lucsa");
		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> studentList =  studentDAO.findAll();

		// display list of students
		for (Student student: studentList) {
			System.out.println(student);
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		Student student = new Student("Evaldo", "Júnior", "evaldofreu@gmail.com");
		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(student);
		// display id of the saved student
		System.out.println("Saved student. Generated id :"+student.getId());
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating 3 students");
		Student student1 = new Student("Rita", "de Cássia", "cassia@parser.com.br");
		Student student2 = new Student("Victor", "Lucsa", "victorlucas@gmail.com");
		Student student3 = new Student("Larissa", "Réu", "larissa@gmail.com");
		// save the student
		System.out.println("Saving the students ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		// display id of the saved student
		System.out.println("Saved students. Generated id :"+student1.getId()+" "+student2.getId()+" "+student3.getId());
	}


	private Student readStudent(StudentDAO studentDAO){
		//creating a new student
		Student createdStudent = new Student("José", "Inácio","jose@inacio.com");
		//save the student
		studentDAO.save( createdStudent);
		System.out.println("Student created id: "+createdStudent.getId());

		// retrieve the student based on the id: primary key
		System.out.println("Retrieving student with id: "+createdStudent.getId());
		Student student = studentDAO.findById(createdStudent.getId());
		//display student
		System.out.println("Student found: "+student);
		return student;
	}


}
