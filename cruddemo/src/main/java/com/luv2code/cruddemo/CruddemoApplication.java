package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return  runner ->{
				//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("Valeria", "Andrusca", "vitalie@luv2code.com");
		studentDAO.save(tempStudent1);
		System.out.println("Created student " + tempStudent1.getId());
		System.out.println("readind student" + tempStudent1.getId() + " " + tempStudent1.getFirstName());
		Student retriebvedStudent = studentDAO.findById(tempStudent1.getId());
		System.out.println(retriebvedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 students");
		Student tempStudent1 = new Student("John", "Doe", "pual@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Doe", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Aplebum", "bonita@luv2code.com");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new student");
		Student tempStudent = new Student("Paul", "Doe", "pual@luv2code.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		System.out.println("Saved student with id : " + tempStudent.getId());


	}


}
