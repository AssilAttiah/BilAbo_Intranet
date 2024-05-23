package com.example.bilabo_intranet.service;

import com.example.bilabo_intranet.model.Leasingaftale;
import com.example.bilabo_intranet.repository.LeasingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeasingService {

    @Autowired
    private LeasingRepository leasingRepository;

    public void saveLeasingaftale(Leasingaftale leasingaftale) {
        leasingRepository.save(leasingaftale);
    }
}
