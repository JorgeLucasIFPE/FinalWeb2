package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ProfessorModel;

public interface ProfessorService {

    public ProfessorModel saveProfessor(ProfessorModel professor);

    public List<ProfessorModel> getProfessors();

    public ProfessorModel getProfessor(int id);

}
