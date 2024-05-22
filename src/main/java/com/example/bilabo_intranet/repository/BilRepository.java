package com.example.bilabo_intranet.repository;

import com.example.bilabo_intranet.model.Bil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BilRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Bil bil) {
        String sql = "INSERT INTO BilAbo.Bil (stelnummer, mærke, model, status) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, bil.getStelnummer(), bil.getMærke(), bil.getModel(), bil.getStatus());
    }

    public Bil findById(String stelnummer) {
        String sql = "SELECT * FROM Bil WHERE stelnummer = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{stelnummer}, new BilRowMapper());
    }

    public List<Bil> findAll() {
        String sql = "SELECT * FROM Bil";
        return jdbcTemplate.query(sql, new BilRowMapper());
    }

    private static final class BilRowMapper implements RowMapper<Bil> {

        @Override
        public Bil mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bil bil = new Bil();
            bil.setStelnummer(rs.getString("stelnummer"));
            bil.setMærke(rs.getString("mærke"));
            bil.setModel(rs.getString("model"));
            bil.setStatus(rs.getString("status"));
            return bil;
        }
    }
}
