package com.example.bilabo_intranet.service;

import com.example.bilabo_intranet.model.Bil;
import com.example.bilabo_intranet.repository.BilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilService {

    @Autowired
    private BilRepository bilRepository;

    // Gemmer bilens oplysninger og bruger metoden fra BilRepository
    public int saveBil(Bil bil) {
        return bilRepository.save(bil);
    }

    // Er ikke brugt. Skal finde specifik bil, og bruger metoden fra BilRepository findById()
    public Bil findBilById(String stelnummer) {
        return bilRepository.findById(stelnummer);
    }


    // skal finde alle biler fra databasen ved hjælp af metoden findAll(), fra bilRepository
    public List<Bil> findAllBiler() {
        return bilRepository.findAll();
    }
}
