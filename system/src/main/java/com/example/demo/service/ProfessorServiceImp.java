package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProfessorModel;
import com.example.demo.repository.ProfessorRepo;

@Service
public class ProfessorServiceImp implements ProfessorService {

    @Autowired
    private ProfessorRepo pRepo;

    @Override
    public ProfessorModel saveProfessor(ProfessorModel professor) {

        return pRepo.save(professor);
    }

    @Override
    public ProfessorModel getProfessor(int id) {
        return pRepo.findById(id).get();
    }

    @Override
    public List<ProfessorModel> getProfessors() {
        return pRepo.findAll();
    }

}
