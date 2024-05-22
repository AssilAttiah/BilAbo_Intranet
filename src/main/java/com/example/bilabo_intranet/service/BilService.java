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

    public int saveBil(Bil bil) {
        return bilRepository.save(bil);
    }

    public Bil findBilById(String stelnummer) {
        return bilRepository.findById(stelnummer);
    }

    public List<Bil> findAllBiler() {
        return bilRepository.findAll();
    }
}
