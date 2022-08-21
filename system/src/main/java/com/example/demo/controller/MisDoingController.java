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

import com.example.demo.model.MisDoingsModel;
import com.example.demo.service.MisDoingsService;
import com.example.demo.service.ProfessorService;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/misdoing")
@CrossOrigin
public class MisDoingController {

    @Autowired
    private MisDoingsService mdService;
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody MisDoingsModel misDoing) {

        misDoing.setProfessor(professorService.getProfessor(misDoing.getProfessor_id()));
        misDoing.setStudent(studentService.getStudent(misDoing.getStudent_id()));
        System.out.println(misDoing.getProfessor());
        System.out.println(misDoing.getStudent());

        mdService.saveMisDoingsQuery(misDoing);

        return "New MisDoing added";
    }

    @GetMapping("/getAll")
    public List<MisDoingsModel> getAll() {
        return mdService.getMisDoings();
    }

    @PutMapping("/{id}")
    public String update(@RequestBody MisDoingsModel misDoing, @PathVariable int id) {

        try {
            MisDoingsModel existingMD = mdService.getMisDoing(id);
            mdService.saveMisDoings(existingMD);
            return "MisDoing updated";

        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

}
