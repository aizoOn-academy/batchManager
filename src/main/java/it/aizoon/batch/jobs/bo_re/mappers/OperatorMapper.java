package it.aizoon.batch.jobs.bo_re.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.aizoon.batch.jobs.bo_re.model.Operator;

public class OperatorMapper implements RowMapper<Operator> {

    @Override
    public Operator mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Operator.builder()
                .operatorId( rs.getLong("id_operatore") )
                .username( rs.getString("username") )
                .build();
    }
    
}
