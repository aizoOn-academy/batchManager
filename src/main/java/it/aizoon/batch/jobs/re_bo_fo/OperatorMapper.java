package it.aizoon.batch.jobs.re_bo_fo;

import it.aizoon.batch.jobs.fo_bo.model.Request;
import it.aizoon.batch.jobs.re_bo_fo.model.Operator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OperatorMapper implements RowMapper<Operator> {

    @Override
    public Operator mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Operator.builder()
                .operatorId( rs.getLong("operator_id") )
                .username( rs.getString("username") )
                .build();
    }



}
