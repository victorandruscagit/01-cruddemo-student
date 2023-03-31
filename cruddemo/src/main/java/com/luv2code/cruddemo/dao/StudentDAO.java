package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    void delete(Integer id);
    void  update(Student student);

    Student findById(Integer id);
    List<Student> findAll();

    List<Student> finbByLastName(String theLastName);
}
