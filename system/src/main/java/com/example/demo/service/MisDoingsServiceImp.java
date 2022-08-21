package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MisDoingsModel;
import com.example.demo.repository.MisDoingsRepo;
import com.example.demo.repository.MisDoingRepoQuery;

@Service
public class MisDoingsServiceImp implements MisDoingsService {

    @Autowired
    private MisDoingsRepo mdRepo;

    @Autowired
    private MisDoingRepoQuery mdqRepo;

    @Override
    public MisDoingsModel saveMisDoings(MisDoingsModel misDoing) {
        System.out.println("aq");

        return mdRepo.save(misDoing);
    }

    @Override
    public MisDoingsModel saveMisDoingsQuery(MisDoingsModel misDoing) {
        return mdqRepo.insertWithQuery(misDoing);

    }

    @Override
    public List<MisDoingsModel> getMisDoings() {
        return mdRepo.findAll();
    }

    @Override
    public MisDoingsModel getMisDoing(int id) {
        return mdRepo.findById(id).get();
    }

    @Override
    public String deleteMisDoing(int id) {
        mdRepo.deleteById(id);
        return "Delete MisDoing";
    }

}
