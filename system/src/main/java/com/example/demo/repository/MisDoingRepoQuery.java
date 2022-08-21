package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.MisDoingsModel;

@Repository
public class MisDoingRepoQuery {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public MisDoingsModel insertWithQuery(MisDoingsModel misDoings) {
        entityManager.createNativeQuery(
                " insert into misdoings (additional_info, description, date, place, student, professor, professor_id, student_id) values (?, ?, ?, ?, ?, ?, ? ,?)")
                .setParameter(1, misDoings.getAdditionalInfo())
                .setParameter(2, misDoings.getDescription())
                .setParameter(3, misDoings.getWhen())
                .setParameter(4, misDoings.getWhere())
                .setParameter(5, misDoings.getStudent())
                .setParameter(6, misDoings.getProfessor())
                .setParameter(7, misDoings.getProfessor_id())
                .setParameter(8, misDoings.getStudent_id())
                .executeUpdate();
        return misDoings;
    }
}
