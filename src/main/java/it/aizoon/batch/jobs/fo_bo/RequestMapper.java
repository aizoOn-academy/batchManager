package it.aizoon.batch.jobs.fo_bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.aizoon.batch.jobs.fo_bo.model.Request;

public class RequestMapper implements RowMapper<Request> {

    @Override
    public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Request.builder()
                .requestId( rs.getLong("user_info_id") )
                .announcementId( rs.getLong("id_bando") )
                .applicantFiscalCode( rs.getString("cfBeneficiary") )
                .applicantName( rs.getString("name") )
                .applicantSurname( rs.getString("surname") )
                .applicantAddress( rs.getString("address") )
                .applicantCityCap( rs.getString("cap") )
                .applicantCity( rs.getString("city") )
                .applicantNation( rs.getString("state") )
                .applicantPhone( rs.getString("phoneNumber") )
                .applicantIban( rs.getString("iban") )
                .moneyAmount( rs.getDouble("requiredAmount") )
                .approved( rs.getBoolean("approvato"))
                .moneyAmountFinale( rs.getDouble("importo_concesso"))
                .note(rs.getString("note"))
                .build();
    }
    
}
