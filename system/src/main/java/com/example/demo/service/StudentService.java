package com.example.demo.service;

import java.util.List;

import com.example.demo.model.StudentModel;

public interface StudentService {

    public StudentModel saveStudent(StudentModel student);

    public List<StudentModel> getAllStudents();

    public StudentModel getStudent(int id);

}
