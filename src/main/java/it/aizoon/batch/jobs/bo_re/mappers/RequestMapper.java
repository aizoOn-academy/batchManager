package it.aizoon.batch.jobs.bo_re.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.aizoon.batch.jobs.bo_re.model.Request;

public class RequestMapper implements RowMapper<Request> {

    @Override
    public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Request.builder()
                .requestId( rs.getLong("id_domanda") )
                .operatorId( rs.getLong("id_operatore"))
                .announcementId( rs.getLong("id_bando") )
                .applicantFiscalCode( rs.getString("cf_beneficiario") )
                .applicantName( rs.getString("nome") )
                .applicantSurname( rs.getString("cognome") )
                .applicantAddress( rs.getString("indirizzo") )
                .applicantCityCap( rs.getString("cap") )
                .applicantCity( rs.getString("citta") )
                .applicantNation( rs.getString("nazione") )
                .applicantPhone( rs.getString("telefono") )
                .applicantIban( rs.getString("iban") )
                .moneyAmount( rs.getDouble("importo") )
                .note( rs.getString("note") )
                .build();
    }
    
}
