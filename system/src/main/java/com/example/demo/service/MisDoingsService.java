package com.example.demo.service;

import java.util.List;

import com.example.demo.model.MisDoingsModel;

public interface MisDoingsService {

    public MisDoingsModel saveMisDoings(MisDoingsModel misDoing);

    public MisDoingsModel saveMisDoingsQuery(MisDoingsModel misDoing);

    public List<MisDoingsModel> getMisDoings();

    public MisDoingsModel getMisDoing(int id);

    public String deleteMisDoing(int id);

}
