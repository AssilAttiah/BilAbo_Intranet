package com.example.bilabo_intranet.service;

import com.example.bilabo_intranet.model.Kunde;
import com.example.bilabo_intranet.repository.KundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KundeService {

    @Autowired
    private KundeRepository kundeRepository;

    public int saveKunde(Kunde kunde) {
        return kundeRepository.save(kunde);
    }

    public Kunde findKundeById(int kundeID) {
        return kundeRepository.findById(kundeID);
    }

    public List<Kunde> findAllKunder() {
        return kundeRepository.findAll();
    }
}
