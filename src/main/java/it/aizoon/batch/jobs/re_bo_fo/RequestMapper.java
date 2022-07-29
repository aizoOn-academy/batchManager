package it.aizoon.batch.jobs.re_bo_fo;

import it.aizoon.batch.jobs.re_bo_fo.model.Request;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestMapper implements RowMapper<Request> {

    @Override
    public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Request.builder()
                .requestId( rs.getLong("announcement_application_id") )
                .announcementId( rs.getLong("id_bando") )
                .operatorId( rs.getLong("operator_id") )
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
                .approved( rs.getBoolean("approvation_status"))
                .moneyAmountFinale( rs.getDouble("approved_money_amount"))
                .note(rs.getString("note"))
                .build();
    }


    
}
