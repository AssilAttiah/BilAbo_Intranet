package com.example.bilabo_intranet.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BilRepository {

    @Autowired
    private JdbcTemplate template;



}
