package io.github.evaldofreu.cruddemo;

import io.github.evaldofreu.cruddemo.dao.AppDAO;
import io.github.evaldofreu.cruddemo.entity.Instructor;
import io.github.evaldofreu.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}



		@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
	   return  runner -> {
		   // createInstructor(appDAO);
		   //findInstructor(appDAO);
		   //deleteInstructor(appDAO);
		   //findInstructorDetail(appDAO);
		   deleteInstructorDetail(appDAO);
	   };
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 2;
		System.out.println("Find instructor detail id: "+id);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Instructor Detail found: "+instructorDetail);
		System.out.println("The relationed Instructor: "+instructorDetail.getInstructor());
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor id: "+id);
	    Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: "+instructor);
		System.out.println("the associated instructorDetail only: "+instructor.getInstructorDetail());
	}
	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Removing instructor id: "+id);
		appDAO.deleteInstructorById(id);

		System.out.println("Done!");

	}
	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		System.out.println("Removing instructor detail by id: "+id);
		appDAO.deleteInstructorDetailById(id);

		System.out.println("Done!");

	}

	private void createInstructor(AppDAO appDAO) {
/*
		//create the instructor
		Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		//create the instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");

*/
		//create the instructor
		Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		//create the instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Guitar");


		//associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// save the instructor
		System.out.println("Saving instructor: "+instructor);
		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because the CascadeType.ALL
		appDAO.save(instructor);

	}
}
