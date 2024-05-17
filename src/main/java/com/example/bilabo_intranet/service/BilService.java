package com.example.bilabo_intranet.service;


import com.example.bilabo_intranet.repository.BilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilService {

    @Autowired
    BilRepository bilRepository;
}
