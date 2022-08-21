package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MisDoingsModel;

@Repository
public interface MisDoingsRepo extends JpaRepository<MisDoingsModel, Integer> {

}
