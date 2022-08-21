package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepo sRepo;

    @Override
    public StudentModel saveStudent(StudentModel student) {
        return sRepo.save(student);
    }

    @Override
    public StudentModel getStudent(int id) {
        return sRepo.findById(id).get();
    }

    @Override
    public List<StudentModel> getAllStudents() {
        return sRepo.findAll();
    }

}
