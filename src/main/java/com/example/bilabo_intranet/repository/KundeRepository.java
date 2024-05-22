package com.example.bilabo_intranet.repository;

import com.example.bilabo_intranet.model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KundeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Kunde kunde) {
        String sql = "INSERT INTO BilAbo.Kunde (fornavn, efternavn, alder, kørekortnummer) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, kunde.getFornavn(), kunde.getEfternavn(), kunde.getAlder(), kunde.getKørekortnummer());
    }

    public Kunde findById(int kundeID) {
        String sql = "SELECT * FROM Kunde WHERE kundeID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{kundeID}, new KundeRowMapper());
    }

    public List<Kunde> findAll() {
        String sql = "SELECT * FROM Kunde";
        return jdbcTemplate.query(sql, new KundeRowMapper());
    }

    private static final class KundeRowMapper implements RowMapper<Kunde> {

        @Override
        public Kunde mapRow(ResultSet rs, int rowNum) throws SQLException {
            Kunde kunde = new Kunde();
            kunde.setKundeID(rs.getInt("kundeID"));
            kunde.setFornavn(rs.getString("fornavn"));
            kunde.setEfternavn(rs.getString("efternavn"));
            kunde.setAlder(rs.getInt("alder"));
            kunde.setKørekortnummer(rs.getString("kørekortnummer"));
            return kunde;
        }
    }
}
