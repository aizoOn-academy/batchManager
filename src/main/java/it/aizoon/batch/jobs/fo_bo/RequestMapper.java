package it.aizoon.batch.jobs.fo_bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.aizoon.batch.jobs.fo_bo.model.Request;

public class RequestMapper implements RowMapper<Request> {

    @Override
    public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Request.builder()
                .requestId( rs.getLong("request_id") )
                .announcementId( rs.getLong("announcement_id") )
                .applicantFiscalCode( rs.getString("applicant_fiscal_code") )
                .applicantName( rs.getString("applicant_name") )
                .applicantSurname( rs.getString("applicant_surname") )
                .applicantAddress( rs.getString("applicant_address") )
                .applicantCityCap( rs.getString("applicant_city_cap") )
                .applicantCity( rs.getString("applicant_city") )
                .applicantNation( rs.getString("applicant_nation") )
                .applicantPhone( rs.getString("applicant_phone") )
                .applicantIban( rs.getString("applicant_iban") )
                .moneyAmount( rs.getDouble("money_amount") )
                .build();
    }
    
}
