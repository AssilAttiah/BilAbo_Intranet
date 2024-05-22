package com.example.bilabo_intranet.service;

import com.example.bilabo_intranet.model.Bil;
import com.example.bilabo_intranet.model.TilstandsrapportModel;
import com.example.bilabo_intranet.repository.TilstandsrapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TilstandsrapportService {
    @Autowired
    private TilstandsrapportRepository tilstandsrapportRepository;

    public int saveBil(TilstandsrapportModel tilstandsrapportModel) {
        return tilstandsrapportRepository.saveTr(tilstandsrapportModel);
    }
    public TilstandsrapportModel findTrById(String rapportnummer) {
        return tilstandsrapportRepository.findByTrNr(rapportnummer);
    }

    public List<TilstandsrapportModel> findAllTr() {
        return tilstandsrapportRepository.findAllTr();
    }
}
