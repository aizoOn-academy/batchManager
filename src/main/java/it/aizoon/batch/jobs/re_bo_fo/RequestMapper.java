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
                .approved( rs.getBoolean("approvation_status"))
                .moneyAmountFinale( rs.getDouble("approved_money_amount"))
                .note(rs.getString("note"))
                .build();
    }


    
}
