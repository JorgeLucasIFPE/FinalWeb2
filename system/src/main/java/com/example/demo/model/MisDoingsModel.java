package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

@Table(name = "misdoings")

public class MisDoingsModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "date")
    private Date when;
    @Column(name = "place")
    private String where;
    private String description;
    private String additionalInfo;
    private int professor_id;
    private int student_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "professor")
    private ProfessorModel professor;

    @MapsId
    @OneToOne
    @JoinColumn(name = "student")
    private StudentModel student;

}
