package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {

            //createStudent(studentDAO);
            createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
            //queryForStudent(studentDAO);
//            queryStudentsByLastName(studentDAO);
            //updateStudent(studentDAO);
//            deleteStudent(studentDAO);
        };
    }

    private void deleteStudent(StudentDAO studentDAO) {
        studentDAO.delete(3);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int idStudent = 1;
        System.out.println("Gettin student with id : " + idStudent);
        Student theStudent = studentDAO.findById(idStudent);
        System.out.println("Update student...");
        theStudent.setFirstName("ZidaneDoo");
        studentDAO.update(theStudent);
        System.out.println(theStudent);
    }

    private void queryStudentsByLastName(StudentDAO studentDAO) {
        List<Student> byLastName = studentDAO.finbByLastName("oe");
        byLastName.forEach(student -> {
            System.out.println(student);
        });
    }

    private void queryForStudent(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.findAll();
        studentList.forEach(student -> {
            System.out.println(student);
        });
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
        Student tempStudent1 = new Student("Andrei111", "Vita11", "pussssal@luv2code.com");
        Student tempStudent2 = new Student("Recxe111", "Omu11", "maryss@luv2code.com");
        Student tempStudent3 = new Student("Calin111", "Goia11", "bonssita@luv2code.com");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating a new student");
        Student tempStudent = new Student("Paul", "Boe", "pussssal@luv2code.com");
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);
        System.out.println("Saved student with id : " + tempStudent.getId());


    }


}
