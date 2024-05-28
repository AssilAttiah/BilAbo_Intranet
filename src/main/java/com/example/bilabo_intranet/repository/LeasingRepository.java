package com.example.bilabo_intranet.repository;

import com.example.bilabo_intranet.model.Leasingaftale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LeasingRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Gemmer Leasingaftalen, altså perioden og typen om det er en unlimited eller limited
    public void save(Leasingaftale leasingaftale) {
        String sql = "INSERT INTO BilAbo.Leasingaftale (leasingType, leasingPeriode) VALUES (?, ?)";
        jdbcTemplate.update(sql, leasingaftale.getLeasingType(), leasingaftale.getLeasingPeriode());
    }

    // Oversættelse fra SQL til JAVA
    public List<Leasingaftale> getAllLeasingaftaler() {
        String sql = "SELECT * FROM BilAbo.Leasingaftale";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Leasingaftale leasingaftale = new Leasingaftale();
            leasingaftale.setLeasingID(rs.getInt("leasingID"));
            leasingaftale.setLeasingType(rs.getString("leasingType"));
            leasingaftale.setLeasingPeriode(rs.getInt("leasingPeriode"));
            return leasingaftale;
        });
    }
}
