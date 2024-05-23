package com.example.bilabo_intranet.repository;

import com.example.bilabo_intranet.model.Bil;
import com.example.bilabo_intranet.model.TilstandsrapportModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TilstandsrapportRepository {

    @Autowired
    private  JdbcTemplate jdbcTemplate;
    public int saveTr(TilstandsrapportModel tilstandsrapport) {
        String sql = "INSERT INTO BilAbo.tilstandsrapport (rapportnummer, pris, stelnummer, skadeMangler) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, tilstandsrapport.getRapportNummer(), tilstandsrapport.getPris(), tilstandsrapport.getStelnummer(), tilstandsrapport.getSkadeOgMangler());
    }
    public TilstandsrapportModel findByTrNr(String rapportnummer) {
        String sql = "SELECT * FROM BilAbo.tilstandsrapport WHERE rapportnummer = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{rapportnummer}, new TrRowMapper());
    }

    public List<TilstandsrapportModel> findAllTr() {
        String sql = "SELECT * FROM BilAbo.tilstandsrapport";
        return jdbcTemplate.query(sql, new TilstandsrapportRepository.TrRowMapper());
    }

    private static final class TrRowMapper implements RowMapper<TilstandsrapportModel> {

        @Override
        public TilstandsrapportModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            TilstandsrapportModel tilstandsrapport = new TilstandsrapportModel();
            tilstandsrapport.setRapportNummer(rs.getString("rapportnummer"));
            tilstandsrapport.setPris(rs.getBigDecimal("pris"));
            tilstandsrapport.setStelnummer(rs.getString("stelnummer"));
            tilstandsrapport.setSkadeOgMangler(rs.getString("Skade_mangler"));
            return tilstandsrapport;
        }
}
}
