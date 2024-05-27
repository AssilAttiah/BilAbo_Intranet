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

    public int saveTr(TilstandsrapportModel tilstandsrapportModel) {
        return tilstandsrapportRepository.saveTr(tilstandsrapportModel);
    }
    public TilstandsrapportModel findTrById(String rapportnummer) {
        return tilstandsrapportRepository.findByTrNr(rapportnummer);
    }

    // Finder alle rapporten der gemt
    public List<TilstandsrapportModel> findAllTr() {
        return tilstandsrapportRepository.findAllTr();
    }

    public double beregnSamletPris(double skadePris1, double skadePris2, double skadePris3, double skadePris4, double skadePris5, double skadePris6) {
        return skadePris1 + skadePris2 + skadePris3 + skadePris4 + skadePris5 + skadePris6;
    }

}

