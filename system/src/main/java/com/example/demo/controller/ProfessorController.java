package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProfessorModel;
import com.example.demo.service.ProfessorService;

@RestController
@RequestMapping("/professor")
@CrossOrigin
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/add")
    public String add(@RequestBody ProfessorModel professor) {
        professorService.saveProfessor(professor);
        return "New professor added";
    }

    @GetMapping("/getAll")
    public List<ProfessorModel> getAll() {
        return professorService.getProfessors();
    }

    @PutMapping("/{id}")
    public String update(@RequestBody ProfessorModel professor, @PathVariable int id) {

        try {
            ProfessorModel existingProfessor = professorService.getProfessor(id);
            professorService.saveProfessor(existingProfessor);
            return "Professor updated";

        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

}
