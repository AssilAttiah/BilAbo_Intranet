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

    public void save(Leasingaftale leasingaftale) {
        String sql = "INSERT INTO BilAbo.Leasingaftale (leasingType, leasingPeriode) VALUES (?, ?)";
        jdbcTemplate.update(sql, leasingaftale.getLeasingType(), leasingaftale.getLeasingPeriode());
    }

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
