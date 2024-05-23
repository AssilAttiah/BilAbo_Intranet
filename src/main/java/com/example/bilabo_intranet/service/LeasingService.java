package com.example.bilabo_intranet.service;

import com.example.bilabo_intranet.model.Leasingaftale;
import com.example.bilabo_intranet.repository.LeasingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeasingService {

    @Autowired
    private LeasingRepository leasingRepository;

    public void saveLeasingaftale(Leasingaftale leasingaftale) {
        leasingRepository.save(leasingaftale);
    }

    public int countLeasedCars() {
        List<Leasingaftale> leasingaftaler = leasingRepository.getAllLeasingaftaler();
        return leasingaftaler.size();
    }

    public double calculateTotalPrice() {
        List<Leasingaftale> leasingaftaler = leasingRepository.getAllLeasingaftaler();
        double totalPrice = 0;
        for (Leasingaftale leasingaftale : leasingaftaler) {
            totalPrice += leasingaftale.getLeasingPeriode() * 1000; // 1000 kr per måned
        }
        return totalPrice;
    }
}
